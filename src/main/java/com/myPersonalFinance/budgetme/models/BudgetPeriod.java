package com.myPersonalFinance.budgetme.models;

import com.myPersonalFinance.budgetme.controllers.BudgetPeriodController;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BudgetPeriod {

    @Id //primary key
    @GeneratedValue //generate values for primary key
    private int id;

    @Column
    private String startDate;
    @Column
    private String endDate;

   // @Column
    //private Local dueDate;

//    @Column
//    private double budgetAmount;

    public BudgetPeriod() {
    }
    public BudgetPeriod(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        //this.dueDate = dueDate;
        //this.budgetAmount = budgetAmount;
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

//    public Local getDueDate() {
//        return dueDate;
//    }

//    public void setDueDate(Local dueDate) {
//        this.dueDate = dueDate;
//    }

//    public double getBudgetAmount() {
//        return budgetAmount;
//    }

//    public void setBudgetAmount(double budgetAmount) {
//        this.budgetAmount = budgetAmount;
//    }
}