/**
 * 
 */
package com.ersystem.revature;

import java.util.Date;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Request menu = new Request(new Scanner(System.in)
	    Date date = new Date();
	    String strDate = String.format("%tc", date );
	    
		Request firstTicket = new Request(1, strDate, 100.00, "I want my money back!", RequestType.TRAVEL, RequestStatus.APPROVED);
		Request secondTicket = new Request(2, strDate, 1000.00, "Job better have my money!", RequestType.FOOD, RequestStatus.PENDING);

		System.out.print(firstTicket);

	}

}
