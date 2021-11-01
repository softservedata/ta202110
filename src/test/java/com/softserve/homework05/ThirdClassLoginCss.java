package com.softserve.homework05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ThirdClassLoginCss {

    @Test

    public void loginWebElementCss() {

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

        driver.findElement(By.cssSelector("#input-email")).sendKeys("hahaha@gmail.com");
        driver.findElement(By.cssSelector("#input-password")).click();
        //driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("qwerty");
        String content = driver.findElement(By.cssSelector("#input-password")).getAttribute("value");
        System.out.println("content password = " + content);

        driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
        //driver.navigate().refresh();


       /*WebElement login = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.getElementById('input-email')");
        Assert.assertTrue(login.getAttribute("value").contains("hahaha@gmail.com")); // exception again  */


    }
}
