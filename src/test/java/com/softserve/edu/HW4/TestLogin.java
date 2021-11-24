package com.softserve.edu.HW4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TestLogin {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
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
        presentationSleep(); // For Presentation ONLY
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY

        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
        }
        presentationSleep(); // For Presentation ONLY
    }

    @Test
    public void checkLogin() throws Exception {
        //Open Account dropdown
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        presentationSleep();
        //Select Login
        driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).click();
        presentationSleep();
        //Enter email
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("hahaha@gmail.com");
        String content = driver.findElement(By.id("input-email")).getAttribute("value");
        System.out.println("***content email = " + content);
        presentationSleep(); // For Presentation ONLY
        //Enter password
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("qwerty");
        content = driver.findElement(By.id("input-password")).getAttribute("value");
        System.out.println("content password = " + content);
        presentationSleep(2);
        //
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        presentationSleep();

        WebElement LogoutButton = driver.findElement(By.xpath("//a[@class='list-group-item'][contains(text(),'Logout')]"));
        Assert.assertTrue(LogoutButton.getText().contains("Logout"));
        System.out.println("User is logged in!");
    }
}