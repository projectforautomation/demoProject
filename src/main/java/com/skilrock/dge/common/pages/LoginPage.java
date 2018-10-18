package com.skilrock.dge.common.pages;

import org.openqa.selenium.WebDriver;

import com.skilrock.dge.common.objectRepository.LoginPageLocators;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean enterUserNameAndPassword(String userName,String password) {
		try {
	    driver.findElement(LoginPageLocators.userName).sendKeys(userName);
	    driver.findElement(LoginPageLocators.password).sendKeys(password);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean clickOnLogin() {
		try {
		driver.findElement(LoginPageLocators.loginBtn).click();
		
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
