package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utils {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest Test;
	public String TestName, TestAuthor, TestDescription;
	
	public void BrowserLaunch() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://todomvc.com/examples/react/dist/");
	}
	
	public void BrowserClose() {
		driver.close();
	}
	
	public void TakeScreenshot(String filename) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:\\Users\\it185\\eclipse-workspace\\Todo\\Screenshots\\" + filename + ".png");
		FileUtils.copyFile(src, Destination);
	}

}
