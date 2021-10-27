package com.softserve.edu05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private WebDriver driver;

    private void takeScreenShot() {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void takePageSource() {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_source.html");
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        // logout;
        // Save Screen;
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to;
            // previous state, logout, etc.
            takeScreenShot();
            takePageSource();
            // driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete
            // session;
        }
        // driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        // driver.findElement(By.cssSelector("#logo > a")).click();
        //driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]/..")).click();
        presentationSleep(); // For Presentation ONLY
    }

    private WebElement getProductByName(String name) {
        WebElement result = null;
        List<WebElement> containers = driver.findElements(By.cssSelector("div.product-layout.product-grid"));
        for (WebElement current : containers) {
            if (current.findElement(By.cssSelector("h4 > a")).getText().equals(name)) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // Develop Custom Exception
            throw new RuntimeException("WebElement by title/name: " + name + " not found");
        }
        return result;
    }

    @Test
    public void findByCss() {
        // Precondition
        WebElement usd = driver.findElement(By.cssSelector("button[name='USD']"));
        System.out.println("*** 1. usd.isDisplayed() = " + usd.isDisplayed());
        // Choose Curency
        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        presentationSleep(); // For Presentation ONLY
        System.out.println("*** 2. usd.isDisplayed() = " + usd.isDisplayed());
        //
        driver.findElement(By.cssSelector("button[name='USD']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Steps
        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        presentationSleep(); // For Presentation ONLY
        //
        //driver.findElement(By.cssSelector("a:contains('MacBook')")).click(); // Selenium ERROR
        //driver.findElement(By.cssSelector("div.product-layout.product-grid h4:has(> a:contains('MacBook'))")).click(); // Selenium ERROR
        //driver.findElement(By.cssSelector("div.product-layout.product-grid h4:has(> a)")).click();
        //
        // Search a $("div.product-layout.product-grid h4 > a")
        // Search h4 $("div.product-layout.product-grid h4:has(> a)")
        // Search Price $("div.product-layout.product-grid h4:has(> a[href*='id=43']) + p + p")
        // Search Price $("div.product-layout.product-grid div:has(> h4 > a[href*='id=43']) > p[class='price']")
        // Search Price $("div.product-layout.product-grid div:has(> h4 > a[href*='id=43']) > p.price")
        //
        // Check
        //WebElement price = driver.findElement(By.cssSelector("div.product-layout.product-grid div:has(> h4 > a[href*='id=43']) > p.price")); // id=43 Hardcode Invalid Solution
        WebElement price = getProductByName("MacBook").findElement(By.cssSelector("p.price"));
        //WebElement price = driver.findElement(By.cssSelector("#content > div:nth-child(8) > div:nth-child(2) > div > div:nth-child(2) > div.caption > h4 > a"));
        //
        Actions action = new Actions(driver);
        action.moveToElement(price).perform();
        //
        Assert.assertTrue(price.getText().contains("$602.00"));
        //
        // Return to Previous State
        presentationSleep(); // For Presentation ONLY
    }

    //@Test
    public void findByXPath() {
        // Precondition
        // Choose Curency
        driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
        presentationSleep(); // For Presentation ONLY
        driver.findElement(By.xpath("//button[@name='USD']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Steps
        // Type Search Field
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mac");
        presentationSleep(); // For Presentation ONLY
        //
        // Click Search Button
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        WebElement price = driver
                .findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
        // Scrolling by Action class
        Actions action = new Actions(driver);
        action.moveToElement(price).perform();
        presentationSleep(); // For Presentation ONLY
        // Check
        Assert.assertTrue(price.getText().contains("$602.00"));
        //
        // Return to Previous State
        presentationSleep(); // For Presentation ONLY
    }

}
