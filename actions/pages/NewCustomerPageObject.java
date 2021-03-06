package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

import bankguru.AbstractPageUI;
import bankguru.NewCustomerPageUI;
import commons.AbstractPage;
import commons.AbstractTest;
import payment.Customer;
import payment.DynamicLocator;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public void inputToCustomerNameTextBox(String customerName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_NAME);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerName, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_NAME);
		} else {
			sendkeyToElement(driver, customerName, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_NAME);
		}
	}

	public void inputToDoBTextBox(String dateOfBirth) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, dateOfBirth, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);
		} else {
			setAttributeOfElementByJS(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);
			sendkeyToElement(driver, dateOfBirth, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DATE_OF_BIRTH);
		}
	}

	public void inputToAddressTextArea(String address) {
		waitForControlVisible(driver, NewCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, address, NewCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);
		} else {
			sendkeyToElement(driver, address, NewCustomerPageUI.DYNAMIC_TEXTAREA, DynamicLocator.ADDRESS);
		}
	}

	public void inputToCityTextBox(String city) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, city, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
		} else {
			sendkeyToElement(driver, city, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CITY);
		}
	}

	public void inputToStateTextBox(String state) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, state, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
		} else {
			sendkeyToElement(driver, state, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.STATE);
		}
	}

	public void inputToPinTextBox(String pin) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, pin, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
		} else {
			sendkeyToElement(driver, pin, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PIN);
		}
	}

	public void inputToMobileTextBox(String mobile) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, mobile, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
		} else {
			sendkeyToElement(driver, mobile, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.MOBILE);
		}
	}

	public void inputToEmailTextBox(String email) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, email + AbstractTest.randomNumber() + "@amil.com", AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
		} else {
			sendkeyToElement(driver, email + AbstractTest.randomNumber() + "@amil.com", AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.EMAIL);
		}
	}

	public void inputToPasswordTextBox(String password) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PASSWORD);
		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, password, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PASSWORD);
		} else {
			sendkeyToElement(driver, password, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PASSWORD);
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
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.CUSTOMER_ID);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.CUSTOMER_ID);
	}

	public String getCustomerNameText() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.CUSTOMER_NAME);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.CUSTOMER_NAME);
	}

	public String getBirthdateText() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.DATE_OF_BIRTH);
		String date_s = getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.DATE_OF_BIRTH);

		Date dt = null;
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse(date_s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return myDateFormat(dt, "MM-dd-yyy");
	}

	public String myDateFormat(Date dt, String pattern) {
		Locale locale = new Locale("en", "US");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
		return simpleDateFormat.format(dt);
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

	public String getEmailText() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.EMAIL);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, Customer.Customer_Header.EMAIL);
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, AbstractPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, AbstractPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, AbstractPageUI.SUBMIT_BUTTON);
		}
	}

}
