package es.unileon.ulebank;

import es.unileon.ulebank.handler.Handler;

/**
 * 
 * @author dorian
 */
public class Employee {
    /**
     * Name of the employee
     */
    private String name;
    /**
     * Surname of the employee
     */
    private String surname;
    /**
     * Office which belong
     */
    private Handler idOffice;
    /**
     * Identifier of the employee
     */
    private Handler idEmployee;

    /**
     * Create a new employee with all data
     * @param name his/her name
     * @param surname his/her surname
     * @param idOffice the identifier of the office, can be null
     * @param idEmployee the identifier of the employee
     */
    public Employee(String name, String surname, Handler idOffice, Handler idEmployee) {
        //hacer comprobaciones
        this.name = name;
        this.surname = surname;
        this.idOffice = idOffice;
        this.idEmployee = idEmployee;
    }

    /**
     * Create a new employee without office
     * @param name his/her name
     * @param surname his/her surname
     * @param idEmployee the identifier of the employee
     */
    public Employee(String name, String surname, Handler idEmployee) {
        this(name, surname, null, idEmployee);
    }
        
    /**
     * Get the name of the employee
     * @return the employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * change the name of the employee
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the surname of the employee
     * @return the employee's surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Change the surname of the employee
     * @param surname the new surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Get the identifier of the office where the employee works
     * @return the identifier of the office or null if not exists
     */
    public Handler getIdOffice() {
        return idOffice;
    }

    /**
     * Set the office
     * @param idOffice 
     */
    public void setIdOffice(Handler idOffice) {
        this.idOffice = idOffice;
    }

    /**
     * Get the identifier of the employee
     * @return a handler that identify the employee
     */
    public Handler getIdEmployee() {
        return idEmployee;
    }

    /**
     * Set the identifier of the employee
     * @param idEmployee the new identifier, can't be null
     */
    public void setIdEmployee(Handler idEmployee) {
        this.idEmployee = idEmployee;
    }
    
    /**
     * Tell if this employee is an admin
     * @return true if is an admin
     */
    public boolean isAdmin(){
        return false;
    }

}