package pages;

import org.openqa.selenium.WebDriver;

import bankguru.NewCustomerPageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCustomerIDText() {
		waitForControlVisible(driver, NewCustomerPageUI.CUSTOMER_ID);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID);
	}
	
	public String getRegisteredSuccessfullyText() {
		waitForControlVisible(driver, NewCustomerPageUI.VERIFY_CREATE_CUSTOMER);
		return getTextElement(driver, NewCustomerPageUI.VERIFY_CREATE_CUSTOMER);
	}

}
