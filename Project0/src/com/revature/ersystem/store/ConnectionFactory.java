package com.revature.ersystem.store;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionFactory {

	public static final ConnectionFactory connectionFactory = new ConnectionFactory();
	private Properties props;
	
	static {
			try {
				
				Class.forName("org.postgresql.Driver");	
				
			} catch(ClassNotFoundException e) {
				
				e.printStackTrace();			
				
			}			
	}
	
	private ConnectionFactory() {
		try {
			
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("db.properties"));
			
		} catch(IOException e) {
			
			e.printStackTrace();			
			
		}
	}
	
	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}
	
	/**
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
		} catch(SQLException e) {
			
			e.printStackTrace();			
			
		}	
		return conn;
	}

}
