package com.skilrock.first;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AttachHooks {
	
	public static WebDriver driver;
	
	@Before
	public void setUp() {
		

		
		System.setProperty("webdriver.chrome.driver", "/home/stpl/eclipse-workspace/Sample/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("http://192.168.134.234:8085/RMS");
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		System.out.println("after");
	}

}
