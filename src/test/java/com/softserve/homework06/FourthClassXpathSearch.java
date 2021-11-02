package com.softserve.homework06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FourthClassXpathSearch {


    @Test

    public void AddToCartXpath () {

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://taqc-opencart.epizy.com/");

        //driver.findElement(By.xpath("//*[@id='form-currency']/div/button/span")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'btn-link dropdown-toggle')]")).click();

        driver.findElement(By.xpath("//button[@name='USD']")).click();

        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("MacBook");
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        driver.findElement(By.xpath("//*[@id='content']/div[3]/div[1]/div/div[2]/div[2]/button[1]/span")).click();
        //driver.findElement(By.xpath("//a[text()='MacBook']/../..//p[contains(text(), '602')]")).click();

        //check an operation success
        String content = driver.findElement(By.xpath("//i[@class= 'fa fa-check-circle']/following-sibling::a")).getAttribute("text");//
        System.out.println("content text1 (macbook) = " + content);

        driver.findElement(By.xpath("//*[@id='search']/input")).clear();
        driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("iPhone 3");
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
        //driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//p[contains(text(), '123')]")).click();
        driver.findElement(By.xpath("//*[@id='content']/div[3]/div[1]/div/div[2]/div[2]/button[1]/span")).click();

        //check an operation success
        String content1 = driver.findElement(By.xpath("//i[@class= 'fa fa-check-circle']/following-sibling::*[1]")).getAttribute("text");
        System.out.println("content text2(iphone3) = " + content1);

        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a/span")).click();
        driver.findElement(By.xpath("//div//tr/td[text()='Quantity']/following::tbody[1]/tr[1]/td[*]//input")).clear();
        driver.findElement(By.xpath("//div//tr/td[text()='Quantity']/following::tbody[1]/tr[1]/td[*]//input")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr[1]/td[4]/div/span/button[1]/i")).click();
        //check that applied
        String content2 = driver.findElement(By.xpath("//i[@class= 'fa fa-check-circle']/self::i")).getAttribute("text");//null in test results of this line
        System.out.println("content text3(iphone3) = " + content2);// Success: You have modified your shopping cart!

        driver.findElement(By.xpath("//div//tr/td[text()='Quantity']/following::tbody[1]/tr[2]/td[*]//input")).clear();
        driver.findElement(By.xpath("//div//tr/td[text()='Quantity']/following::tbody[1]/tr[2]/td[*]//input")).sendKeys("3");
        driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr[2]/td[4]/div/span/button[1]/i")).click();
        String content3 = driver.findElement(By.xpath("//i[@class= 'fa fa-check-circle']/self::*[1]")).getAttribute("text");//null in test results of this line
        System.out.println("content text4(macbook) = " + content3);



        WebElement result = driver
                .findElement(By.xpath("//*[@id='content']/div[2]//tbody/tr[4]/td[2]"));
        Assert.assertTrue(result.getText().contains("$2,052"));
        System.out.println("***contains result: " + result.getText());


        driver.close();

    }


}
