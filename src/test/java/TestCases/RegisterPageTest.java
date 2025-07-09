package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demoQA.pages.Base;
import com.demoQA.pages.RegisterPage;

public class RegisterPageTest {

	RegisterPage registerPage;
	
	private WebDriver driver;
	 private static final Logger logger = LogManager.getLogger(RegisterPage.class);
	 
	 @BeforeClass
	 public void setUp() {
	 driver = Base.getDriver();
	 registerPage = new RegisterPage();
	 }
	 
	 @Test
	 public void testRegisterNewUser() {
		 logger.info("Executing registration test");
		 registerPage.registerNewUser("Mohammed", "Motala", "Motala", "Password!");
	 }
	 
	 @AfterClass
	 public void tearDown() {
	 driver.quit();
	 logger.info("Browser closed");
	 }
}
