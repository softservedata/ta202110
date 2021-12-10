package com.softserve.edu.homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.softserve.edu.homework6.WebElements.*;

public class homework6 implements WebElements
{
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

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
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void checkShoppingCard() {
        driver.findElement(currencyDropDown).click();
        driver.findElement(currencyUsd).click();
        presentationSleep();
        driver.findElement(addMacbookToCard).click();
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        presentationSleep();
        driver.findElement(addIphoneToCard).click();
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        driver.findElement(shoppingCard).click();
        presentationSleep();
        driver.findElement(changeNumberOfIphone).clear();
        driver.findElement(changeNumberOfIphone).sendKeys("2");
        driver.findElement(refreshNumberOfIphone).click();
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        driver.findElement(changeNumberOfMacBook).clear();
        driver.findElement(changeNumberOfMacBook).sendKeys("3");
        driver.findElement(refreshNumberOfMacBook).click();
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        Assert.assertEquals("$2,052.40",driver.findElement(totalPrice).getText());



    }
}
