/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.users;

import es.unileon.ulebank.users.Admin;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.bank.BankHandler;
import es.unileon.ulebank.exceptions.MalformedHandlerException;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.OfficeHandler;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dorian
 */
public class AdminTest {

    Admin oneEmployee;
    Admin anotherEmployee;
    DNIHandler dni;
    DNIHandler anotherDNI;
    OfficeHandler oneIdOffice;
    OfficeHandler anotherIdOffice;
    Office oneOffice;
    Office anotherOffice;
    float salary = 5000;
    Bank bank;

    @Before
    public void setUp() throws MalformedHandlerException {
        dni = new DNIHandler("71463395A");
        anotherDNI = new DNIHandler("36167364W");
        
        bank = new Bank(null, new BankHandler("1234"));

        oneIdOffice = new OfficeHandler(1234);
        anotherIdOffice = new OfficeHandler(9876);

        oneOffice = new Office(oneIdOffice,bank);
        anotherOffice = new Office(anotherIdOffice,bank);

        oneEmployee = new Admin("name", "surname", "address", salary, oneOffice, dni);
        anotherEmployee = new Admin("name2", "surname2", "address2", salary, anotherOffice,
                anotherDNI);
    }

    /**
     * Test of isAdmin method, of class Admin.
     */
    @Test
    public void testIsAdmin() {
        assertTrue(oneEmployee.isAdmin());
        assertTrue(anotherEmployee.isAdmin());
    }

    /**
     * Test of addEmployee method, of class Admin.
     */
    @Test
    public void testAddEmployee() {
        oneEmployee.addEmployee(anotherEmployee);
        ArrayList list=oneEmployee.getListEmployee();
        assertTrue(list.size()==1);
        assertEquals(list.get(0), anotherEmployee);
    }
    
    @Test
    public void testAddBetweenEmployee() {
        anotherEmployee.setOffice(oneOffice);
        oneEmployee.addEmployee(anotherEmployee);
        //another employee has access to the list modified by oneEmployee
        ArrayList list=anotherEmployee.getListEmployee();
        assertTrue(list.size()==1);
        assertEquals(list.get(0), anotherEmployee);
    }
    

    /**
     * Test of removeEmployee method, of class Admin.
     */
    @Test
    public void testRemoveEmployee() {
        oneEmployee.addEmployee(oneEmployee);
        oneEmployee.addEmployee(anotherEmployee);
        ArrayList list=oneEmployee.getListEmployee();
        assertTrue(list.size()==2);
        oneEmployee.removeEmployee(oneEmployee.getIdEmployee());
        list=oneEmployee.getListEmployee();
        assertTrue(list.size()==1);
        assertEquals(list.get(0), anotherEmployee);
    }

}
