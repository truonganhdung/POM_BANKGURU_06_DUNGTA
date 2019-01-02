package pages;

import org.openqa.selenium.WebDriver;

import bankguru.AbstractPageUI;
import bankguru.EditCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import payment.Customer;
import payment.DynamicLocator;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerIdTextBox(String customerID) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerID, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
		} else {
			sendkeyToElement(driver, customerID, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
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
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, city, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
		} else {
			sendkeyToElement(driver, city, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
		}
	}

	public void editToStateTextBox(String state) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, state, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
		} else {
			sendkeyToElement(driver, state, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
		}
	}

	public void editToPinTextBox(String pin) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, pin, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
		} else {
			sendkeyToElement(driver, pin, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
		}
	}

	public void editToMobileTextBox(String mobile) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, mobile, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
		} else {
			sendkeyToElement(driver, mobile, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
		}
	}

	public void editToEmailTextBox(String email) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, email + AbstractTest.randomNumber() + "@amil.com", AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
		} else {
			sendkeyToElement(driver, email + AbstractTest.randomNumber() + "@amil.com", AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
		}
	}

	public String getUpdatedText() {
		waitForControlVisible(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
		return getTextElement(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
	}

	public String getAddressText() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.ADDRESS);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.ADDRESS);
	}

	public String getCityText() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.CITY);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.CITY);
	}

	public String getStateText() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.STATE);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.STATE);
	}

	public String getPinText() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.PIN);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.PIN);
	}

	public String getMobileNoText() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.MOBILE);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.MOBILE);
	}

}
