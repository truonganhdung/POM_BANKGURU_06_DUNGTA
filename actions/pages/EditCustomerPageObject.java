package pages;

import org.openqa.selenium.WebDriver;

import payment.Customer;
import payment.DynamicLocator;
import bankguru.EditCustomerPageUI;

import commons.AbstractPage;
import commons.AbstractTest;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerIdTextBox(String customerID) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerID, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
		} else {
			sendkeyToElement(driver, customerID, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
		}
	}

	public void editToAddressTextArea(String address) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, address, EditCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);
		} else {
			sendkeyToElement(driver, address, EditCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);
		}
	}

	public void editToCityTextBox(String city) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, city, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
		} else {
			sendkeyToElement(driver, city, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
		}
	}

	public void editToStateTextBox(String state) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, state, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
		} else {
			sendkeyToElement(driver, state, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
		}
	}

	public void editToPinTextBox(String pin) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, pin, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
		} else {
			sendkeyToElement(driver, pin, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
		}
	}

	public void editToMobileTextBox(String mobile) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, mobile, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
		} else {
			sendkeyToElement(driver, mobile, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
		}
	}

	public void editToEmailTextBox(String email) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, email + AbstractTest.randomNumber() + "@amil.com", EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
		} else {
			sendkeyToElement(driver, email + AbstractTest.randomNumber() + "@amil.com", EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
		}
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, EditCustomerPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		} else {
			clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		}
	}

	public String getUpdatedText() {
		waitForControlVisible(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
		return getTextElement(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
	}

	public String getAddressText() {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.ADDRESS);
		return getTextElement(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.ADDRESS);
	}

	public String getCityText() {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.CITY);
		return getTextElement(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.CITY);
	}

	public String getStateText() {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.STATE);
		return getTextElement(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.STATE);
	}

	public String getPinText() {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.PIN);
		return getTextElement(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.PIN);
	}

	public String getMobileNoText() {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.MOBILE);
		return getTextElement(driver, EditCustomerPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.MOBILE);
	}

}
