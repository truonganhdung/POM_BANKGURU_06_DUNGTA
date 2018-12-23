package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.DeleteAccountPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.DeleteAccountPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import payment.Account;
import payment.DynamicLocator;

public class TC08_DeleteAccount extends AbstractTest {
	AbstractPage abstractPage = new AbstractPage();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLogInPage(driver);

		loginPage.inputToUserIDTextbox(Common_01_CreateUser.userID);
		loginPage.inputToPasswordTextbox(Common_01_CreateUser.password);
		homePage = loginPage.clickToLoginButton();

	}
	
	@Test
	public void Payment_TC08_DeleteAccount_Payers() {
		deleteAccountPage = homePage.openDeleteAccountPage(driver);
		
		deleteAccountPage.sendkeyToElement(driver, DeleteAccountPageUI.DYNAMIC_TEXTBOX, TC03_NewAccount.Account_ID_Payers, DynamicLocator.ACCOUNT_NUMBER);
		deleteAccountPage.clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
		
		acceptAlert(driver);
		acceptAlert(driver, Account.DeleteAccount.VERIFY_DELETE_ACCOUNT);
		
	}

	@Test
	public void Payment_TC08_DeleteAccount_Payees() {
		deleteAccountPage = homePage.openDeleteAccountPage(driver);

		deleteAccountPage.sendkeyToElement(driver, DeleteAccountPageUI.DYNAMIC_TEXTBOX, TC03_NewAccount.Account_ID_Payees, DynamicLocator.ACCOUNT_NUMBER);
		deleteAccountPage.clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON);

		acceptAlert(driver);
		acceptAlert(driver, Account.DeleteAccount.VERIFY_DELETE_ACCOUNT);

	}

	@AfterClass
	public void afterClass() {
		 closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private DeleteAccountPageObject deleteAccountPage;

}
