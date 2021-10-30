package com.softserve.homework05;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeworkTest05 {

	private final String BASE_URL = "http://taqc-opencart.epizy.com/";
	private final Long IMPLICITLY_WAIT_SECONDS = 10L;
	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(BASE_URL);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (!result.isSuccess()) {
			String testName = result.getName();
			System.out.println("***TC error, name = " + testName + " ERROR");
		}
	}

	@Test
	public void testLogin() throws InterruptedException {

		// Click on My Account and Login
		driver.findElement(By.cssSelector("a[title='My Account']")).click();
		driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).click();
		Thread.sleep(1000);

		// Enter Email and Password
		WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
		emailField.click();
		emailField.clear();
		emailField.sendKeys("hahaha@gmail.com");
		String content = emailField.getAttribute("value");
		System.out.println("content email = " + content);
		
		WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
		passwordField.click();
		passwordField.clear();
		passwordField.sendKeys("qwerty");
		content = passwordField.getAttribute("value");
		System.out.println("content password = " + content);

		// Click Login button
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);

		// Check registration 
		WebElement logout = driver.findElement(By.cssSelector("div[class='list-group']>a[href*='route=account/logout']"));
		Assert.assertEquals(logout.getText(), "Logout");
		System.out.println("check registration = " + logout.getText());
	}
}
