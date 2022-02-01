/**
 * 
 */
package com.ersystem.revature;

// Import java tools
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Import custom objects
import com.ersystem.revature.obj.*;


public class Main {
	static Scanner userInput = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	    
	    
	    // Title
	    System.out.println("EXPENSE REIMBURSEMENT API");
	    System.out.println("\n");
	    
	    String input = "";
//		int intRep = 0;	
		String[] values = {"1","2","3"};
		String output = null;
		boolean sInArray = true;
	    
	    
	    // Set up main questions for API
	    String qnOne = "What would you like to accomplish? Please type the number associated with your query.\n"
	    		   + "[1] Start New Request\n[2] View Status of Request\n[3] Access Archieve\n";   	
  
//	    String qnTwo = "Would you like to perform another action?\n"
//	    		   + "[1] Yes\n[2] No\n";
//	    
//	   
//	    
//	    String qnThree = "Thank You for using my Expense Reimbursement API System!\n";	
	    

    	
	    // Set up questions for entryQ([1] Start New Request)
    	String enqn1 = "Please enter your EmployeeID.\n";
    	String enqn2 = "Enter the amount needed for reimbursement.";
    	String enqn3 = "Enter the date of puchase in dd/MM/yyyy format:\n";
    	String enqn4 = "Please provide a short description of purchase.\n";
    	String enqn5 = "Successful Submission! Your manaager will be in touch within 2-3 business days regarding your reimbursement.\n";
    	
    	// Set up questions for requestQ([2] View Status of Request)
    	String reqn1 = "Please enter your EmployeeID.\n";
	    
	    // Set up questions for archieveQ([3] Access Archive)
    	String arqn1 = "Please enter your EmployeeID.\n";
    	
    	
    	
//	    Question []  mainQ = { 
//	    		new Question(qnOne, input)
//	    	};
	    
//	    Question []  returnQ = { 
//	    		new Question(qnTwo,  "1"),
//	    		new Question(qnTwo,  "2"),
//	    		new Question(qnThree, "")
//	    };
	    
	    Question []  entryQ = { 
	    		new Question(enqn1,  input),
	    		new Question(enqn2,  input),
	    		new Question(enqn3,  input),
	    		new Question(enqn4,  input),
	    		new Question(enqn5,  input)
	    	};
	    
	    Question []  requestQ = { 
	    		new Question(reqn1,  input)		
	    	};
	    
	    Question []  archiveQ = { 
	    		new Question(arqn1,  input)		
	    	};
	
		
		while(sInArray) {
			
			System.out.println(qnOne);
			
		
			try {  			 
				String  resp = userInput.nextLine();
					int intRep = Integer.parseInt(resp);	
	    			switch (intRep) {
	    			case 1:  startRequest(entryQ);
	        			break;
	    			case 2:  viewRequest(requestQ);
	        			break;
	    			case 3:  accessArchive(archiveQ);
	        			break;
	        		default: output =  "\nPlease type either 1, 2, or 3 to proceed.\n";
	        			break;
	    			} 	
	    			sInArray = Arrays.stream(values).anyMatch(resp::equals);
    				System.out.println(output);
		
			} catch(Exception e) {
				System.out.println("\nInvalid Entry! Please use correct valuetype.\n");
			}
			if(sInArray != true) {
				sInArray = true;
			}
		
		}
    		
		userInput.close();
		
	};

    
	// This function establishes what happens if a user needs to start a new request ticket
    public static void startRequest(Question [] entryQ) {
    	
    	// Title
	    System.out.println("REQUEST TICKET ENTRY");
	    System.out.println("\n");
				
    	for (int u = 0; u < entryQ.length; u++) {
    		System.out.println(entryQ[u].query);
    		String subResponse = userInput.nextLine();
    		System.out.println("\n");
    	}

    	
    }
 
    // This function establishes what happens if a user needs to view the status of an existing request ticket
    public static void viewRequest(Question [] requestQ) {
    	
    	// Title
	    System.out.println("STATUS OF REQUEST");
	    System.out.println("\n");
				
    	for (int u = 0; u < requestQ.length; u++) {
    		System.out.println(requestQ[u].query);
    		String subResponse = userInput.nextLine();
    		System.out.println("\n");
    	}
    	
    }
    
    // This function establishes what happens if a user needs to access old and new request tickets
    public static void accessArchive(Question [] archiveQ) {
    	
    	// Title
	    System.out.println("ACCESSING REQUEST ARCHIEVE");
	    System.out.println("\n");
				
    	for (int u = 0; u < archiveQ.length; u++) {
    		System.out.println(archiveQ[u].query);
    		String subResponse = userInput.nextLine();
    		System.out.println("\n");
    	}
    	
    }
    
    


}







