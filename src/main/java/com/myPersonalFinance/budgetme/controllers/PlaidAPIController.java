package com.myPersonalFinance.budgetme.controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.myPersonalFinance.budgetme.data.AccessTokenRepository;
import com.myPersonalFinance.budgetme.data.UserRepository;
import com.myPersonalFinance.budgetme.models.PlaidAccessToken;
import com.myPersonalFinance.budgetme.models.User;
import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import okhttp3.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/api/plaid/")
    class PlaidAPIController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccessTokenRepository accessTokenRepository;

        private static PlaidApi plaidClient;

    public static class LinkToken {
        @JsonProperty
        private String linkToken;


        public LinkToken(String linkToken) {
            this.linkToken = linkToken;
        }
    }


    @GetMapping(path = "generateLinkToken")
        public LinkToken handle(@CookieValue(value = "sessionId") int sessionId)  throws IOException {

            // Create your Plaid client

            HashMap<String, String> apiKeys = new HashMap<String, String>();


            apiKeys.put("clientId", "64a74bf17c8ccb0013c8bf5c");
            apiKeys.put("secret", "d2c7d5dd31c038447448eed176d954");
            ApiClient apiClient = new ApiClient(apiKeys);
            apiClient.setPlaidAdapter(ApiClient.Sandbox);

            plaidClient = apiClient.createService(PlaidApi.class);

            // Get the clientUserId by searching for the current user

            LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
                    .clientUserId(String.valueOf(sessionId));

            // Create a link_token for the given user

            LinkTokenCreateRequest request = new LinkTokenCreateRequest()
                    .user(user)
                    .clientName("Budget Me")
                    .products(Arrays.asList(Products.fromValue("assets"), Products.fromValue("transactions")))
                    .countryCodes(Arrays.asList(CountryCode.US))
                    .language("en");
            Response<LinkTokenCreateResponse> response = plaidClient

                    .linkTokenCreate(request)

                    .execute();

            // Send the data to the client


            return new LinkToken(response.body().getLinkToken());
        }
        @PostMapping(path = "createAccessToken", consumes = "text/plain")
        public ResponseEntity createAccessToken(@RequestBody String public_token, @CookieValue(value = "sessionId") int sessionId) throws IOException {

            //Creates a request object with the public token to be exchanged
            ItemPublicTokenExchangeRequest request = new ItemPublicTokenExchangeRequest()
                    .publicToken(public_token);
            //Sends the request to plaid and returns with the access token, an id, and a request id in the response

            Response<ItemPublicTokenExchangeResponse> response = plaidClient
                    .itemPublicTokenExchange(request)
                    .execute();

            //Checks the repository to see if the bank information is already linked

            PlaidAccessToken checkForSavedToken = accessTokenRepository.findByitemId(response.body().getItemId());

            //Returns an error if the bank account has an access token

            if(checkForSavedToken != null){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bank account already registered!");

                //Creates an access token object which relates to the current user and the current item associated with
                //a bank account and saves it to the database

            } else if (checkForSavedToken == null){
                User user = userRepository.findById(sessionId);
                PlaidAccessToken plaidAccessToken =
                        new PlaidAccessToken(response.body().getAccessToken(), user, response.body().getItemId());
                accessTokenRepository.save(plaidAccessToken);
                return ResponseEntity.ok("Access token saved");

                //Don't know when this would be used but figured it should be here

            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong...");
            }

    }



    }


