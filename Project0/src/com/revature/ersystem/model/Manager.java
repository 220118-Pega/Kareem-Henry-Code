/**
 * 
 */
package com.revature.ersystem.model;

import com.revature.ersystem.enu.DepartmentType;

/**
 * @author Kareem A. Henry
 *
 */
public class Manager {

	/**
	 * 
	 */

	int id;

	String name;

	DepartmentType dep_type;
	
	public Manager(int id, String name, DepartmentType dep_type) {
			
			this.id = id;
			this.name = name;
			this.dep_type = dep_type;
					
		
	}
	
	public Manager() {
		
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

	public DepartmentType getDepartment() {
		return dep_type;
	}

	public void setDepartment(DepartmentType dep_type) {
		this.dep_type = dep_type;
	}
	
	@Override
	public String toString() {
		return  "Manager ID: " + id + "\n" + 
				"Name: " + name + "\n"  + 
				"Department: " + dep_type + "\n" + "\n";
	}

}
