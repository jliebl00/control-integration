package es.unileon.ulebank;

import java.util.ArrayList;

import es.unileon.ulebank.exceptions.MalformedHandlerException;
import es.unileon.ulebank.handler.Handler;
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
	private Handler idOffice;
	/**
	 * The costs of the local of the office
	 */
	private int localCost;
	/**
	 * The costs of the light, water and gas of the office
	 */
	private int utilitiesCost;
	/**
	 * The expenses in the salaries of the employees
	 */
	private int employeeCost;
	/**
	 * The total expenses or costs of the office
	 */
	private int totalExpenses;
	/**
	 * The total income of the office
	 */
	private int totalIncome;
	/**
	 * The list of employees of this office
	 */
	private ArrayList<Employee> employeeList;
	/**
	 * The list of accounts of this office
	 */
	private ArrayList<Account> accountList;

	/**
	 * Constructor of the class
	 * 
	 * @throws MalformedHandlerException
	 */
	public Office(Handler idOffice) throws MalformedHandlerException {
		this.idOffice = new IdOffice(idOffice.toString());
	}

	/**
	 * Returns the id of the office
	 */
	public Handler getIdOffice() {
		return idOffice;
	}

	/**
	 * Sets the id of the office
	 */
	public void setIdOffice(Handler idOffice) {
		this.idOffice = idOffice;
	}

	/**
	 * Returns the expenses of the office
	 */
	public int getExpenses() {
		return totalExpenses;
	}

	/**
	 * Sets the total expenses of the office
	 */
	public void setExpenses(int localCost, int utilitiesCost, int employeeCost) {

		this.localCost = localCost;
		this.utilitiesCost = utilitiesCost;
		this.employeeCost = employeeCost;

		this.totalExpenses = this.localCost + this.utilitiesCost
				+ this.employeeCost;
	}

	/**
	 * Returns the income of the office
	 */
	public int getTotalIncome() {
		return totalIncome;
	}

	/**
	 * Sets the total income of the office
	 */
	public void setTotalIncome(int totalIncome) {
		// Addition of the types of incomes.
		this.totalIncome = totalIncome;
	}

	/**
	 * Returns a copy of the list of employees of the office
	 */
	public ArrayList<Employee> getEmployeeList() {
		return new ArrayList<Employee>(employeeList);
	}

	/**
	 * Sets the list of employees of the office
	 */
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * Returns the list of accounts of the office
	 */
	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	/**
	 * Sets the list of accounts of the office
	 */
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}

	/**
	 * Adds an employee to the list of employees
	 */
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	/**
	 * Deletes an employee to the list of employees
	 */
	public void deleteEmployee(Employee employee) {
		employeeList.remove(employee);
	}

	/**
	 * Adds an account to the list of accounts
	 */
	public void addAccount(Account account) {
		accountList.add(account);
	}

	/**
	 * Deletes an account to the list of accounts
	 */
	public void deleteAccount(Account account) {
		accountList.remove(account);
	}
}
