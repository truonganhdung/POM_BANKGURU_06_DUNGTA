package pages;

import org.openqa.selenium.WebDriver;

import payment.DynamicLocator;
import bankguru.NewCustomerPageUI;

import commons.AbstractPage;
import commons.AbstractTest;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerNameTextBox(String customerName) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_NAME);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, customerName, DynamicLocator.CUSTOMER_NAME);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, customerName, DynamicLocator.CUSTOMER_NAME);
		}
	}

	public void inputToDoBTextBox(String dateOfBirth) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);

		if (driver.toString().toLowerCase().contains("firefox")) {
			setAttributeOfElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, dateOfBirth, DynamicLocator.DATE_OF_BIRTH);
		} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, dateOfBirth, DynamicLocator.DATE_OF_BIRTH);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, dateOfBirth, DynamicLocator.DATE_OF_BIRTH);
		}
	}

	public void inputToAddressTextArea(String address) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTAREA, address, DynamicLocator.ADDRESS);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTAREA, address, DynamicLocator.ADDRESS);
		}
	}

	public void inputToCityTextBox(String city) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, city, DynamicLocator.CITY);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, city, DynamicLocator.CITY);
		}
	}

	public void inputToStateTextBox(String state) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, state, DynamicLocator.STATE);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, state, DynamicLocator.STATE);
		}
	}

	public void inputToPinTextBox(String pin) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, pin, DynamicLocator.PIN);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, pin, DynamicLocator.PIN);
		}
	}

	public void inputToMobileTextBox(String mobile) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, mobile, DynamicLocator.MOBILE);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, mobile, DynamicLocator.MOBILE);
		}
	}

	public void inputToEmailTextBox(String email) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, email + AbstractTest.randomNumber() + "@amil.com", DynamicLocator.EMAIL);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, email + AbstractTest.randomNumber() + "@amil.com", DynamicLocator.EMAIL);
		}
	}

	public void inputToPasswordTextBox(String password) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PASSWORD);
		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, password, DynamicLocator.PASSWORD);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, password, DynamicLocator.PASSWORD);
		}
	}

	public void clickToSubmitButton(WebDriver driver) {
		waitForControlVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, NewCustomerPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		}
	}

	public String getCustomerIDText() {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_ID);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID);
	}

	public String getRegisteredSuccessfullyText() {
		waitForControlVisible(driver, NewCustomerPageUI.VERIFY_CREATE_CUSTOMER);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_CREATE_CUSTOMER);
	}

}
