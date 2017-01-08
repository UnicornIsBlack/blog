package com.chai.blog.dao.system;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.chai.blog.dao.BaseDao;
import com.chai.blog.dao.DatabaseConnection;
import com.chai.blog.pojo.IT;



public class ITDAO {
	
	private DatabaseConnection connection;
	private BaseDao baseDao = null;
	
	public ITDAO() {
		connection = new DatabaseConnection();
		baseDao = new BaseDao(connection.getConnection());
	}
	
	
	public boolean addIT(IT it)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into it(title,path,datetime) values('");
		sql.append(it.getTitle());
		sql.append("','");
		sql.append(it.getPath());
		sql.append("','");
		sql.append(it.getTime());
		sql.append("')");
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());	
		baseDao.closeStatement();			
		
		
		return flag;
	}
	
	public boolean updateIT(IT it)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("update it set title='");
		sql.append(it.getTitle());
		sql.append("',path='");
		sql.append(it.getPath());
		sql.append("',datetime='");
		sql.append(it.getTime());
		sql.append("' where id=");
		sql.append(it.getId());
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();		
		
		return flag;
	}
	
	public boolean deleteIT(int id)
	{
		
		StringBuffer sql = new StringBuffer();
		sql.append("delete from it where id=");
		sql.append(id);
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();
		
		return flag;
	}
	
	public IT getITById(int Id)
	{
		IT it = null;
		ResultSet resultSet = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from it where id=");
		sql.append(Id);
		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try 
		{
			if(resultSet.next())
			{
				it = new IT();
				it.setId(Id);
				it.setTitle(resultSet.getString(2));
				it.setPath(resultSet.getString(3));
				it.setTime(resultSet.getString(4));
				
				baseDao.closeResultSet();
				baseDao.closeStatement();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return it;
	}
	
	
	public List getITList()
	{
		
		List list = new ArrayList();
		
		ResultSet resultSet = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from it order by datetime desc");
		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try
		{
			while(resultSet.next())
			{
				IT it = new IT();
				
				it.setId(resultSet.getInt(1));
				it.setTitle(resultSet.getString(2));
				it.setPath(resultSet.getString(3));
				it.setTime(resultSet.getString(4));
				
				list.add(it);
			}
			
			baseDao.closeResultSet();
			baseDao.closeStatement();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void close()
	{
		connection.close();
	}
	
}
