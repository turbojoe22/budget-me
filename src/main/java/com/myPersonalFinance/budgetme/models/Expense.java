package com.myPersonalFinance.budgetme.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int expenseId;
    @Column
    @NotBlank(message= "Name is required")
    private String expenseName;

    @Column
    private int amount ;
    @Column
    String frequency;

    @Column
    private boolean isRepeated;
    @Column
    String dueDate;
    @Column
    private String category;


    public Expense(String expenseName,int amount, String frequency, boolean isRepeated, String dueDate, String category) {
        this.expenseName = expenseName;
        this.amount = amount;
        this.frequency = frequency;
        this.isRepeated = isRepeated;
        this.dueDate = dueDate;
        this.category = category;
    }

    public Expense() {}

    public int getExpenseId() {
        return expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setName(String expenseName) {
        this.expenseName = expenseName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount() {
        this.amount = amount;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean getIsRepeated() {
        return isRepeated;
    }

    public void setIsRepeated(boolean isRepeated) {
        this.isRepeated = isRepeated;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDue_date(String due_date) {
        this.dueDate = due_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;
        Expense expense = (Expense) o;
        return expenseId == expense.expenseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId);
    }

    public String toString() {

        if (this.category.equals("")){
            this.category = "-";
        }
        if (this.frequency.equals("")) {
            this.frequency = "-";
        }
        return "\n" + "ID: " + getExpenseId() + "\n" +
                "Name: " + getExpenseName() + "\n" +
                "Amount: " + getAmount() + "\n" +
                "Frequency: " + getFrequency() + "\n" +
                "Current due date: "  + getDueDate() + "\n" +
                "Repeating: " + getIsRepeated() + "\n" +
                "Category: " + getCategory() + "\n";
    }
}
