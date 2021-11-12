package com.softserve.edu.homework4;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW4 {

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void loginTest() {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li//a[text()='Login']")).click();
        driver.findElement(By.cssSelector("#input-email")).sendKeys("hahaha@gmail.com");
        driver.findElement(By.cssSelector("#input-password")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());

    }
}

