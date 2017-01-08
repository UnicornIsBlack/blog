package com.chai.blog.dao.system;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.chai.blog.dao.BaseDao;
import com.chai.blog.dao.DatabaseConnection;
import com.chai.blog.pojo.Article;



public class ArticleDAO {
	
	private DatabaseConnection connection;
	private BaseDao baseDao = null;
	
	public ArticleDAO() {
		connection = new DatabaseConnection();
		baseDao = new BaseDao(connection.getConnection());
	}
	
	
	public boolean addArticle(Article article)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into article(title,path,datetime) values('");
		sql.append(article.getTitle());
		sql.append("','");
		sql.append(article.getPath());
		sql.append("','");
		sql.append(article.getTime());
		sql.append("')");
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());	
		baseDao.closeStatement();			
		
		
		return flag;
	}
	
	public boolean updateArticle(Article article)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("update article set title='");
		sql.append(article.getTitle());
		sql.append("',path='");
		sql.append(article.getPath());
		sql.append("',datetime='");
		sql.append(article.getTime());
		sql.append("' where id=");
		sql.append(article.getId());
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();		
		
		return flag;
	}
	
	public boolean deleteArticle(int id)
	{
		
		StringBuffer sql = new StringBuffer();
		sql.append("delete from article where id=");
		sql.append(id);
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();
		
		return flag;
	}
	
	public Article getArticleById(int Id)
	{
		Article article = null;
		ResultSet resultSet = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from article where id=");
		sql.append(Id);
		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try 
		{
			if(resultSet.next())
			{
				article = new Article();
				article.setId(Id);
				article.setTitle(resultSet.getString(2));
				article.setPath(resultSet.getString(3));
				article.setTime(resultSet.getString(4));
				
				baseDao.closeResultSet();
				baseDao.closeStatement();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return article;
	}
	
	
	public List getArticleList()
	{
		
		List list = new ArrayList();
		
		ResultSet resultSet = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from article order by datetime desc");
		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try
		{
			while(resultSet.next())
			{
				Article article = new Article();
				
				article.setId(resultSet.getInt(1));
				article.setTitle(resultSet.getString(2));
				article.setPath(resultSet.getString(3));
				article.setTime(resultSet.getString(4));
				
				list.add(article);
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
