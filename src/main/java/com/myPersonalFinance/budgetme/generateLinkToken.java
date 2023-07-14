package com.myPersonalFinance.budgetme;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import com.sun.net.httpserver.HttpExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.*;
import java.util.List;




@RestController
@RequestMapping("/api/")
    class GetLinkToken {

        private static PlaidApi plaidClient;
    @GetMapping(path = "generateLinkToken")
        public String handle() throws IOException {

            // Create your Plaid client

            HashMap<String, String> apiKeys = new HashMap<String, String>();


            apiKeys.put("clientId", "64a72eb489f8b500199bbbd0");

            apiKeys.put("secret", "48158393baddf3a9bb20423f5e44da");

            ApiClient apiClient = new ApiClient(apiKeys);

            apiClient.setPlaidAdapter(ApiClient.Sandbox);

            plaidClient = apiClient.createService(PlaidApi.class);

            // Get the clientUserId by searching for the current user


            LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()

                    .clientUserId("1");

            // Create a link_token for the given user

            LinkTokenCreateRequest request = new LinkTokenCreateRequest()

                    .user(user)

                    .clientName("Budget Me")

                    .products(Arrays.asList(Products.fromValue("auth")))

                    .countryCodes(Arrays.asList(CountryCode.US))

                    .language("en");


            Response<LinkTokenCreateResponse> response = plaidClient

                    .linkTokenCreate(request)

                    .execute();

            // Send the data to the client
        System.out.println(response.body().getLinkToken());
            return response.body().getLinkToken();
        }
        @PostMapping(path = "createAccessToken", consumes = "application/x-www-form-urlencoded;charset=UTF-8", produces = "application/json")
        public ItemPublicTokenExchangeResponse createAccessToken(PlaidApi plaidClient, @RequestBody String public_token) throws IOException {

            ItemPublicTokenExchangeRequest request = new ItemPublicTokenExchangeRequest()

                    .publicToken(public_token);

            Response<ItemPublicTokenExchangeResponse> response = plaidClient
                    .itemPublicTokenExchange(request)
                    .execute();
            System.out.println(response);

            accessToken

    }

    @GetMapping(path = "getAnswer")
    public ResponseEntity<?> getAnswer() {
        HashMap<String, String> response = new HashMap<>();
        response.put("data", "How are you doing?");
        return ResponseEntity.ok(response);

    }
    }

//public class generateLinkToken {
//
//    private final List<String> countryCodes;
//    final List<Products> correctedPlaidProducts;
//    private final List<CountryCode> correctedCountryCodes;
//
//    public generateLinkToken(List<String> countryCodes) {
//
//        this.countryCodes = countryCodes;
//        this.correctedPlaidProducts = new ArrayList<>();
//        this.correctedCountryCodes = new ArrayList<>();
//    }
//
//    public static class LinkToken {
//
//        @JsonProperty
//        private String linkToken;
//
//
//        public LinkToken(String linkToken) {
//            this.linkToken = linkToken;
//        }
//    }
//    @GetMapping(path = "generateLinkToken")
//    public String getLinkToken() throws IOException {
//
//
//        String clientUserId = Long.toString((new Date()).getTime());
//        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
//                .clientUserId(clientUserId);
//
////        for (int i = 0; i < this.plaidProducts.size(); i++){
////            this.correctedPlaidProducts.add(Products.fromValue(this.plaidProducts.get(i)));
////        };
//
//        for (int i = 0; i < this.countryCodes.size(); i++){
//            this.correctedCountryCodes.add(CountryCode.fromValue(this.countryCodes.get(i)));
//        };
//
//        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
//                .user(user)
//                .clientName("Budget Me")
//                .products(this.correctedPlaidProducts)
//                .countryCodes(this.correctedCountryCodes)
//                .language("en");
//
////        Response<LinkTokenCreateResponse> response =plaidClient
////                .linkTokenCreate(request)
////                .execute();
////        return new LinkToken(response.body().getLinkToken());
//  return "";
//    }
//
//
//
//
//
//
//
//
//    }



