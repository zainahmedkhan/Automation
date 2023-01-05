package paralleltesting;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(

		features = {"src/test/resources/paralleltesting"}, 
		glue = "paralleltesting", 
		plugin ={"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		monochrome = true, 
		dryRun = false
	)

public class ParallelRun extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
