package com.softserve.homework06;

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

public class HomeworkTest06 {

	private final String BASE_URL = "http://taqc-opencart.epizy.com/";
	private final Long IMPLICITLY_WAIT_SECONDS = 10L;
	private final Long ONE_SECOND_DELAY = 1000L;
	private WebDriver driver;
	
	private void useSleep() {
		useSleep(1);
	}

	private void useSleep(int seconds) {
		try {
			Thread.sleep(seconds * ONE_SECOND_DELAY);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

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
	public void testCart() {

		// Select Currency 'USD'
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		driver.findElement(By.xpath("//button[@name='USD']")).click();
		useSleep();

		// Add to cart 'MacBook'
		driver.findElement(By.xpath("//a[text()='MacBook']/../../..//span[text()='Add to Cart']")).click();
		useSleep();
		
		// Check success message and close
		driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
		driver.findElement(By.xpath("//button[@class='close']")).click();	
		useSleep();

		// Add to cart 'iPhone 3'
		driver.findElement(By.xpath("//a[text()='iPhone 3']/../../..//span[text()='Add to Cart']")).click();
		useSleep();
		
		// Check success message and close
		driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
		driver.findElement(By.xpath("//button[@class='close']")).click();	
		useSleep();

		// Go to Shopping Cart
		driver.findElement(By.xpath("//li//span[text()='Shopping Cart']")).click();
		useSleep();

		// Change the number of 'iPhone 3' to 2
		driver.findElement(By.xpath("//div[@class='table-responsive']//a[text()='iPhone 3']/../following-sibling::td/div/input")).clear();
		driver.findElement(By.xpath("//div[@class='table-responsive']//a[text()='iPhone 3']/../following-sibling::td/div/input")).sendKeys("2");
		driver.findElement(By.xpath("//div[@class='table-responsive']//a[text()='iPhone 3']/../following-sibling::td/div//button[@type='submit']")).click();
		useSleep();
		
		// Check success message and close
		driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
		driver.findElement(By.xpath("//button[@class='close']")).click();	
		useSleep();

		// Change the number of 'MacBook' to 3
		driver.findElement(By.xpath("//div[@class='table-responsive']//a[text()='MacBook']/../following-sibling::td/div/input")).clear();
		driver.findElement(By.xpath("//div[@class='table-responsive']//a[text()='MacBook']/../following-sibling::td/div/input")).sendKeys("3");
		driver.findElement(By.xpath("//div[@class='table-responsive']//a[text()='MacBook']/../following-sibling::td/div//button[@type='submit']")).click();
		useSleep();
		
		// Check success message and close
		driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
		driver.findElement(By.xpath("//button[@class='close']")).click();
		useSleep();

		// Check the expected price.
		WebElement price = driver.findElement(By.xpath("//div[@id='content']/div[@class='row']/div/table/tbody/tr[4]/td[2]"));
		useSleep();
		Assert.assertTrue(price.getText().contains("$2,052.40"));
		System.out.println("Price: " + price.getText());

	}
}
