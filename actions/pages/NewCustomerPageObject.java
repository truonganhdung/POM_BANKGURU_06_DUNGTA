package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

import bankguru.NewCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import payment.Customer;
import payment.DynamicLocator;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public void inputToCustomerNameTextBox(String customerName) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_NAME);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerName, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_NAME);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, customerName, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_NAME);
		}
	}

	public void inputToDoBTextBox(String dateOfBirth) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, dateOfBirth, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);
			staticSleep(5);
		} else {
			setAttributeOfElementByJS(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);
			sendkeyToElement(driver, dateOfBirth, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);
		}
	}

	public void inputToAddressTextArea(String address) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, address, NewCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, address, NewCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);
		}
	}

	public void inputToCityTextBox(String city) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, city, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, city, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
		}
	}

	public void inputToStateTextBox(String state) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, state, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, state, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
		}
	}

	public void inputToPinTextBox(String pin) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, pin, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, pin, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
		}
	}

	public void inputToMobileTextBox(String mobile) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, mobile, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, mobile, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
		}
	}

	public void inputToEmailTextBox(String email) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, email + AbstractTest.randomNumber() + "@amil.com", NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, email + AbstractTest.randomNumber() + "@amil.com", NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
		}
	}

	public void inputToPasswordTextBox(String password) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PASSWORD);
		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, password, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PASSWORD);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, password, NewCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PASSWORD);
		}
	}

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getRegisteredText() {
		waitForControlVisible(driver, NewCustomerPageUI.VERIFY_CREATE_CUSTOMER);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_CREATE_CUSTOMER);
	}

	public String getCustomerIDText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.CUSTOMER_ID);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.CUSTOMER_ID);
	}

	public String getCustomerNameText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.CUSTOMER_NAME);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.CUSTOMER_NAME);
	}

	public String getBirthdateText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.DATE_OF_BIRTH);
		String date_s = getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.DATE_OF_BIRTH);

		Date dt = null;
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse(date_s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return myDateFormat(dt,"MM-dd-yyy");
	}
	
	public String myDateFormat(Date dt, String pattern) {
		Locale locale = new Locale("en", "US");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
		return simpleDateFormat.format(dt);
	}

	public String getAddressText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.ADDRESS);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.ADDRESS);
	}

	public String getCityText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.CITY);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.CITY);
	}

	public String getStateText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.STATE);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.STATE);
	}

	public String getPinText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.PIN);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.PIN);
	}

	public String getMobileNoText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.MOBILE);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.MOBILE);
	}

	public String getEmailText() {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.EMAIL);
		return getTextElement(driver, NewCustomerPageUI.DYNAMIC_VERIFY, Customer.NewCustomer_Header.EMAIL);
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, NewCustomerPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		}
	}

}
