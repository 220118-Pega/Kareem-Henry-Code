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
	String name, number;
	
	public Employee(int id, String name, String number) {
		
		this.id = id;
		this.name = name;
		this.number = number;
		
		
	}
	
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee Information" + "\n" + 
				"Employee ID: " + id + "\n" + 
				"Name: " + name + "\n"  + 
				"Number: " + number + "\n" + "\n";
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


}
