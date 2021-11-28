package com.softserve.edu;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    // Overload
    private void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
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
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
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
    public void afterMethod() {
        presentationSleep(); // For Presentation ONLY
        // logout; clear cache; delete cookie; delete session;
        // Save Screen;
    }

    @Test
    public void loginByCss() throws Exception {
        // Precondition
        // Click My Account Button
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        presentationSleep(); // For Presentation Only
        // Click login Button
        driver.findElement(By.cssSelector("#top-links a[href*='account/login']")).click();
        presentationSleep(); // For Presentation Only
        //
        // Steps
        // Type Login Email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email")).sendKeys("hahaha@gmail.com");
        presentationSleep(); // For Presentation Only
        //
        // Type Password
        // driver.findElement(By.id("input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password")).sendKeys("qwerty");
        presentationSleep(); // For Presentation Only
        //
        // Click Login Button
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        presentationSleep(); // For Presentation Only
        //
        // Goto Edit Account
        driver.findElement(By.cssSelector("#column-right a[href*='account/edit']")).click();
        presentationSleep(); // For Presentation Only
        //
        // Read Email WebElement
        // WebElement price = driver.findElement(By.id("input-email"));
        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        presentationSleep(); // For Presentation Only
        //
        // Check
        Assert.assertEquals("hahaha@gmail.com", email.getAttribute("value"));
        //
        // Return to Previous State
        // Click My Account Button
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        presentationSleep(); // For Presentation Only
        // Click Logout Button
        driver.findElement(By.cssSelector("#top-links a[href*='account/logout']")).click();
        presentationSleep(); // For Presentation Only
        // Click Continue Button
        driver.findElement(By.cssSelector("#content a[href*='common/home']")).click();
        presentationSleep(); // For Presentation Only
    }

}
