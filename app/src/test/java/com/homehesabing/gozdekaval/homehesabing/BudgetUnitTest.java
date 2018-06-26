package com.homehesabing.gozdekaval.homehesabing;

import com.homehesabing.gozdekaval.homehesabing.model.Budget;
import com.homehesabing.gozdekaval.homehesabing.model.Expense;
import com.homehesabing.gozdekaval.homehesabing.model.HouseMate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class BudgetUnitTest {

    //float totalAmount = getTotalExpenseAmount();
    //String message = getMessage(totalAmount);


    private Budget budgetNo;
    private Budget budgetEq;
    private Budget budgetMore;

    private String prefix = "Total expense is :";

    @Before
    public void prepareBudgetData(){
        HouseMate houseMate1 = new HouseMate("a");
        houseMate1.addExpense(3);
        HouseMate houseMate2 = new HouseMate("b");
        houseMate2.addExpense(3);
        budgetEq = new Budget(houseMate1,houseMate2);

        HouseMate houseMate3 = new HouseMate("c");
        houseMate3.addExpense(2);

        budgetMore = new Budget(houseMate1,houseMate3);

        HouseMate houseMate5 = new HouseMate("e");
        houseMate5.addExpense(0);
        HouseMate houseMate6 = new HouseMate("f");
        houseMate6.addExpense(0);
        budgetNo = new Budget(houseMate5,houseMate6);
    }

    /*
    * if(houseMate1.hasNoExpense() && houseMate2.hasNoExpense()){
            message = "no expense";
        }else if(houseMate1.isPaidMore(houseMate2)){
            message = houseMate1.getName() + " paid more";
        }else if(houseMate2.isPaidMore(houseMate1)) {
            message = houseMate2.getName() + " paid more";
        }else if(houseMate1.isPaidEqual(houseMate2)){
            message = houseMate1.getName() + " and " + houseMate2.getName() + " paid equal";
        }
      eturn  "Total expense is :" + totalAmount + " " +message;
    * */
    @Test
    public void noExpenseMessage(){
        String m = "no expense";
        assertEquals(m,budgetNo.getMessage(0));
    }

    @Test
    public void equalPaymentMessage(){
        String m = "6.0 a and b paid equal";
        assertEquals(prefix+m,budgetEq.getMessage(6));
    }

    @Test
    public void houseMate1PaidMoreMessage(){

    }

    @Test
    public void houseMate1PaidLessMessage(){

    }


}