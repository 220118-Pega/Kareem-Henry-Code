package com.revature.ersystem.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ersystem.enu.*;
import com.revature.ersystem.model.*;
import com.revature.ersystem.store.ConnectionFactory;

public class RequestDAO {
	public List<Request> getAllRequests() {
		List<Request> allRequests = new ArrayList<Request>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM ticket";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allRequests.add(new Request(
						rs.getInt("id"), 
						rs.getString("date"), 
						rs.getInt("employeeID"), 
						rs.getString("name"), 
						rs.getDouble("amount"), 
						rs.getString("dateofpurchase"),
						rs.getString("description"),
						RequestType.valueOf(rs.getString("req_type")), 
						RequestStatus.valueOf(rs.getString("req_status"))
						));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return allRequests;
	}

	public Request getTicketById(int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM ticket WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Request(
						rs.getInt("id"), 
						rs.getString("date"), 
						rs.getInt("employeeID"), 
						rs.getString("name"), 
						rs.getDouble("amount"), 
						rs.getString("dateofpurchase"),
						rs.getString("description"),
						RequestType.valueOf(rs.getString("req_type")), 
						RequestStatus.valueOf(rs.getString("req_status"))
						);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public static void addRequest(Request newRequest) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query  = "INSERT INTO ticket (name, dep_type, req_type, amount, dateofpurchase, req_status, description) values (?,CAST(? as dep_type),CAST(? as req_type),?,?,,CAST(? as req_status),?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newRequest.getName());
			pstmt.setString(2, newRequest.getDepartment().toString());
			pstmt.setString(3, newRequest.getRequestType().toString());
			pstmt.setDouble(4, newRequest.getAmount());
			pstmt.setString(5, newRequest.getDateofPurchase());
			pstmt.setString(6, newRequest.getRequestStatus().toString());
			pstmt.setString(7, newRequest.getDescription());
			pstmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
	}
}