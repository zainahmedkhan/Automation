package com.ebanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass{

	//public static Logger logger = LogManager.getLogger(TC_LoginPage_001.class.getName());
	
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseURL);
		
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.clickBtn();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
			logger.error("Test Case Failed");
		}
		else 
		{ 
			captureScreenShot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Test case Failed...!");
		}
		 
		
	}
	
	

}
