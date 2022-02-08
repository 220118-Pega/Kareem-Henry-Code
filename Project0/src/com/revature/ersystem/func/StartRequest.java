/**
 * 
 */
package com.revature.ersystem.func;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.revature.ersystem.enu.RequestType;
import com.revature.ersystem.model.Question;

/**
 * @author Kareem A. Henry
 *
 */
public class StartRequest {
    
	static String input = "";
	
    // Set up questions for entryQ([1] Start New Request)
	static String enqn1 = "Please enter your EmployeeID.\n";
	static String enqn2 = "Please enter the number cooresponding to your type of reimbursement.\n"
    		   + "[1] Lodging\n[2] Travel\n[3] Food\n[4] Other\n";
	static String enqn3 = "Enter the amount needed for reimbursement.\n";
	static String enqn4 = "Enter the date of puchase in MM/dd/yyyy format:\n";
	static String enqn5 = "Please provide a short description of purchase.\n";
	static String enqn6 = "Successful Submission! Your manaager will be in touch within 2-3 business days regarding your reimbursement.\n";
    
    public static Question []  entryQ = { 
    		new Question(enqn1,  input),
    		new Question(enqn2,  input),
    		new Question(enqn3,  input),
    		new Question(enqn4,  input),
    		new Question(enqn5,  input),
    		new Question(enqn6,  input)
    	};

	// This function establishes what happens if a user needs to start a new request ticket
    public static void startRequest(Question [] entryQ) {
		Scanner userInput = new Scanner(System.in);
		boolean validID = false;
		boolean validType = false;
		boolean validAOP = false;
		boolean validDOP = false;
		String strInput;
		int emID = 0; 
		RequestType typeER = null;
		Double reimAmt = null; 
		Date dopStr = new Date();
		String desc = "";
		
    	
    	// Set up question to review information.
    	String checkIt = "Please review the informationn entered: \n\n" + "Is this information correct?\n"
        		   + "Yes\nNo\n";
    	
    	// Title
	    System.out.println("\nREQUEST TICKET ENTRY\n");	
	    	for (int i = 0; i < entryQ.length; i++) {	
	    		// Take User ID 
	    		while(validID == false) {
	    			System.out.println(entryQ[0].query);
	    			strInput = userInput.nextLine();
	    			System.out.print("\n");
	    				try { 
	    					emID = Integer.parseInt(strInput);
	    					validID = true;
	    				} catch(NumberFormatException e) {
	    					System.out.println("\nInvalid Entry! Please use correct datatype.\n");
	    	    			userInput.reset();
	    				}
	    				// if employee id is found say hello username
	    				
	    				
	    				
				}
	    		// Set type of reimbursement
	    		while(validType == false) {
	    			System.out.println(entryQ[1].query);
	    			String inCorrect = "";
	    			try {
		    			String  resp = userInput.nextLine();
		    			int intRep = Integer.parseInt(resp);
		    			System.out.print("\n");
	    				switch (intRep) {
    						case 1: typeER = RequestType.LODGING;
	    							validType = true;
    								break;
    						case 2: typeER = RequestType.TRAVEL;
									validType = true;
    								break;
    						case 3: typeER = RequestType.FOOD;
									validType = true;
    								break;
    						case 4: typeER = RequestType.OTHER;
									validType = true;
    								break;	
    						default: inCorrect =  "\nPlease type either 1, 2, 3, or 4 to proceed.\n";
        							break;
	    				}
	    				System.out.println(inCorrect);
	    			} catch(NumberFormatException  e){
    					System.out.println("\nInvalid Entry! Please use correct datatype.\n");
    				    continue;
    				}
	    		}
	    		// Take Amount of Purchase 
	    		while(validAOP == false) {
	    			System.out.println(entryQ[2].query);
	    			strInput = userInput.nextLine();
	    			System.out.print("\n"); 
	    				try {  
	    					reimAmt = Double.parseDouble(strInput);
	    					validAOP = true;
	    				} catch(NumberFormatException e) {
	    					System.out.println("\nInvalid Entry! Please use correct datatype.\n");
	    	    			userInput.reset();
	    				} 
	    		}
	    		// Take Date of Purchase
	    		while(validDOP == false) {
		    		System.out.println(entryQ[3].query);
		    		strInput = userInput.nextLine();
		    		System.out.print("\n");
		    		SimpleDateFormat dop = new SimpleDateFormat("MM/dd/yyyy");
		    		dop.setLenient(false); 
		    			try { 
		    				dopStr = dop.parse(strInput);
		    				validDOP = true;
		    			} catch(ParseException e) {
		    				System.out.println("\nInvalid Entry! Please use correct datatype.\n");
			    			userInput.reset();
		    			}
        			
	    		}
	    		// Take a Description
	    		System.out.println(entryQ[4].query);
	    		desc = userInput.nextLine();
	    		System.out.print("\n");
    		
	    		System.out.print("Entered Information:\n");
	    		System.out.print("Employee ID: " + emID + "\n");
	    		System.out.print("Type of Reimbursement: " + typeER + "\n");
	    		System.out.print("Purchase Amount: " + reimAmt + "\n");
	    		System.out.print("Purchase Date: " + dopStr.toString() + "\n");
    	    	System.out.print("Description: " + desc + "\n\n");
    	    	
    	    	System.out.println(checkIt);
    	    	String ans = userInput.nextLine();
        		System.out.print("\n");
    	    		if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")) {
    	    			// Successful Submission
    	    			System.out.println(entryQ[5].query);
    	    			break; 
    	    		} else {
    	    			validID = false;
    	    			validType = false;
    	    			validAOP = false;
    	    			validDOP = false;
    	    			continue; 
    	    		}
	    	}
    }

}
