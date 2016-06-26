/**
 * Created by FZL on 6/18/2016.
 */
package com.accounts;

import com.customers.Customer;
import com.transactions.Transaction;

/**
 * checking class
 *
 */
public class Checking extends Account {
	private static final long serialVersionUID = -8807798234473395749L;
	private double checkingTransactionFee;
	private double checkingTransactionFeeAmount;
	private int numberOfTransactions;

	/** 
	 * default constructor
	 * 
	 */
	public Checking() {
		
	}
	
	/** checking constructor non-default
	 */
	public Checking(String accountNumber, double accountBalance, Customer customer, Transaction transaction) {
		super(accountNumber, accountBalance, customer, transaction);
		this.checkingTransactionFee = 2.00;
		this.checkingTransactionFeeAmount = 0.0;
		this.numberOfTransactions = 0;
	}

	/** all parameter constructor
	 * 
	 */
	public Checking(String accountNumber, double accountBalance, Customer customer, Transaction transaction, double checkingTransactionFee, double checkingTransactionFeeAmount) {
		super(accountNumber, accountBalance, customer, transaction);
		this.checkingTransactionFee = checkingTransactionFee;
		this.checkingTransactionFeeAmount = checkingTransactionFeeAmount;
		if (checkingTransactionFeeAmount > 0) {
			this.numberOfTransactions = (int) (checkingTransactionFeeAmount / checkingTransactionFee);
		} else {
			this.numberOfTransactions = 0;
		}
		
	}
	// get
	
	public double getCheckingTransactionFee() {
		return checkingTransactionFee;
	}

	public double getCheckingTransactionFeeAmount() {
		return checkingTransactionFeeAmount;
	}

	public int getNumberOfTransactions() {
		return numberOfTransactions;
	}

	// set

	public void setCheckingTransactionFee(double checkingTransactionFee) {
		this.checkingTransactionFee = checkingTransactionFee;
	}

	public void setCheckingTransactionFeeAmount(double checkingTransactionFeeAmount) {
		this.checkingTransactionFeeAmount = checkingTransactionFeeAmount;
	}

	public void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	/** make deposit
	 * 
	 */
	public boolean makeDeposit(double amount) {
		if (amount < 0) {
			return false;
		}
		this.setNumberOfTransactions(this.getNumberOfTransactions() + 1);
		if (this.numberOfTransactions > 2) {
			this.checkingTransactionFeeAmount += this.checkingTransactionFee;
		}
		this.setAccountBalance(this.getAccountBalance() + amount);
		return true;
	}

	/** make withdrawal
	 * 
	 */
	public double makeWithdrawal(double amount) {
		// if the amount is negative return -1.0
		if (amount < 0) {
			return -1.0;
		}
		// increment the transaction counter for checking account
		this.setNumberOfTransactions(this.getNumberOfTransactions() + 1);
		// if the transaction number is greater than 2 start adding the fee
		if (this.numberOfTransactions > 2) {
			this.checkingTransactionFeeAmount += this.checkingTransactionFee;
		}
		// if the balance is less then the amount requested
		// allow the available balance only to prevent
		// the checking account from going into a deficit(lacking the sufficient money)
		if (this.getAccountBalance() < amount) {
			amount = this.getAccountBalance();
		}
		// apply the withdrawal
		this.setAccountBalance((this.getAccountBalance() - amount));
		return amount;
	}
	
	// ********************************************* display checking account info *********************************************
	public String toString() {
		return String.format("%s \t %s \t %s \t $%12.2f \t\t\t\t %d \t\t\t $%12.2f \t\t\t $%12.2f\n", "Checking", this.getCustomer(), this.getAccountNumber(), this.getAccountBalance(), this.getNumberOfTransactions(), this.getCheckingTransactionFee(), this.getCheckingTransactionFeeAmount());
	}
}
