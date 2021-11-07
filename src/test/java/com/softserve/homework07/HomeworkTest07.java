package com.softserve.homework07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeworkTest07 {

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
	public void testWait() {

		// Add to cart 'MacBook'
		driver.findElement(By.xpath("//a[text()='MacBook']/../../..//span[text()='Add to Cart']")).click();

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		// Check success message and close
		getSuccessMessage();

		// Add to Wish list 'iPhone 3'
		driver.findElement(By.xpath("//a[text()='iPhone 3']/../../..//i[@class='fa fa-heart']")).click();

		// Check success message and close
		getSuccessMessage();

	}

	public void getSuccessMessage() {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
		driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
		driver.findElement(By.xpath("//button[@class='close']")).click();
	}
}
