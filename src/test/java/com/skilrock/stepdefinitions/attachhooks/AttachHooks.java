package com.skilrock.stepdefinitions.attachhooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skilrock.dge.common.utils.ConfigManager;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AttachHooks {
	
	public static WebDriver driver;
	
	private static Logger logger = LoggerFactory.getLogger(AttachHooks.class);
	
	@Before
	public void setUp() {
		logger.info("Inside attachhooks setup");
		System.setProperty("webdriver.chrome.driver", "/home/stpl/eclipse-workspace/Sample/chromedriver");
		driver = new ChromeDriver();
		ConfigManager.loadConfig();
		driver.get(ConfigManager.getProperty("EnvironmentURL"));
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		logger.info("after tear down");
	}

}
