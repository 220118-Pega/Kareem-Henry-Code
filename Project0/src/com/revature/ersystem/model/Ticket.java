package com.revature.ersystem.model;

import com.revature.ersystem.enu.DepartmentType;
import com.revature.ersystem.enu.RequestStatus;
import com.revature.ersystem.enu.RequestType;

public class Ticket {


	int id;
	int employeeID;
	double amount;
	RequestType req_type;
	RequestStatus req_status;
	DepartmentType dep_type;
	String description, date, dateofPurchase, name, department;
	
	public Ticket(double amount, String dateofPurchase, String description, RequestType req_type, RequestStatus req_status) {

		this.amount = amount;
		this.dateofPurchase = dateofPurchase;
		this.description = description;
		this.req_type = req_type;
		this.req_status = req_status;
		
	}

	public Ticket() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public RequestType getReq_type() {
		return req_type;
	}

	public void setReq_type(RequestType req_type) {
		this.req_type = req_type;
	}

	public RequestStatus getReq_status() {
		return req_status;
	}

	public void setReq_status(RequestStatus req_status) {
		this.req_status = req_status;
	}

	public DepartmentType getDep_type() {
		return dep_type;
	}

	public void setDep_type(DepartmentType dep_type) {
		this.dep_type = dep_type;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
