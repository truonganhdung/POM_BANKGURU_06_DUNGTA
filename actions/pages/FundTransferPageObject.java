package pages;

import org.openqa.selenium.WebDriver;

import bankguru.FundTransferPageUI;
import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driverHomePageObject;

	public FundTransferPageObject(WebDriver driver) {
		this.driverHomePageObject = driver;
	}

	public void clickToLogoutLink() {
		waitForControlVisible(driverHomePageObject, FundTransferPageUI.LOGOUT_LINK);
		clickToElement(driverHomePageObject, FundTransferPageUI.LOGOUT_LINK);
		acceptAlert(driverHomePageObject);
	}

}
