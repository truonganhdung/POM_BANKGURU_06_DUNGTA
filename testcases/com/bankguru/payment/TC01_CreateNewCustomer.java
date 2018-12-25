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
	public void Payment_TC01_CreateNewCustomer() {
		newCustomerPage = homePage.openNewCustomerPage(driver);

		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.CUSTOMER_NAME, DynamicLocator.CUSTOMER_NAME);
		if (driver.toString().toLowerCase().contains("firefox")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.DATE_OF_BIRTH, DynamicLocator.DATE_OF_BIRTH);
			newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.DATE_OF_BIRTH, DynamicLocator.DATE_OF_BIRTH);
		} else {
			newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.DATE_OF_BIRTH, DynamicLocator.DATE_OF_BIRTH);
		}
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTAREA, Customer.NewCustomer.ADDRESS, DynamicLocator.ADDRESS);
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.CITY, DynamicLocator.CITY);
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.STATE, DynamicLocator.STATE);
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.PIN, DynamicLocator.PIN);
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.MOBILE, DynamicLocator.MOBILE);
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.PREFIX_EMAIL + randomNumber() + "@amil.com", DynamicLocator.EMAIL);
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, Customer.NewCustomer.PASSWORD, DynamicLocator.PASSWORD);
		newCustomerPage.clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);

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
