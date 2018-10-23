package com.skilrock.dge.common.pages;

import org.openqa.selenium.WebDriver;

import com.skilrock.dge.common.objectRepository.LoginPageLocators;
import com.skilrock.dge.common.utils.ConfigManager;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean enterUserNameAndPassword(String userName,String password) {
		try {
	    findElement(LoginPageLocators.userName,5).sendKeys(userName);
	    findElement(LoginPageLocators.password,5).sendKeys(password);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean clickOnLogin() {
		try {
		findElement(LoginPageLocators.loginBtn,5).click();
		
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean performLogin(String username, String password) {
		String queryParam = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}";
		Response response = given().contentType("application/json")
				.queryParam("json", queryParam).get(ConfigManager.getProperty("EnvironmentURL")+"/com/skilrock/lms/web/loginMgmt/userLogin.action");
		
				
				String resp = response.getBody().asString();
		// TODO Auto-generated method stub
		return true;
	}

}
