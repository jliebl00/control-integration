package es.unileon.ulebank;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.IdDNI;
import es.unileon.ulebank.handler.IdOffice;

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
	IdDNI dni;
	ArrayList<Employee> employeeTestList;
	ArrayList<Account> accountTest;
	Account testAccount;
	int testExpenses;
	int totalExpenses;
	int totalIncome;
	
	@Before
	public void setUp() {
		dni = new IdDNI("36167364W");
		idTestOffice = new IdOffice(1234);
		oneEmployee = new Employee("name", "surname", "address", 0, dni);
		
		employeeTestList = new ArrayList<>();
		accountTest = new ArrayList<>();
		
		testAccount = new Account();
		
		testOffice = new Office(idTestOffice);
		
		testExpenses = 1000;
		totalExpenses = 3000;
		totalIncome = 1000;
		
		testOffice.setExpenses(testExpenses, testExpenses, testExpenses);
	}

	@Test
	public void testGetIdOffice() {

//		Handler expected = idTestOffice;
//		Handler result = testOffice.getIdOffice();
//		assertEquals(result, expected);

		Handler expected = idTestOffice;
		Handler result = testOffice.getIdOffice();
		assertEquals(expected, result);
		
	}

	@Test
	public void testSetIdOffice() {
		Handler idOffice = new IdOffice(5995);
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
		result =testOffice.getTotalIncome();
		
		assertNotEquals(result, expected);
		
	}

	@Test
	public void testGetEmployeeList() {
		testOffice.setEmployeeList(employeeTestList);
		ArrayList <Employee> result = testOffice.getEmployeeList();
		ArrayList <Employee> expected = employeeTestList;
		
		assertEquals(result, expected);
		}

	@Test
	public void testSetEmployeeList() {
		testOffice.setEmployeeList(employeeTestList);
		ArrayList <Employee> result = testOffice.getEmployeeList();
		ArrayList <Employee> expected = employeeTestList;
		
		assertEquals(result, expected);
		
	}

	@Test
	public void testGetAccountList() {
		testOffice.setAccountList(accountTest);
		ArrayList <Account> result = testOffice.getAccountList();
		ArrayList <Account> expected = accountTest;
		
		assertEquals(result, expected);
	}

	@Test
	public void testSetAccountList() {
		testOffice.setAccountList(accountTest);;
		ArrayList <Account> result = testOffice.getAccountList();
		ArrayList <Account> expected = accountTest;
		
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
