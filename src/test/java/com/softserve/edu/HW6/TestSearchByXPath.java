package com.softserve.edu.HW6;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSearchByXPath {
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
        // Choose Curency USD
        driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
        presentationSleep();
        driver.findElement(By.xpath("//button[@name='USD']")).click();
        presentationSleep();
        // Add MacBook
        driver.findElement(By.xpath("//a[text()='MacBook']/../../following-sibling::div[@class='button-group']/button[contains(@onclick,'cart.add')]")).click();
        presentationSleep();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        //Add iPhone3
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../../..//button[contains(@onclick,'cart.add')]")).click();
        presentationSleep();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        //Go to Shopping Cart
        driver.findElement(By.xpath("//a[contains(@title,'Shopping Cart')]")).click();
        presentationSleep();
        //Change Quantity of iPhone
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//input[contains(@class,'form-control')]")).click();
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//input[contains(@class,'form-control')]")).clear();
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//input[contains(@class,'form-control')]")).sendKeys("2");
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='alert alert-success']//button[@class='close']")).click();
        //Change Quantity of MacBook
        driver.findElement(By.xpath("//a[text()='MacBook']/../..//input[contains(@class,'form-control')]")).click();
        driver.findElement(By.xpath("//a[text()='MacBook']/../..//input[contains(@class,'form-control')]")).clear();
        driver.findElement(By.xpath("//a[text()='MacBook']/../..//input[contains(@class,'form-control')]")).sendKeys("3");
        driver.findElement(By.xpath("//a[text()='MacBook']/../..//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        //Check Total
        WebElement Total = driver.findElement(By.xpath("//strong[text()='Total:']/../following::td"));
        Assert.assertTrue(Total.getText().contains("$2,052.40"));
        System.out.println("Expected!");

    }
}
