package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.EditCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.EditCustomerPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import payment.Customer;
import payment.DynamicLocator;

public class TC02_EditCustomer extends AbstractTest {
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
	public void Payment_TC02_EditCustomer() {
		editCustomerPage = homePage.openEditCustomerPage(driver);

		editCustomerPage.sendkeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, TC01_CreateNewCustomer.CustomerID, DynamicLocator.CUSTOMER_ID);
		editCustomerPage.clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);

		editCustomerPage = PageFactoryManager.getEditCustomerPage(driver);

		editCustomerPage.sendkeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTAREA, Customer.EditCustomer.EDIT_ADDRESS, DynamicLocator.ADDRESS);
		editCustomerPage.sendkeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, Customer.EditCustomer.EDIT_CITY, DynamicLocator.CITY);
		editCustomerPage.sendkeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, Customer.EditCustomer.EDIT_STATE, DynamicLocator.STATE);
		editCustomerPage.sendkeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, Customer.EditCustomer.EDIT_PIN, DynamicLocator.PIN);
		editCustomerPage.sendkeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, Customer.EditCustomer.EDIT_MOBILE + randomNumber() + "@amil.com", DynamicLocator.MOBILE);
		editCustomerPage.sendkeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, Customer.EditCustomer.EDIT_PREFIX_EMAIL, DynamicLocator.EMAIL);
		editCustomerPage.clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);

		verifyEquals(editCustomerPage.getUpdatedSuccessfullyText(), Customer.EditCustomer.VERIFY_EDIT_CUSTOMER);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private EditCustomerPageObject editCustomerPage;

}
