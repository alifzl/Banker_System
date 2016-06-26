/**
 * Created by FZL on 6/18/2016.
 */
package com.transactions;

import java.io.Serializable;

/** transaction class
 * it tracks all transactions that change the account balance and is
 * used throughout the client code
 * 
 * 
 * transaction constructor
 */
public class Transaction implements Serializable{
	private static final long serialVersionUID = -3071907899278997557L;
	private java.util.Date createDate;
	private String customerID;
	private String accountNumber;
	private String description;
	private double amount;
	private long transactionNumber;
	
	/** default constructor
	 * 
	 */
	Transaction() {
	}
	
	/** transaction constructor
	 * 
	 * this is for the account transactions
	 */
	public Transaction(java.util.Date createDate, String customerID, String accountNumber, String description, double amount, long transactionNumber) {
		this.createDate = createDate;
		this.customerID = customerID;
		this.accountNumber = accountNumber;
		this.description = description;
		this.amount = amount;
		this.transactionNumber = transactionNumber;
	}
	
	/** transaction constructor
	 * 
	 * this is for the customer transaction
	 */
	public Transaction(java.util.Date createDate, String customerID, String description, long transactionNumber) {
		this.createDate = createDate;
		this.customerID = customerID;
		this.accountNumber = "No Accounts";
		this.description = description;
		this.amount = 0.00;
		this.transactionNumber = transactionNumber;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public String getCustomerID() {
		return customerID;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public long getTransactionNumber() {
		return transactionNumber;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	// **************************************** display transactions ****************************************
	public String toString() {
		return String.format("%d \t %s \t %s \t %s \t %s \t\t $%12.2f \n", this.transactionNumber, this.createDate, this.customerID, this.accountNumber, this.description, this.amount);
	}
}
