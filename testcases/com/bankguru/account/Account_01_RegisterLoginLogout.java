package com.bankguru.account;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Account_01_RegisterLoginLogout {
	WebDriver driver;
	String email, userID, password, loginURL;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/v4/");

		email = "automation" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_RegisterToSystem() throws Exception {
		loginURL = driver.getCurrentUrl();

		// register
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(1000);
		// get info after registering
		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		// System.out.println(userID);
		// System.out.println(password);
	}

	@Test
	public void TC_02_LoginToSystem() throws Exception {
		driver.get(loginURL);

		// login
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		// verify loggin successfully
		Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Manger Id : " + userID + "')]")).isDisplayed());
		Thread.sleep(1000);
	}

	@Test
	public void TC_03_LogoutToSystem() {
		driver.findElement(By.xpath("//a[text()='Log out']")).click();

		Alert alertLogout = driver.switchTo().alert();
		alertLogout.accept();
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
