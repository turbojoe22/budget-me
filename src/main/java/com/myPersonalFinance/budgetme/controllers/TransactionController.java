package com.myPersonalFinance.budgetme.controllers;

import com.myPersonalFinance.budgetme.data.TransactionsRepository;
import com.myPersonalFinance.budgetme.models.ActualTransaction;
import com.myPersonalFinance.budgetme.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionsRepository transactionsRepository;
    @GetMapping(path = "/getTransactionsNewestFirst")
    public List<ActualTransaction> listExpensesNewestFirst(@CookieValue(value = "sessionId")int sessionId) {
        return transactionsRepository.findByUserIdOrderByDateDesc(sessionId);

    }
    @GetMapping(path = "/getTransactionsOldestFirst")
    public List<ActualTransaction> listExpensesOldestFirst(@CookieValue(value = "sessionId")int sessionId) {
        return transactionsRepository.findByUserIdOrderByDateAsc(sessionId);

    }
    @GetMapping(path = "/getTransactionsAmountHighest")
    public List<ActualTransaction> listExpensesAmountHighest(@CookieValue(value = "sessionId")int sessionId) {
        return transactionsRepository.findByUserIdOrderByAmountDesc(sessionId);

    }
    @GetMapping(path = "/getTransactionsAmountLowest")
    public List<ActualTransaction> listExpensesAmountLowest(@CookieValue(value = "sessionId")int sessionId) {
        return transactionsRepository.findByUserIdOrderByAmountAsc(sessionId);

    }
    @GetMapping(path = "/getTransactionsCategoryZToA")
    public List<ActualTransaction> listExpensesAtoZ(@CookieValue(value = "sessionId")int sessionId) {
        return transactionsRepository.findByUserIdOrderByCategoryDesc(sessionId);

    }
    @GetMapping(path = "/getTransactionsCategoryAToZ")
    public List<ActualTransaction> listExpensesZtoA(@CookieValue(value = "sessionId")int sessionId) {
        return transactionsRepository.findByUserIdOrderByCategoryAsc(sessionId);

    }

}
