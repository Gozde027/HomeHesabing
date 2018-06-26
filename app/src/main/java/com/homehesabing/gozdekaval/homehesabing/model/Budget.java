package com.homehesabing.gozdekaval.homehesabing.model;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.VisibleForTesting;

/**
 * Created by Gozde Kaval on 6/25/2018.
 */

public class Budget {

    private HouseMate houseMate1;
    private HouseMate houseMate2;

    public MutableLiveData<String> budgetMessage = new MutableLiveData<>();

    public Budget(HouseMate houseMate1, HouseMate houseMate2){
        this.houseMate1 = houseMate1;
        this.houseMate2 = houseMate2;
    }

    public void addExpenseForHouseMate1(){
        houseMate1.addExpense(4);
    }

    public void addExpenseForHouseMate2(){
        houseMate2.addExpense(5);
    }

    public String getHouseMate1Expense(){
        return houseMate1.getExpense().getString();
    }

    public String getHouseMate2Expense(){
        return houseMate2.getExpense().getString();
    }

    private float getTotalExpenseAmount(){
        return houseMate1.getExpense().getAmount() + houseMate2.getExpense().getAmount();
    }

    public String getMessage(float totalAmount){
        String message = "";

        if(houseMate1.hasNoExpense() && houseMate2.hasNoExpense()){
            return "no expense";
        }else if(houseMate1.isPaidMore(houseMate2)){
            message = houseMate1.getName() + " paid more";
        }else if(houseMate2.isPaidMore(houseMate1)) {
            message = houseMate2.getName() + " paid more";
        }else if(houseMate1.isPaidEqual(houseMate2)){
            message = houseMate1.getName() + " and " + houseMate2.getName() + " paid equal";
        }

        return  "Total expense is :" + totalAmount + " " +message;
    }

    public void prepareTotalMessage(){
        float totalAmount = getTotalExpenseAmount();
        String message = getMessage(totalAmount);
        budgetMessage.setValue(message);
    }

    public void resetBudget(){
        houseMate1.resetExpense();
        houseMate2.resetExpense();
    }

    public HouseMate getHouseMate1() {
        return houseMate1;
    }

    public HouseMate getHouseMate2() {
        return houseMate2;
    }
}
