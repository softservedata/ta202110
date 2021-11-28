package com.softserve.homework10;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitTest {

    private final String BASE_URL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/paging/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    long seconds10 = 10L;
    long seconds05 = 5L;
    long seconds01 = 1L;
    long seconds00 = 0;
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
        //
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(seconds10, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(seconds00, TimeUnit.SECONDS);
        //List<WebElement> foooterButton = driver.findElements(By.xpath("//footer[contains(@class,'cookie')]//button"));
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .ignoring(NoSuchElementException.class)
                .ignoring(NullPointerException.class)
                .ignoring(TimeoutException.class);
        //
        WebElement foooterButton = wait.until(new Function<WebDriver, WebElement>() {
          public WebElement apply(WebDriver driver) {
              String s = null;
              System.out.print("s = ");
              if (System.currentTimeMillis() % 2 == 0) {
                  System.out.println(s.toString());
              }
            return driver.findElement(By.xpath("//footer[contains(@class,'cookie')]//button"));
          }
        });
        System.out.println("foooterButton = " + foooterButton);
        //foooterButton.click();
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(seconds10, TimeUnit.SECONDS);
    }
    
    @Test
    public void AjaxIframePage() {
        //WebElement position = driver.findElement(By.id("use-paging-with-other-data-processing-plugins"));
        driver.manage().timeouts().implicitlyWait(seconds00, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        WebDriverWait wait = new WebDriverWait(driver, seconds10);
        WebElement position = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("use-paging-with-other-data-processing-plugins")));
        System.out.println("position = " + position.getText());
    }
    
}
