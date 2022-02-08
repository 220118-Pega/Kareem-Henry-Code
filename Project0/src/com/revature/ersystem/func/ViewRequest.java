/**
 * 
 */
package com.revature.ersystem.func;

import java.util.Date;
import java.util.Scanner;

import com.revature.ersystem.model.Question;

/**
 * @author Kareem A. Henry
 *
 */
public class ViewRequest {
	
	static String input = "";
    
	// Set up questions for requestQ([2] View Status of Request)
	static String reqn1 = "Please enter your EmployeeID.\n";
    
	public static Question []  requestQ = { 
    		new Question(reqn1,  input)		
    	};
	
	// This function establishes what happens if a user needs to view the status of an existing request ticket
    public static void viewRequest(Question [] requestQ) {
		Scanner userInput = new Scanner(System.in);
		Date date = new Date();
    	
    	// Title
	    System.out.println("\nSTATUS OF REQUEST\n");
	    
				
    	for (int u = 0; u < requestQ.length; u++) {
    		System.out.println(requestQ[u].query);
    		String subResponse = userInput.nextLine();
    	}  	
    }

}
