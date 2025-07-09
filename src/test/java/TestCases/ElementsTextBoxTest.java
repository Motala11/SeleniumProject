package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demoQA.pages.Base;
import com.demoQA.pages.ElementsTextBox;

public class ElementsTextBoxTest {

	ElementsTextBox elementsTextBox;
	
	private WebDriver driver;
	
	 private static final Logger logger = LogManager.getLogger(ElementsTextBox.class);
	 
	 @BeforeClass
	 public void setUp() {
	 driver = Base.getDriver();
	 elementsTextBox = new ElementsTextBox();
	 }
	 
	 @Test
	 public void testElementsTextBoxField() {
		 logger.info("Executing ElementsTextBoxField test");
		 elementsTextBox.completeTextBox("Motala", "test123@test.com", "280 Bishopsgate", "123 Test Road");
	 }
	 
	 @AfterClass
	 public void tearDown() {
	 driver.quit();
	 logger.info("Browser closed");
	 }
}
