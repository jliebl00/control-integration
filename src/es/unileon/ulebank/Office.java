package es.unileon.ulebank;

import java.util.ArrayList;
import es.unileon.ulebank.exceptions.MalformedHandlerException;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.handler.AccountHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
//import org.apache.log4j.Logger;

/**
 *
 * @author Patricia
 *
 */
public class Office {

    /**
     * Bank
     */
    private final Bank bank;
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
     * The total balance of the office
     */
    private int balance;
    /**
     * The list of employees of this office
     */
    private ArrayList<Employee> employeeList;
    /**
     * The list of accounts of this office
     */
    private ArrayList<Account> accountList;
    /**
     * Log
     */
//    private static final Logger LOG = Logger.getLogger(Account.class.getName());

    /**
     * Constructor of the class
     *
     * @throws MalformedHandlerException
     */
    public Office(Handler idOffice, Bank bank) throws MalformedHandlerException {
        this.accountList = new ArrayList<>();
        this.idOffice = idOffice;
        this.bank = bank;
        employeeList=new ArrayList<>();
        accountList=new ArrayList<>();
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
     * Returns the balance of the office
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Sets the total balance of the office
     */
    public void setBalance() {
        this.balance = this.totalIncome - this.totalExpenses;
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
    public boolean addEmployee(Employee employee) {
        return employeeList.add(employee);
    }

    /**
     * Deletes an employee to the list of employees
     * @param employee
     * @return 
     */
    public boolean deleteEmployee(Employee employee) {
        return employeeList.remove(employee);
    }

    /**
     * Adds an account to the list of accounts
     */
    public boolean addAccount(Account account) {
        return this.accountList.add(account);
    }

    /**
     * Deletes an account to the list of accounts
     */
    public void deleteAccount(Account account) {
        accountList.remove(account);
    }

    public void doTransaction(Transaction t, Handler destine)
            throws TransactionException, MalformedHandlerException {
        boolean finish = false;
        StringBuilder error = new StringBuilder();
        if (t != null && destine != null) {
            AccountHandler handler = new AccountHandler(destine);
            if (handler.getBankHandler().compareTo(this.bank.getID()) == 0
                    && handler.getOfficeHandler().compareTo(this.idOffice) == 0) {
                for (int i = 0; i < accountList.size() && !finish; i++) {
                    if (accountList.get(i).getID().compareTo(destine) == 0) {
                        if (t.getType() == TransactionType.CHARGE) {
                            accountList.get(i).doWithdrawal(t);
                        } else if (t.getType() == TransactionType.PAYMENT) {
                            accountList.get(i).doDeposit(t);
                        } else {
                            error.append("Error, transaction not supported ")
                                    .append(t.getType()).append("\n");
                        }
                        finish = true;
                    }
                }
            } else {
                this.bank.doTransaction(t, destine);
            }
        } else {
            error.append(("The transaction cannot be null or destination be null"));
        }

        if (error.length() > 0) {
//            LOG.error("Office id " + this.idOffice + " error : "
//                    + error.toString());
            throw new TransactionException(error.toString());
        }
    }
}
