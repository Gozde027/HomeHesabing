package com.homehesabing.gozdekaval.homehesabing.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.homehesabing.gozdekaval.homehesabing.R;
import com.homehesabing.gozdekaval.homehesabing.databinding.BudgetActivityBinding;
import com.homehesabing.gozdekaval.homehesabing.model.HouseMate;
import com.homehesabing.gozdekaval.homehesabing.viewmodel.BudgetViewModel;

public class BudgetActivity extends AppCompatActivity  {

    private BudgetViewModel budgetViewModel;

    private HouseMate houseMate1 = new HouseMate("Gozde");
    private HouseMate houseMate2 = new HouseMate("Alex");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
    }

    private void bindViews(){
        BudgetActivityBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.budget_activity);
        budgetViewModel = ViewModelProviders.of(this).get(BudgetViewModel.class);
        budgetViewModel.init(houseMate1,houseMate2);
        activityBinding.setBudget(budgetViewModel);
        setUpCalculationDialogListener();
    }

    private void setUpCalculationDialogListener(){
        budgetViewModel.getMessage().observe(this,getBudgetMessageObserver());
    }

    private Observer<String> getBudgetMessageObserver(){
       return new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                popupWithMessage(s);
            }
        };
    }

    @VisibleForTesting
    public void popupWithMessage(String message){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton("Tamam", (dialog, id) -> {
            budgetViewModel.reset();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
