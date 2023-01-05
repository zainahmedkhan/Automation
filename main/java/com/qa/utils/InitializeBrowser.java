package com.qa.utils;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;


public class InitializeBrowser {

	private ConfigReader configReader = new ConfigReader();
	private Properties prop = configReader.init_prop();

	public InitializeBrowser(WebDriver driver, String url)
	{
		DriverFactory.getDriver().get(url);
		DriverFactory.getDriver().manage().window().maximize();
	}
}
