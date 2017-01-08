package com.chai.blog.dao.system;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.chai.blog.dao.BaseDao;
import com.chai.blog.dao.DatabaseConnection;
import com.chai.blog.pojo.Book;



public class BookDAO {
	
	private DatabaseConnection connection;
	private BaseDao baseDao = null;
	
	public BookDAO() {
		connection = new DatabaseConnection();
		baseDao = new BaseDao(connection.getConnection());
	}
	
	
	public boolean addBook(Book book)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into book(email,path,datetime) values('");
		sql.append(book.getEmail());
		sql.append("','");
		sql.append(book.getPath());
		sql.append("','");
		sql.append(book.getTime());
		sql.append("')");
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());	
		baseDao.closeStatement();			
		
		
		return flag;
	}
	
	public boolean updateBook(Book book)
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append("update book set email='");
		sql.append(book.getEmail());
		sql.append("',path='");
		sql.append(book.getPath());
		sql.append("',datetime='");
		sql.append(book.getTime());
		sql.append("' where id=");
		sql.append(book.getId());
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();		
		
		return flag;
	}
	
	public boolean deleteBook(int id)
	{
		
		StringBuffer sql = new StringBuffer();
		sql.append("delete from book where id=");
		sql.append(id);
		
		boolean flag = false;
		flag = baseDao.exeUpdate(sql.toString());
		baseDao.closeStatement();
		
		return flag;
	}
	
	public Book getBookById(int Id)
	{
		Book book = null;
		ResultSet resultSet = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from book where id=");
		sql.append(Id);
		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try 
		{
			if(resultSet.next())
			{
				book = new Book();
				book.setId(Id);
				book.setEmail(resultSet.getString(2));
				book.setPath(resultSet.getString(3));
				book.setTime(resultSet.getString(4));
				
				baseDao.closeResultSet();
				baseDao.closeStatement();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return book;
	}
	
	
	public List getBookList()
	{
		
		List list = new ArrayList();
		
		ResultSet resultSet = null;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from book order by datetime desc");
		
		resultSet = baseDao.exeQuery(sql.toString());
		
		try
		{
			while(resultSet.next())
			{
				Book book = new Book();
				
				book.setId(resultSet.getInt(1));
				book.setEmail(resultSet.getString(2));
				book.setPath(resultSet.getString(3));
				book.setTime(resultSet.getString(4));
				
				list.add(book);
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
