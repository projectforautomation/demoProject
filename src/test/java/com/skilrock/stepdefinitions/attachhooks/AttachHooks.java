package com.skilrock.stepdefinitions.attachhooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.skilrock.dge.common.utils.ConfigManager;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AttachHooks {
	
	public static WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/stpl/eclipse-workspace/Sample/chromedriver");
		driver = new ChromeDriver();
		ConfigManager.loadConfig();
		driver.get(ConfigManager.getProperty("EnvironmentURL"));
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		System.out.println("after");
	}

}
