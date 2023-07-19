package com.myPersonalFinance.budgetme.models;

import javax.persistence.Entity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Entity
public class User extends AbstractEntity {

    private String username;
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){
    };

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isMatchingPassword(String password) {

        return encoder.matches(password, pwHash);
    }
}