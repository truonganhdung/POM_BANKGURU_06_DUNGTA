package pages;

import org.openqa.selenium.WebDriver;

import bankguru.AbstractPageUI;
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

	public String getBalance(String locatorName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, locatorName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, locatorName);
	}

	public void inputToAccountNoTextBox(String accountNo, String locatorName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, locatorName);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, accountNo, AbstractPageUI.DYNAMIC_TEXTBOX, locatorName);
		} else {
			sendkeyToElement(driver, accountNo, AbstractPageUI.DYNAMIC_TEXTBOX, locatorName);
		}
	}

}
