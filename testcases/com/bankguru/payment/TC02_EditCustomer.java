package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.EditCustomerPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import payment.Customer;

import com.bankguru.common.Common_01_CreateUser;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;

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

		editCustomerPage.inputToCustomerIdTextBox(TC01_CreateNewCustomer.CustomerID);
		editCustomerPage.clickToSubmitButton();

		editCustomerPage = PageFactoryManager.getEditCustomerPage(driver);

		editCustomerPage.editToAddressTextArea(Customer.EditCustomer.EDIT_ADDRESS);
		editCustomerPage.editToCityTextBox(Customer.EditCustomer.EDIT_CITY);
		editCustomerPage.editToStateTextBox(Customer.EditCustomer.EDIT_STATE);
		editCustomerPage.editToPinTextBox(Customer.EditCustomer.EDIT_PIN);
		editCustomerPage.editToMobileTextBox(Customer.EditCustomer.EDIT_MOBILE);
		editCustomerPage.editToEmailTextBox(Customer.EditCustomer.EDIT_PREFIX_EMAIL);
		editCustomerPage.clickToSubmitButton();

	}

	@Test
	public void Payment_TC02_VerifyEditCustomer() {
		verifyEquals(editCustomerPage.getUpdatedText(), Customer.EditCustomer.VERIFY_EDIT_CUSTOMER);
		
		verifyEquals(editCustomerPage.getAddressText(), Customer.EditCustomer.EDIT_ADDRESS);
		verifyEquals(editCustomerPage.getCityText(), Customer.EditCustomer.EDIT_CITY);
		verifyEquals(editCustomerPage.getStateText(), Customer.EditCustomer.EDIT_STATE);
		verifyEquals(editCustomerPage.getPinText(), Customer.EditCustomer.EDIT_PIN);
		verifyEquals(editCustomerPage.getMobileNoText(), Customer.EditCustomer.EDIT_MOBILE);

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
