package paralleltesting;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.pages.WebShopCartPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;
import com.qa.utils.ExcelReader;
import com.qa.utils.InitializeBrowser;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceWebshopOrderSteps

{

	private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
	private WebShopCartPage page = new WebShopCartPage(DriverFactory.getDriver());
	private ConfigReader configReader = new ConfigReader();
	private Properties prop = configReader.init_prop();

	@Given("User navigates to the webshop URL")
	public void user_navigates_to_the_webshop_url() throws InterruptedException {

		String url = prop.getProperty("URL");
		new InitializeBrowser(DriverFactory.getDriver(), url);
		Thread.sleep(5000);

	}

	@Then("The title of the page is {string}")
	public void the_title_of_the_page_is(String expectedPageTitle) {

		String actualPageTitle = page.getPageTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		System.out.println("Actual Page Title is : " + actualPageTitle);
	}

	@When("User accepts the cookies")
	public void user_accept_the_cookies() throws InterruptedException {

		page.acceptCookies();
		Thread.sleep(3000);
		// Assert.fail();
	}

	@When("User enters the valid email address")
	public void user_enters_the_valid_email_address() {

		String midString = RandomStringUtils.randomAlphabetic(8);
		String email = "testautomation" + midString + "@visionet.com";

		page.enterEmail(email);
	}

	@When("User clicks the continue to payment button")
	public void user_clicks_the_continue_to_payment_button() throws InterruptedException {

		page.clickContinueButton();
		wait.until(ExpectedConditions.titleContains("Checkout"));
	}

	@Then("User navigates to the checkout page")
	public void user_navigates_to_the_checkout_page() {

		String pageTitle = page.getPageTitle();
		AssertJUnit.assertTrue(pageTitle.equals("Checkout"));
		System.out.println("Page title is : " + pageTitle);

	}

	@Then("User enters the following billing details")
	public void user_enters_the_following_billing_details(DataTable dataTable) {

		List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> e : userList) {
			String firstName = e.get("firstname");
			String lastName = e.get("lastname");
			String address = e.get("address");
			String zip = e.get("zip");
			String phone = e.get("phone");
			String city = e.get("city");

			page.fillBillingDetails(firstName, lastName, zip, address, phone, city);
		}
	}

	@Then("User selects the payment method Invoice")
	public void user_selects_the_payment_method_invoice() throws InterruptedException {

		page.selectInvoicePaymentMethod();
	}

	@Then("User accepts the license agreement")
	public void user_accepts_the_license_aggreement() throws InterruptedException {

		page.acceptAgreement();
	}

	@Then("User clicks on the place order button")
	public void user_clicks_on_the_place_order_button() throws InterruptedException {

		page.clickPlaceOrder();
		wait.until(ExpectedConditions.titleContains("Success"));
		Thread.sleep(20000);

	}

	@Then("User selects the payment method Paypal")
	public void user_selects_the_payment_method_paypal() {
		page.selectPaypalPaymentMethod();
	}

	@Then("User clicks on the paypal button")
	public void user_clicks_on_the_Paypal_button() {
		page.clickPaypalButton();
	}

	@Then("User enters the paypal credentials")
	public void enterPayapalCredentials(DataTable dataTable) {
		Map<String, String> payalCredentials = dataTable.asMap(String.class, String.class);

		String email = payalCredentials.get("Email");
		String password = payalCredentials.get("Password");

		page.enterPaypalCredentials(email, password);
	}
}
