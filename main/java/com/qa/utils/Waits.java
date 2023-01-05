package com.qa.utils;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Waits {

	private WebDriver driver;
	private ConfigReader configReader = new ConfigReader();
	private Properties prop = configReader.init_prop();
		
	public void addImplicitWait()  {

		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
	
	}
}
