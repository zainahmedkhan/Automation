package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}catch(Exception e)
		{
		    System.out.println("File not found.....!");
		}
		
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String userName = pro.getProperty("userName");
		return userName;
	}
	
	public String getPassword()
	{
		String pass = pro.getProperty("password");
		return pass;
	}
	
	public String getChromePath()
	{
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}

}
