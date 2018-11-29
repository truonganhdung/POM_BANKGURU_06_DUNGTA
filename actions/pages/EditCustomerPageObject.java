package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driverHomePageObject;

	public EditCustomerPageObject(WebDriver driver) {
		this.driverHomePageObject = driver;
	}

}
