package com.myPersonalFinance.budgetme.data;

import com.myPersonalFinance.budgetme.models.PlaidAccessToken;
import com.myPersonalFinance.budgetme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTokenRepository extends JpaRepository<PlaidAccessToken, Integer> {
    PlaidAccessToken findById(int id);
    PlaidAccessToken findByitemId(String itemId);
}
