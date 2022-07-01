package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver d)
	{
		driver=d;		
		PageFactory.initElements(d, this);
	}
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement NewCustomer;
	
	@CacheLookup
	@FindBy(name="name")
	WebElement CustomerName;
	
	@CacheLookup
	@FindBy(name="rad1")
	WebElement rGender;
	
	@CacheLookup
	@FindBy(how=How.ID_OR_NAME, using = "dob")
	WebElement DateOfBirth;
	
	@CacheLookup
	@FindBy(name="city")
	WebElement City;
	
	@CacheLookup
	@FindBy(name="state")
	WebElement State;
	
	@CacheLookup
	@FindBy(name="addr")
	WebElement Address;
	
	@CacheLookup
	@FindBy(name="pinno")
	WebElement Pin_No;
	
	@CacheLookup
	@FindBy(how=How.ID_OR_NAME , using="telephoneno")
	WebElement Mobile;
	
	@CacheLookup
	@FindBy(name="emailid")
	WebElement Email;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement Password;
	
	@CacheLookup
	@FindBy(name="sub")
	WebElement Btn_Submit;
	
	public void LinkNewCustomer()
	{
		NewCustomer.click();
	}
	
	public void setCustomerName(String name)
	{
		CustomerName.sendKeys(name);
	}
	
	public void customerGender(String c_Gender)
	{
		rGender.click();
	}
	
	public void setDob(String mm, String dd, String yy)
	{
		DateOfBirth.sendKeys(mm);
		DateOfBirth.sendKeys(dd);
		DateOfBirth.sendKeys(yy);
	}
	
	public void setAddress(String add)
	{
		Address.sendKeys(add);
	}
	
	public void setCity(String c)
	{
		City.sendKeys(c);
	}
	
	public void setState(String s)
	{
		State.sendKeys(s);
	}
	
	public void setMobileNo(String ph)
	{
		Mobile.sendKeys(ph);
	}
	
	public void setPin(int pin)
	{
		Pin_No.sendKeys(String.valueOf(pin));
	}
	
	public void setEmail(String e)
	{
		Email.sendKeys(e);
	}
	
	public void setPassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void clickSubmit()
	{
		Btn_Submit.click();
	}
	

}