/*
 * This area is for tried and old code gathered during project.
 * 
 * 
 * 
 * */



// Run task base on user selection
//for (int i = 0; i < mainQ.length; i++) {
//System.out.println(mainQ[0].query);	

//
//for (int i = 0; i < returnQ.length; i++) {
//	System.out.println(returnQ[i].query);
//System.out.println(qnOne);
//returnQuestions(returnQ);
//}

// This function establishes what happens if a user needs to access old and new request tickets
//public static void returnQuestions(Question [] returnQ) {
//	
//	// Title
//    System.out.println("ACCESSING REQUEST ARCHIEVE");
//    System.out.println("\n");
//			
//	for (int u = 0; u < returnQ.length; u++) {
//		System.out.println(returnQ[u].query);
//		String subResponse = userInput.nextLine();
//		System.out.println("\n");
//	}
//	
//}
	
//    ArrayList<String> qnOne = new ArrayList<>();
//    qnOne.add("What would you like to accomplish? Please type the number associated with your query.");
//    qnOne.add("[1] Start New Request");
//    qnOne.add("[2] View Status of Request");
//    qnOne.add("[3] Access Archieve");
    
//    for (int i = 0; i < qnOne.size(); i++) {
//    	System.out.println(qnOne.get(i));
//    }
//    
    
    
    // When 1 is select, this is the process to start a new request.
//    if(qnAnswer == "1") {
//    System.out.print("Please enter your Employee ID.");
//    String idEntry = "";
//    idEntry = userInput.nextLine();
//    System.out.print("Entered ID is: " + Integer.parseInt(idEntry));
//    }
    
//    System.out.print("Enter the amount needed for reimbursement.");
//    String amtEntry = "";
//    amtEntry = userInput.nextLine();
//    System.out.print("Entered Date is: " + Double.parseDouble(amtEntry));
//    
//    
//    Date date = new Date();
//    String strDate = String.format("%tc", date );
//    SimpleDateFormat dop = new SimpleDateFormat("dd/MM/yyyy");
//    String dopStr = dop.format(date);
//    System.out.println("Enter the date of puchase in dd/MM/yyyy format: " + "\n");
//    dopStr = userInput.nextLine();
//    System.out.print("Entered Date is: " + dopStr.toString());
   

//    ArrayList<String> qnOned = new ArrayList<>();
//    qnOned.add("Please describe, in short detail, what the purchase wa");
    
    
//		Print the values to check if the input was correctly obtained.
//  System.out.println("Name: "+name);
//  System.out.println("Gender: "+gender);
//  System.out.println("Age: "+age);
//  System.out.println("Mobile Number: "+mobileNo);
//  System.out.println("CGPA: "+cgpa);
//    
//	Request firstTicket = new Request(strDate, 1, "Jesus", 100.00, RequestType.TRAVEL, RequestStatus.APPROVED, "I want my money back!");
//	Request secondTicket = new Request(strDate, 2, "Mary", 1000.00, RequestType.FOOD, RequestStatus.PENDING, "Job better have my money!");
//
//	System.out.print(firstTicket);
//	System.out.print(secondTicket);
	    
//    	for (int i = 0; i < questions.length; i++) {
//	    	System.out.println(questions[i].query);
//	    	String response = userInput.nextLine();
//	    	for (int u = 0; u < subQuestions.length; u++) {
//	    		if(response == "1") {
//	    			System.out.println(subQuestions[u].query);
//	    		}
//	    	}
//    	}
