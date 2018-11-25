package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bankguru.AbstractPageUI;
import pages.DepositPageObject;
import pages.EditCustomerPageObject;
import pages.FundTransferPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import pages.NewCustomerPageObject;

public class AbstractPage {
	private Actions action;
	private String root = System.getProperty("user.dir");

	private WebDriverWait wait;
	private int longTimeOut = 20;

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void clickToElement(WebDriver driver, String xpathExpression) {
		driver.findElement(By.xpath(xpathExpression)).click();
	}

	public void sendkeyToElement(WebDriver driver, String xpathExpression, String value) {
		driver.findElement(By.xpath(xpathExpression)).clear();
		driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
	}

	public void selectItemInHtmlDropdownByVisibleText(WebDriver driver, String xpathExpression, String value) {
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		select.selectByVisibleText(value);
	}

	public void selectItemInHtmlDropdownByValue(WebDriver driver, String xpathExpression, String value) {
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		select.selectByValue(value);
	}

	public void selectItemInHtmlDropdownByIndex(WebDriver driver, String xpathExpression, int index) {
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		select.selectByIndex(index);
	}

	public String getItemInHtmlDropdown(WebDriver driver, String xpathExpression) {
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(WebDriver driver, WebDriverWait wait, String parentLocator, String allItemsLocator, String expectedValue) throws Exception {
		clickToElementByJS(driver, parentLocator);

		Thread.sleep(1000);

		List<WebElement> allItemsDropDown = driver.findElements(By.xpath(allItemsLocator));
		int itemNumber = allItemsDropDown.size();

		wait.until(ExpectedConditions.visibilityOfAllElements(allItemsDropDown));

		for (int i = 0; i < itemNumber; i++) {
			if (allItemsDropDown.get(i).getText().trim().equals(expectedValue)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allItemsDropDown.get(i));
				Thread.sleep(1000);

				allItemsDropDown.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
	}

	public String getAttributeValue(WebDriver driver, String xpathExpression, String value) {
		return driver.findElement(By.xpath(xpathExpression)).getAttribute(value);
	}

	public String getTextElement(WebDriver driver, String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression)).getText();
	}

	public int countElementNumber(WebDriver driver, String xpathExpression) {
		List<WebElement> list = driver.findElements(By.xpath(xpathExpression));
		return list.size();
	}

	public void checkCheckBox(WebDriver driver, String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		if (!element.isSelected()) {
			element.isSelected();
		}
	}

	public void uncheckCheckBox(WebDriver driver, String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		if (element.isSelected()) {
			element.isSelected();
		}
	}

