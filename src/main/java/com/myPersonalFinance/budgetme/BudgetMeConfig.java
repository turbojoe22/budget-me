package com.myPersonalFinance.budgetme;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;




public  class BudgetMeConfig {
    @NotEmpty
    private String plaidClientID;

    @NotEmpty
    private String plaidSecret;

    @NotEmpty
    private String plaidEnv;

    @NotEmpty
    private String plaidProducts;

    @NotEmpty
    private String plaidCountryCodes;


    @JsonProperty
    public String getPlaidClientID() {
        return plaidClientID;
    }

    @JsonProperty
    public String getPlaidSecret() {
        return plaidSecret;
    }

    @JsonProperty
    public String getPlaidEnv() {
        return plaidEnv;
    }

    @JsonProperty
    public String getPlaidProducts() {
        return plaidProducts;
    }

    @JsonProperty
    public String getPlaidCountryCodes() {
        return plaidCountryCodes;
    }
}
