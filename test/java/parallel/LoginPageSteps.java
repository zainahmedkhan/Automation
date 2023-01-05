package parallel;

import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {
	
	private WebDriver driver;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ConfigReader configReader;
	private String title;
	private Properties prop;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	   
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		String URL = prop.getProperty("URL");		
		DriverFactory.getDriver().get(URL);
		DriverFactory.getDriver().manage().window().maximize();
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getPageTitle();
		System.out.println("Page tite is : "+ title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		
		System.out.println("Title is :"+title);
	    Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    
		Assert.assertTrue(loginPage.isForgotPassworkLink_Displayed());
	}

	@When("User enters the valid username {string}")
	public void user_enters_the_valid_username(String userName) {
		
		loginPage.enterPassword(userName);
	}

	@When("User enters the correct password {string}")
	public void user_enters_the_correct_password(String pwd) {
	    loginPage.enterPassword(pwd);
	}

	@When("User clicks on the Signin button")
	public void user_clicks_on_the_Signin_button() {
	    loginPage.clickSubmit();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}
}
