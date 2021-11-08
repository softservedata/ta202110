package com.softserve.homework07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FifthImExplicitWait {

    @Test

    public void ImplicitExplicitWaitCheck () {

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://taqc-opencart.epizy.com/");


        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("MacBook");
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        driver.findElement(By.xpath("//a[text()='MacBook']/../..//p[contains(text(), '602')]")).click();
        driver.findElement(By.xpath("//*[@id='content']/../..//button[1]/span")).click();


        //check an operation success
        String content = driver.findElement(By.xpath("//i[@class= 'fa fa-check-circle']/following-sibling::a")).getAttribute("text");//
        System.out.println("content text1 (macbook) = " + content);

        driver.findElement(By.xpath("//*[@id='search']/input")).clear();
        driver.findElement(By.xpath("//*[@id='search']/input")).sendKeys("iPhone 3");
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
        driver.findElement(By.xpath("//*[@id='content']/..//div[2]/button[2]/i")).click();


        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]")));

        //check an operation success
        String content1 = driver.findElement(By.xpath("//i[@class= 'fa fa-check-circle']/following-sibling::*[1]")).getAttribute("text");
        System.out.println("content text2(iphone3) = " + content1);

        driver.close();


    }
}
