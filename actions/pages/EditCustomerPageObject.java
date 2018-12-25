package pages;

import org.openqa.selenium.WebDriver;

import payment.DynamicLocator;
import bankguru.EditCustomerPageUI;
import bankguru.NewCustomerPageUI;

import commons.AbstractPage;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	NewCustomerPageObject newCustomerPageObject = new NewCustomerPageObject(driver);
	
	public void inputToCustomerIdTextBox(String customerID) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, customerID, DynamicLocator.CUSTOMER_ID);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, customerID, DynamicLocator.CUSTOMER_ID);
		}
	}

	public void inputToAddressTextArea(String address) {
		newCustomerPageObject.inputToAddressTextArea(address);
	}

	public void inputToCityTextBox(String city) {
		newCustomerPageObject.inputToCityTextBox(city);
	}

	public void inputToStateTextBox(String state) {
		newCustomerPageObject.inputToStateTextBox(state);
	}

	public void inputToPinTextBox(String pin) {
		newCustomerPageObject.inputToPinTextBox(pin);
	}

	public void inputToMobileTextBox(String mobile) {
		newCustomerPageObject.inputToMobileTextBox(mobile);
	}

	public void inputToEmailTextBox(String email) {
		newCustomerPageObject.inputToEmailTextBox(email);
	}

	public void inputToPasswordTextBox(String password) {
		newCustomerPageObject.inputToPasswordTextBox(password);
	}

	public void clickToSubmitButton(WebDriver driver) {
		newCustomerPageObject.clickToSubmitButton(driver);
	}

	public String getUpdatedSuccessfullyText() {
		waitForControlVisible(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
		return getTextElement(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
	}
}
