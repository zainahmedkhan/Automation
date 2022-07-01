package com.ebanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.AddCustomerPage;
import com.ebanking.pageObjects.LoginPage;

public class TC_AddCustomer extends BaseClass {

	@Test
	public void addCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.clickBtn();
		
		Thread.sleep(3000);
		
		AddCustomerPage customerPage = new AddCustomerPage(driver);
		
		customerPage.LinkNewCustomer();
		logger.info("Clicked on New Customer");
		
		customerPage.setCustomerName("zain");
		logger.info("customer name has entered");
		
		customerPage.setCity("Lahore");
		logger.info("customer city has entered");
		
		customerPage.setDob("12", "25", "1997");
		System.out.println("DOB Entered");
		Thread.sleep(3000);
		customerPage.setState("Punjab");
		System.out.println("State Entered");
		customerPage.customerGender("male");
		System.out.println("Gender Entered");
		customerPage.setAddress("house 123");
		System.out.println("Address Entered");
		customerPage.setMobileNo("123456487");
		System.out.println("Mobile Entered");
		customerPage.setPassword("123456");
		System.out.println("Password Entered");
		
		String email = randomString()+"@gmail.com";
		customerPage.setEmail(email);		
		customerPage.setPin(125578);
		
		Thread.sleep(1000);
		
		customerPage.clickSubmit();		
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
			logger.info("Customer registered Successfully");
		}
		else
		{
			Assert.assertTrue(false);
			captureScreenShot(driver,"TC_AddCustomer");
		}
	}
}
