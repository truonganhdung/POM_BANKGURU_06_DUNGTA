package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_CreateUser;

import bankguru.DeleteCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.DeleteCustomerPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import payment.Customer;
import payment.DynamicLocator;

public class TC09_DeleteCustomer extends AbstractTest {
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
		deleteCustomerPage = homePage.openDeleteCustomerPage(driver);

		deleteCustomerPage.sendkeyToElement(driver, DeleteCustomerPageUI.DYNAMIC_TEXTBOX, TC01_CreateNewCustomer.CustomerID, DynamicLocator.CUSTOMER_ID);
		deleteCustomerPage.clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);

		acceptAlert(driver);
		acceptAlert(driver, Customer.DeleteCustomer.VERIFY_DELETE_CUSTOMER);

	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private DeleteCustomerPageObject deleteCustomerPage;

}
