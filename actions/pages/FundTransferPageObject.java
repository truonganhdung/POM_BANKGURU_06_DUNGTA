package pages;

import org.openqa.selenium.WebDriver;

import bankguru.AbstractPageUI;
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
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_VERIFY, "Amount");
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VERIFY, "Amount");
	}

	public void inputToPayersAccountNoTextBox(String payersAccountNo) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYERS_ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, payersAccountNo, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYERS_ACCOUNT_NUMBER);
		} else {
			sendkeyToElement(driver, payersAccountNo, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYERS_ACCOUNT_NUMBER);
		}
	}

	public void inputToPayeesAccountNoTextBox(String payeesAccountNo) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYEES_ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, payeesAccountNo, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYEES_ACCOUNT_NUMBER);
		} else {
			sendkeyToElement(driver, payeesAccountNo, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.PAYEES_ACCOUNT_NUMBER);
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
