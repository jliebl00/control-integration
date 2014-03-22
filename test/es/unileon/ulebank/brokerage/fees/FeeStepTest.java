/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.brokerage.fees;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author roobre
 */
public class FeeStepTest {
	
	FeeStep feeStep1 = new FeeStep(0, 1000, 0.01);
	FeeStep feeStep2 = new FeeStep(1000, 1200, 0.2);
//	FeeStep feeStep3 = new FeeStep(1000, 500, 0.03);
	FeeStep feeStep4 = new FeeStep(800, 1200, 0.5);

    public FeeStepTest() {
    }

    @Before
    public void setUp() {
    	
    }

    @Test
    public void testGetFee() {
        assertEquals(0.01, feeStep1.getFee(), 0.0);
        assertEquals(0.2, feeStep2.getFee(), 0.0);
//        assertEquals(0.03, feeStep3.getFee(), 0.0);
        assertEquals(0.5, feeStep4.getFee(), 0.0);
    }

    @Test
    public void testGetLow() {
        assertEquals(0, feeStep1.getLow(), 0.0);
        assertEquals(1000, feeStep2.getLow(), 0.0);
//        assertEquals(1000, feeStep3.getLow(), 0.0);
        assertEquals(800, feeStep4.getLow(), 0.0);
    }

    @Test
    public void testGetHigh() {
        assertEquals(1000, feeStep1.getHigh(), 0.0);
        assertEquals(1200, feeStep2.getHigh(), 0.0);
//        assertEquals(500, feeStep3.getHigh(), 0.0);
        assertEquals(1200, feeStep4.getHigh(), 0.0);
    }

    @Test
    public void testWraps() {
        
        assertTrue(feeStep1.wraps(100));
        assertTrue(feeStep1.wraps(0));
        assertFalse(feeStep1.wraps(1000));
        assertFalse(feeStep1.wraps(1001));
        
        assertTrue(feeStep2.wraps(1100));
        assertTrue(feeStep2.wraps(1000));
        assertFalse(feeStep2.wraps(1200));
        assertFalse(feeStep2.wraps(1234));
        
        assertTrue(feeStep4.wraps(800));
        assertTrue(feeStep4.wraps(1000));
        assertFalse(feeStep4.wraps(1200));
        assertFalse(feeStep4.wraps(1234));
        
    }

    @Test
    public void testCollides() {
        assertFalse(feeStep1.collides(feeStep2));
//        assertFalse(feeStep1.collides(feeStep3));
        assertTrue(feeStep1.collides(feeStep1));
        assertTrue(feeStep1.collides(feeStep4));
        
        assertTrue(feeStep2.collides(feeStep2));
        assertTrue(feeStep2.collides(feeStep4));
        
        assertTrue(feeStep4.collides(feeStep4));
    }

    @Test
    public void testToString() {
        assertEquals("[0.0,1000.0)", feeStep1.toString());
        assertEquals("[1000.0,1200.0)", feeStep2.toString());
        assertEquals("[800.0,1200.0)", feeStep4.toString());
    }

}