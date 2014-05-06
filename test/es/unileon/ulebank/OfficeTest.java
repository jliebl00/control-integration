package es.unileon.ulebank;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.bank.handler.BankHandler;
import es.unileon.ulebank.exceptions.MalformedHandlerException;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.OfficeHandler;
import es.unileon.ulebank.transacionManager.TransactionManager;

/**
 * @author Pedro
 *
 */
public class OfficeTest {

    Office testOffice;
    Office anotherTestOffice;
    Handler idTestOffice;
    Handler anotherIdOffice;
    Employee oneEmployee;
    DNIHandler dni;
    ArrayList<Employee> employeeTestList;
    ArrayList<Account> accountTest;
    Account testAccount;
    int testExpenses;
    int totalExpenses;
    int totalIncome;
    
    Bank bank;

    @Before
    public void setUp() throws MalformedHandlerException {
        dni = new DNIHandler("36167364W");
        idTestOffice = new OfficeHandler(1234);
        oneEmployee = new Employee("name", "surname", "address", 0, dni);

        employeeTestList = new ArrayList<>();
        accountTest = new ArrayList<>();
        
        bank=new Bank(new TransactionManager(), new BankHandler("1234"));

//        testAccount = new CommercialAccountAccount();

        testOffice = new Office(idTestOffice,bank);

        testExpenses = 1000;
        totalExpenses = 3000;
        totalIncome = 1000;

        testOffice.setExpenses(testExpenses, testExpenses, testExpenses);
    }

    @Test
    public void testGetIdOffice() {
        Handler expected = idTestOffice;
        Handler result = testOffice.getIdOffice();
        assertEquals(expected, result);

    }

    @Test
    public void testSetIdOffice() throws MalformedHandlerException {
        Handler idOffice = new OfficeHandler(5995);
        testOffice.setIdOffice(idOffice);

        Handler result = testOffice.getIdOffice();
        assertEquals(idOffice, result);
    }

    @Test
    public void testGetExpenses() {
        assertTrue(testOffice.getExpenses() == totalExpenses);
    }

    @Test
    public void testSetExpenses() {
        int newTestExpenses = 3000;
        int newTotalExenses = 9000;
        testOffice.setExpenses(newTestExpenses, newTestExpenses, newTestExpenses);

        assertTrue(newTotalExenses == testOffice.getExpenses());
    }

    @Test
    public void testGetTotalIncome() {
        testOffice.setTotalIncome(totalIncome);
        int result = testOffice.getTotalIncome();
        int expected = totalIncome;

        assertEquals(result, expected);
    }

    @Test
    public void testSetTotalIncome() {
        int testIncome = 3000;
        testOffice.setTotalIncome(totalIncome);
        int result = testOffice.getTotalIncome();
        int expected = totalIncome;

        assertEquals(result, expected);

        testOffice.setTotalIncome(testIncome);
        result = testOffice.getTotalIncome();

        assertTrue(result!=expected);

    }

    @Test
    public void testGetEmployeeList() {
        testOffice.setEmployeeList(employeeTestList);
        ArrayList<Employee> result = testOffice.getEmployeeList();
        ArrayList<Employee> expected = employeeTestList;

        assertEquals(result, expected);
    }

    @Test
    public void testSetEmployeeList() {
        testOffice.setEmployeeList(employeeTestList);
        ArrayList<Employee> result = testOffice.getEmployeeList();
        ArrayList<Employee> expected = employeeTestList;

        assertEquals(result, expected);

    }

    @Test
    public void testGetAccountList() {
        testOffice.setAccountList(accountTest);
        ArrayList<Account> result = testOffice.getAccountList();
        ArrayList<Account> expected = accountTest;

        assertEquals(result, expected);
    }

    @Test
    public void testSetAccountList() {
        testOffice.setAccountList(accountTest);;
        ArrayList<Account> result = testOffice.getAccountList();
        ArrayList<Account> expected = accountTest;

        assertEquals(result, expected);

    }

    @Test
    public void testAddEmployee() {
        testOffice.setEmployeeList(employeeTestList);
        testOffice.addEmployee(oneEmployee);

        Employee result = employeeTestList.get(0);
        Employee expected = oneEmployee;

        assertEquals(result, expected);

    }

    @Test
    public void testDeleteEmployee() {
        testOffice.setEmployeeList(employeeTestList);
        testOffice.addEmployee(oneEmployee);

        Employee result = employeeTestList.get(0);
        Employee expected = oneEmployee;

        assertEquals(result, expected);

        testOffice.deleteEmployee(oneEmployee);
        assertTrue(employeeTestList.isEmpty());
    }

    @Test
    public void testAddAccount() {
        testOffice.setAccountList(accountTest);
        testOffice.addAccount(testAccount);

        Account result = accountTest.get(0);
        Account expected = testAccount;

        assertEquals(result, expected);
    }

    @Test
    public void testDeleteAccount() {
        testOffice.setAccountList(accountTest);
        testOffice.addAccount(testAccount);

        Account result = accountTest.get(0);
        Account expected = testAccount;

        assertEquals(result, expected);

        testOffice.deleteAccount(testAccount);
        assertTrue(accountTest.isEmpty());
    }

}
