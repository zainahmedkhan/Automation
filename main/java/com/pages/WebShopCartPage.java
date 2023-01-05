package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;
import com.qa.utils.ExcelUtils;

public class WebShopCartPage {

	private WebDriver driver;
	private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
	
	By MDSCheckBox = By.xpath("//*[@id='add_update_action_fake_checkbox_23']/em[1]");
	By email = By.id("email-input");
	By continueBtn = By.xpath("//button[@class='checkout-submit']");
	By acceptCookies = By.id("onetrust-accept-btn-handler");
	By mdsPrice = By.xpath("//*[@id='_summary_addons']/div/div/div/div[2]/strong");
	By taxAmount = By.xpath("//*[contains(text(),'21%')]");
	By firstName = By.xpath("//*[@name='firstname']");
	By lastName = By.xpath("//*[@name='lastname']");
	By phoneNo = By.xpath("//*[@name='telephone']");
	By company = By.xpath("//*[@name='company']");
	By zip = By.xpath("//*[@name='postcode']");
	By city = By.xpath("//*[@name='city']");
	By address = By.xpath("//*[@name='street[0]']");
	By acceptAgreementCheckbox = By.xpath("//*[@id='sticky-side']/div[3]/div[1]/div/div/div/label/span[1]");
	By invoice = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[5]/div[1]/label/span[1]");
	By paypal = By.xpath("$x(\"//*[@id='checkout-payment-method-load']/div/div/div[3]/div[1]/label\")");
	By paypalButton = By.xpath("//*[@id=\"buttons-container\"]/div/div/div/div[1]/img");
	By placeOrderButton = By.xpath("//*[@id='action-primary-continue']");
	By paypalLoginEmail = By.xpath("//*input[@id='email']");
	By paypalLoginPassword = By.xpath("//*input[@id='password']");
	By paypalLoginButton = By.xpath("//*button[@id='btnLogin']");
	
	
	// By backLink = By.linkText("Back");

	public WebShopCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void acceptCookies() {
		WebElement acceptCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookies));
		acceptCookie.click();
	}

	public void addMDS() {
		driver.findElement(MDSCheckBox).click();
	}

	public void enterEmail(String e) {
		driver.findElement(email).sendKeys(e);
	}

	public void clickContinueButton() {
		driver.findElement(continueBtn).click();
	}

	public String getPageTitle() {
		return DriverFactory.getDriver().getTitle();
	}

	public String getMDSPrice() {
		String MDS_price = driver.findElement(mdsPrice).getText();
		return MDS_price;
	}

	public String getTax() {
		String tax_amount = driver.findElement(taxAmount).getText();
		return tax_amount;
	}

	public void enterBillingDetails(){
		
			driver.findElement(firstName).sendKeys("zain");
			driver.findElement(lastName).sendKeys("khan");
			driver.findElement(company).sendKeys("visionet");
			driver.findElement(phoneNo).sendKeys("+6464556656");
			driver.findElement(address).sendKeys("street 101");
			driver.findElement(city).sendKeys("soest");
			driver.findElement(zip).sendKeys("1234");			
	}
	
	public void fillBillingDetails(String f_name, String l_name, String zip_code, 
			String add, String ph, String city_name)
	{
		driver.findElement(firstName).sendKeys(f_name);
		driver.findElement(lastName).sendKeys(l_name);
		driver.findElement(phoneNo).sendKeys(ph);
		driver.findElement(address).sendKeys(add);
		driver.findElement(city).sendKeys(city_name);
		driver.findElement(zip).sendKeys(zip_code);	
		
	}
	public void acceptAgreement() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(acceptAgreementCheckbox)).click();
		Thread.sleep(5000);
	}

	public void selectInvoicePaymentMethod() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(invoice)).click();
		Thread.sleep(5000);
	}
		
	public void clickPlaceOrder() {

		wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
	}
	
	public void selectPaypalPaymentMethod()
	{
		driver.findElement(paypal);
	}
	
	public void clickPaypalButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(paypalButton)).click();
	}
	
	public void enterPaypalCredentials(String email, String pass)
	{
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();	
		String parentWindow = iterator.next();
		String childWindow = iterator.next();	
		driver.switchTo().window(childWindow);	
		driver.findElement(paypalLoginEmail).sendKeys(email);
		driver.findElement(paypalLoginPassword).sendKeys(pass);
		driver.findElement(paypalLoginButton).click();
		
	}

}
