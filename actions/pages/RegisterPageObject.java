package pages;

import org.openqa.selenium.WebDriver;

import bankguru.RegisterPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class RegisterPageObject extends AbstractPage {
	private WebDriver driverRegisterPageObject;

	public RegisterPageObject(WebDriver driverTestCase) {
		this.driverRegisterPageObject = driverTestCase;
	}
	
	public void inputToEmailTextBox(String email) {
		waitForControlVisible(driverRegisterPageObject, RegisterPageUI.EMAILID_TEXTBOX);
		sendkeyToElement(driverRegisterPageObject, RegisterPageUI.EMAILID_TEXTBOX, email);
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driverRegisterPageObject, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driverRegisterPageObject, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDText() {
		waitForControlVisible(driverRegisterPageObject, RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driverRegisterPageObject, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordText() {
		waitForControlVisible(driverRegisterPageObject, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driverRegisterPageObject, RegisterPageUI.PASSWORD_TEXT);
	}
	
	public LoginPageObject openLoginPageByUrl(String loginPageUrl) {
		openAnyUrl(driverRegisterPageObject, loginPageUrl);
//		return new LoginPageObject(driverRegisterPageObject);
		return PageFactoryManager.getLogInPage(driverRegisterPageObject);
	}
}
