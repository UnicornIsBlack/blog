package com.chai.blog.dao;

import java.sql.*;

public class DatabaseConnection {
	
	private Connection connection = null;
	
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String Url = "jdbc:mysql://127.0.0.1:3306/blog?user=root&password=chai&useUnicode=true&characterEncoding=utf-8";
	public DatabaseConnection() 
	{

		try 
		{
			Class.forName(Driver);
			connection = DriverManager.getConnection(Url);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}			
		

	}
	public Connection getConnection()
	{		
		return connection;
	}
	
	
	public void close()
	{
		if(connection != null)
		{
			try
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
