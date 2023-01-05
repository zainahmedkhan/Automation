package cucumbertestrunners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures/Place_Order_From_Webshop.feature"},
		glue= {"stepdefinitions" , "AppHooks"},
		plugin= {"pretty"},
		monochrome=true,
		dryRun=false
		
		)

public class MyTestRunner {

	//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
