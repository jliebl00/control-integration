/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.history.condition;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author dorian
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    es.unileon.ulebank.history.condition.ConditionTransactionBetweenTwoAmountsTest.class, 
    es.unileon.ulebank.history.condition.ConditionSubjectTest.class, 
    es.unileon.ulebank.history.condition.ConditionalTransactionBetweenTwoDays.class})
public class PackageConditionTest {
    
}
