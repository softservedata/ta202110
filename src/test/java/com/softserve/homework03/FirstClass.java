package com.softserve.homework03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstClass {

    @Test

    public void searchWebElement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://taqc-opencart.epizy.com/");

        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector("button[name='EUR']")).click();
        //
        driver.findElement(By.name("search")).sendKeys("iPhone");
        driver.findElement(By.cssSelector("#search button")).click(); //some problem with click

        WebElement price = driver
                .findElement(By.xpath("//a[contains(text(),'iPhone XR')]/../.."));
        Assert.assertTrue(price.getText().contains("707.71€"));
        System.out.println("***contains: " + price.getText());

        driver.close();





    }
}
