/*package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExtentReportsTest {

	 protected WebDriver driver;
	 protected static ExtentReports extent;
	 protected static ExtentTest test;
	 @BeforeSuite
	 public void setupExtent() {
	 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("testoutput/ExtentReport.html");
	 htmlReporter.config().setDocumentTitle("Automation Report");
	 htmlReporter.config().setReportName("Selenium Test Results");
	 htmlReporter.config().setTheme(Theme.STANDARD);
	 extent = new ExtentReports();
	 extent.attachReporter(htmlReporter);
	 }
	 @BeforeMethod
	 public void setup() {
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 }
	 @AfterMethod
	 public void teardown() {
	 driver.quit();
	 }
	 @AfterSuite
	 public void tearDownExtent() {
	 extent.flush();
	 }
	}
}*/
