package es.unileon.ulebank;

import java.util.ArrayList;
import es.unileon.ulebank.handler.IdOffice;

/**
 * 
 * @author Patricia
 * 
 */
public class Office {

	/**
	 * The id of the office
	 */
	IdOffice idOffice;
	ArrayList<Account> accountList;
	/**
	 * The list of employees of this office
	 */
	ArrayList<Employee> employeeList;

	/**
	 * Constructor of the class
	 */
	public Office(IdOffice idOffice) {
		this.idOffice = idOffice;
	}

	/**
	 * Returns the id of the office
	 */
	public IdOffice getIdOffice() {
		return idOffice;
	}

	/**
	 * Sets the id of the office
	 */
	public void setIdOffice(IdOffice idOffice) {
		this.idOffice = idOffice;
	}

	/**
	 * Returns the list of employees of the office
	 */
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * Sets the list of employees of the office
	 */
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	public void deleteEmployee(Employee employee) {
		employeeList.remove(employee);
	}

	public void addAccount(Account account) {
		accountList.add(account);
	}

	public void deleteAccount(Account account) {
		accountList.remove(account);
	}

}
