package com.chai.blog.service;


import java.util.List;

import com.chai.blog.dao.system.ITDAO;
import com.chai.blog.pojo.IT;

public class ITService {
	
	ITDAO itDAO = new ITDAO();
	
	public boolean addIT(IT it)
	{
		return itDAO.addIT(it);
	}
	
	public boolean updateIT(IT it)
	{
		return itDAO.updateIT(it);
	}
	
	public boolean deleteIT(int id)
	{
		return itDAO.deleteIT(id);
	}
	
	public IT getITById(int Id)
	{
		return itDAO.getITById(Id);
	}
	
	
	public List getITList()
	{
		return itDAO.getITList();
	}
	
	public void close()
	{
		itDAO.close();
	}
}
