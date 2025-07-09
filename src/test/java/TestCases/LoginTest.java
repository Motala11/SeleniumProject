package TestCases;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.demoQA.pages.Base;
import com.demoQA.pages.LoginPage;

public class LoginTest {

	LoginPage loginPage;
	
	private WebDriver driver;
	 private static final Logger logger = LogManager.getLogger(LoginTest.class);
	 
	 @BeforeClass
	 public void setUp() {
	 driver = Base.getDriver();
	 loginPage = new LoginPage();
	 }
	 
	 @Test
	 public void testLogin() {
	 logger.info("Executing login test");
	 loginPage.login("Motala", "password");
	 }
	 
	 @AfterClass
	 public void tearDown() {
	 driver.quit();
	 logger.info("Browser closed");
	 }
	}


