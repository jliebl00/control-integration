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
public class ScaledPercentFeeTest {

    public ScaledPercentFeeTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testAddStep() throws Exception {
        System.out.println("addStep");
        FeeStep step = null;
        ScaledPercentFee instance = null;
        instance.addStep(step);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFee() {
        System.out.println("getFee");
        double value = 0.0;
        ScaledPercentFee instance = null;
        double expResult = 0.0;
        double result = instance.getFee(value);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

}