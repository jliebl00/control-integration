package es.unileon.ulebank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test all the test suites of the aplication
 *
 * @author dorian
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
            es.unileon.ulebank.account.PackageAccountTest.class,
    es.unileon.ulebank.bank.PackageBankTest.class,
    es.unileon.ulebank.command.PackageCommandTest.class,
    es.unileon.ulebank.history.PackageHistoryTest.class,
    es.unileon.ulebank.office.PackageOfficeTest.class,
    es.unileon.ulebank.time.PackageTime.class,
    es.unileon.ulebank.transactionManager.PackageTransactionManager.class,
    es.unileon.ulebank.users.PackageUsersTest.class,
    es.unileon.ulebank.handler.PackageHandlerTest.class,
    es.unileon.ulebank.fees.PackageFeesTest.class,
    es.unileon.ulebank.pack.PackagePackTest.class,
    es.unileon.ulebank.brokerage.PackageBrokerageTest.class

})

public class AllTest {
}