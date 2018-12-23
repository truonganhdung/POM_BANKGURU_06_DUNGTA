package pages;

import org.openqa.selenium.WebDriver;

import bankguru.EditCustomerPageUI;
import commons.AbstractPage;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUpdatedSuccessfullyText() {
		waitForControlVisible(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
		return getTextElement(driver, EditCustomerPageUI.VERIFY_EDIT_CUSTOMER);
	}
}
