package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.NewCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.HomePageObject;
import pages.LoginPageObject;
import pages.NewCustomerPageObject;
import payment.Customer;
import payment.DynamicLocator;

public class TC01_CreateNewCustomer extends AbstractTest {

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
	public void Payment_TC01_CreateNewCustomer() {
		newCustomerPage = homePage.openNewCustomerPage(driver);

		newCustomerPage.inputToCustomerNameTextBox(Customer.NewCustomer.CUSTOMER_NAME);
		newCustomerPage.inputToDoBTextBox(Customer.NewCustomer.DATE_OF_BIRTH);
		newCustomerPage.inputToAddressTextArea(Customer.NewCustomer.ADDRESS);
		newCustomerPage.inputToCityTextBox(Customer.NewCustomer.CITY);
		newCustomerPage.inputToStateTextBox(Customer.NewCustomer.STATE);
		newCustomerPage.inputToPinTextBox(Customer.NewCustomer.PIN);
		newCustomerPage.inputToMobileTextBox(Customer.NewCustomer.MOBILE);
		newCustomerPage.inputToEmailTextBox(Customer.NewCustomer.PREFIX_EMAIL);
		newCustomerPage.inputToPasswordTextBox(Customer.NewCustomer.PASSWORD);
		newCustomerPage.clickToSubmitButton(driver);

		verifyEquals(newCustomerPage.getRegisteredSuccessfullyText(), Customer.NewCustomer.VERIFY_CREATE_NEW_CUSTOMER);

		CustomerID = newCustomerPage.getCustomerIDText();
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;

	public static String CustomerID = "";

}
