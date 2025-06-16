package com.demo_qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo_qa.utilities.PropertiesHandler;

public class Base {

	protected WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		
			switch(PropertiesHandler.getConfig("browserType".toLowerCase())) {
			case "chrome":
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				driver = new FirefoxDriver();
				break;
				
			case "edge":
				driver = new EdgeDriver();
				break;
				
			case "safari":
				driver = new SafariDriver();
				break;
				
			default:
				driver = new ChromeDriver();
				break;
			}							
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(PropertiesHandler.getConfig("applicationUnderTest"));
			return driver;
	}
	
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}

