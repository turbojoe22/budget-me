package com.myPersonalFinance.budgetme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@SpringBootApplication
public class BudgetMeApplication {
	@Configuration
	public class ViewResolverConfig {
		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/static/");
			viewResolver.setSuffix(".html");
			return viewResolver;
		}
	}


	public static void main(String[] args) {

		SpringApplication.run(BudgetMeApplication.class, args);



	}
}
