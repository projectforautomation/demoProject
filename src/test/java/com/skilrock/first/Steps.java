package com.skilrock.first;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.When;


public class Steps {
	
	WebDriver driver = AttachHooks.driver;
	@When("^we enter username and password$")
	public void we_enter_username_and_password() throws Throwable {
	    driver.findElement(By.id("username")).sendKeys("bomaster");
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345678");
		// Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@When("^click on login$")
	public void click_on_login() throws Throwable {

	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}
	
}
