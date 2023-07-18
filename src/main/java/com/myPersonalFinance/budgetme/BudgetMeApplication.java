package com.myPersonalFinance.budgetme;

import com.plaid.client.ApiClient;
import com.plaid.client.request.PlaidApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class BudgetMeApplication{
	public static void main(String[] args) {

		SpringApplication.run(BudgetMeApplication.class, args);
	}

}
