package com.homehesabing.gozdekaval.homehesabing.model;

/**
 * Created by Gozde Kaval on 6/25/2018.
 */

public class HouseMate {

    private String name;

    private Expense expense;

    public HouseMate(String name){
        this.name = name;
        this.expense = new Expense();
    }

    public void addExpense(float newExpense){
        expense.add(newExpense);
    }

    public String getName() {
        return name;
    }

    public Expense getExpense() {
        return expense;
    }

    public void resetExpense(){
        expense.reset();
    }

    public boolean hasNoExpense(){
        return expense.hasNoAmount();
    }

    public boolean isPaidMore(HouseMate otherHouseMate){
        return (expense.isBiggerThan(otherHouseMate.expense));
    }

    public boolean isPaidEqual(HouseMate otherHouseMate){
        return (expense.isEqualWith(otherHouseMate.expense));
    }
}
