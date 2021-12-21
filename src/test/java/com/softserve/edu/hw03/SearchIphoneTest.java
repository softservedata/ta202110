package com.softserve.edu.hw03;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchIphoneTest {

    @Test
    public void searchWebElement() {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://taqc-opencart.epizy.com/");

        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector("button[name='EUR']")).click();
        //
        driver.findElement(By.name("search")).sendKeys("iPhone");
        //driver.findElement(By.cssSelector("#search > input")).click(); //some problem with click
        driver.findElement(By.cssSelector("#search button")).click();

        WebElement price = driver.findElement(By.xpath("//a[contains(text(),'iPhone XR')]/../.."));
        Assert.assertTrue(price.getText().contains("707.71€"));
        System.out.println("***contains: " + price.getText());
        //
        driver.close();
    }
}
