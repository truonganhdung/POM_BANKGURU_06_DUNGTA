package pages;

import org.openqa.selenium.WebDriver;

import bankguru.DepositPageUI;
import commons.AbstractPage;

public class DeleteAccountPageObject extends AbstractPage {
	WebDriver driver;

	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
