package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.FundTransferPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
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

		fundTransferPage.inputToPayersAccountNoTextBox(TC03_NewAccount.Account_ID_Payers);
		fundTransferPage.inputToPayeesAccountNoTextBox(TC03_NewAccount.Account_ID_Payees);
		fundTransferPage.inputToAmountTextBox(FundTransfer.AMOUNT);
		fundTransferPage.inputToDescriptionTextBox(FundTransfer.DESCRIPTION);
		fundTransferPage.clickToSubmitButton();

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
