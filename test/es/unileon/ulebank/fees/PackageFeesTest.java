/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.fees;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author dorian
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    es.unileon.ulebank.fees.FeeStrategyTest.class, 
    es.unileon.ulebank.fees.LinearFeeTest.class, 
    es.unileon.ulebank.fees.ScaledPercentFeeTest.class, 
    es.unileon.ulebank.fees.FeeStepTest.class})

public class PackageFeesTest {}
