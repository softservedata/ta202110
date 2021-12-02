package com.softserve.edu.opencart.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.softserve.edu.opencart.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestRunner {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    //private WebDriver driver;
    private Map<Long, WebDriver> drivers = new HashMap<>();

    protected void presentationSleep() {
        presentationSleep(1);
    }

    protected void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void takeScreenShot(String testname) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + currentTime + "_" + testname + "_screenshot.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void takePageSource(String testname) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = getDriver().getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_" + testname + "_source.html");
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected WebDriver getDriver() {
        WebDriver driver = drivers.get(Thread.currentThread().getId());
        //
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
            //driver.manage().window().maximize();
            drivers.put(Thread.currentThread().getId(), driver);
        }
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() {
        // System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        /*-
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
        */
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        //driver.quit();
        for (Map.Entry<Long, WebDriver> driverEntry : drivers.entrySet()) {
            if (driverEntry.getValue() != null) {
                driverEntry.getValue().quit();
            }
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        //driver.get(BASE_URL);
        getDriver().get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            // Take Screenshot, Save sourceCode, Save to log, Prepare report, Return to previous state, logout, etc.
            // driver.manage().deleteAllCookies();
            // clear cache; delete cookie; delete session;
            takeScreenShot(testName);
            takePageSource(testName);
            // driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete
            // session;
        }
        //driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //driver.findElement(By.cssSelector("#logo > a")).click();
        //driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]/..")).click();
        presentationSleep(); // For Presentation ONLY
    }

    protected HomePage loadApplication() {
        //return new HomePage(driver);
        return new HomePage(getDriver());
    }
}