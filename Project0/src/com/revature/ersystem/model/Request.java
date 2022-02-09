/**
 * 
 */
package com.revature.ersystem.model;

import com.revature.ersystem.enu.*;

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
	int id;
	int employeeID;
	double amount;
	RequestType req_type;
	RequestStatus req_status;
	DepartmentType dep_type;
	String description, date, dateofPurchase, name, department;
	
	public Request(int id, String date, int employeeID, String name, Double amount, String dateofPurchase, 
			String description, RequestType req_type, RequestStatus req_status) {

		this.id = id;
		this.date = date;
		this.employeeID = employeeID;
		this.name = name;
		this.amount = amount;
		this.dateofPurchase = dateofPurchase;
		this.description = description;
		this.req_type = req_type;
		this.req_status = req_status;
		
	}
	
	public Request() {
		
	}


	public int getId() {
		return id;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public RequestType getRequestType() {
		return req_type;
	}

	public void setRequestType(RequestType req_type) {
		this.req_type = req_type;
	}

	public RequestStatus getRequestStatus() {
		return req_status;
	}

	public void setRequestStatus(RequestStatus req_status) {
		this.req_status = req_status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateofPurchase() {
		return dateofPurchase;
	}

	public void setDateofPurchase(String dateofPurchase) {
		this.dateofPurchase = dateofPurchase;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentType getDepartment() {
		return dep_type;
	}

	public void setDepartment(DepartmentType dep_type) {
		this.dep_type = dep_type;
	}
	
	@Override
	public String toString() {
		return "REIMBURSEMENT REQUEST TICKET" + "\n" + 
				"Employee ID: " + employeeID + "\n"  + 
				"Date of Request: " +  date + "\n" + 
				"Employee Name: " + name + "\n"  + 		
				"Department: " + dep_type + "\n"  + 		
				"Type: " + req_type + "\n" + 
				"Amount: " + amount + "\n" + 
				"Date of Purchase: " + dateofPurchase + "\n" + 	
				"Status: " +  req_status + "\n" + 
				"Description: " + description + "\n" +"]";
	}

}
