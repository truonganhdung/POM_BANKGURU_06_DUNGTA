package pages;

import org.openqa.selenium.WebDriver;

import bankguru.EditCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import payment.DynamicLocator;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	NewCustomerPageObject newCustomerPageObject = new NewCustomerPageObject(driver);

	public void inputToCustomerIdTextBox(String customerID) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerID, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, customerID, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
		}
	}

	public void editToAddressTextArea(String address) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, address, EditCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, address, EditCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);
		}
	}

	public void editToCityTextBox(String city) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, city, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, city, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
		}
	}

	public void editToStateTextBox(String state) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, state, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, state, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
		}
	}

	public void editToPinTextBox(String pin) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, pin, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, pin, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
		}
	}

	public void editToMobileTextBox(String mobile) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, mobile, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, mobile, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
		}
	}

	public void editToEmailTextBox(String email) {
		waitForControlVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, email + AbstractTest.randomNumber() + "@amil.com", EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, email + AbstractTest.randomNumber() + "@amil.com", EditCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
		}
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, EditCustomerPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, EditCustomerPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
		}
	}

	public String getUpdatedSuccessfullyText() {
		waitForControlVisible(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
		return getTextElement(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
	}
}
