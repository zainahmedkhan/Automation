package parallel;


import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private ConfigReader configReader= new ConfigReader();
	private Properties prop;
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage; 

	@Given("User has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable credTable) {
	    
		List<Map<String,String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String pwd = credList.get(0).get("password");
		
		prop = configReader.init_prop();
		String url = prop.getProperty("URL");
		DriverFactory.getDriver().get(url);
		DriverFactory.getDriver().manage().window().maximize();
		
		accountPage = loginPage.doLogin(userName, pwd);    //page chaining
		
		
	}

	@Given("User is on account page")
	public void user_is_on_account_page() {
		
		Assert.assertTrue(accountPage.getPageTitle().equals("My account - My Store"));
	    
	}

	@Then("User gets the account sections")
	public void user_gets_the_account_sections(DataTable sectionsTable) {
		
		List<String> expectedPageSectionsList = sectionsTable.asList();
		System.out.println("Expected Account Sections Lists: "+ expectedPageSectionsList);
		
		List<String> actualPageSectionsList = accountPage.getPageSectionsList();
		System.out.println("Actual Account Sections Lists: "+ actualPageSectionsList);
		
		Assert.assertTrue(expectedPageSectionsList.containsAll(actualPageSectionsList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expectedCount) {
	  Assert.assertTrue(accountPage.getAccountSectionsCount() == expectedCount);
	}

}