	public boolean isControlDisplay(WebDriver driver, String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression)).isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression)).isSelected();
	}

	public boolean isControlEnable(WebDriver driver, String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression)).isEnabled();
	}

	public void switchWindowByID(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String findWindow : allWindows) {
			if (!findWindow.equals(parent)) {
				driver.switchTo().window(findWindow);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String findWindow : allWindows) {
			driver.switchTo().window(findWindow);
			String currentWindow = driver.getTitle();
			if (currentWindow.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentWindow)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIframe(WebDriver driver, String xpathIframe, String xpathIconX) {
		List<WebElement> iFrame = driver.findElements(By.xpath(xpathIframe));

		if (iFrame.size() > 0) {
			driver.switchTo().frame(iFrame.get(0));

			clickToElementByJS(driver, xpathIconX);
		}
	}

	public void doubleClickToElement(WebDriver driver, String xpathExpression) throws Exception {
		action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xpathExpression));

		action.doubleClick(element).perform();
		Thread.sleep(1000);
	}

	public void moveToElement(WebDriver driver, String xpathExpression) {
		action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath(xpathExpression))).perform();
	}

	public void rightClick(WebDriver driver, String xpathExpression) {
		action = new Actions(driver);

		action.contextClick(driver.findElement(By.xpath(xpathExpression))).perform();
	}

	public void dragAndDrop(WebDriver driver, String source, String target) {
		action = new Actions(driver);

		WebElement drpSource = driver.findElement(By.xpath(source));
		WebElement drpTarget = driver.findElement(By.xpath(target));

		action.dragAndDrop(drpSource, drpTarget).perform();
	}

	public void keyPressDown(WebDriver driver) {
		action = new Actions(driver);

		action.keyDown(Keys.SHIFT).perform();
	}

	public void keyPressUp(WebDriver driver) {
		action = new Actions(driver);

		action.keyUp(Keys.SHIFT).perform();
	}

	public void uploadSendkeyOneFile(WebDriver driver, String xpathExpression, String file) {
		String filePath = root + "\\upload\\" + file;

		driver.findElement(By.xpath(xpathExpression)).sendKeys(filePath);
	}

	public void uploadSendkeyMultiFile(WebDriver driver, String xpathExpression, String listFile) {
		String[] arrSplit = (listFile.split(", "));
		String uploadFilePath = "";

		for (int i = 0; i < arrSplit.length; i++) {
			uploadFilePath = root + "\\upload\\" + arrSplit[i] + "\n " + uploadFilePath;
		}

		driver.findElement(By.xpath(xpathExpression)).sendKeys(uploadFilePath);
	}

	public void uploadAutoIT(WebDriver driver, String xpathExpression, String file) throws Exception {
		String filePath = root + "\\upload\\" + file;

		clickToElementByJS(driver, xpathExpression);

		Runtime.getRuntime().exec(new String[] { ".\\upload\\firefox.exe", filePath });
	}

	public void uploadByRobot(WebDriver driver, String xpathExpression, String file) throws Exception {
		String filePath = root + "\\upload\\" + file;
		StringSelection select = new StringSelection(filePath);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		clickToElementByJS(driver, xpathExpression);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public Object clickToElementByJS(WebDriver driver, String xpathExpression) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathExpression));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeJSToBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object executeJSToElement(WebDriver driver, String xpathExpression) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathExpression));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottomPage(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToElement(WebDriver driver, String xpathExpression) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathExpression));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].srollIntoView(true);", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object sendkeyToElementByJS(WebDriver driver, String xpathExpression, String value) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathExpression));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object removeAttributeInDOM(WebDriver driver, String xpathExpression, String attribute) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathExpression));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object navigateToUrlByJS(WebDriver driver, String url) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void highlightElement(WebDriver driver, String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public boolean checkAnyImageLoaded(WebDriver driver, WebElement image) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (boolean) jsExecutor.executeScript("return arguments[0].complete && " + "typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", image);
	}

	public void waitForControlPrecense(WebDriver driver, String xpathExpression) {
		By by = By.xpath(xpathExpression);

		wait = new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitForControlVisible(WebDriver driver, String xpathExpression) {
		By by = By.xpath(xpathExpression);

		wait = new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForControlNotVisible(WebDriver driver, String xpathExpression) {
		By by = By.xpath(xpathExpression);

		wait = new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForControlClickable(WebDriver driver, String xpathExpression) {
		By by = By.xpath(xpathExpression);

		wait = new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForAlertPresence(WebDriver driver) {
		wait = new WebDriverWait(driver, longTimeOut);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/*** Open Dynamic Pages ***/
	public HomePageObject openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.HOME_PAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOME_PAGE_LINK);
//		return new HomePageObject(driver);
		return PageFactoryManager.getHomePage(driver);
	}
	
	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
//		return new NewCustomerPageObject(driver);
		return PageFactoryManager.getNewCustomerPage(driver);
	}
	
	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
//		return new EditCustomerPageObject(driver);
		return PageFactoryManager.getEditCustomerPage(driver);
	}
	
	public DepositPageObject openDepositPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DEPOSIT_LINK);
		clickToElement(driver, AbstractPageUI.DEPOSIT_LINK);
//		return new DepositPageObject(driver);
		return PageFactoryManager.getDepositPage(driver);
	}
	
	public FundTransferPageObject openFundTransferPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, AbstractPageUI.FUND_TRANSFER_LINK);
//		return new FundTransferPageObject(driver);
		return PageFactoryManager.getFundTransferPage(driver);
	}
	
	public LoginPageObject clickToLogoutLink(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.LOGOUT_LINK);
		clickToElement(driver, AbstractPageUI.LOGOUT_LINK);
		acceptAlert(driver);
//		return new LoginPageObject(driver);
		return PageFactoryManager.getLogInPage(driver);
	}
}
