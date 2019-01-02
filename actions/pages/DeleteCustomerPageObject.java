package pages;

import org.openqa.selenium.WebDriver;

import bankguru.AbstractPageUI;
import commons.AbstractPage;
import payment.DynamicLocator;

public class DeleteCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToCustomerIdTextBox(String customerId) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, customerId, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
		} else {
			sendkeyToElement(driver, customerId, AbstractPageUI.DYNAMIC_TEXTBOX, DynamicLocator.CUSTOMER_ID);
		}
	}

}
