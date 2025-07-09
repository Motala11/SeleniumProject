package com.demoQA.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesHandler {
	
	public static String fs = System.getProperty("file.separator");
	public static String userDir = System.getProperty("user.dir");
	public static String testResources = userDir + fs + "src" + fs + "test" + fs + "resources" + fs;
	
	public static String configFile = testResources + "config.properties" + fs;
	public static String reportsFolder = testResources + "reports" + fs;
	public static String screenshotsFolder = testResources + "screenshots" + fs;
			
	static String reportDate;

	public static String getConfig(String key) {
		Properties props = new Properties();
		
		try (FileInputStream input = new FileInputStream(configFile)) {
				props.load(input);
				String value = props.getProperty(key);
				
				if (value == null) {
					throw new RuntimeException("Key '" + key + "'not found in config file.");
				}
			
			return value;
		} catch (IOException e) {
			throw new RuntimeException("Failed to read config file: " + configFile, e);
		}
	}
	
}
