package com.chai.blog.dao.system;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.chai.blog.dao.BaseDao;
import com.chai.blog.dao.DatabaseConnection;
import com.chai.blog.pojo.News;



public class NewsDAO {
	
	private DatabaseConnection connection;
	private BaseDao baseDao = null;
	
	public NewsDAO() {
		connection = new DatabaseConnection();
		baseDao = new BaseDao(connection.getConnection());
	}
	
	
	public boolean addNews(News news)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into news(title,path,datetime) values('");
		sql.append(news.getTitle());
		sql.append("','");
		sql.append(news.getPath());
		sql.append("','");
		sql.append(news.getTime());
		sql.append("')");
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());	
		baseDao.closeStatement();			
		
		
		return flag;
	}
	
	public boolean updateNews(News news)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("update news set title='");
		sql.append(news.getTitle());
		sql.append("',path='");
		sql.append(news.getPath());
		sql.append("',datetime='");
		sql.append(news.getTime());
		sql.append("' where id=");
		sql.append(news.getId());
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();		
		
		return flag;
	}
	
	public boolean deleteNews(int id)
	{
		
		StringBuffer sql = new StringBuffer();
		sql.append("delete from news where id=");
		sql.append(id);
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();
		
		return flag;
	}
	
	public News getNewsById(int Id)
	{
		News news = null;
		ResultSet resultSet = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from news where id=");
		sql.append(Id);
		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try 
		{
			if(resultSet.next())
			{
				news = new News();
				news.setId(Id);
				news.setTitle(resultSet.getString(2));
				news.setPath(resultSet.getString(3));
				news.setTime(resultSet.getString(4));
				
				baseDao.closeResultSet();
				baseDao.closeStatement();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return news;
	}
	
	
	public List getNewsList()
	{
		
		List list = new ArrayList();
		
		ResultSet resultSet = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from news order by datetime desc");
		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try
		{
			while(resultSet.next())
			{
				News news = new News();
				
				news.setId(resultSet.getInt(1));
				news.setTitle(resultSet.getString(2));
				news.setPath(resultSet.getString(3));
				news.setTime(resultSet.getString(4));
				
				list.add(news);
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
