package com.chai.blog.service;


import java.util.List;

import com.chai.blog.dao.system.ArticleDAO;
import com.chai.blog.pojo.Article;

public class ArticleService {
	
	ArticleDAO articleDAO = new ArticleDAO();
	
	public boolean addArticle(Article article)
	{
		return articleDAO.addArticle(article);
	}
	
	public boolean updateArticle(Article article)
	{
		return articleDAO.updateArticle(article);
	}
	
	public boolean deleteArticle(int id)
	{
		return articleDAO.deleteArticle(id);
	}
	
	public Article getArticleById(int Id)
	{
		return articleDAO.getArticleById(Id);
	}
	
	
	public List getArticleList()
	{
		return articleDAO.getArticleList();
	}
	
	public void close()
	{
		articleDAO.close();
	}
}
