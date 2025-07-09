package com.demoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Base {

	WebDriver driver;
	
	public RegisterPage() {
		super();
		driver = Base.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "login")
	WebElement loginButton;
	
	@FindBy (id = "newUser")
	WebElement newUserButton;
	
	@FindBy (id = "firstname")
	WebElement firstnameField;
	
	@FindBy (id = "lastname")
	WebElement lastnameField;
	
	@FindBy (id = "userName")
	WebElement usernameField;
	
	@FindBy (id = "password")
	WebElement passwordField;
	
	@FindBy (xpath = "/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")
	WebElement recaptchaButton;
	
	@FindBy (id = "register")
	WebElement registerButton;
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void clickNewUser() {
		newUserButton.click();
	}
	
	public void enterFirstname(String firstname) {
		firstnameField.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		lastnameField.sendKeys(lastname);
	}
	
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void verifyRecaptcha() {
		recaptchaButton.click();
	}
	
	public void clickRegister() {
		registerButton.click();
	}
	
	public void registerNewUser(String firstname, String lastname, String username, String password) {
		clickLogin();
		clickNewUser();
		enterFirstname(firstname);
		enterLastname(lastname);
		enterUsername(username);
		enterPassword(password);
		///verifyRecaptcha();
		///clickRegister();
	}
}
