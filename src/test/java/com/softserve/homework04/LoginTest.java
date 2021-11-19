package com.softserve.homework04;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
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
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).click();
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("hahaha@gmail.com");
        String content = driver.findElement(By.id("input-email")).getAttribute("value");
        System.out.println("check email = " + content);
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("qwerty");
        content = driver.findElement(By.id("input-password")).getAttribute("value");
        System.out.println("check password = " + content);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.getCurrentUrl().concat("account/account");
        String myAccountText = driver.findElement(By.cssSelector("#content h2")).getText();
        Assertions.assertEquals("My Account", myAccountText);
        Thread.sleep(2000);
    }
}
