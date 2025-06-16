package com.demo_qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base {

	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "searchBox")
	WebElement searchBox;
	
	@FindBy (id = "login")
	WebElement loginButton;
	
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a")
	WebElement gitBookLink;
	
	public void enterSearchTerm(String term) {
		searchBox.clear();
		searchBox.sendKeys(term);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickGitPocketGuide() {
		gitBookLink.click();
	}
	
	
}
