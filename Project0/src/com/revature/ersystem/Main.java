package com.revature.ersystem;

// Import java tools
import java.util.Scanner;

// Import custom objects
import com.revature.ersystem.func.*;

public class Main {   
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);   
	    
	    // Title
	    System.out.println("\nEXPENSE REIMBURSEMENT API\n");
    
		String output = null;
		boolean start = true;
	    
	    
	    // Set up main questions for API
	    String qnOne = "What would you like to accomplish? Please type the number associated with your query.\n"
	    		   + "[1] Start New Request\n[2] View Status of Request\n[3] Access Archieve\n[4] Exit\n";  	    
    	
//	    Question []  mainQ = { 
//	    		new Question(qnOne, input)
//	    	}; 
		    
		
		while(start) {
			System.out.println(qnOne);
    		System.out.print("\n");
		
			try {  			 
				String  resp = userInput.nextLine();
				int intRep = Integer.parseInt(resp);	
	    			switch (intRep) {
	    				case 1:  StartRequest.startRequest(StartRequest.entryQ);
	    						 	output = "";
		    			    		System.out.print("\n");
		    			    		break;
	    				case 2:  ViewRequest.viewRequest(ViewRequest.requestQ);
	    						 	output = "";
	    			    			System.out.print("\n");
	    			    			break;
	    				case 3:  AccessRequest.accessArchive(AccessRequest.archiveQ);
	    						 	output = "";
	    			    			System.out.print("\n");
	    			    			break;
	    				case 4:  output =  "4";
	        				break;	
	    				default: output =  "5";
	        				break;
	    			}
	    			if(output.equals("4")){
	    				System.out.println("\nThank you! Come Again.\n");
	    				return;
	    			} else if (output.equals("5")) {
	    				System.out.println("\nPlease type either 1, 2, 3, or 4 to proceed.\n");
	    				start = true;
	    			} 
		
			} catch(Exception e) {

					System.out.println("\nInvalid Entry! Please use correct datatype.\n");

			}
		
		}
		userInput.close();
		
	};
    
}
