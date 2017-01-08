package com.chai.blog.service;


import java.util.List;

import com.chai.blog.dao.system.BookDAO;
import com.chai.blog.pojo.Book;

public class BookService {
	
	BookDAO bookDAO = new BookDAO();
	
	public boolean addBook(Book book)
	{
		return bookDAO.addBook(book);
	}
	
	public boolean updateBook(Book book)
	{
		return bookDAO.updateBook(book);
	}
	
	public boolean deleteBook(int id)
	{
		return bookDAO.deleteBook(id);
	}
	
	public Book getBookById(int Id)
	{
		return bookDAO.getBookById(Id);
	}
	
	
	public List getBookList()
	{
		return bookDAO.getBookList();
	}
	
	public void close()
	{
		bookDAO.close();
	}
}
