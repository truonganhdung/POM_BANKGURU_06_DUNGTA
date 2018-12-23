package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.BalanceEnquiryPageUI;
import bankguru.EditCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.BalanceEnquiryPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import payment.BalanceEnquiry;
import payment.DynamicLocator;

public class TC07_BalanceEnquiry extends AbstractTest {
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
	public void Payment_TC07_BalanceEnquiry() {
		balanceEnquiryPage = homePage.openBalanceEnquiryPage(driver);

		balanceEnquiryPage.sendkeyToElement(driver, BalanceEnquiryPageUI.DYNAMIC_TEXTBOX, TC03_NewAccount.Account_ID_Payers, DynamicLocator.ACCOUNT_NUMBER);
		balanceEnquiryPage.clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);

		balanceEnquiryPage = PageFactoryManager.getBalanceEnquiryPage(driver);

		String Verify_BalanceDetails = "Balance Details for Account " + TC03_NewAccount.Account_ID_Payers;

		verifyEquals(balanceEnquiryPage.getBalanceDetailsText(), Verify_BalanceDetails);
		verifyEquals(balanceEnquiryPage.getBalance(), BalanceEnquiry.BALANCE);

	}

	@AfterClass
	public void afterClass() {
		 closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private BalanceEnquiryPageObject balanceEnquiryPage;

}
