package com.myPersonalFinance.budgetme.controllers;

import com.myPersonalFinance.budgetme.data.ExpenseRepository;
import com.myPersonalFinance.budgetme.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @PostMapping(path="/create-expense", consumes="application/json")
    public ResponseEntity<String> createExpense(@RequestBody Expense expense) {

        System.out.println(expense.getExpenseId());

        try {
            expenseRepository.save(expense);
            return ResponseEntity.ok("Expense created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during expense creation.");
        }
    }

    @GetMapping(path="/expenses")
    public List<Expense> listExpenses() {
        System.out.println(expenseRepository.findAll());
        return expenseRepository.findAll();

    }
}


