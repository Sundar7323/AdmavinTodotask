package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utils;

public class Todobase extends Utils{
	
	@BeforeSuite
	public void reports() {
		String path="C:\\Users\\it185\\eclipse-workspace\\Todo\\Reports";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Todo List Report");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		Test=extent.createTest(TestName, TestDescription);
		Test.assignAuthor(TestAuthor);
	}
	
	@BeforeMethod
	public void Launch_browser() {
		BrowserLaunch();
	}
	
	@AfterMethod
	public void Close_browser() {
		BrowserClose();
	}
	
	@AfterSuite
	public void reportclose() {
		extent.flush();
	}
	
}
