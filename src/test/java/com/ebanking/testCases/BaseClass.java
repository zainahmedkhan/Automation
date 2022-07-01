package com.ebanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ebanking.utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	//public String userName = "mngr405331";
	//public String password="EpaqEju";
	//public String URL = "https://demo.guru99.com/v4/";
	
	ReadConfig readConfig = new ReadConfig();
	public String userName = readConfig.getUsername();
	public String password=readConfig.getPassword();
	public String baseURL = readConfig.getApplicationURL();
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		 logger = Logger.getLogger("ebanking");
		 DOMConfigurator.configure("log4j2.xml");
		
		 if(br.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ readConfig.getChromePath());
				driver = new ChromeDriver();
		 }
		 
		 driver.get(baseURL);
		 driver.manage().window().maximize();
		 logger.info("URL is opened");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public boolean isAlertPresent()
	{
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	public String randomString()
	{
		String rString = RandomStringUtils.randomAlphabetic(8);
		return rString;
	}
	
	public void captureScreenShot(WebDriver driver, String test_name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "//Screenshots//" + test_name + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Captured...!");
		logger.info("Screenshot captured....!");
	}
	

}
