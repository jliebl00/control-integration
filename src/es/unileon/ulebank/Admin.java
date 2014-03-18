/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank;

import es.unileon.ulebank.handler.Handler;

/**
 *
 * @author dorian
 */
public class Admin extends Employee {

    /**
     * 
     * @see es.unileon.ulebank.Employee#Employee(java.lang.String, 
     * java.lang.String, es.unileon.ulebank.handler.Handler, es.unileon.ulebank.handler.Handler)  
     */
    public Admin(String name, String surname, Handler idOffice, Handler idEmployee) {
        super(name, surname, idOffice, idEmployee);
    }
    
    /**
     * 
     * @see es.unileon.ulebank.Employee#Employee(java.lang.String, java.lang.String, es.unileon.ulebank.handler.Handler) 
     */
    public Admin(String name, String surname, Handler idEmployee) {
        super(name, surname, idEmployee);
    }
    
    /**
     * @see es.unileon.ulebank.Employee#isAdmin() 
     * @return true if the employee is admin
     */
    @Override
    public boolean isAdmin(){
        return true;
    }
    
    /**
     * Add a new employee
     * @param newEmployee the employee to add
     * @return true if sucesfully added
     */
    public boolean addEmployee(Employee newEmployee){
        //call database or something similar to store the new employee
        return false;
    }
    
    /**
     * Remove the employee with the given identifier
     * @param employeeIdentifier the handler of the employee
     * @return true if sucessful removed
     */
    public boolean removeEmployee(Handler employeeIdentifier){
        //call database or something similar to store the new employee
        return false;
    }
    
}
