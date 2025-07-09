package com.demoQA.stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.demoQA.pages.Base;
import com.demoQA.pages.LoginPage;
import com.demoQA.utilities.ExtentListener;
import com.demoQA.utilities.ScreenshotUtil;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);

    @Given("I open the application")
    public void i_open_the_application() {
        logger.info("Opening the application");
        driver = Base.getDriver();
        loginPage = new LoginPage();
        logger.info("Application launched successfully");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        logger.info("Entering username: " + username);
        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        logger.info("Entering password: " + password);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        logger.info("Clicking the login button");
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        logger.info("Verifying successful login");
        ExtentTest extentTest = ExtentListener.getCurrentTest();
        try {
            Assert.assertTrue("Expected login to be successful", loginPage.isLoginSuccessful());
            logger.info("Login verification passed");
            extentTest.pass("Login was successful");
        } catch (AssertionError e) {
            String path = ScreenshotUtil.captureScreenshot(driver, "LoginSuccessFailure");
            extentTest.fail("Login assertion failed").addScreenCaptureFromPath(path);
            logger.error("Assertion failed. Screenshot saved at: " + path);
            throw e;
        }
    }

    @Then("I should see a validation error")
    public void i_should_see_a_validation_error() {
        logger.info("Verifying presence of validation or error message");
        ExtentTest extentTest = ExtentListener.getCurrentTest();
        try {
            String errorMsg = loginPage.getErrorMessage();
            logger.info("Error message retrieved: " + errorMsg);
            Assert.assertTrue("Expected an error message", errorMsg.toLowerCase().contains("invalid")
                    || errorMsg.toLowerCase().contains("required")
                    || errorMsg.length() > 0);
            logger.info("Validation message assertion passed");
            extentTest.pass("Validation error appeared as expected");
        } catch (AssertionError e) {
            String path = ScreenshotUtil.captureScreenshot(driver, "ValidationErrorFailure");
            extentTest.fail("Validation error assertion failed").addScreenCaptureFromPath(path);
            logger.error("Validation assertion failed. Screenshot saved at: " + path);
            throw e;
        }
    }
}
