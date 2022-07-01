package com.ebanking.utilities;

//Listener class to generate extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter html_reporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timeStramp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStramp+".html";
		
		html_reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		html_reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(html_reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("Environemt", "QA");
		extent.setSystemInfo("user", "zain");
		
		
		html_reporter.config().setDocumentTitle("ebanking Test Automation Report");
		html_reporter.config().setReportName("Functional Test Report");
		html_reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		html_reporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());   //add new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f = new File(screenShotPath);
		
		if(f.exists())
		{
			try 
			{
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenShotPath));			
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
			
	}
	
	public void onTestSkipper(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
