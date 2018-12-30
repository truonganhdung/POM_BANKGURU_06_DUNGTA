package pages;

import org.openqa.selenium.WebDriver;

import payment.DynamicLocator;
import bankguru.DeleteAccountPageUI;

import commons.AbstractPage;

public class DeleteAccountPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAccountNoTextBox(String accountNo) {
		waitForControlVisible(driver, DeleteAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, accountNo, DeleteAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
		} else {
			sendkeyToElement(driver, accountNo, DeleteAccountPageUI.DYNAMIC_TEXTBOX, DynamicLocator.ACCOUNT_NUMBER);
		}
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, DeleteAccountPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
		}
	}

}
