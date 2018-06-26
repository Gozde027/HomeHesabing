package com.homehesabing.gozdekaval.homehesabing;

import com.homehesabing.gozdekaval.homehesabing.model.HouseMate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gozde Kaval on 6/26/2018.
 */

public class HouseMateUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checkName(){
        HouseMate houseMate = new HouseMate("Gozde");
        assertEquals("Gozde",houseMate.getName());
    }

    @Test
    public void paid(){
        HouseMate houseMate1 = new HouseMate("Gozde");
        houseMate1.addExpense(45);

        HouseMate houseMate2 = new HouseMate("Alex");
        houseMate2.addExpense(12);

        assertEquals(true,houseMate1.isPaidMore(houseMate2));
        assertEquals(false,houseMate1.isPaidEqual(houseMate2));

        HouseMate houseMate3 = new HouseMate("Gozde");
        houseMate3.addExpense(5);

        HouseMate houseMate4 = new HouseMate("Alex");
        houseMate4.addExpense(5);

        assertEquals(false,houseMate3.isPaidMore(houseMate4));
        assertEquals(true,houseMate3.isPaidEqual(houseMate4));

        HouseMate houseMate5 = new HouseMate("Gozde");
        houseMate5.addExpense(5);

        HouseMate houseMate6 = new HouseMate("Alex");
        houseMate6.addExpense(6);

        assertEquals(false,houseMate5.isPaidMore(houseMate6));
        assertEquals(false,houseMate5.isPaidEqual(houseMate6));
    }

}
