package com.bankguru.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.LoginPageObject;
import pages.RegisterPageObject;

public class Common_01_CreateUser extends AbstractTest {

	@Parameters("browser")
	@BeforeSuite
	public void beforeSuite(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLogInPage(driver);

		email = "automations" + randomNumber() + "@gmail.com";

		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailTextBox(email);
		registerPage.clickToSubmitButton();

		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();

		closeBrowser(driver);
	}

	WebDriver driver;
	public static String userID, password;

	private String email;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
}
