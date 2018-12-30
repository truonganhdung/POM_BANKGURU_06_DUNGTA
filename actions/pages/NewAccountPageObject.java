package pages;

import org.openqa.selenium.WebDriver;

import payment.DynamicLocator;
import bankguru.NewAccountPageUI;

import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getGeneratedSuccessfullyText() {
		waitForControlVisible(driver, NewAccountPageUI.VERIFY_CREATE_ACCOUNT);
		return getTextElement(driver, NewAccountPageUI.VERIFY_CREATE_ACCOUNT);
	}

	public String getCurrentAmount() {
		waitForControlVisible(driver, NewAccountPageUI.VERIFY_DYNAMIC, "Current Amount");
		return getTextElement(driver, NewAccountPageUI.VERIFY_DYNAMIC, "Current Amount");
	}

	public String getAccountID() {
		waitForControlVisible(driver, NewAccountPageUI.VERIFY_DYNAMIC, "Account ID");
		return getTextElement(driver, NewAccountPageUI.VERIFY_DYNAMIC, "Account ID");
	}

	public void inputToCustomerIdTextBox(String customerId) {
		waitForControlVisible(driver, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_id);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerId, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_id);
		} else {
			sendkeyToElement(driver, customerId, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_id);
		}
	}

	public void selectAccountTypeFromDropdownList(String accountType) {
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_TYPE);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			selectItemInHtmlDropdownByValue(driver, NewAccountPageUI.ACCOUNT_TYPE, accountType);
			staticSleep(5);
		} else {
			selectItemInHtmlDropdownByValue(driver, NewAccountPageUI.ACCOUNT_TYPE, accountType);
		}
	}

	public void inputToInitialDepositTextBox(String initialDeposit) {
		waitForControlVisible(driver, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.INITIAL_DEPOSIT);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, initialDeposit, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.INITIAL_DEPOSIT);
		} else {
			sendkeyToElement(driver, initialDeposit, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.INITIAL_DEPOSIT);
		}
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, NewAccountPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, NewAccountPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
		}
	}

}
