/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.brokerage;

import es.unileon.ulebank.brokerage.buyable.Enterprise;
import es.unileon.ulebank.handler.Handler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roobre
 */
public class BagSimulatorTest {

    public BagSimulatorTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetEnterpriseHandler() {
        System.out.println("getEnterpriseHandler");
        Handler enterpriseID = null;
        BagSimulator instance = null;
        Enterprise expResult = null;
        Enterprise result = instance.getEnterpriseHandler(enterpriseID);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}