package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Account_01_RegisterLoginLogout {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/v4/");
		
		email = "automationtesting" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr155533");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("aqAtAda");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		
	}

	@Test
	public void TC_02_LoginToSystem() {
	}

	@Test
	public void TC_03_LogoutToSystem() {
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
