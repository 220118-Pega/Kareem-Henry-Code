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

	/**
	 * @param args
	 *
	 */
	
	/*****************************************START OF MAIN LOGIC ***********************************************/
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);   
	    
	    // Title
	    System.out.println("\nEXPENSE REIMBURSEMENT API\n");
    
		String[] values = {"1","2","3"};
		String output = null;
		boolean sInArray = true;
	    
	    String input = "";
	    
	    
	    // Set up main questions for API
	    String qnOne = "What would you like to accomplish? Please type the number associated with your query.\n"
	    		   + "[1] Start New Request\n[2] View Status of Request\n[3] Access Archieve\n[4] Exit\n";  	    
    	
	    // Set up questions for entryQ([1] Start New Request)
    	String enqn1 = "Please enter your EmployeeID.\n";
    	String enqn2 = "Please enter the number cooresponding to your type of reimbursement.\n"
	    		   + "[1] Lodging\n[2] Travel\n[3] Food\n[4] Other\n";
    	String enqn3 = "Enter the amount needed for reimbursement.\n";
    	String enqn4 = "Enter the date of puchase in MM/dd/yyyy format:\n";
    	String enqn5 = "Please provide a short description of purchase.\n";
    	String enqn6 = "Successful Submission! Your manaager will be in touch within 2-3 business days regarding your reimbursement.\n";
    	
    	// Set up questions for requestQ([2] View Status of Request)
    	String reqn1 = "Please enter your EmployeeID.\n";
	    
	    // Set up questions for archieveQ([3] Access Archive)
    	String arqn1 = "Please select if you're a Maanager or Employee?\n"
	    		   + "[1] Manager\n[2] Employee\n";
    	
    	
    	
    	
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
	    		new Question(enqn5,  input),
	    		new Question(enqn6,  input)
	    	};
	    
	    Question []  requestQ = { 
	    		new Question(reqn1,  input)		
	    	};
	    
	    Question []  archiveQ = { 
	    		new Question(arqn1,  input)		
	    	};
	    
	    /*****TESTING CODES******/	    
	    
//		Print the values to check if the input was correctly obtained.	    
//		Request firstTicket = new Request(strDate, 1, "Jesus", RequestType.TRAVEL, reqDate, 100.00, RequestStatus.APPROVED, "I want my money back!");
//		Request secondTicket = new Request(strDate, 2, "Mary", RequestType.FOOD, reqDate, 1000.00, RequestStatus.PENDING, "Job better have my money!");
//	
//		System.out.print(firstTicket);
//		System.out.print(secondTicket);
	    
	    /*****END OF TESTING CODES******/
		    
		
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
	    				case 4:  output =  "\nThank you! Come Again.\n";
	        				break;	
	    				default: output =  "\nPlease type either 1, 2, or 3 to proceed.\n";
	        				break;
	    			} 	
	    			sInArray = Arrays.stream(values).anyMatch(resp::equals);
	    			if(output.equals(null)){
	    				output =  "\nThank you! Come Again.\n";
	    				System.out.println(output);
	    				return;
	    			} else {
	    				System.out.println(output);
	    			}
		
			} catch(Exception e) {
				System.out.println("\nInvalid Entry! Please use correct datatype.\n");
			}
			if(sInArray != true) {
				sInArray = true;
			}
		
		}
    		
		userInput.close();
		
	};

   /*************************************** END OF MAIN LOGIC ****************************************/ 
	
	
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
				}
	    		// Set type of reimbursement
	    		while(validType == false) {
	    			System.out.println(entryQ[1].query);
	    			String  resp = userInput.nextLine();
	    			String inCorrect = "";
	    			int intRep = Integer.parseInt(resp);
	    			System.out.print("\n");
	    			try {
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
	    			} catch(Exception e){
    					System.out.println("\nInvalid Entry! Please use correct datatype.\n");
    	    			userInput.reset();
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
    	    			userInput.reset();
    	    			validID = false;
    	    			validType = false;
    	    			validAOP = false;
    	    			validDOP = false;
    	    			continue; 
    	    		}
	    	}
    }
 // iii
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
