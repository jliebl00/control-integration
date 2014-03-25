/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.brokerage.fees;

import es.unileon.ulebank.fees.FeeStrategy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roobre
 */
public class FeeStrategyTest {

    public FeeStrategyTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetFee() {
        System.out.println("getFee");
        double value = 0.0;
        FeeStrategy instance = new FeeStrategyImpl();
        double expResult = 0.0;
        double result = instance.getFee(value);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    public class FeeStrategyImpl implements FeeStrategy {

        public double getFee(double value) {
            return 0.0;
        }
    }

}