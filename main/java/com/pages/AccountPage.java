package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {

	private WebDriver driver;

	private By accountSections = By.cssSelector("div#center_column span");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// page actions

	public int getAccountSectionsCount() {
		return driver.findElements(accountSections).size();
	}

	public List<String> getPageSectionsList() {
		List<String> accountsList = new ArrayList<String>();
		List<WebElement> accountHeadersList = driver.findElements(accountSections);

		for (WebElement e : accountHeadersList) {
			String text = e.getText();
			accountsList.add(text);
		}

		return accountsList;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}

}
