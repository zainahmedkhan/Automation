package com.qa.factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	private ConfigReader configReader = new ConfigReader();
	private Properties prop = configReader.init_prop();

	public WebDriver init_driver(String browser) {
		System.out.println("Browser is " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else {
			System.out.println("Please pass the correct browser value...!");
		}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		
		
		return tlDriver.get();
	}
}
