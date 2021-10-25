package com.softserve.homework03;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeworkTest03 {

	private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
	private static final Long IMPLICITLY_WAIT_SECONDS = 10L;

	@Test
	public void testSearch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get(BASE_URL);
		Thread.sleep(1000);

		// Select Currency 'Euro'
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		driver.findElement(By.xpath("//button[@name='EUR']")).click();
		Thread.sleep(1000);

		// Search by "iPhone"
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iPhone", Keys.ENTER);
		Thread.sleep(1000);

		// Check if "iPhone XR" is located on the page with price 707.71€.
		WebElement price = driver
				.findElement(By.xpath("//a[text()='iPhone XR']/../following-sibling::p[@class='price']"));
		Assert.assertTrue(price.getText().contains("707.71€"));
		System.out.println("***Price: " + price.getText());

		// close browser
		driver.quit();
	}
}
