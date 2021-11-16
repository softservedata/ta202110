package com.softserve.homework07;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AddToCard {
    private final String BASE_URL = "http://taqc-opencart.epizy.com";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeClass
    public void beforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {

        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
        }
    }

    @Test
    public void testAddItemToCartAndWishList() throws InterruptedException {

        //Search MacBook item
        driver.findElement(By.xpath("//div[@id='search']//input[@type='text']")).click();
        driver.findElement(By.xpath("//div[@id='search']//input[@type='text']")).clear();
        driver.findElement(By.xpath("//div[@id='search']//input[@type='text']")).sendKeys("MacBook", Keys.ENTER);

        //Add MacBook to the cart
        WebElement macBookAddToCart = new WebDriverWait(driver,10).until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[text()='MacBook']/../../..//span[text()='Add to Cart']")));
        macBookAddToCart.click();

        //Verify success message is displayed
        WebElement macBookAddedToTheCartSuccessMessage = new WebDriverWait(driver,10).until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']/a[contains(text(),'MacBook')]")));
        macBookAddedToTheCartSuccessMessage.isDisplayed();

        //Search iPhone 3 item
        driver.findElement(By.xpath("//div[@id='search']//input[@type='text']")).click();
        driver.findElement(By.xpath("//div[@id='search']//input[@type='text']")).clear();
        driver.findElement(By.xpath("//div[@id='search']//input[@type='text']")).sendKeys("iPhone 3", Keys.ENTER);

        //Add iPhone 3 to the WishList
        WebElement iPhone3AddToWishList = new WebDriverWait(driver,10).until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[text()='iPhone 3']/../../"
                        + "following-sibling::div[@class='button-group']/button[@type='button']"
                        + "/i[@class='fa fa-heart']")));
        iPhone3AddToWishList.click();

        //Verify success message is displayed
        WebElement iPhone3AddedToWishListSuccessMessage = new WebDriverWait(driver,10).until(ExpectedConditions.
                visibilityOfElementLocated(By.
                        xpath("//div[@class='alert alert-success']/a[contains(text(),'iPhone 3')]"
                                + "/following-sibling::a[contains(text(),'wish list')]")));
        iPhone3AddedToWishListSuccessMessage.isDisplayed();

    }

}
