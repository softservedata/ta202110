package com.softserve.homework07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToWishListTest {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
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
    
    @Test
    public void checkExistWebElement() throws Exception {
        driver.findElement(By.xpath("//a[.='MacBook']//..//..//..//button[contains(@onclick, 'cart.add')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        driver.findElement(By.xpath("//a[.='iPhone 3']//..//..//..//button[@data-original-title='Add to Wish List']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        Thread.sleep(2000);
    }
}
