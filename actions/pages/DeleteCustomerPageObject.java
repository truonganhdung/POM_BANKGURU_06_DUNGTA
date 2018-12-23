package pages;

import org.openqa.selenium.WebDriver;

import bankguru.DepositPageUI;
import commons.AbstractPage;

public class DeleteCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
