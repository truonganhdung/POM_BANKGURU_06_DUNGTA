package pages;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import bankguru.LoginPageUI;
import commons.AbstractPage;

public class HomePageObject extends AbstractPage {
	WebDriver driverHomePageObject;

	public HomePageObject(WebDriver driver) {
		this.driverHomePageObject = driver;
	}

	public boolean isHomePageDisplay() {
		waitForControlVisible(driverHomePageObject, HomePageUI.HOME_PAGE_HEADING);
		return isControlDisplayed(driverHomePageObject, HomePageUI.HOME_PAGE_HEADING);
	}

	public boolean isHomePageNotDisplayed() {
		waitForControlInvisible(driverHomePageObject, HomePageUI.HOME_PAGE_HEADING);
		return isControlNotDisplayed(driverHomePageObject, HomePageUI.HOME_PAGE_HEADING);
	}
}
