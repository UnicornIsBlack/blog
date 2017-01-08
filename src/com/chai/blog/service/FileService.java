package com.chai.blog.service;

import com.chai.blog.dao.system.FileDAO;
import com.chai.blog.pojo.Path;

public class FileService {
	
	FileDAO fileDAO = new FileDAO();
	
	public Path getFilePath(String type,String realPath)
	{
		return fileDAO.getFilePath(type,realPath);
	}
	
	public boolean addFile(Path path,String content)
	{
		return fileDAO.addFile(path, content);
	}
	
	public boolean deleteFile(String filePath)
	{
		return fileDAO.deleteFile(filePath);
	}
	
	public String getAbstract(String filePath)
	{
		return fileDAO.getAbstract(filePath);
	}
	
	public String getContent(String filePath)
	{
		return fileDAO.getContent(filePath);
	}
}
