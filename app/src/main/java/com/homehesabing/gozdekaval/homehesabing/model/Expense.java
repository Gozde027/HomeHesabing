package com.homehesabing.gozdekaval.homehesabing.model;

/**
 * Created by Gozde Kaval on 6/25/2018.
 */

public class Expense {

    private float amount;

    public Expense(){
        this.amount = 0;
    }

    public Expense(float amount){
        this.amount = amount;
    }

    public void add(float expense){
        amount += expense;
    }

    public void reset(){
        amount = 0;
    }

    public boolean hasNoAmount(){
        return amount == 0;
    }

    public boolean isBiggerThan(Expense otherExpense){
        return amount > otherExpense.amount;
    }

    public boolean isEqualWith(Expense otherExpense){
        return amount == otherExpense.amount;
    }

    public String getString(){
        return String.valueOf(amount);
    }

    public float getAmount() {
        return amount;
    }
}
