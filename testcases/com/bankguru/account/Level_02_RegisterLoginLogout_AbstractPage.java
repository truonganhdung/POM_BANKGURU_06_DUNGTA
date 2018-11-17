package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Level_02_RegisterLoginLogout_AbstractPage {
	WebDriver driver;
	String email, userID, password, loginURL;
	private AbstractPage abstractPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage();

		abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");

		email = "automation" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_RegisterToSystem() throws Exception {
		loginURL = abstractPage.getCurrentURL(driver);

		abstractPage.clickToElement(driver, "//a[text()='here']");
		abstractPage.sendkeyToElement(driver, "//input[@name='emailid']", email);
		abstractPage.clickToElement(driver, "//input[@type='submit']");
		
		Thread.sleep(1000);

		userID = abstractPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
		password =  abstractPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void TC_02_LoginToSystem() throws Exception {
		driver.get(loginURL);

		abstractPage.sendkeyToElement(driver, "//input[@name='uid']", userID);
		abstractPage.sendkeyToElement(driver, "//input[@name='password']", password);
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");

		abstractPage.isControlDisplay(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]");
		abstractPage.isControlDisplay(driver, "//td[contains(text(),'Manger Id : " + userID + "')]");
		Thread.sleep(1000);
	}

	@Test
	public void TC_03_LogoutToSystem() {
		abstractPage.clickToElement(driver, "//a[text()='Log out']");
		abstractPage.acceptAlert(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		int random = rand.nextInt(99999) + 1;
		return random;
	}
}
