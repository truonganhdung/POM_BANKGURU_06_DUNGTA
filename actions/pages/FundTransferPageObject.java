package pages;

import org.openqa.selenium.WebDriver;

import bankguru.FundTransferPageUI;
import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;

	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLogoutLink() {
		waitForControlVisible(driver, FundTransferPageUI.LOGOUT_LINK);
		clickToElement(driver, FundTransferPageUI.LOGOUT_LINK);
		acceptAlert(driver);
	}

	public String getAmount() {
		waitForControlVisible(driver, FundTransferPageUI.VERIFY_DYNAMIC, "Amount");
		return getTextElement(driver, FundTransferPageUI.VERIFY_DYNAMIC, "Amount");
	}

}
