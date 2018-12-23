package pages;

import org.openqa.selenium.WebDriver;

import bankguru.LoginPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class LoginPageObject extends AbstractPage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driverTestCase) {
		this.driver = driverTestCase;
	}

	public String getLoginPageUrl() {
		return getCurrentURL(driver);
	}

	public void inputToUserIDTextbox(String email) {
		waitForControlVisible(driver, LoginPageUI.USER_ID);
		sendkeyToElement(driver, LoginPageUI.USER_ID, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD);
		sendkeyToElement(driver, LoginPageUI.PASSWORD, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, LoginPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, LoginPageUI.SUBMIT_BUTTON);
		}

		// return new HomePageObject(driverLoginPageObject);
		return PageFactoryManager.getHomePage(driver);
	}

	public RegisterPageObject clickToHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, LoginPageUI.HERE_LINK);
			staticSleep(5);
		} else {
			clickToElement(driver, LoginPageUI.HERE_LINK);
		}

		return PageFactoryManager.getResgisterPage(driver);
	}

	public boolean isLoginPageDisplayed() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_PAGE_FORM);
		return isControlDisplayed(driver, LoginPageUI.LOGIN_PAGE_FORM);
	}

	public boolean isLoginPageNotDisplayed() {
		waitForControlInvisible(driver, LoginPageUI.LOGIN_PAGE_FORM);
		return isControlNotDisplayed(driver, LoginPageUI.LOGIN_PAGE_FORM);
	}
}
