package com.revature.ersystem.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.ersystem.model.Request;
import com.revature.ersystem.model.Ticket;

public class TicketDAO {

	public static void addTicket(Ticket newTicket) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query  = "INSERT INTO ticket (amount, dateofpurchase, description, req_type, req_status) values (?, ?, ?, CAST(? as req_type), CAST(? as req_status),?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, newTicket.getAmount());
			pstmt.setString(2, newTicket.getDateofPurchase());
			pstmt.setString(3, newTicket.getDescription());
			pstmt.setString(4, newTicket.getDep_type().toString());
			pstmt.setString(5, newTicket.getReq_status().toString());
			pstmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
	}

}
