package pages;

import org.openqa.selenium.WebDriver;

import bankguru.AbstractPageUI;
import bankguru.NewAccountPageUI;
import commons.AbstractPage;
import payment.DynamicLocator;

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
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, "Current Amount");
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, "Current Amount");
	}

	public String getAccountID() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, "Account ID");
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, "Account ID");
	}

	public void inputToCustomerIdTextBox(String customerId) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_id);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerId, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_id);
		} else {
			sendkeyToElement(driver, customerId, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_id);
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
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.INITIAL_DEPOSIT);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, initialDeposit, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.INITIAL_DEPOSIT);
		} else {
			sendkeyToElement(driver, initialDeposit, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.INITIAL_DEPOSIT);
		}
	}

}
