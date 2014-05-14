/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.fees;

import es.unileon.ulebank.fees.LinearFee;
import es.unileon.ulebank.fees.InvalidFeeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author roobre, dain735
 */
public class LinearFeeTest {

	LinearFee linearFee1;
	LinearFee linearFee2;
	LinearFee linearFee3;
	LinearFee linearFee4;
	
    public LinearFeeTest() {
    }

    @Before
    public void setUp() throws InvalidFeeException {
    	linearFee1 = new LinearFee(0.2, 10);
    	linearFee2 = new LinearFee(0.2, 0);
    }

    @Test
    public void testGetFee() {
        assertEquals(10, linearFee1.getFee(1), 0.0);
        assertEquals(100*0.2, linearFee2.getFee(100), 0.0);
    }
    
    @Test (expected = InvalidFeeException.class)
    public void testInvalidFeeExceptionFee() throws InvalidFeeException {
    	linearFee3 = new LinearFee(-0.2, 0);	
    }
    
    @Test (expected = InvalidFeeException.class)
    public void testInvalidFeeExceptionMin() throws InvalidFeeException {
    	linearFee3 = new LinearFee(0.2, -10);	
    }

}