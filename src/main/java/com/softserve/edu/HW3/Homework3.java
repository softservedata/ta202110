package com.softserve.edu.HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Homework3 {

    @Test

    public void homework3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://taqc-opencart.epizy.com/");
        driver.findElement(By.cssSelector("button[class = 'btn btn-link dropdown-toggle']")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("button[name = 'EUR']")).click();
        driver.findElement(By.cssSelector("input[name = 'search']")).sendKeys("iPhone");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name = 'search']")).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='iPhone XR']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'707.71')]")).getText().contains("707.71€"));

        //$x("//a[text()='iPhone XR']")
        //$x("//p[contains(text(),'707.71')]")
        //driver.close();


    }


}
