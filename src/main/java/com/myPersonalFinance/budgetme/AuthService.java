package com.myPersonalFinance.budgetme;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private String accessToken;

    public String getAccessToken() {

        return accessToken;
    }

    public void setAccessToken(String accessToken) {

        this.accessToken = accessToken;
    }

}
