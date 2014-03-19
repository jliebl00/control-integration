/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.brokerage.fees;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author roobre
 */
public class FeeStepTest {

    public FeeStepTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetFee() {
        System.out.println("getFee");
        FeeStep instance = null;
        double expResult = 0.0;
        double result = instance.getFee();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLow() {
        System.out.println("getLow");
        FeeStep instance = null;
        double expResult = 0.0;
        double result = instance.getLow();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHigh() {
        System.out.println("getHigh");
        FeeStep instance = null;
        double expResult = 0.0;
        double result = instance.getHigh();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testWraps() {
        System.out.println("wraps");
        double value = 0.0;
        FeeStep instance = null;
        boolean expResult = false;
        boolean result = instance.wraps(value);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCollides() {
        System.out.println("collides");
        FeeStep another = null;
        FeeStep instance = null;
        boolean expResult = false;
        boolean result = instance.collides(another);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        FeeStep instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}