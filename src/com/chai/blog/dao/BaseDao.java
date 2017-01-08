package com.chai.blog.dao;

import java.sql.*;

public class BaseDao {
	
	private Connection connection= null;
	private Statement statement = null;
	private ResultSet resultSet	= null;
	
	public BaseDao(Connection connection) 
	{
		this.connection = connection;
	}
	
	public ResultSet exeQuery(String sql)
	{		
		try 
		{
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		return resultSet;
	}
	
	public boolean exeUpdate(String sql)
	{
		int count = 0;
		try 
		{
			statement = connection.createStatement();
			count = statement.executeUpdate(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(count > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void closeStatement()
	{		
		try 
		{
			if(this.statement != null)
			{
				this.statement.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void closeResultSet()
	{		
		try 
		{
			if(this.resultSet != null)
			{
				this.resultSet.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	

}
