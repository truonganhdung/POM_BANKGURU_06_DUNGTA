package pages;

import org.openqa.selenium.WebDriver;

import payment.DynamicLocator;
import bankguru.DepositPageUI;
import bankguru.NewAccountPageUI;

import commons.AbstractPage;

public class DepositPageObject extends AbstractPage {
	WebDriver driver;

	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTransactionSuccessfullyText() {
		waitForControlVisible(driver, DepositPageUI.VERIFY_DEPOSIT);
		return getTextElement(driver, DepositPageUI.VERIFY_DEPOSIT);
	}

	public String getCurrentBalance() {
		waitForControlVisible(driver, DepositPageUI.VERIFY_DYNAMIC, "Current Balance");
		return getTextElement(driver, DepositPageUI.VERIFY_DYNAMIC, "Current Balance");
	}

	public void inputToAccountNoTextBox(String accountNo) {
		waitForControlVisible(driver, DepositPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, accountNo, DepositPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
		} else {
			sendkeyToElement(driver, accountNo, DepositPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
		}
	}

	public void inputToAmountTextBox(String amount) {
		waitForControlVisible(driver, DepositPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, amount, DepositPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);
		} else {
			sendkeyToElement(driver, amount, DepositPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);
		}
	}

	public void inputToDescriptionTextBox(String description) {
		waitForControlVisible(driver, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, description, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);
		} else {
			sendkeyToElement(driver, description, NewAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);
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
