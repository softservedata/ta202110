package com.softserve.homework06;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartWithXPathTest {
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
    	driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
        driver.findElement(By.xpath("//button[@name='USD']")).click();
        
        driver.findElement(By.xpath("//a[.='MacBook']//..//..//..//button[contains(@onclick, 'cart.add')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        driver.findElement(By.xpath("//a[.='iPhone 3']//..//..//..//button[contains(@onclick, 'cart.add')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        
        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
        driver.findElement(By.xpath("//a[.='MacBook']//..//..//input[contains(@name, 'quantity')]")).clear();
        driver.findElement(By.xpath("//a[.='MacBook']//..//..//input[contains(@name, 'quantity')]")).sendKeys("2");
        driver.findElement(By.xpath("//a[.='MacBook']//..//..//i[contains(@class, 'fa-refresh')]")).click();
        driver.findElement(By.xpath("//a[.='iPhone 3']//..//..//input[contains(@name, 'quantity')]")).clear();
        driver.findElement(By.xpath("//a[.='iPhone 3']//..//..//input[contains(@name, 'quantity')]")).sendKeys("3");
        driver.findElement(By.xpath("//a[.='iPhone 3']//..//..//i[contains(@class, 'fa-refresh')]")).click();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        driver.findElement(By.xpath("//button[@data-dismiss=\"alert\"]")).click();
        
        String subTotal = driver.findElement(By.xpath("//td[.='Sub-Total:']/./following::td")).getText();
        float priceSubTotal = Float.parseFloat(subTotal.replaceAll("[$,]", ""));
        String ecoTax = driver.findElement(By.xpath("//td[.='Eco Tax (-2.00):']/./following::td")).getText();
        float priceEcoTax = Float.parseFloat(ecoTax.replaceAll("[$,]", ""));
        String vat20 = driver.findElement(By.xpath("//td[.='VAT (20%):']/./following::td")).getText();
        float priceVat20 = Float.parseFloat(vat20.replaceAll("[$,]", ""));
        String total = driver.findElement(By.xpath("//td[.='Total:']/./following::td")).getText();
        float priceTotal = Float.parseFloat(total.replaceAll("[$,]", ""));
        Assertions.assertEquals(priceTotal, priceSubTotal+priceEcoTax+priceVat20);
        
        Thread.sleep(2000);
    }
}
