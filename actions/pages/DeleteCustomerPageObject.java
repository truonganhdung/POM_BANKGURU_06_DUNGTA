package pages;

import org.openqa.selenium.WebDriver;

import bankguru.DeleteCustomerPageUI;
import commons.AbstractPage;
import payment.DynamicLocator;

public class DeleteCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerIdTextBox(String customerId) {
		waitForControlVisible(driver, DeleteCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerId, DeleteCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, customerId, DeleteCustomerPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
		}
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
		}
	}

}
