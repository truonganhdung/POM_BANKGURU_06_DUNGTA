package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.WithdrawalPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.HomePageObject;
import pages.LoginPageObject;
import pages.WithdrawalPageObject;
import payment.DynamicLocator;
import payment.Withdrawal;

public class TC05_Withdrawal extends AbstractTest {
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
	public void Payment_TC05_Withdrawal() {
		withdrawalPage = homePage.openWithdrawalPage(driver);

		withdrawalPage.sendkeyToElement(driver, WithdrawalPageUI.DYNAMIC_TEXTBOX, TC03_NewAccount.Account_ID_Payers, DynamicLocator.ACCOUNT_NUMBER);
		withdrawalPage.sendkeyToElement(driver, WithdrawalPageUI.DYNAMIC_TEXTBOX, Withdrawal.AMOUNT, DynamicLocator.AMOUNT);
		withdrawalPage.sendkeyToElement(driver, WithdrawalPageUI.DYNAMIC_TEXTBOX, Withdrawal.DESCRIPTION, DynamicLocator.DESCRIPTION);
		withdrawalPage.clickToElement(driver, WithdrawalPageUI.SUBMIT_BUTTON);

		String Verify_Withdrawal = "Transaction details of Withdrawal for Account " + TC03_NewAccount.Account_ID_Payers;

		verifyEquals(withdrawalPage.getTransactionSuccessfullyText(), Verify_Withdrawal);
		verifyEquals(withdrawalPage.getCurrentBalance(), Withdrawal.CURRENT_BALANCE);

	}

	@AfterClass
	public void afterClass() {
		 closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private WithdrawalPageObject withdrawalPage;

}
