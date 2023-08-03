package com.myPersonalFinance.budgetme.data;

import com.myPersonalFinance.budgetme.models.PlaidAccessToken;
import com.myPersonalFinance.budgetme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenRepository extends JpaRepository<AccessTokenRepository, Integer> {
    PlaidAccessToken findById(int Id);
}
