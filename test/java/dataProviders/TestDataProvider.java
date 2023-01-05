package dataProviders;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.utils.ExcelUtils;

public class TestDataProvider {
	
	WebDriver driver;
	public TestDataProvider(WebDriver dri)
	{
		driver=dri;
	}
	
	//zain
	//ahmed
	
	By firstName = By.xpath("//*[@name='firstname']");
	By lastName = By.xpath("//*[@name='lastname']");
	By phoneNo = By.xpath("//*[@name='telephone']");
	By company = By.xpath("//*[@name='company']");
	By zip = By.xpath("//*[@name='postcode']");
	By city = By.xpath("//*[@name='city']");
	By address = By.xpath("//*[@name='street[0]']");
	
	@Test(dataProvider = "Checkout Data")
	public void getCheckoutData(String firstname, String lastname, String email, String phone, String comp, String add, String z, String c )
	{
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(company).sendKeys(comp);
		driver.findElement(phoneNo).sendKeys(phone);
		driver.findElement(address).sendKeys(add);
		driver.findElement(city).sendKeys(c);
		driver.findElement(zip).sendKeys(z);
	}
	
	
	@DataProvider(name = "Checkout Data")
	public String [][] getTestData() throws IOException
	{		
		String path="C:\\Users\\zain.rehani\\eclipse-workspace\\HybridFrameworkBDD\\src\\test\\resources\\testdata.xlsx";
		ExcelUtils xlUtils = new ExcelUtils(path);
		
		int totalRows = xlUtils.getRowCount("Sheet1");
		int totalCols = xlUtils.getCellCount("Sheet1", 1);
		
		String checkoutData[][] = new String[totalRows][totalCols];
		
		for(int i=1;i<=totalRows; i++)
		{
			for(int j=0;j<totalCols; j++)
			{
				checkoutData[i-1][j] = xlUtils.getCellData("Sheet1", i, j);
			}
		}
		return checkoutData;
	}
}
