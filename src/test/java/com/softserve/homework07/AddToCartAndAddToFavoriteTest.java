package com.softserve.homework07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AddToCartAndAddToFavoriteTest {
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
    public void AddToCartAndAddtoFavorite () throws InterruptedException {

        // Find MacBook
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("MacBook");
        presentationSleep();

        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();    //click on Search button
        presentationSleep();

        //Add MacBook to Cart
        WebElement macBook = new WebDriverWait(driver,10).until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[text()='MacBook']/../../..//span[text()='Add to Cart']")));
        macBook.click();
        presentationSleep();

        //Verify that success message about MacBook added to the cart is displayed
        WebElement macBookAddedToTheCartSuccessMessage = new WebDriverWait(driver,10).until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']/a[contains(text(),'MacBook')]")));
        macBookAddedToTheCartSuccessMessage.isDisplayed();

        // Find iPhone 3
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).clear();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iPhone 3");
        presentationSleep();

        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();    //click on Search button
        presentationSleep();

        //Add iPhone 3 to Favorite
        WebElement iPhone3AddToWishList = new WebDriverWait(driver,10).until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[text()='iPhone 3']/../../"
                        + "following-sibling::div[@class='button-group']/button[@type='button']"
                        + "/i[@class='fa fa-heart']")));
        iPhone3AddToWishList.click();

        //Verify that success message about iPhone added to the favorite is displayed
        WebElement iPhone3AddedToWishListSuccessMessage = new WebDriverWait(driver,10).until(ExpectedConditions.
                visibilityOfElementLocated(By.
                        xpath("//div[@class='alert alert-success']/a[contains(text(),'iPhone 3')]"
                                + "/following-sibling::a[contains(text(),'wish list')]")));
        iPhone3AddedToWishListSuccessMessage.isDisplayed();

    }
}
