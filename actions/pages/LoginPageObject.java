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
		waitForControlVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.SUBMIT_BUTTON);
		clickToElement(driver, LoginPageUI.SUBMIT_BUTTON);
//		return new HomePageObject(driverLoginPageObject);
		return PageFactoryManager.getHomePage(driver);
	}

	public RegisterPageObject clickToHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
//		return new RegisterPageObject(driverLoginPageObject);

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
