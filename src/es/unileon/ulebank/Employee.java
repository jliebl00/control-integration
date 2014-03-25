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
	 * Salary of the employee
	 */
	private float salary;
	/**
	 * Office which belong
	 */
	private Office idOffice;
	/**
	 * Identifier of the employee
	 */
	private Handler idEmployee;

	/**
	 * Create a new employee with all data
	 * 
	 * @param name
	 *            his/her name
	 * @param surname
	 *            his/her surname
	 * @param idOffice
	 *            the office, can be null
	 * @param idEmployee
	 *            the identifier of the employee
	 */
	public Employee(String name, String surname, float salary, Office idOffice,
			Handler idEmployee) {
		// hacer comprobaciones
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.idOffice = idOffice;
		this.idEmployee = idEmployee;
	}

	/**
	 * Create a new employee without office
	 * 
	 * @param name
	 *            his/her name
	 * @param surname
	 *            his/her surname
	 * @param salary
	 *            his/her salary
	 * @param idEmployee
	 *            the identifier of the employee
	 */
	public Employee(String name, String surname, float salary,
			Handler idEmployee) {
		this(name, surname, salary, null, idEmployee);
	}

	/**
	 * Get the name of the employee
	 * 
	 * @return the employee's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * change the name of the employee
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		if (name != null) {
			if (name.length() > 0) {
				this.name = name;
			}
		}
	}

	/**
	 * Get the surname of the employee
	 * 
	 * @return the employee's surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Change the surname of the employee
	 * 
	 * @param surname
	 *            the new surname
	 */
	public void setSurname(String surname) {
		if (surname != null) {
			if (surname.length() > 0) {
				this.surname = surname;
			}
		}
	}

	/**
	 * Get the salary of the employee
	 * 
	 * @return the employee's salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * Change the salary of the employee
	 * 
	 * @param salary
	 *            the new salary
	 */
	public void setSalary(float salary) {
		if (salary > 0) {
			this.salary = salary;
		}
	}

	/**
	 * Get the the office where the employee works
	 * 
	 * @return the office or null if not exists
	 */
	public Office getOffice() {
		return idOffice;
	}

	/**
	 * Set the office
	 * 
	 * @param idOffice
	 */
	public void setOffice(Office idOffice) {
		this.idOffice = idOffice;
	}

	/**
	 * Get the identifier of the employee
	 * 
	 * @return a handler that identify the employee
	 */
	public Handler getIdEmployee() {
		return idEmployee;
	}

	/**
	 * Set the identifier of the employee
	 * 
	 * @param idEmployee
	 *            the new identifier, can't be null
	 */
	public void setIdEmployee(Handler idEmployee) {
		if (idEmployee != null) {
			this.idEmployee = idEmployee;
		}
	}

	/**
	 * Tell if this employee is an admin
	 * 
	 * @return true if is an admin
	 */
	public boolean isAdmin() {
		return false;
	}

}
