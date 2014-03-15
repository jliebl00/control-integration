package es.unileon.ulebank;

import es.unileon.ulebank.handler.Handler;

/**
 *
 * @author dorian
 */
public class Employee {

    private String name;
    private String surname;
    private Handler idOffice;
    private Handler idEmployee;

    public Employee(String name, String surname, Handler idOffice, Handler idEmployee) {
        //hacer comprobaciones
        this.name = name;
        this.surname = surname;
        this.idOffice = idOffice;
        this.idEmployee = idEmployee;
    }

    public Employee(String name, String surname, Handler idEmployee) {
        this(name, surname, null, idEmployee);
    }
        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Handler getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Handler idOffice) {
        this.idOffice = idOffice;
    }

    public Handler getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Handler idEmployee) {
        this.idEmployee = idEmployee;
    }

}
