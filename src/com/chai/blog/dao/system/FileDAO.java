package com.chai.blog.dao.system;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.tomcat.util.buf.Utf8Encoder;

import com.chai.blog.pojo.Path;

public class FileDAO {
	

	
	public Path getFilePath(String type,String realPath)
	{
		
		Path path = new Path();
		
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day_of_month = calendar.get(Calendar.DAY_OF_MONTH);
		Date date = calendar.getTime();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(); 
		
		String dicPath = type + "\\" + year + "\\" + month + "\\" + day_of_month;
		String filePath = dicPath + "\\" + date.getTime() + ".txt";
		
		path.setDicPath(dicPath);
		path.setFilePath(filePath);
		path.setRealPath(realPath);
		path.setTime(dateFormat.format(date));
		return path;
	}
	
	public boolean addFile(Path path,String content)
	{
		boolean flag = false;
		
		
		String dicPath = path.getRealPath() + path.getDicPath();
		
		File dic = new File(dicPath);
		
		if(!dic.exists()&&!dic.isDirectory())
		{
			dic.mkdirs();
		}
		
		String filePath = path.getRealPath() + path.getFilePath();
		File file = new File(filePath);
		
		
		try 
		{
			FileOutputStream fout = new FileOutputStream(file);
			if(!file.exists())
			{
				file.createNewFile();
			}
			
			byte[] contentByte = content.getBytes();
			
			fout.write(contentByte);
			
			fout.flush();
			fout.close();
			
			flag = true;
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public String getAbstract(String filePath)
	{
		ByteArrayOutputStream bos = null;
		File file = new File(filePath);
		
		
		try 
		{
			if(file.exists()&&file.isFile())
			{				
				FileInputStream fin = new FileInputStream(file);
				bos = new ByteArrayOutputStream();
				byte[] buffer = new byte[100];
				int length = -1;
				
				length = fin.read(buffer);
				
				bos.write(buffer, 0, length);
				
				bos.close();
				fin.close();
				
				
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		
		return bos.toString();
	}
	
	public String getContent(String filePath)
	{
		ByteArrayOutputStream bos = null;
		File file = new File(filePath);
		
		
		try 
		{
			if(file.exists()&&file.isFile())
			{				
				FileInputStream fin = new FileInputStream(file);
				bos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int length = -1;
				
				while((length=fin.read(buffer))>0)
				{
					if(length != 1024)
					{
						bos.write(buffer, 0, length);
					}
					else
					{
						bos.write(buffer);
					}
				}
				
				bos.close();
				
				fin.close();
				
				
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
		
		return bos.toString();
	}
	
	public boolean deleteFile(String filePath)
	{
		boolean flag = false;
		
		File file = new File(filePath);
		
		if(file.exists()&&file.isFile())
		{
			file.delete();
			flag = true;
		}
		return flag;
	}
	
	
}
