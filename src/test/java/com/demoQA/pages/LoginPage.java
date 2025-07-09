package com.demoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
	
	WebDriver driver;
	
	public LoginPage () {
		super();
		driver = Base.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "userName")
	WebElement usernameField;
	
	@FindBy (id = "password")
	WebElement passwordField;
	
	@FindBy (id = "login")
	WebElement loginButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[1]/div[3]/label[2]")
	WebElement loggedInUsernameLabel;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/p")
	WebElement errorMessage;


	
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void login (String user, String pass) {
		clickLogin();
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
	}
	
	public boolean isLoginSuccessful() {
	    try {
	        return loggedInUsernameLabel.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public String getErrorMessage() {
	    try {
	        return errorMessage.getText().trim();
	    } catch (Exception e) {
	        return "No error message found";
	    }
	}


}
