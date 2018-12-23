package pages;

import org.openqa.selenium.WebDriver;

import bankguru.BalanceEnquiryPageUI;
import commons.AbstractPage;

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

}
