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
 * @author roobre, dain735
 */
public class ScaledPercentFeeTest {

	FeeStep feeStep1;
	FeeStep feeStep2;
	FeeStep feeStep3;
	FeeStep feeStep4;
	ScaledPercentFee instance;
	ScaledPercentFee instance2;
	
    public ScaledPercentFeeTest() {
    }

    @Before
    public void setUp() throws InvalidStepException, InvalidFeeException {
    	instance = new ScaledPercentFee(0.0);
    	instance2 = new ScaledPercentFee(10.0);
    	feeStep1 = new FeeStep(0, 1000, 0.01);
    	feeStep2 = new FeeStep(900, 1200, 0.2);
    	feeStep3 = new FeeStep(1200, 2000, 0.03);
    	feeStep4 = new FeeStep(800, 1200, 0.5);
    }

    @Test
    public void testAddStep() throws Exception {
        instance.addStep(feeStep1);
        
//        try {
//			instance.addStep(feeStep2);
//		} catch (CrossedStepException e) {
//			e.printStackTrace();
//		}
        
        instance.addStep(feeStep3);
        
//        try {
//			instance.addStep(feeStep4);
//		} catch (CrossedStepException e) {
//			e.printStackTrace();
//		}
    }
    
    @Test(expected = CrossedStepException.class)
    public void testCrossedStepException() throws InvalidStepException, InvalidFeeException, CrossedStepException {
    	instance.addStep(feeStep1);
    	instance.addStep(feeStep2);
    }

    @Test
    public void testGetFee() throws InvalidFeeException, CrossedStepException {
    	instance2.addStep(feeStep1);
    	instance2.addStep(feeStep3);
    	assertEquals(500*0.01+10, instance2.getFee(500), 0.0);
    	assertEquals(0*0.01+10, instance2.getFee(0), 0.0);
    	assertFalse(1100*0.01+10==(instance2.getFee(1100)));		//1100 is not in feeStep1 but we are considering so
    	assertEquals(1500*0.03+10, instance2.getFee(1500), 0.0);
    	
    }

}