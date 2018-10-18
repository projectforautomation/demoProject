package com.skilrock.dge.common.objectRepository;

import org.openqa.selenium.By;

public class LoginPageLocators {
	
	public static By userName = By.id("username");
	
	public static By password = By.xpath("//input[@id='password']");
	
	public static By loginBtn = By.xpath("//input[@value='Login']");

}
