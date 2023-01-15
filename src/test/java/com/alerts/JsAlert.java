package com.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlert {

	WebDriver driver;
	Alert alertWindow;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void clickJsAlert() throws InterruptedException {
		WebElement button1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		button1.click();
		Thread.sleep(3000);
		alertWindow = driver.switchTo().alert();
		alertWindow.accept();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void clickJsConfirm() throws InterruptedException {
		WebElement button2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		button2.click();
		Thread.sleep(3000);
		alertWindow = driver.switchTo().alert();
		alertWindow.dismiss();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void clickJsPrompt() throws InterruptedException {
		WebElement button3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		button3.click();
		Thread.sleep(3000);
		alertWindow = driver.switchTo().alert();
		alertWindow.sendKeys("zain");
		alertWindow.accept();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void validateBasicAuth() throws InterruptedException {
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
