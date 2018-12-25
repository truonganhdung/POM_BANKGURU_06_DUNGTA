package pages;

import org.openqa.selenium.WebDriver;

import bankguru.RegisterPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class RegisterPageObject extends AbstractPage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driverTestCase) {
		this.driver = driverTestCase;
	}

	public void inputToEmailTextBox(String email) {
		waitForControlVisible(driver, RegisterPageUI.EMAILID_TEXTBOX);
		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			sendkeyToElementByJS(driver, RegisterPageUI.EMAILID_TEXTBOX, email);
			staticSleep(5);
		} else {
			sendkeyToElement(driver, RegisterPageUI.EMAILID_TEXTBOX, email);
		}
		
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BUTTON);

		if (driver.toString().toLowerCase().contains("internetexplorer")) {
			clickToElementByJS(driver, RegisterPageUI.SUBMIT_BUTTON);
			staticSleep(5);
		} else {
			clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
		}
	}

	public String getUserIDText() {
		waitForControlVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordText() {
		waitForControlVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPageObject openLoginPageByUrl(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
		return PageFactoryManager.getLogInPage(driver);
	}
}
