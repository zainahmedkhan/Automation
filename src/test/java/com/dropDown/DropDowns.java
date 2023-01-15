package com.dropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowns {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
	}
	
	
	  @Test(priority=1) 
	  public void selectDropDown() throws InterruptedException 
	  {
		  WebElement dropDownEle = driver.findElement(By.id("input-country")); Select
		  countryDropDown = new Select(dropDownEle);
		  countryDropDown.selectByVisibleText("Brazil");
		  //countryDropDown.selectByValue("2"); Thread.sleep(5000); 
	  }
	 
	
	@Test(priority=0)
	public void selectWithGetOptions()
	{
		WebElement dropDownEle = driver.findElement(By.id("input-country"));
		Select countryDropDown = new Select(dropDownEle);
		List<WebElement> allOptions = countryDropDown.getOptions();
		
		for(WebElement option:allOptions)
		{
			if(option.getText().equals("Cuba"))
			{
				option.click();
				break;
			}
		}
			
	}
	
	@AfterTest()
	public void tearDown()
	{
		driver.quit();
	}

}
