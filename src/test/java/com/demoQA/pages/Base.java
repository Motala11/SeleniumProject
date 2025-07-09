package com.demoQA.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.demoQA.utilities.PropertiesHandler;


public class Base {

	protected static WebDriver driver;
	
	public Base() {
	}
	
	public static WebDriver getDriver() {
		
		String browser = PropertiesHandler.getConfig("browserType");
		
		if (browser == null) {
			throw new RuntimeException("browserType is not defined in config.properties");
		}
		
			switch(browser.toLowerCase()) {
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
			driver.get(PropertiesHandler.getConfig("appUrl"));
			///driver.get("https://demoqa.com/books");
			return driver;
	}
	
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}

