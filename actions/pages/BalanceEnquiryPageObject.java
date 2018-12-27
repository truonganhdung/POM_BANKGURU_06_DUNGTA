package pages;

import org.openqa.selenium.WebDriver;

import bankguru.BalanceEnquiryPageUI;
import commons.AbstractPage;
import payment.DynamicLocator;

public class BalanceEnquiryPageObject extends AbstractPage {
	WebDriver driver;

	public BalanceEnquiryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getBalanceDetailsText() {
		waitForControlVisible(driver, BalanceEnquiryPageUI.VERIFY_BALANCE);
		return getTextElement(driver, BalanceEnquiryPageUI.VERIFY_BALANCE);
	}

	public String getBalance() {
		waitForControlVisible(driver, BalanceEnquiryPageUI.VERIFY_DYNAMIC, "Balance");
		return getTextElement(driver, BalanceEnquiryPageUI.VERIFY_DYNAMIC, "Balance");
	}

	public void inputToAccountNoTextBox(String accountNo) {
		waitForControlVisible(driver, BalanceEnquiryPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, accountNo, BalanceEnquiryPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, accountNo, BalanceEnquiryPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
		}
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
		}
	}
}
