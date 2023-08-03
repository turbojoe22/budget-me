package com.myPersonalFinance.budgetme.models;

import javax.persistence.*;

@Entity
public class PlaidAccessToken {
    @Id
    @GeneratedValue
    private int Id;

    @Column(nullable = false)
    private String accessToken;
    @ManyToOne
    private User user;

    public PlaidAccessToken(){}
    public PlaidAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getId() {
        return Id;
    }

    public String getAccessToken() {

        return accessToken;
    }

    public void setAccessToken(String accessToken) {

        this.accessToken = accessToken;
    }

}
