package com.myPersonalFinance.budgetme.data;

import com.myPersonalFinance.budgetme.models.ActualTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<ActualTransaction, Integer> {

}
