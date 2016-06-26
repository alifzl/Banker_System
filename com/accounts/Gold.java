/**
 * Created by FZL on 6/18/2016.
 */
package com.accounts;

import com.customers.Customer;
import com.transactions.Transaction;

/**
 * gold class
 */
public class Gold extends Account {
	private static final long serialVersionUID = -144957960012585567L;
	private double goldInterestAmount;
	private double goldInterestRate;
	
	/** default constructor
	 * 
	 */
	public Gold() {
		
	}
	
	public Gold(String accountNumber, double accountBalance, Customer customer, Transaction transaction) {
		super(accountNumber, accountBalance, customer, transaction);
		this.goldInterestAmount = 0.0;
		this.goldInterestRate = 5.0;

	}

	/** all parameter constructor
	 * 
	 * this is for adding individual records
	 * nevertheless it is not necessary using serializable
	 */
	public Gold(String accountNumber, double accountBalance, Customer customer, Transaction transaction, double goldInterestAmount, double goldInterestRate) {
		super(accountNumber, accountBalance, customer, transaction);
		this.goldInterestAmount = goldInterestAmount;
		this.goldInterestRate = goldInterestRate;
	}
	
	//get methods

	public double getGoldInterestAmount() {
		return goldInterestAmount;
	}

	public double getGoldInterestRate() {
		return goldInterestRate;
	}

	//set methods

	public void setGoldInterestAmount(double goldInterestAmount) {
		this.goldInterestAmount = goldInterestAmount;
	}

	public void setGoldInterestRate(double goldInterestRate) {
		if (goldInterestRate < 0) {
			System.out.print("\nInvalid Gold interest rate! Reseting to default value!\n");
			goldInterestRate = 5.0;
		} else if (goldInterestRate > 0.0 && goldInterestRate < 1.0) {
			goldInterestRate *= 100;
		}
		this.goldInterestRate = goldInterestRate;
		System.out.print("\nGold interest rate successfully changed!\n");
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
	 * 
	 */
	public double makeWithdrawal(double amount) {
		if (amount < 0) {
			return -1.0;
		}
		this.setAccountBalance(this.getAccountBalance() - amount);
		return amount;
	}

	// ********************************************** display gold account info **********************************************
	public String toString() {
			return String.format("%s \t %s \t %s \t $%12.2f \t %10.2f%% \t\t $%12.2f\n", "Gold", this.getCustomer(), this.getAccountNumber(), this.getAccountBalance(), this.getGoldInterestRate(), this.getGoldInterestAmount());
	}
}
