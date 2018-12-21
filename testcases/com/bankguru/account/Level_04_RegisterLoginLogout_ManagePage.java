package com.bankguru.account;

import org.openqa.selenium.WebDriver;
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
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLogInPage(driver);
		email = "automations" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		log.info("Account - TC_01: Register to System");
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
		verifyTrue(loginPage.isLoginPageDisplayed());

		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isHomePageDisplay());

		verifyFalse(loginPage.isLoginPageNotDisplayed());
	}

	@Test
	public void TC_03_OpenMultiPage() {
		newCustomerPage = homePage.openNewCustomerPage(driver);
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		depositPage = editCustomerPage.openDepositPage(driver);
		fundTransferPage = depositPage.openFundTransferPage(driver);
		depositPage = fundTransferPage.openDepositPage(driver);
		homePage = depositPage.openHomePage(driver);
	}

	@Test
	public void TC_04_LogoutToSystem() {
		loginPage = homePage.clickToLogoutLink(driver);
		verifyTrue(loginPage.isLoginPageDisplayed());

		verifyFalse(homePage.isHomePageNotDisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	WebDriver driver;
	public static String userID, password;

	private String email, loginURL;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private DepositPageObject depositPage;
	private FundTransferPageObject fundTransferPage;
}
