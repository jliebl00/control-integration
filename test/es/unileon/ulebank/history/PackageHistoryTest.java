/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.history;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author dorian
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    es.unileon.ulebank.history.HistoryTest.class,
es.unileon.ulebank.history.condition.PackageConditionTest.class,
es.unileon.ulebank.history.iterator.PackageIteratorTest.class})
public class PackageHistoryTest {
    
}
