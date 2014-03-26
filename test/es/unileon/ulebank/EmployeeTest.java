package es.unileon.ulebank;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.IdDNI;
import es.unileon.ulebank.handler.IdOffice;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author dorian
 */
public class EmployeeTest {
	Employee oneEmployee;
	Employee anotherEmployee;
	IdDNI dni;
	IdDNI anotherDNI;
	IdOffice oneIdOffice;
	IdOffice anotherIdOffice;
	Office oneOffice;
	Office anotherOffice;
	float salary;

	@Before
	public void setUp() {
		salary = 5000;

		dni = new IdDNI("71463395A");
		anotherDNI = new IdDNI("36167364W");

		oneIdOffice = new IdOffice(1234);
		anotherIdOffice = new IdOffice(9876);

		oneOffice = new Office(oneIdOffice);
		anotherOffice = new Office(anotherIdOffice);

		oneEmployee = new Employee("name", "surname", "address", salary,
				oneOffice, dni);
		anotherEmployee = new Employee("name2", "surname2", "address2", salary,
				anotherOffice, anotherDNI);
	}

	/**
	 * Test of getName method, of class Employee.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		String expResult = "name";
		String result = oneEmployee.getName();
		assertEquals(expResult, result);

		expResult = "name2";
		result = anotherEmployee.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setName method, of class Employee.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "nameChanged";
		oneEmployee.setName(name);

		assertEquals(name, oneEmployee.getName());
	}

	/**
	 * Test of getSursursurname method, of class Employee.
	 */
	@Test
	public void testGetSurname() {
		System.out.println("getSurname");
		String expResult = "surname";
		String result = oneEmployee.getSurname();
		assertEquals(expResult, result);

		expResult = "surname2";
		result = anotherEmployee.getSurname();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setSursurname method, of class Employee.
	 */
	@Test
	public void testSetSurname() {
		System.out.println("setSurname");
		String surname = "surnameChanged";
		oneEmployee.setSurname(surname);

		assertEquals(surname, oneEmployee.getSurname());
	}

	/**
	 * Test of getIdOffice method, of class Employee.
	 */
	@Test
	public void testGetIdOffice() {
		System.out.println("getIdOffice");
		Office result = oneEmployee.getOffice();
		assertEquals(oneOffice, result);

		result = anotherEmployee.getOffice();
		assertEquals(anotherOffice, result);
	}

	/**
	 * Test of setIdOffice method, of class Employee.
	 */
	@Test
	public void testSetIdOffice() {
		System.out.println("setIdOffice");
		Handler idOffice = new IdOffice(5995);
		Office office = new Office(idOffice);
		oneEmployee.setOffice(office);

		Office result = oneEmployee.getOffice();
		assertEquals(office, result);
	}

	/**
	 * Test of getIdEmployee method, of class Employee.
	 */
	@Test
	public void testGetIdEmployee() {
		System.out.println("getIdEmployee");

		Handler expResult = dni;
		Handler result = oneEmployee.getIdEmployee();
		assertEquals(expResult, result);

		expResult = anotherDNI;
		result = anotherEmployee.getIdEmployee();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setIdEmployee method, of class Employee.
	 */
	@Test
	public void testSetIdEmployee() {
		System.out.println("setIdEmployee");
		Handler idEmployee = new IdDNI("62457969C");
		oneEmployee.setIdEmployee(idEmployee);

		Handler result = oneEmployee.getIdEmployee();
		assertEquals(idEmployee, result);
	}

	/**
	 * Test to set an invalid surname, surname must not be changed
	 */
	@Test
	public void testSetNullName() {
		String name = null;
		oneEmployee.setName(name);

		assertEquals("name", oneEmployee.getName());

		name = "";
		oneEmployee.setName(name);

		assertEquals("name", oneEmployee.getName());
	}

	/**
	 * Test to set an invalid surname, surname must not be changed
	 */
	@Test
	public void testSetNullSurname() {
		String surname = null;
		oneEmployee.setName(surname);

		assertEquals("surname", oneEmployee.getSurname());

		surname = "";
		oneEmployee.setSurname(surname);

		assertEquals("surname", oneEmployee.getSurname());
	}

	/**
	 * Test to set an invalid (null) idEmployee, the original id must not be
	 * changed
	 */
	@Test
	public void testSetNullIdEmployee() {
		Handler idEmployee = null;
		oneEmployee.setIdEmployee(idEmployee);

		Handler result = oneEmployee.getIdEmployee();
		assertEquals(dni, result);
	}

	/**
	 * Test the method getSalary()
	 */
	@Test
	public void testGetSalary() {
		assertEquals(5000, oneEmployee.getSalary(), 0);
	}

	/**
	 * Test the set salary a negative salary is not acepted
	 */
	@Test
	public void testSetSalary() {
		float newSalary = 3000;
		float badSalary = -1000;
		assertEquals(5000, oneEmployee.getSalary(), 0);
		oneEmployee.setSalary(newSalary);
		assertEquals(newSalary, oneEmployee.getSalary(), 0);
		oneEmployee.setSalary(badSalary);
		assertEquals(newSalary, oneEmployee.getSalary(), 0);
	}

	/**
	 * Test the method getAddress()
	 */
	@Test
	public void testGetAddress() {
		assertEquals("address", oneEmployee.getAddress());
	}

	/**
	 * Test the method setAddress()
	 */
	@Test
	public void testSetAddress() {
		String address = "3th avenue";
		oneEmployee.setAddress(address);
		assertEquals(oneEmployee.getAddress(), address);
	}

}
