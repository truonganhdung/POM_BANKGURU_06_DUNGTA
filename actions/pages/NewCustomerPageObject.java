package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driverHomePageObject;

	public NewCustomerPageObject(WebDriver driver) {
		this.driverHomePageObject = driver;
	}

}
