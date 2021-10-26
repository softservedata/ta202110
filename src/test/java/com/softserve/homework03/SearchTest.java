package com.softserve.homework03;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchTest {
	private final String BASE_URL = "http://taqc-opencart.epizy.com";
	private final Long IMPLICITLY_WAIT_SECONDS = 10L;
	private final Long ONE_SECOND_DELAY = 1000L;
	private WebDriver driver;

	private void addSleep() {
		addSleep(1);
	}

	private void addSleep(int seconds) {
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
		addSleep();
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(BASE_URL);
		addSleep();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		addSleep();

		if (!result.isSuccess()) {
			String testName = result.getName();
			System.out.println("***TC error, name = " + testName + " ERROR");
		}
	}

	@Test
	public void testSearch() {
		WebDriverManager.chromedriver().setup();

		//Chose EUR currency
		driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
		addSleep();
		driver.findElement(By.cssSelector("button[name='EUR']")).click();

		//Search iPhone
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("iPhone", Keys.ENTER);
		addSleep();

		//Verify the price
		WebElement price = driver.findElement(By.xpath("//a[text()='iPhone XR']/../following-sibling::p[@class='price']"));
		Assert.assertTrue(price.getText().contains("707.71€"));
		System.out.println("***contains: " + price.getText());

	}

}
