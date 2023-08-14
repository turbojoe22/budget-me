package com.myPersonalFinance.budgetme.controllers;

import com.myPersonalFinance.budgetme.data.BudgetPeriodRepository;
import com.myPersonalFinance.budgetme.models.BudgetPeriod;
import com.myPersonalFinance.budgetme.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/budget-period-list")
public class BudgetPeriodController {

    @Autowired
    private BudgetPeriodRepository budgetPeriodRepository;

    @PostMapping(path="/create-budget-period", consumes="application/json")
    public ResponseEntity<String> setBudgetPeriod(@RequestBody BudgetPeriod budgetPeriod) {
        System.out.println(budgetPeriod);
        try {
            budgetPeriodRepository.save(budgetPeriod);

            return ResponseEntity.ok("Budget period received and saved!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving!");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<BudgetPeriod> getBudgetById(@PathVariable int id, @RequestBody BudgetPeriod budgetPeriod) {
        budgetPeriodRepository.findById(id);

        if (budgetPeriod != null) {
            return ResponseEntity.ok(budgetPeriod);
        } else {
            return ResponseEntity.notFound().build();


        }
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<BudgetPeriod>> getBudgetPeriodsByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
//        try {
//            List<BudgetPeriod> budgetPeriods = budgetPeriodRepository.findByStartDateBetween(startDate, endDate);
//            return ResponseEntity.ok(budgetPeriods);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//}
//    }

    @GetMapping("/list")
    public ResponseEntity<List<BudgetPeriod>> getBudgetPeriods() {
        try {
            List<BudgetPeriod> budgetPeriods = budgetPeriodRepository.findAll();
            return ResponseEntity.ok(budgetPeriods);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

//    @PutMapping(path = "/update", consumes = "application/json")
//    public ResponseEntity<String> updateBudgetPeriod(@RequestBody BudgetPeriod budgetPeriod) {
//        try {
//            budgetPeriodRepository.save(budgetPeriod);
//            return ResponseEntity.ok("Expense created successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during expense creation.");
//        }
//    }
//
    @PostMapping(path = "/delete")
    public ResponseEntity<List<BudgetPeriod>> deleteBudgetPeriod(@RequestBody List <Integer> budgetPeriodIds) {
        try {
            for (Integer budgetPeriodId : budgetPeriodIds) {
                budgetPeriodRepository.deleteById(budgetPeriodId);
        }
            List<BudgetPeriod> budgetPeriods = budgetPeriodRepository.findAll();

            return ResponseEntity.ok(budgetPeriods);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

