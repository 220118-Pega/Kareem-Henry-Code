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

public class ManagerDAO {
	public List<Manager> getAllManagers() {
		List<Manager> allManagers = new ArrayList<Manager>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM manager";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allManagers.add(new Manager(rs.getInt("id"), rs.getString("name"), DepartmentType.valueOf(rs.getString("dep_type"))));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return allManagers;
	}

	public Manager getManagerById(int id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "SELECT * FROM manager WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Manager(rs.getInt("id"), rs.getString("name"), DepartmentType.valueOf(rs.getString("dep_type")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public static void addManager(Manager newManager) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query  = "INSERT INTO manager (name, dep_type) values (?,CAST(? as dep_type))";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newManager.getName());
			pstmt.setString(2, newManager.getDepartment().toString());
			pstmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
	}
}
//, DepartmentType.valueOf(rs.getString("dep_type"))
//, DepartmentType.valueOf(rs.getString("dep_type"))