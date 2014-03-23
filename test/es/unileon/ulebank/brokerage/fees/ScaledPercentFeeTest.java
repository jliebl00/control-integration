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
	
	FeeStep feeStep1 = new FeeStep(0, 1000, 0.01);
	FeeStep feeStep2 = new FeeStep(1000, 1200, 0.2);
	FeeStep feeStep3 = new FeeStep(1200, 2000, 0.03);
	FeeStep feeStep4 = new FeeStep(800, 1200, 0.5);

    public ScaledPercentFeeTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testAddStep() throws Exception {
        ScaledPercentFee instance = new ScaledPercentFee(0.0);
        instance.addStep(feeStep1);
        
        try {
			instance.addStep(feeStep2);
		} catch (CrossedStepException e) {
			e.printStackTrace();
		}
        
        instance.addStep(feeStep3);		//Throws CrossedStepException but it shouldn't
        
        try {
			instance.addStep(feeStep4);
		} catch (CrossedStepException e) {
			e.printStackTrace();
		}
    }

    @Test
    public void testGetFee() throws CrossedStepException {
    	ScaledPercentFee instance = new ScaledPercentFee(10);
    	instance.addStep(feeStep1);
//    	instance.addStep(feeStep3);
    	assertEquals(500*0.01+10, instance.getFee(500), 0.0);
    	assertEquals(0*0.01+10, instance.getFee(0), 0.0);
    	assertFalse(1100*0.01+10==(instance.getFee(1100)));		//1100 is not in feeStep1 but we are considering so
    	
    }

}