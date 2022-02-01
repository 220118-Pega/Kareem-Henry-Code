/**
 * 
 */
package com.ersystem.revature.obj;

import com.ersystem.revature.RequestStatus;
import com.ersystem.revature.RequestType;

/**
 * @author Kareem A. Henry
 *
 */

public class Request {

	/**
	 * Start A Request = addTicket
	 * View Open Request = openTicket
	 * Access Closed Request = closeTicket
	 * newRequest object = new addRequest();  
	 * openRequest object = new openRequest();  
	 * closeRequest object = new closeRequest();  
	 */
	
	//Request Attributes
	int employeeID;
	double amount;
	RequestType requestType;
	RequestStatus requestStatus;
	String description, date, dateofPurchase, name;
	
	public Request(String date, int employeeID, String name, String dateofPurchase, double amount, RequestType requestType, RequestStatus requestStatus, String description) {

		this.date = date;
		this.employeeID = employeeID;
		this.name = name;
		this.dateofPurchase = dateofPurchase;
		this.amount = amount;
		this.requestType = requestType;
		this.requestStatus = requestStatus;
		this.description = description;
		
	}
	
	@Override
	public String toString() {
		return "REIMBURSEMENT REQUEST TICKET" + "\n" + 
				"Date of Request: " +  date + "\n" + 
				"Employee ID: " + employeeID + "\n"  + 
				"Employee Name: " + name + "\n"  + 
				"Amount: " + amount + "\n" + 
				"Amount: " + dateofPurchase + "\n" + 				
				"Type: " + requestType + "\n" + 
				"Status: " +  requestStatus + "\n" + 
				"Description: " + description + "\n" +"\n";
	}

}
