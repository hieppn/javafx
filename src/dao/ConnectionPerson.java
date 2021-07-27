package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPerson {
	public static final String URL="jdbc:mysql://localhost:3306/project";
	public static final String USERNAME="root";
	public static final String PASSWORD="";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}
