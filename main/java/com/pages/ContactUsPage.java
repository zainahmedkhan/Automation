package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	private WebDriver driver;
	
	
	/*
	 * @FindBy(how=How.PARTIAL_LINK_TEXT, using="Contact us") WebElement contactUs;
	 */
	
	By contactUs = By.linkText("Contact us");
	
	
	public ContactUsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	

}
