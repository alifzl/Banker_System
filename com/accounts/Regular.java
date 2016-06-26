/**
 * Created by FZL on 6/18/2016.
 */
package com.accounts;

import com.customers.Customer;
import com.transactions.Transaction;

/**
 * regular class
 *
 */
public class Regular extends Account {
	private static final long serialVersionUID = 8082267220118547343L;
	private double regularInterestRate;
	private double regularInterestAmount;
	private double regularFixedCharge;
	
	/** default constructor
	 */
	public Regular() {
		
	}
	
	/** basic constructor to create the regular account with default values
	 *  
	 */
	public Regular(String accountNumber, double accountBalance,	Customer customer, Transaction transaction) {
		super(accountNumber, accountBalance, customer, transaction);
		this.regularInterestRate = 6.0;
		this.regularInterestAmount = 0.0;
		this.regularFixedCharge = 10.0;
	}
	
	/** all parameter constructor 
	 */
	public Regular(String accountNumber, double accountBalance, Customer customer, Transaction transaction, double regularInterestRate, double regularInterestAmount, double regularFixedCharge) {
		super(accountNumber, accountBalance, customer, transaction);
		this.regularInterestRate = regularInterestRate;
		this.regularInterestAmount = regularInterestAmount;
		this.regularFixedCharge = regularFixedCharge;
	}
	
	// get
	
	public double getRegularInterestRate() {
		return regularInterestRate;
	}

	public double getRegularInterestAmount() {
		return regularInterestAmount;
	}

	public double getRegularFixedCharge() {
		return regularFixedCharge;
	}

	// set

	public void setRegularInterestRate(double regularInterestRate) {
		if (regularInterestRate < 0) {
			System.out.print("Invalid Regular interest rate! Reseting to default value\n");
			regularInterestRate = 6.0;
		} else if (regularInterestRate > 0. && regularInterestRate < 1.0) {
			regularInterestRate *= 100;
		}
		this.regularInterestRate = regularInterestRate;
		System.out.print("Regular interest rate successfully changed!");
	}


	public void setRegularFixedCharge(double regularFixedCharge) {
		if (regularFixedCharge < 0) {
			System.out.print("\nInvalid Regular interest charge! Reseting to original value\n");
			regularFixedCharge = 10.0;
		}
		this.regularFixedCharge = regularFixedCharge;
		System.out.print("Regular interest charge successfully updated!\n");
	}

	public void setRegularInterestAmount(double interest) {
		this.regularInterestAmount += interest;
	}

	/** make deposit
	 */
	public boolean makeDeposit(double amount) {
		if (amount < 0) {
			return false;
		}
		this.setAccountBalance(this.getAccountBalance() + amount);
		return true;
	}

	/** make withdrawal
	 */
	public double makeWithdrawal(double amount) {
		if (amount < 0) {
			return -1.0;
		} else if (this.getAccountBalance() < amount) {
			amount = this.getAccountBalance();
		}
		this.setAccountBalance(this.getAccountBalance() - amount);
		return amount;
	}

	// *********************************************** display regular account info ***********************************************
	public String toString() {
		return String.format("%s\t %s \t %s \t\t $%12.2f \t\t %10.2f%% \t\t $%12.2f \t\t $%12.2f\n", "Regular", this.getCustomer(), this.getAccountNumber(), this.getAccountBalance(), this.getRegularInterestRate(), this.getRegularFixedCharge(), this.getRegularInterestAmount());
	}

}
