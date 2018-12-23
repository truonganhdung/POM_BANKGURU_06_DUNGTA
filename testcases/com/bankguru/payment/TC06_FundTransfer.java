package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.FundTransferPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.FundTransferPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import payment.DynamicLocator;
import payment.FundTransfer;

public class TC06_FundTransfer extends AbstractTest {
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
	public void Payment_TC06_FundTransfer() {
		fundTransferPage = homePage.openFundTransferPage(driver);

		fundTransferPage.sendkeyToElement(driver, FundTransferPageUI.DYNAMIC_TEXTBOX, TC03_NewAccount.Account_ID_Payers, DynamicLocator.PAYERS_ACCOUNT_NUMBER);
		fundTransferPage.sendkeyToElement(driver, FundTransferPageUI.DYNAMIC_TEXTBOX, TC03_NewAccount.Account_ID_Payees, DynamicLocator.PAYEES_ACCOUNT_NUMBER);
		fundTransferPage.sendkeyToElement(driver, FundTransferPageUI.DYNAMIC_TEXTBOX, FundTransfer.AMOUNT, DynamicLocator.AMOUNT);
		fundTransferPage.sendkeyToElement(driver, FundTransferPageUI.DYNAMIC_TEXTBOX, FundTransfer.DESCRIPTION, DynamicLocator.DESCRIPTION);
		fundTransferPage.clickToElement(driver, FundTransferPageUI.SUBMIT_BUTTON);

		verifyEquals(fundTransferPage.getAmount(), FundTransfer.AMOUNT);

	}

	@AfterClass
	public void afterClass() {
		 closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private FundTransferPageObject fundTransferPage;

}
