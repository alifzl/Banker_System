/**
 * Created by FZL on 6/18/2016.
 */
package com.accounts;

import java.io.Serializable;
import com.customers.Customer;
import com.transactions.Transaction;

public abstract class Account implements Serializable{
	private static final long serialVersionUID = 2983907122991279834L;
	private String accountNumber;
	private double accountBalance;
	private Customer customer;
	private Transaction transaction;
	
	/** default constructor
	 * 
	 * 
	 */
	public Account() {
	}
	
	/** account construct
	 * 
	 * this will add the account and customer to the account tab
	 * 
	 */
	public Account(String accountNumber, double accountBalance, Customer customer, Transaction transaction){
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.customer = customer;
	}
	
	// get
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getAccountBalance() {
		return this.accountBalance;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}
	
	// set 
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setTransation(Transaction transaction) {
		this.transaction = transaction;
	}
	
	// ********************* abstract methods *********************
	
	abstract public boolean makeDeposit(double amount);
	
	abstract public double makeWithdrawal(double amount);
	
}
