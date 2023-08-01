package com.myPersonalFinance.budgetme.controllers;

import com.myPersonalFinance.budgetme.data.ExpenseRepository;
import com.myPersonalFinance.budgetme.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @PostMapping(path="/add", consumes="application/json")
    public void addExpense(@RequestBody Expense expense) {

//        expenseRepository.findById(expense.getExpenseId());

        System.out.println(expense.getExpenseId());

        expenseRepository.save(expense);

    }
}
