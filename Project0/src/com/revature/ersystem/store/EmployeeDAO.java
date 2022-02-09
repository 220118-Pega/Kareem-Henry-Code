package com.revature.ersystem.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ersystem.model.*;
import com.revature.ersystem.store.ConnectionFactory;

public class EmployeeDAO {
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<Employee>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM employee ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allEmployees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("number"), rs.getString("email")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return allEmployees;
	}

	public static Employee getEmployeeById(int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM employee where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("number"), rs.getString("email"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public static void addEmployee(Employee newEmployee) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query  = "INSERT INTER employee (name, number, email) values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newEmployee.getName());
			pstmt.setString(2, newEmployee.getNumber());
			pstmt.setString(3, newEmployee.getEmail());
			pstmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
	}
}
