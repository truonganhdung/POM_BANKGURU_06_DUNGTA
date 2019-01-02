package pages;

import org.openqa.selenium.WebDriver;

import bankguru.AbstractPageUI;
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
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, "Current Balance");
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, "Current Balance");
	}

	public void inputToAccountNoTextBox(String accountNo) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, accountNo, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
		} else {
			sendkeyToElement(driver, accountNo, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
		}
	}

	public void inputToAmountTextBox(String amount) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, amount, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);
		} else {
			sendkeyToElement(driver, amount, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.AMOUNT);
		}
	}

}
