package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.NewAccountPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.HomePageObject;
import pages.LoginPageObject;
import pages.NewAccountPageObject;
import payment.Account;
import payment.DynamicLocator;

public class TC03_NewAccount extends AbstractTest {
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
	public void Payment_TC03_NewAccount_Payers() {
		newAccountPage = homePage.openNewAccountPage(driver);
		
		newAccountPage.sendkeyToElement(driver, NewAccountPageUI.DYNAMIC_TEXTBOX, TC01_CreateNewCustomer.CustomerID, "Customer id");
		newAccountPage.selectItemInHtmlDropdownByValue(driver, NewAccountPageUI.ACCOUNT_TYPE, "Current");
		newAccountPage.sendkeyToElement(driver, NewAccountPageUI.DYNAMIC_TEXTBOX, Account.NewAccount.INITIAL_DEPOSIT, "Initial deposit");
		newAccountPage.clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
		
		verifyEquals(newAccountPage.getGeneratedSuccessfullyText(), Account.NewAccount.VERIFY_CREATE_ACCOUNT);
		verifyEquals(newAccountPage.getCurrentAmount(), Account.NewAccount.INITIAL_DEPOSIT);
		
		Account_ID_Payers = newAccountPage.getAccountID();
	}
	
	@Test
	public void Payment_TC03_NewAccount_Payees() {
		newAccountPage = homePage.openNewAccountPage(driver);

		newAccountPage.sendkeyToElement(driver, NewAccountPageUI.DYNAMIC_TEXTBOX, TC01_CreateNewCustomer.CustomerID, DynamicLocator.CUSTOMER_id);
		newAccountPage.selectItemInHtmlDropdownByValue(driver, NewAccountPageUI.ACCOUNT_TYPE, DynamicLocator.CURRENT);
		newAccountPage.sendkeyToElement(driver, NewAccountPageUI.DYNAMIC_TEXTBOX, Account.NewAccount.INITIAL_DEPOSIT, DynamicLocator.INITIAL_DEPOSIT);
		newAccountPage.clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);

		verifyEquals(newAccountPage.getGeneratedSuccessfullyText(), Account.NewAccount.VERIFY_CREATE_ACCOUNT);
		verifyEquals(newAccountPage.getCurrentAmount(), Account.NewAccount.INITIAL_DEPOSIT);

		Account_ID_Payees = newAccountPage.getAccountID();
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewAccountPageObject newAccountPage;

	public static String Account_ID_Payers;
	public static String Account_ID_Payees;

}
