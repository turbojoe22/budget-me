package com.myPersonalFinance.budgetme.models;

import javax.persistence.*;

@Entity
public class PlaidAccessToken {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String accessToken;
    @Column(nullable = false)
    private String itemId;
    @Column(nullable = false)
    private String cursor;
    @ManyToOne
    private User user;

    public PlaidAccessToken(){}
    public PlaidAccessToken(String accessToken, User user, String itemId) {
        this.accessToken = accessToken;
        this.user = user;
        this.itemId = itemId;
        this.cursor = cursor;

    }

    public int getId() {
        return id;
    }

    public String getAccessToken() {

        return accessToken;
    }

    public void setAccessToken(String accessToken) {

        this.accessToken = accessToken;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getItemId() {
        return itemId;
    }
}
