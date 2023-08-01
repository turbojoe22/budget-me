package com.myPersonalFinance.budgetme.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Entity
public class Expense {
    @Id
    @GeneratedValue
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
    private String tag;


    public Expense(String expenseName,int amount, String frequency, boolean isRepeated, String dueDate, String tag) {
        this.expenseName = expenseName;
        this.amount = amount;
        this.frequency = frequency;
        this.isRepeated = isRepeated;
        this.dueDate = dueDate;
        this.tag = tag;
    }

    public Expense() {}

    public int getExpenseId() {
        return expenseId;
    }

    public String getName() {
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

        if (this.tag.equals("")){
            this.tag = "Data not available";
        }
        if (this.frequency.equals("")) {
            this.frequency = "Data not available";
        }
        return "\n" + "ID: " + getExpenseId() + "\n" +
                "Name: " + getName() + "\n" +
                "Amount: " + getAmount() + "\n" +
                "Frequency: " + getFrequency() + "\n" +
                "Current due date: "  + getDueDate() + "\n" +
                "Repeating: " + getIsRepeated() + "\n" +
                "Tag: " + getTag() + "\n";
    }
}
