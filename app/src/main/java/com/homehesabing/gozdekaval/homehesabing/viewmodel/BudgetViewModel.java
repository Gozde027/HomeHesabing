package com.homehesabing.gozdekaval.homehesabing.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.homehesabing.gozdekaval.homehesabing.model.Budget;
import com.homehesabing.gozdekaval.homehesabing.model.HouseMate;

/**
 * Created by Gozde Kaval on 6/25/2018.
 */

public class BudgetViewModel extends ViewModel {

    //https://stackoverflow.com/questions/48684547/databinding-observablefield-of-custom-object-it-is-not-working-properly

    //https://stackoverflow.com/questions/48020377/livedata-update-on-object-field-change

    public final ObservableField<Budget> budgetObservableField = new ObservableField<>();

    private Budget budget;

    public void init(HouseMate houseMate1, HouseMate houseMate2) {
        budget = new Budget(houseMate1,houseMate2);
        budgetObservableField.set(budget);
    }

    public String houseMate1Name(){
        return budget.getHouseMate1().getName();
    }

    public String houseMate2Name(){
        return budget.getHouseMate2().getName();
    }

    //button click -> will update model
    public void addExpenseForHouseMate1(){
        budget.addExpenseForHouseMate1();
        notifyChange();
    }

    //button click -> will update model
    public void addExpenseForHouseMate2(){
        budget.addExpenseForHouseMate2();
        notifyChange();
    }

    private void notifyChange(){
        budgetObservableField.notifyChange();
    }

    //button click -> observable for activity
    public void calculate(){
        budget.prepareTotalMessage();
    }

    public LiveData<String> getMessage(){
        return budget.budgetMessage;
    }

    public void reset(){
        budget.resetBudget();
        notifyChange();
    }
}
