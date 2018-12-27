package pages;

import org.openqa.selenium.WebDriver;

import bankguru.WithdrawalPageUI;
import commons.AbstractPage;
import payment.DynamicLocator;

public class WithdrawalPageObject extends AbstractPage {
	WebDriver driver;

	public WithdrawalPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTransactionSuccessfullyText() {
		waitForControlVisible(driver, WithdrawalPageUI.VERIFY_WITHDRAWAL);
		return getTextElement(driver, WithdrawalPageUI.VERIFY_WITHDRAWAL);
	}

	public String getCurrentBalance() {
		waitForControlVisible(driver, WithdrawalPageUI.VERIFY_DYNAMIC, "Current Balance");
		return getTextElement(driver, WithdrawalPageUI.VERIFY_DYNAMIC, "Current Balance");
	}

	public void inputToAccountNoTextBox(String accountNo) {
		waitForControlVisible(driver, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, accountNo, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, accountNo, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
		}
	}

	public void inputToAmountTextBox(String amount) {
		waitForControlVisible(driver, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, amount, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, amount, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);
		}
	}

	public void inputToDescriptionTextBox(String description) {
		waitForControlVisible(driver, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, description, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, description, WithdrawalPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);
		}
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, WithdrawalPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, WithdrawalPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, WithdrawalPageUI.SUBMIT_BUTTON);
		}
	}

}
