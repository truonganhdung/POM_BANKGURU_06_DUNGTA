package pages;

import org.openqa.selenium.WebDriver;

import bankguru.NewAccountPageUI;
import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getGeneratedSuccessfullyText() {
		waitForControlVisible(driver, NewAccountPageUI.VERIFY_CREATE_ACCOUNT);
		return getTextElement(driver, NewAccountPageUI.VERIFY_CREATE_ACCOUNT);
	}

	public String getCurrentAmount() {
		waitForControlVisible(driver, NewAccountPageUI.VERIFY_DYNAMIC, "Current Amount");
		return getTextElement(driver, NewAccountPageUI.VERIFY_DYNAMIC, "Current Amount");
	}
	
	public String getAccountID() {
		waitForControlVisible(driver, NewAccountPageUI.VERIFY_DYNAMIC, "Account ID");
		return getTextElement(driver, NewAccountPageUI.VERIFY_DYNAMIC, "Account ID");
	}

}
