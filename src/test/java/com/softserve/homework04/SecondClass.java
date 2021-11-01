package com.softserve.homework04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class SecondClass {


    @Test

    public void loginWebElement() {

        /*private final String BASE_URL = "http://taqc-opencart.epizy.com/";
        private final Long IMPLICITLY_WAIT_SECONDS = 10L;
        private final Long ONE_SECOND_DELAY = 1000L;
        private WebDriver driver;*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://taqc-opencart.epizy.com/");


        driver.findElement(By.cssSelector("a[title='My Account']")).click();

        driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).click();

        driver.findElement(By.id("input-email")).sendKeys("hahaha@gmail.com");
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("qwerty");
        String content = driver.findElement(By.id("input-password")).getAttribute("value");
        System.out.println("content password = " + content);

        driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
        //driver.navigate().refresh();


       /*WebElement login = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.getElementById('input-email')");
        Assert.assertTrue(login.getAttribute("value").contains("hahaha@gmail.com")); // викидає exception
        */

    }
}

 /*  @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();

    }
    @BeforeClass
    public void beforeClass() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://taqc-opencart.epizy.com/");
    }*/

    /*@BeforeMethod
    public void beforeMethod() {
        final String BASE_URL = "http://taqc-opencart.epizy.com/";
        final Long IMPLICITLY_WAIT_SECONDS = 10L;
        final Long ONE_SECOND_DELAY = 1000L;
        WebDriver driver;
        driver.get(BASE_URL);
    }*/

   /* @AfterClass(alwaysRun = true)
    public void afterClass() {
        WebDriver driver = new ChromeDriver();
        driver.close();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        // logout;
        // Save Screen;
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
        }*/
