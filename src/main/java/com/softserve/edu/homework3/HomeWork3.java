package com.softserve.edu.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomeWork3 {
    @Test
    public void homework3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver instance = new ChromeDriver();
        instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        instance.manage().window().maximize();
        instance.get("http://taqc-opencart.epizy.com/");
        instance.findElement(By.cssSelector("button[class = 'btn btn-link dropdown-toggle']")).click();
        instance.findElement(By.cssSelector("button[name = 'EUR']")).click();
        instance.findElement(By.cssSelector("input[name = 'search']")).sendKeys("iPhone");
        Thread.sleep(500);
        instance.findElement(By.cssSelector("input[name = 'search']")).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        Assert.assertTrue(instance.findElement(By.xpath("//a[text()='iPhone XR']")).isDisplayed());
        Assert.assertTrue(instance.findElement(By.xpath("//p[contains(text(),'707.71')]")).getText().contains("707.71€"));

        //$x("//a[text()='iPhone XR']")
        //$x("//p[contains(text(),'707.71')]")
        //driver.close();

    }

}
