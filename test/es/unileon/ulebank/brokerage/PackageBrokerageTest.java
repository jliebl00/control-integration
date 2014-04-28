/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.brokerage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author dorian
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({es.unileon.ulebank.brokerage.BagSimulatorTest.class,
es.unileon.ulebank.brokerage.pack.PackageBrokeragePackTest.class,
es.unileon.ulebank.brokerage.fees.PackageBrokerageFeesTest.class})

public class PackageBrokerageTest {
    
}
