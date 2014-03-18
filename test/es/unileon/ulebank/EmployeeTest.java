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
    
    @Before
    public void setUp() {
        dni=new IdDNI("71463395A");
        anotherDNI=new IdDNI("36167364W");
        
        oneIdOffice=new IdOffice(1234);
        anotherIdOffice=new IdOffice(9876);
        
        oneEmployee=new Employee("name", "surname", oneIdOffice, dni);
        anotherEmployee=new Employee("name2", "surname2", anotherIdOffice, anotherDNI);
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
        Handler result = oneEmployee.getIdOffice();
        assertEquals(oneIdOffice, result);
        
        result = anotherEmployee.getIdOffice();
        assertEquals(anotherIdOffice, result);
    }

    /**
     * Test of setIdOffice method, of class Employee.
     */
    @Test
    public void testSetIdOffice() {
        System.out.println("setIdOffice");
        Handler idOffice = new IdOffice(55);
        oneEmployee.setIdOffice(idOffice);
        
        Handler result = oneEmployee.getIdOffice();
        assertEquals(idOffice, result);
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
    public void testSetNullName(){
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
    public void testSetNullSurname(){
        String surname = null;
        oneEmployee.setName(surname);
        
        assertEquals("surname", oneEmployee.getSurname());
        
        surname = "";
        oneEmployee.setSurname(surname);
        
        assertEquals("surname", oneEmployee.getSurname());
    }
    
    /**
     * Test to set an invalid (null) idEmployee, the original id must
     * not be changed
     */
    @Test
    public void testSetNullIdEmployee(){
        Handler idEmployee = null;
        oneEmployee.setIdEmployee(idEmployee);
        
        Handler result = oneEmployee.getIdEmployee();
        assertEquals(dni, result);
    }
    
}
