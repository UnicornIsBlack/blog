package com.chai.blog.dao.system;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.chai.blog.dao.BaseDao;
import com.chai.blog.dao.DatabaseConnection;
import com.chai.blog.pojo.Admin;

public class AdminDAO {
	
	
	private DatabaseConnection connection;
	private BaseDao baseDao = null;
	
	public AdminDAO() 
	{
		connection = new DatabaseConnection();
		baseDao = new BaseDao(connection.getConnection());
	}
	
	public Admin getAdmin(String username)
	{
		Admin admin = null;
		ResultSet resultSet = null;		
		StringBuffer sql = new StringBuffer();
		
		
		sql.append("select password from admin where username='");
		sql.append(username);
		sql.append("'");			
		resultSet = baseDao.exeQuery(sql.toString());
		
		
		try 
		{
			if(resultSet.next())
			{
				admin = new Admin();
				String password = resultSet.getString(1);
				admin.setUsername(username);
				admin.setPassword(password);
				
				baseDao.closeResultSet();
				baseDao.closeStatement();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		
		return admin;		
	}
	
	
	public List getAdminList()
	{
		List list = new ArrayList();
		

		ResultSet resultSet = null;		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from admin");		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try
		{
			while(resultSet.next())
			{
				Admin admin = new Admin();
				
				admin.setUsername(resultSet.getString(1));
				admin.setPassword(resultSet.getString(2));
				
				list.add(admin);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		baseDao.closeResultSet();
		baseDao.closeStatement();
		return list;
	}
	
	
	public boolean addAdmin(Admin admin)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into admin(username,password) values('");
		sql.append(admin.getUsername());
		sql.append("','");
		sql.append(admin.getPassword());
		sql.append("')");
		
		boolean flag = false;
		
		flag = baseDao.exeUpdate(sql.toString());
		
		baseDao.closeStatement();
		
		return flag;		
	}
	
	
	public boolean updateAdmin(Admin admin)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("update admin set password='");
		sql.append(admin.getPassword());
		sql.append("' where username='");
		sql.append(admin.getUsername());
		sql.append("'");
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();
		
		
		return flag;
	}
	
	public boolean deleteAdmin(String username)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("delete from admin where username='");
		sql.append(username);
		sql.append("'");
		
		boolean flag = false;
		
		flag = baseDao.exeUpdate(sql.toString());
		
		baseDao.closeStatement();

		return flag;		
	}
	
	
	public boolean checkAdmin(String username,String password) 
	{
		Admin admin = getAdmin(username);
		if(admin != null)
		{
			if(password.equals(admin.getPassword()))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean hasAdmin(String username)
	{
		Admin admin = getAdmin(username);
		if(admin != null)
		{
			return true;
		}
		return false;
	}
	
	public void close()
	{
		connection.close();
	}
}
