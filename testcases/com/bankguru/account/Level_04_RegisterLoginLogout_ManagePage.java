package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.DepositPageObject;
import pages.EditCustomerPageObject;
import pages.FundTransferPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import pages.NewCustomerPageObject;
import pages.RegisterPageObject;

public class Level_04_RegisterLoginLogout_ManagePage extends AbstractTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestCase = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLogInPage(driverTestCase);
		email = "automations" + randomNumber() + "@gmail.com";
	}
	@Test
	public void TC_01_RegisterToSystem() {
		loginURL = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailTextBox(email);
		registerPage.clickToSubmitButton();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();
	}
	@Test
	public void TC_02_LoginToSystem() {
		loginPage = registerPage.openLoginPageByUrl(loginURL);
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplay());
	}

	@Test
	public void TC_03_OpenMultiPage() {
		newCustomerPage = homePage.openNewCustomerPage(driverTestCase);
		editCustomerPage = newCustomerPage.openEditCustomerPage(driverTestCase);
		depositPage = editCustomerPage.openDepositPage(driverTestCase);
		fundTransferPage = depositPage.openFundTransferPage(driverTestCase);
		depositPage = fundTransferPage.openDepositPage(driverTestCase);
		homePage = depositPage.openHomePage(driverTestCase);
	}

	@Test
	public void TC_04_LogoutToSystem() {
		loginPage = homePage.clickToLogoutLink(driverTestCase);
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driverTestCase);
	}

	WebDriver driverTestCase;
	String email, userID, password, loginURL;

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private DepositPageObject depositPage;
	private FundTransferPageObject fundTransferPage;
}
