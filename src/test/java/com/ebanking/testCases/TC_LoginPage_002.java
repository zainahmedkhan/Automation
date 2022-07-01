package com.ebanking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.ExcelUtilities;

public class TC_LoginPage_002 extends BaseClass{
	
	@Test(dataProvider="loginData")
	public void loginDDT(String uname, String pass) throws IOException, InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(uname);
		logger.info("User name entered");
		
		lp.setPassword(pass);
		logger.info("Password entered");
		
		lp.clickBtn();
		logger.info("Login button clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			lp.clickLogOut();
			
			Thread.sleep(3000);
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();				
			}
			else
			{
				Assert.assertTrue(false);
				captureScreenShot(driver,"DDT_Test");
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				logger.warn("Login Failed...!");
				
			}
		}
	}
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException
	{
		
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\ebanking\\testData\\ebanking_testdata.xlsx";
		ExcelUtilities xlUtil = new ExcelUtilities(path);
		
		int totalRows = xlUtil.getRowCount("sheet1");
		int totalCols = xlUtil.getCellCount("sheet1", 1);
		
		String loginData[][] = new String[totalRows][totalCols];
		
		for(int r=1; r<=totalRows; r++)
		{
			for(int c=0; c<totalCols; c++)
			{
				loginData[r-1][c] = xlUtil.getCellData("sheet1", r, c);
			}
		}
		
		return loginData;
	}

}
