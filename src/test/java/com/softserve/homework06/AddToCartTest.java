package com.softserve.homework06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AddToCartTest {

    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {

        presentationSleep();

        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep();

        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
        }
    }


    @Test
    public void AddToCurt(){

        presentationSleep();

        driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();   //open Currency menu

        presentationSleep();

        driver.findElement(By.xpath("//button[@name='USD']")).click();      //select USD

        presentationSleep();

        // Find MacBook
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("MacBook");
        presentationSleep();

        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();    //click on Search button
        presentationSleep();

        driver.findElement(By.xpath("//a[text()='MacBook']/../../..//span[text()='Add to Cart']")).click();  //add MAcBook to cart
        presentationSleep();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();  //verify success message
        presentationSleep();

        // Find iPhone 3
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iPhone 3");
        presentationSleep();

        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();    //click on Search button
        presentationSleep();

        driver.findElement(By.xpath("//a[text()='iPhone 3']/../../..//span[text()='Add to Cart']")).click();  //add iPhone 3 to cart
        presentationSleep();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();    //verify success message

        driver.findElement(By.xpath("//div[@id='top-links']//span[contains(text(),'Shopping Cart')]")).click();     //open cart

        //Change item quantity of iPhone
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//input[contains(@class,'form-control')]")).click();
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//input[contains(@class,'form-control')]")).clear();
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//input[contains(@class,'form-control')]")).sendKeys("2");
        driver.findElement(By.xpath("//a[text()='iPhone 3']/../..//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='alert alert-success']//button[@class='close']")).click();

        //Change  item quantity of MacBook
        driver.findElement(By.xpath("//a[text()='MacBook']/../..//input[contains(@class,'form-control')]")).click();
        driver.findElement(By.xpath("//a[text()='MacBook']/../..//input[contains(@class,'form-control')]")).clear();
        driver.findElement(By.xpath("//a[text()='MacBook']/../..//input[contains(@class,'form-control')]")).sendKeys("3");
        driver.findElement(By.xpath("//a[text()='MacBook']/../..//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();

        //Check Total
        WebElement Total = driver.findElement(By.xpath("//strong[text()='Total:']/../following::td"));
        Assert.assertTrue(Total.getText().contains("$2,052.40"));
        System.out.println("Price is equal to expected!");




    }
}
