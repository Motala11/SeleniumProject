package com.demo_qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {
	
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "username")
	WebElement usernameField;
	
	@FindBy (id = "password")
	WebElement passwordField;
	
	@FindBy (id = "login")
	WebElement loginButton;
	
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		usernameField.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void login (String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
	}
}
