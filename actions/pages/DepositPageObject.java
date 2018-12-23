package pages;

import org.openqa.selenium.WebDriver;

import bankguru.DepositPageUI;
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
}
