package com.softserve.homework04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeworkTest04 {

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
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).click();
		Thread.sleep(1000);

		// Enter E-Mail and Password
		driver.findElement(By.id("input-email")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("hahaha@gmail.com");
		String content = driver.findElement(By.id("input-email")).getAttribute("value");
		System.out.println("content email = " + content);

		driver.findElement(By.id("input-password")).click();
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty");
		content = driver.findElement(By.id("input-password")).getAttribute("value");
		System.out.println("content password = " + content);

		// Click Login button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);

		// Check registration by URL
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://taqc-opencart.epizy.com/index.php?route=account/account");
		System.out.println("Registration URL= " + URL);
	}
}
