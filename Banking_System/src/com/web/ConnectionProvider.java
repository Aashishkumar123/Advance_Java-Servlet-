package com.web;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectionProvider {
	static Connection connection=null;
	private ConnectionProvider()
	{
		
	}
	public static Connection getConn()
	{
		try {
			if(connection==null)
			{
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/WorldBank","root","admin");
			return connection;
			
			}else
			{
				return connection;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
		
	}

}
