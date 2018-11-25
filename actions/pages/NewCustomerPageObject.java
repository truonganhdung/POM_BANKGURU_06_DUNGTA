package pages;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driverHomePageObject;

	public NewCustomerPageObject(WebDriver driver) {
		this.driverHomePageObject = driver;
	}

	public boolean isHomePageDisplay() {
		waitForControlVisible(driverHomePageObject, HomePageUI.HOME_PAGE_HEADING);
		return isControlDisplay(driverHomePageObject, HomePageUI.HOME_PAGE_HEADING);
	}

	public void clickToLogoutLink() {
		waitForControlVisible(driverHomePageObject, HomePageUI.LOGOUT_LINK);
		clickToElement(driverHomePageObject, HomePageUI.LOGOUT_LINK);
		acceptAlert(driverHomePageObject);
	}

}
