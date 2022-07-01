package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver local_driver;
	
	public LoginPage(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txt_username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(how=How.XPATH , using = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement LogOut;
	
	public void setUsername(String name)
	{
		txt_username.sendKeys(name);
	}
	
	public void setPassword(String pass)
	{
		txt_password.sendKeys(pass);
	}
	
	public void clickBtn()
	{
		btn_login.click();
	}
	
	public void clickLogOut()
	{
		LogOut.click();
	}
	
}
