package com.softserve.edu07exp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjaxTest {
	private final String BASE_URL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/paging/";
	private final Long IMPLICITLY_WAIT_SECONDS = 10L;
	private final Long ONE_SECOND_DELAY = 1000L;
	private WebDriver driver;

	// Overload
	private void presentationSleep() {
		presentationSleep(1);
	}

	// Overload
	private void presentationSleep(int seconds) {
		try {
			Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.firefoxdriver().setup();
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		presentationSleep(); // For Presentation ONLY
		// driver.close();
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(BASE_URL);
		presentationSleep(); // For Presentation ONLY
		//
		closePopup();
	}

	@AfterMethod
	public void afterMethod() {
		presentationSleep(); // For Presentation ONLY
		// logout; clear cache; delete cookie; delete session;
		// Save Screen;
	}

	private void closePopup() {
		presentationSleep(); // For Presentation ONLY
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> foooterButton = driver.findElements(By.xpath("//footer[contains(@class,'cookie')]//button"));
		// System.out.println("***foooterButton.size() = " + foooterButton.size());
		if (foooterButton.size() > 0) {
			foooterButton.get(0).click();
			presentationSleep(); // For Presentation ONLY
		}
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
	}

	@Test
	public void AjaxIframePage() {
		// Move to Element by JavaScript Injection
		WebElement position = driver.findElement(By.id("use-paging-with-other-data-processing-plugins"));
		// WebElement position =
		// driver.findElement(By.cssSelector("#using-paging-with-other-data-processing-plugins"));
		//
		Actions action = new Actions(driver);       
        action.moveToElement(position).perform();
		//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", position);
		//
		// WebElement position =
		// driver.FindElement(By.CssSelector("#using-paging-with-other-data-processing-plugins"));
		// javaScript.ExecuteScript("arguments[0].scrollIntoView(true);", position);
		//
		// Move to Element by Action
		// Actions action = new Actions(driver);
		// action.moveToElement(position).perform();
		presentationSleep(2); // Do no use
		//
		// Switch To IFrame
		driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@data-options,'remote-paging')]//iframe")));
		// Switch To IFrame
		// driver.SwitchTo().Frame(driver.FindElement(By.XPath("//div[@id='grid-paging-remote-paging-demo-pane-preview']//iframe")));
		//
		// Search First Element
		WebElement tdNevadaFirstData = driver.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[2]"));
		System.out.println("tdNevadaFirstData.getText() = " + tdNevadaFirstData.getText());
		String removeText = driver.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[3]")).getText();
		System.out.println("removeText = " + removeText);
		//
		// Goto to Page 2
		driver.findElement(By.xpath("//span[text()='2']")).click();
		// presentationSleep(4); // DO NOT USE
		//
		// Explicit Wait
		//presentationSleep(4); // DO NOT USE
		//
		// Turn off Implicit Wait
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//
//        (new WebDriverWait(driver, 10)).until(
//                ExpectedConditions.stalenessOf(tdNevadaFirstData));
		//
//-        (new WebDriverWait(driver, 10)).until(
//-             ExpectedConditions.invisibilityOfElementLocated(
//-                     By.xpath("//td[text()='" + tdNevadaFirstData.getText() + "']")));
		//
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='" + removeText + "']")));
		//
		// Search First Element
//		WebDriverWait driverWait = new WebDriverWait(driver, 10);
//		WebElement tdNevadaSecondData = driverWait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Nevada']/preceding-sibling::td[2]")));

		// Turn on Implicit Wait
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
		//
		// Search First Element
		WebElement tdNevadaSecondData = driver.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[2]"));
		// WebElement tdNevadaSecondData =
		// driver.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[1]"));
		// presentationSleep(4); // DO NOT USE
		System.out.println("tdNevadaSecondData.getText() = " + tdNevadaSecondData.getText());
		//System.out.println("R: tdNevadaFirstData.getText() = " + tdNevadaFirstData.getText());
		presentationSleep(4); // DO NOT USE
	}

}
