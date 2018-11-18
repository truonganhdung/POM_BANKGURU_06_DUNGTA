package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pages.HomePageObject;
import pages.LoginPageObject;
import pages.RegisterPageObject;

public class Level_03_RegisterLoginLogout_PageObject extends AbstractTest{
	WebDriver driverTestCase;
	String email, userID, password, loginURL;

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestCase = openMultiBrowser(browserName);
		
		loginPage = new LoginPageObject(driverTestCase);

		email = "automations" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginURL = loginPage.getLoginPageUrl();
		loginPage.clickToHereLink();

		registerPage = new RegisterPageObject(driverTestCase);
		registerPage.inputToEmailTextBox(email);
		registerPage.clickToSubmitButton();

		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();
	}

	@Test
	public void TC_02_LoginToSystem() {
		registerPage.openAnyUrl(driverTestCase, loginURL);

		loginPage = new LoginPageObject(driverTestCase);
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driverTestCase);
		Assert.assertTrue(homePage.isHomePageDisplay());
	}
	
	 @Test
	 public void TC_03_LogoutToSystem() {
		homePage.clickToLogoutLink();
		
		loginPage = new LoginPageObject(driverTestCase);
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
	 }

	@AfterClass
	public void afterClass() {
		driverTestCase.quit();
	}

}
