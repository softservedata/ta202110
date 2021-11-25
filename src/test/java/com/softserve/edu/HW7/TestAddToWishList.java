package com.softserve.edu.HW7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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


public class TestAddToWishList {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
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
        presentationSleep();
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep();

        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
        }
        presentationSleep();
    }
    @Test
    public void findByXPath() {
        // Add MacBook to shopping cart
        driver.findElement(By.xpath("//a[text()='MacBook']/../../following-sibling::div[@class='button-group']/button[contains(@onclick,'cart.add')]")).click();
        presentationSleep();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        presentationSleep();
        driver.findElement(By.xpath("//div[@class='alert alert-success']//button[@class='close']")).click();
        presentationSleep();
        //Add iPhone3 to wish list
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../../..//button[contains(@data-original-title,'Add to Wish List')]")).click();
        presentationSleep();
        driver.findElement(By.xpath("//div[@class='alert alert-success']//a[contains(text(),'login')]")).isDisplayed();

    }
}
