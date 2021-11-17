package com.softserve.homework05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginUseCssTest {

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
        System.out.println("print after");
        presentationSleep();

        driver.findElement(By.cssSelector("a[href*='route=account/account']")).click();     //open Account menu
        presentationSleep();
        driver.findElement(By.cssSelector("div#top-links a[href*='route=account/logout']")).click(); //open login page
        presentationSleep();
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
    public void LoginCss(){

        presentationSleep();

        driver.findElement(By.cssSelector("a[href*='route=account/account']")).click();     //open Account menu

        presentationSleep();

        driver.findElement(By.cssSelector("div#top-links a[href*='route=account/login']")).click(); //open login page

        presentationSleep();

        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email")).sendKeys("hahaha@gmail.com");  //enter an e-mail

        presentationSleep();

        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("qwerty");    //enter password

        presentationSleep();

        driver.findElement(By.cssSelector("input[type='submit']")).click();   //Click on Login button


        presentationSleep();

        //Verify that user is logged in
        WebElement LogoutButton = driver.findElement(By.cssSelector("a[href*='account/edit']"));
        Assert.assertTrue(LogoutButton.getText().contains("Edit your account information"));
        System.out.println("Logged in successfully! There is '" + LogoutButton.getText() + "' button");

    }
}
