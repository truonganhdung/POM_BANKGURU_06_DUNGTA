package pages;

import org.openqa.selenium.WebDriver;

import bankguru.LoginPageUI;
import commons.AbstractPage;

public class LoginPageObject extends AbstractPage {
	private WebDriver driverLoginPageObject;

	public LoginPageObject(WebDriver driverTestCase) {
		this.driverLoginPageObject = driverTestCase;
	}

	public String getLoginPageUrl() {
		return getCurrentURL(driverLoginPageObject);
	}

	public void inputToUserIDTextbox(String email) {
		waitForControlVisible(driverLoginPageObject, LoginPageUI.USER_ID_TEXTBOX);
		sendkeyToElement(driverLoginPageObject, LoginPageUI.USER_ID_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driverLoginPageObject, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driverLoginPageObject, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForControlVisible(driverLoginPageObject, LoginPageUI.SUBMIT_BUTTON);
		clickToElement(driverLoginPageObject, LoginPageUI.SUBMIT_BUTTON);
	}

	public void clickToHereLink() {
		waitForControlVisible(driverLoginPageObject, LoginPageUI.HERE_LINK);
		clickToElement(driverLoginPageObject, LoginPageUI.HERE_LINK);
	}
	
	public boolean isLoginPageDisplayed() {
		waitForControlVisible(driverLoginPageObject, LoginPageUI.LOGIN_PAGE_FORM);
		return isControlDisplay(driverLoginPageObject, LoginPageUI.LOGIN_PAGE_FORM);
	}
}
