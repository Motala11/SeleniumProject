package com.demoQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsTextBox extends Base {

	WebDriver driver;
	
	public ElementsTextBox () {
		super();
		driver = Base.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/span/div")
	WebElement dropDownElementsList;
	
	@FindBy (id = "item-0")
	WebElement textBox;
	
	@FindBy (id = "userName")
	WebElement userNameField;
	
	@FindBy (id = "userEmail")
	WebElement emailField;
	
	@FindBy (id = "currentAddress")
	WebElement currentAddressField;
	
	@FindBy (id = "permanentAddress")
	WebElement permanentAddressField;
	
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/button")
	WebElement submitButton;
	
	public void clickDropdownMenu() {
		dropDownElementsList.click();
	}
	
	public void clickTextBox() {
		textBox.click();
	}
	
	public void enterUsername(String username) {
		userNameField.sendKeys(username);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterCurrentAddress(String currentAddress) {
		currentAddressField.sendKeys(currentAddress);
	}
	
	public void enterPermanentAddress(String permanentAddress) {
		permanentAddressField.sendKeys(permanentAddress);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
	
	public void completeTextBox(String username, String email, String currentAddress, String permanentAddress) {
		dropDownElementsList.click();
		textBox.click();
		enterUsername(username);
		enterEmail(email);
		enterCurrentAddress(currentAddress);
		enterPermanentAddress(permanentAddress);
	///	clickSubmit();
	}
}
