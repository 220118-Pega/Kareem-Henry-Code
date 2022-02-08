package com.revature.ersystem.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ersystem.enu.*;
import com.revature.ersystem.model.*;

public class RequestDAO {
	public List<Request> getAllRequest() {
		List<Request> allRequestes = new ArrayList<Request>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from heroes";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allRequestes.add(new Request(rs.getInt("id"), rs.getString("date"), rs.getInt("employeeID"), rs.getString("name"), DepartmentType.valueOf(rs.getString("dep_type")), RequestType.valueOf(rs.getString("req_type")), rs.getString("dateofpurchase"),
						rs.getDouble("amount"), RequestStatus.valueOf(rs.getString("req_status")), rs.getString("description")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return allRequestes;
	}

	public Request getTicketById(int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "Select * from heroes where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Request(rs.getInt("id"), rs.getString("date"), rs.getInt("employeeID"), rs.getString("name"), DepartmentType.valueOf(rs.getString("dep_type")), RequestType.valueOf(rs.getString("req_type")), rs.getString("dateofpurchase"),
						rs.getDouble("amount"), RequestStatus.valueOf(rs.getString("req_status")), rs.getString("description"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public static void addRequest(Request newRequest) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query  = "insert into heroes ((id, date, employeeID, name, and dep_type : FROM DB) req_type, amount, dateofpurchase, req_status, description)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newRequest.getRequestType().toString());
			pstmt.setDouble(2, newRequest.getAmount());
			pstmt.setString(3, newRequest.getDateofPurchase());
			pstmt.setString(4, newRequest.getRequestStatus().toString());
			pstmt.setString(5, newRequest.getDescription());
			pstmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
	}
}