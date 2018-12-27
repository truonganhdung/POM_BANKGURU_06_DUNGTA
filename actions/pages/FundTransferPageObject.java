package pages;

import org.openqa.selenium.WebDriver;

import bankguru.FundTransferPageUI;
import commons.AbstractPage;
import payment.DynamicLocator;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;

	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLogoutLink() {
		waitForControlVisible(driver, FundTransferPageUI.LOGOUT_LINK);
		clickToElement(driver, FundTransferPageUI.LOGOUT_LINK);
		acceptAlert(driver);
	}

	public String getAmount() {
		waitForControlVisible(driver, FundTransferPageUI.VERIFY_DYNAMIC, "Amount");
		return getTextElement(driver, FundTransferPageUI.VERIFY_DYNAMIC, "Amount");
	}

	public void inputToPayersAccountNoTextBox(String payersAccountNo) {
		waitForControlVisible(driver, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYERS_ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, payersAccountNo, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYERS_ACCOUNT_NUMBER);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, payersAccountNo, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYERS_ACCOUNT_NUMBER);
		}
	}

	public void inputToPayeesAccountNoTextBox(String payeesAccountNo) {
		waitForControlVisible(driver, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYEES_ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, payeesAccountNo, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYEES_ACCOUNT_NUMBER);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, payeesAccountNo, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYEES_ACCOUNT_NUMBER);
		}
	}

	public void inputToAmountTextBox(String amount) {
		waitForControlVisible(driver, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, amount, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, amount, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);
		}
	}

	public void inputToDescriptionTextBox(String description) {
		waitForControlVisible(driver, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, description, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, description, FundTransferPageUI.DYNAMIC_TEXTBOX, DynamicLocator.DESCRIPTION);
		}
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, FundTransferPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, FundTransferPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, FundTransferPageUI.SUBMIT_BUTTON);
		}
	}

}
