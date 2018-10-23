package com.skilrock.stepdefinitions.first;

import com.skilrock.dge.common.pages.LoginPage;
import com.skilrock.stepdefinitions.attachhooks.AttachHooks;

import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.*;


public class Steps {
	
	LoginPage login = new LoginPage(AttachHooks.driver);
	@When("^we enter (.*) and (.*)$")
	public void we_enter_username_and_password(String userName,String password) throws Throwable {
		assertThat(login.enterUserNameAndPassword(userName, password)).isTrue();
	}

	@When("^click on login$")
	public void click_on_login() throws Throwable {

	 assertThat(login.clickOnLogin()).isTrue();   

	}
	
	@When("^login is performed through api with (.*) and (.*)$")
	public void perform_login(String username,String password) {
		assertThat(login.performLogin(username,password)).isTrue();
	}
}
