package com.softserve.edu.sel;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchiPhon {
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;

    private static void presentationSleep() {
        presentationSleep(1);
    }

    private static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void checkiPhon() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        presentationSleep(); // For Presentation ONLY
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
        //
        // Choose Curency
        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        presentationSleep(); // For Presentation ONLY
        //driver.findElement(By.cssSelector("button[name='EUR']")).click();
        driver.findElement(By.name("EUR")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Steps
        //driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.name("search")).click();
        //driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.name("search")).clear();
        //driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
        driver.findElement(By.name("search")).sendKeys("iPhone");
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        WebElement price = driver
                .findElement(By.xpath("//a[text()='iPhone XR']/../following-sibling::p[@class='price']"));
        Assert.assertTrue(price.getText().contains("707.71"));
        System.out.println("***contains: " + price.getText());
        presentationSleep(); // For Presentation ONLY
        //
        driver.quit(); // close browser, stop server
    }
}

