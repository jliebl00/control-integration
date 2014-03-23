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
public class LinearFeeTest {

    public LinearFeeTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetFee() throws InvalidFeeException {
    	LinearFee linearFee1 = new LinearFee(0.2, 10);
    	LinearFee linearFee2 = new LinearFee(0.2, 0);
    	
        assertEquals(100*0.2+10, linearFee1.getFee(100), 0.0);
        assertEquals(100*0.2+0, linearFee2.getFee(100), 0.0);
    }

}