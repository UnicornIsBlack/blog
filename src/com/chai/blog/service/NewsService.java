package com.chai.blog.service;


import java.util.List;

import com.chai.blog.dao.system.NewsDAO;
import com.chai.blog.pojo.News;

public class NewsService {
	
	NewsDAO newsDAO = new NewsDAO();
	
	public boolean addNews(News news)
	{
		return newsDAO.addNews(news);
	}
	
	public boolean updateNews(News news)
	{
		return newsDAO.updateNews(news);
	}
	
	public boolean deleteNews(int id)
	{
		return newsDAO.deleteNews(id);
	}
	
	public News getNewsById(int Id)
	{
		return newsDAO.getNewsById(Id);
	}
	
	
	public List getNewsList()
	{
		return newsDAO.getNewsList();
	}
	
	public void close()
	{
		newsDAO.close();
	}
}
