package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.NewCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.HomePageObject;
import pages.LoginPageObject;
import pages.NewCustomerPageObject;

public class NewCustomer extends AbstractTest {
	AbstractPage abstractPage = new AbstractPage();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
	}

	@Test
	public void TC01_NameCustomer() {
		
		// newCustomerPage = homePage.openNewCustomerPage(driver);
		newCustomerPage.clickToElement(driver, NewCustomerPageUI.DYNAMIC_Textbox, "New Customer");
		abstractPage.pressTab(driver);

		verifyEquals(abstractPage.getTextElement(driver, NewCustomerPageUI.DYNAMIC_Warning_Message, "New Customer"), TC01_NameCustomer_Verify);
	}

	@Test
	public void TC02_NameCustomer() {
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_Textbox, "New Customer", TC02_NameCustomer_Textdata);

		verifyEquals(abstractPage.getTextElement(driver, NewCustomerPageUI.DYNAMIC_Warning_Message, "New Customer"), TC02_NameCustomer_Verify);
	}

	@Test
	public void TC03_NameCustomer() {
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_Textbox, "New Customer", TC03_NameCustomer_Textdata);

		verifyEquals(abstractPage.getTextElement(driver, NewCustomerPageUI.DYNAMIC_Warning_Message, "New Customer"), TC03_NameCustomer_Verify);
	}

	@Test
	public void TC04_NameCustomer() {
		newCustomerPage.sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_Textbox, "New Customer", TC04_NameCustomer_Textdata);

		verifyEquals(abstractPage.getTextElement(driver, NewCustomerPageUI.DYNAMIC_Warning_Message, "New Customer"), NewCustomer_TC04_Verify);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;

	private String TC01_NameCustomer_Verify = "Customer name must not be blank";

	private String TC02_NameCustomer_Textdata = "name123";
	private String TC02_NameCustomer_Verify = "Numbers are not allowed";

	private String TC03_NameCustomer_Textdata = "name@!@#";
	private String TC03_NameCustomer_Verify = "Special characters are not allowed";

	private String TC04_NameCustomer_Textdata = " name";
	private String NewCustomer_TC04_Verify = "First character can not have space";
}
