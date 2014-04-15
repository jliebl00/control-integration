/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank;

import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.bank.handler.BankHandler;
import es.unileon.ulebank.exceptions.MalformedHandlerException;
import es.unileon.ulebank.handler.IdDNI;
import es.unileon.ulebank.handler.IdOffice;
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
    IdDNI dni;
    IdDNI anotherDNI;
    IdOffice oneIdOffice;
    IdOffice anotherIdOffice;
    Office oneOffice;
    Office anotherOffice;
    float salary = 5000;
    Bank bank;

    @Before
    public void setUp() throws MalformedHandlerException {
        dni = new IdDNI("71463395A");
        anotherDNI = new IdDNI("36167364W");
        
        bank = new Bank(null, new BankHandler("1234"));

        oneIdOffice = new IdOffice(1234);
        anotherIdOffice = new IdOffice(9876);

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
        fail("Method has to be implemented");
    }

    /**
     * Test of removeEmployee method, of class Admin.
     */
    @Test
    public void testRemoveEmployee() {
        fail("Method has to be implemented");
    }

}
