package com.homehesabing.gozdekaval.homehesabing;

import com.homehesabing.gozdekaval.homehesabing.model.Expense;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gozde Kaval on 6/25/2018.
 */

public class ExpenseUnitTest {

    @Test
    public void increaseExpenseAmount(){
        Expense expense = new Expense();
        expense.add(12);
        expense.add(5);
        assertEquals(17,expense.getAmount(),Double.MAX_VALUE);
    }

    @Test
    public void resetExpense(){
        Expense expense = new Expense();
        expense.add(1345);
        expense.reset();
        assertEquals(0,expense.getAmount(),Double.MAX_VALUE);
    }

    @Test
    public void isExpensesEqual(){
        Expense expense = new Expense();
        expense.add(4);

        Expense expense2 = new Expense();
        expense2.add(4);

        assertEquals(true,expense.isEqualWith(expense2));

        expense2.add(4);
        assertEquals(false,expense.isEqualWith(expense2));
    }

    @Test
    public void isExpenseBigger(){
        Expense expense1 = new Expense();
        expense1.add(4);

        Expense expense2 = new Expense();
        expense2.add(5);

        assertEquals(false,expense1.isBiggerThan(expense2));
        assertEquals(true,expense2.isBiggerThan(expense1));
    }

    @Test
    public void hasNoAmount(){
        Expense expense1 = new Expense();
        expense1.add(0);

        Expense expense2 = new Expense();

        Expense expense3 = new Expense();
        expense3.add(5);

        Expense expense4 = new Expense();
        expense4.add(567);
        expense4.reset();

        assertEquals(true,expense1.hasNoAmount());
        assertEquals(true,expense2.hasNoAmount());
        assertEquals(false,expense3.hasNoAmount());
        assertEquals(true,expense4.hasNoAmount());
    }


}
