package es.unileon.ulebank;

import java.util.ArrayList;
import es.unileon.ulebank.handler.IdOffice;

/**
 * 
 * @author Patricia
 * 
 */
public class Office {

	IdOffice idOffice;
	// ArrayList<Account> accountList;
	ArrayList<Employee> employeeList;

	public Office(IdOffice idOffice) {
		this.idOffice = idOffice;
	}

	public IdOffice getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(IdOffice idOffice) {
		this.idOffice = idOffice;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	public void addEmployee(Employee employee){
		employeeList.add(employee);
	}
	public void deleteEmployee(Employee employee){
		employeeList.remove(employee);
	}
//	public void addAccount(Account account){
//		employeeList.add(employee);
//	}
//	public void deleteAccount(Account account){
//		employeeList.remove(employee);
//	}

}
