/**
 * 
 */
package com.revature.ersystem.model;

/**
 * @author Kareem A. Henry
 *
 */
public class Manager {

	/**
	 * 
	 */

	int id;

	String name, department;
	
	public Manager(int id, String name, String department) {
			
			this.id = id;
			this.name = name;
			this.department = department;
					
		
	}
	
	public Manager() {
		
	}
	
	@Override
	public String toString() {
		return "Manager Information" + "\n" + 
				"Manager ID: " + id + "\n" + 
				"Name: " + name + "\n"  + 
				"Department: " + department + "\n" + "\n";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
