package com.softserve.homework03;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {

    @Test
    public void SearchForIPhone(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //
        driver.get("http://taqc-opencart.epizy.com/");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("i.fa.fa-caret-down")).click();  //open selector

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("button[name='EUR']")).click();  // select currency Euro

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.name("search")).sendKeys("iPhone");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        //
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //check if iPhone XR has been found
        WebElement iPhone = driver.findElement(By.xpath("//*[.='iPhone XR']"));
        Assertions.assertEquals("iPhone XR", iPhone.getText());

        //check price of found iPhone XR
        WebElement price = driver.findElement(By.xpath("//*[.='iPhone XR']/../following-sibling::p[@class='price']"));
        Assert.assertTrue(price.getText().contains("707.71€"));

        driver.quit();
    }
}
