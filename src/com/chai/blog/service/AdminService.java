package com.chai.blog.service;

import java.util.List;

import com.chai.blog.dao.system.AdminDAO;
import com.chai.blog.pojo.Admin;

public class AdminService {
	AdminDAO adminDAO = new AdminDAO();
	
	public Admin getAdmin(String username)
	{
		return adminDAO.getAdmin(username);
	}
	
	
	public List getAdminList()
	{
		return adminDAO.getAdminList();
	}
	
	
	public boolean addAdmin(Admin admin)
	{
		return adminDAO.addAdmin(admin);
	}
	
	public boolean updateAdmin(Admin admin)
	{
		return adminDAO.updateAdmin(admin);
	}
	
	
	public boolean deleteAdmin(String username)
	{
		return adminDAO.deleteAdmin(username);
	}
	
	
	public boolean checkAdmin(String username,String password)
	{
		return adminDAO.checkAdmin(username, password);
	}
	
	public boolean hasAdmin(String username)
	{
		return adminDAO.hasAdmin(username);
	}
	
	
	public void close()
	{
		adminDAO.close();
	}
}
