package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	//private By emailId = By.id("email");
	
	  @FindBy(how=How.ID , using="email") 
	  WebElement emailID;
	  
	
	  @FindBy(id = "passwd")
	  WebElement password;
	 
	  @FindBy(name = "SubmitLogin")
	  WebElement submitBtn;
	  
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPassworkLink_Displayed()
	{
		return driver.findElement(By.linkText("Forgot your password?")).isDisplayed();
	}
	
	
	public void enterUsername(String email)
	{
		emailID.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		submitBtn.click();
	}
	
	//page chaining
	
	public AccountPage doLogin(String un, String pwd)
	{
		System.out.println("Login with "+un + " and " + pwd);
		emailID.sendKeys(un);
		password.sendKeys(pwd);
		submitBtn.click();
		return new AccountPage(driver);
	}
	
}







