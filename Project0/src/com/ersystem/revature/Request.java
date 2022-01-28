/**
 * 
 */
package com.ersystem.revature;

/**
 * @author Kareem A. Henry
 *
 */

//Import need tools for project
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	int studentID;
	double amount;
	RequestType requestType;
	RequestStatus requestStatus;
	String description;
	String date;
	
	public Request(int studentID, String date, double amount, String description, RequestType requestType, RequestStatus requestStatus) {
		this.studentID = studentID;
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.requestType = requestType;
		this.requestStatus = requestStatus;
	}
	
	@Override
	public String toString() {
		return studentID + "\n"  + date + "\n" + amount + "\n" + description + "\n" + requestType + "\n" + requestStatus;
	}

}
