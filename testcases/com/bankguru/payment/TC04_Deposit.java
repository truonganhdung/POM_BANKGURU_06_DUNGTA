package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.DepositPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.DepositPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import payment.Deposit;
import payment.DynamicLocator;

public class TC04_Deposit extends AbstractTest {
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
	public void Payment_TC04_Deposit() {
		depositPage = homePage.openDepositPage(driver);

		depositPage.sendkeyToElement(driver, DepositPageUI.DYNAMIC_TEXTBOX, TC03_NewAccount.Account_ID_Payers, DynamicLocator.ACCOUNT_NUMBER);
		depositPage.sendkeyToElement(driver, DepositPageUI.DYNAMIC_TEXTBOX, Deposit.AMOUNT, DynamicLocator.AMOUNT);
		depositPage.sendkeyToElement(driver, DepositPageUI.DYNAMIC_TEXTBOX, Deposit.DESCRIPTION, DynamicLocator.DESCRIPTION);
		depositPage.clickToElement(driver, DepositPageUI.SUBMIT_BUTTON);

		String Verify_Deposit = "Transaction details of Deposit for Account " + TC03_NewAccount.Account_ID_Payers;
		
		verifyEquals(depositPage.getTransactionSuccessfullyText(), Verify_Deposit);
		verifyEquals(depositPage.getCurrentBalance(), Deposit.CURRENT_BALANCE);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private DepositPageObject depositPage;

}
