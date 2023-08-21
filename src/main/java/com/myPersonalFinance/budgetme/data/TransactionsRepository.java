package com.myPersonalFinance.budgetme.data;

import com.myPersonalFinance.budgetme.models.ActualTransaction;
import com.myPersonalFinance.budgetme.models.PlaidAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<ActualTransaction, Integer> {
    List<ActualTransaction> findByUserId(Integer user_id);
    List<ActualTransaction> findByUserIdOrderByDateDesc(Integer user_id);
    List<ActualTransaction> findByUserIdOrderByDateAsc(Integer user_id);
    List<ActualTransaction> findByUserIdOrderByAmountDesc(Integer user_id);
    List<ActualTransaction> findByUserIdOrderByAmountAsc(Integer user_id);
    List<ActualTransaction> findByUserIdOrderByCategoryDesc(Integer user_id);
    List<ActualTransaction> findByUserIdOrderByCategoryAsc(Integer user_id);

}
