package com.softserve.homework06;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebELXPath {
    private final String BASE_URL = "http://taqc-opencart.epizy.com";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void addSleep() {
        addSleep(1);
    }

    private void addSleep(int seconds) {
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
        addSleep();
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        addSleep();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        addSleep();

        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
        }
    }

    @Test
    public void TestXPath() {

        //Choose USD currency
        driver.findElement(By.xpath("//span[contains(text(),'Currency')]")).click();
        addSleep();
        driver.findElement(By.xpath("//button[contains(text(),'US')]")).click();

        //Add items from the list to Shopping cart
        String[] itemList = {"iPhone 3", "MacBook"};
        int index = 0;

        while(index<itemList.length) {

            //Search item
            driver.findElement(By.xpath("//div[@class='input-group']/input")).click();
            driver.findElement(By.xpath("//div[@class='input-group']/input")).clear();
            driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(itemList[index], Keys.ENTER);
            addSleep();

            //Add item to the cart
            driver.findElement(By.xpath("//a[text()='%item%']/../../..//span[text()='Add to Cart']".replace("%item%", itemList[index]))).click();

            //Verify success message is displayed
            driver.findElement(By.xpath("//div[@class='alert alert-success']/a[contains(text(),'%item%')]".replace("%item%", itemList[index]))).isDisplayed();

            index++;

        }

        //Go to Shopping Cart
        addSleep();
        driver.findElement(By.xpath("//nav[@id='top']//span[contains(text(),'Shopping Cart')]")).isDisplayed();
        driver.findElement(By.xpath("//nav[@id='top']//span[contains(text(),'Shopping Cart')]")).click();

        //Change the quantity of items in Shopping cart
        String[] itemsList = {"iPhone 3", "MacBook"};
        String[] itemsQuantity = {"2", "3"};
        int indexOf = 0;

        while(indexOf<itemsQuantity.length) {

            //Change item quantity
            driver.findElement(By.xpath("//tr/td/a[contains(text(),'%item%')]/../..//td/div/input[@type='text']".replace("%item%", itemsList[indexOf]))).click();
            driver.findElement(By.xpath("//tr/td/a[contains(text(),'%item%')]/../..//td/div/input[@type='text']".replace("%item%", itemsList[indexOf]))).clear();
            driver.findElement(By.xpath("//tr/td/a[contains(text(),'%item%')]/../..//td/div/input[@type='text']".replace("%item%", itemsList[indexOf]))).sendKeys(("%quantity%").replace("%quantity%", itemsQuantity[indexOf]));

            //Refresh total
            driver.findElement(By.xpath("//tr/td/a[contains(text(),'%item%')]/../..//td/div/input[@type='text']/..//i[@class='fa fa-refresh']".replace("%item%", itemsList[indexOf]))).click();
            addSleep();

            //Verify that success message is displayed and close it
            driver.findElement(By.xpath("//div[@class='alert alert-success'][contains(text(),'Success: You have modified your shopping cart!')]")).isDisplayed();
            driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();

            indexOf++;

        }

        //Verify expected total price
        String actualResult, expectedResult;
        expectedResult =  "$2,052.40";
        actualResult= driver.findElement(By.xpath("//div[@class='buttons clearfix']/..//div[@class='row']/div/table/tbody/tr/td/strong[text()='Total:']/../following-sibling::td")).getText();
        System.out.println("Total: " + actualResult);
        Assert.assertEquals(actualResult, expectedResult);

    }

}
