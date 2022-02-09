/**
 * 
 */
package com.revature.ersystem.model;

/**
 * @author Kareem A. Henry
 *
 */
public class Employee {

	/**
	 * 
	 */
	int id;
	String name, number, email;
	
	public Employee(int id, String name, String number, String email) {
		
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		
		
	}
	
	public Employee() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee Information" + "\n" + 
				"Employee ID: " + id + "\n" + 
				"Name: " + name + "\n"  + 
				"Number: " + number + "\n" + 
				"Email: " + email + "\n" + "\n";
	}


}
