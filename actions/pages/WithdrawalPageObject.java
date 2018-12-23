package pages;

import org.openqa.selenium.WebDriver;

import bankguru.WithdrawalPageUI;
import commons.AbstractPage;

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

}
