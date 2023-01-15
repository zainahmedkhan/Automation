package com.iframes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames {

	// we can switch to frame using name or id, WebElement and index
	
	WebDriver driver;
	
	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("zain");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div/div/iframe")));
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("abc");
		Thread.sleep(3000);
	
		
		driver.quit();
	}
}
