/**
 * Created by FZL on 6/18/2016.
 */
package com.customers;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersionUID = 6981023203602380035L;
	private String customerID;
	private String customerName;
	private boolean active;
	
	public Customer() {
		
	}
	/** customer constructor non-default
	 * and set the active status to false
	 */
	public Customer(String id, String name) {
		this.customerID = id;
		this.customerName = name;
		this.active = false;
	}
	
	/** customer constructor for loading the individual data from the files
	 * 
	 * if the customers are saved as an object this constructor is not needed
	 */
	public Customer(String id, String name, boolean active) {
		this.customerID = id;
		this.customerName = name;
		this.active = active;
	}
	
	// get
	
	public String getCustomerID() {
		return this.customerID;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	// set
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	// ***************************** display the customer info *****************************
	public String toString() {
		return String.format("%-10s \t %-40s \t\t %s", this.customerID, this.customerName, ((this.active)? "Active" : "Inactive"));
	}
	
	
}
