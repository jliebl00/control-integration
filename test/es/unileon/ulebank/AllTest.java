package es.unileon.ulebank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite; 

/**
 * Test all the test suites of the aplication
 * @author dorian
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    es.unileon.ulebank.PackageUlebankTest.class,
    es.unileon.ulebank.handler.PackageHandlerTest.class,
    es.unileon.ulebank.fees.PackageFeesTest.class,
    es.unileon.ulebank.pack.PackagePackTest.class,
    es.unileon.ulebank.brokerage.PackageBrokerageTest.class
})

public class AllTest {}
