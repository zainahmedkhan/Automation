package cucumbertestrunners;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(

		features = {"src/test/resources/AppFeatures/Place_Order_From_Webshop.feature" }, 
		glue = "stepdefinitions", 
		plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
		monochrome = true, 
		dryRun = false
	)

public class TestRunner extends AbstractTestNGCucumberTests {

	// extends AbstractTestNGCucumberTests

	/*
	 * private TestNGCucumberRunner testNGCucumberRunner;
	 * 
	 * @BeforeClass(alwaysRun = true) public void setup() { testNGCucumberRunner =
	 * new TestNGCucumberRunner(this.getClass()); }
	 * 
	 * @Test(groups = "cucumber", description = "Runs Cucumber Scenarios",
	 * dataProvider = "features") public void scenario(PickleWrapper pickle,
	 * FeatureWrapper cucumberFeature) {
	 * testNGCucumberRunner.runScenario(pickle.getPickle()); }
	 * 
	 * @DataProvider public Object[][] features() { return
	 * testNGCucumberRunner.provideScenarios(); }
	 * 
	 * @AfterClass(alwaysRun = true) public void tearDownClass() throws Exception {
	 * testNGCucumberRunner.finish(); }
	 */

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */

}
