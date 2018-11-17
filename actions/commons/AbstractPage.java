package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	
	public void openAnyUrl (WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getPageTitle (WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentURL (WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource (WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPreviousPage (WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToNextPage (WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage (WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert (WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert (WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String getTextAlert (WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert (WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	
	public void clickToElement (WebDriver driver, String xpathExpression) {
		driver.findElement(By.xpath(xpathExpression)).click();
	}
	
	public void sendkeyToElement (WebDriver driver, String xpathExpression, String value) {
		driver.findElement(By.xpath(xpathExpression)).clear();
		driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
	}
	
	public void selectItemInHtmlDropdownByVisibleText (WebDriver driver, String xpathExpression, String value) {
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		select.selectByVisibleText(value);
	}
	
	public void selectItemInHtmlDropdownByValue (WebDriver driver, String xpathExpression, String value) {
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		select.selectByValue(value);
	}
	
	public void selectItemInHtmlDropdownByIndex (WebDriver driver, String xpathExpression, int index) {
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		select.selectByIndex(index);
	}
		
	public String getItemInHtmlDropdown (WebDriver driver, String xpathExpression) {
		Select select = new Select(driver.findElement(By.xpath(xpathExpression)));
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectItemInCustomDropdown (WebDriver driver, WebDriverWait wait, String parentLocator, String allItemsLocator, String expectedValue) throws Exception  {
		WebElement parantDropDown = driver.findElement(By.xpath(parentLocator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", parantDropDown);
		
		Thread.sleep(1000);
		
		List <WebElement> allItemsDropDown = driver.findElements(By.xpath(allItemsLocator));
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
}
