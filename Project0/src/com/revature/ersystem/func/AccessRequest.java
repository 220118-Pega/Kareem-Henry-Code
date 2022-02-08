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
public class AccessRequest {
	
	static String input = "";
    
    // Set up questions for archieveQ([3] Access Archive)
	static String arqn1 = "Please select if you're a Maanager or Employee?\n"
    		   + "[1] Manager\n[2] Employee\n";
    
	public static Question []  archiveQ = { 
    		new Question(arqn1,  input)		
    	};

	// This function establishes what happens if a user needs to access old and new request tickets
    public static void accessArchive(Question [] archiveQ) {
		Scanner userInput = new Scanner(System.in);
		Date date = new Date();
    	
    	// Title
	    System.out.println("\nACCESSING REQUEST ARCHIEVE\n");
				
    	for (int u = 0; u < archiveQ.length; u++) {
    		System.out.println(archiveQ[u].query);
    		String subResponse = userInput.nextLine();
    	}   	
    }

}
