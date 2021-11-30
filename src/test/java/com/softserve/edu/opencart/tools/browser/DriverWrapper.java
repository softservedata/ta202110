package com.softserve.edu.opencart.tools.browser;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public final class DriverWrapper {
    //
    //private static WebDriver driver;
    private static Map<Long, WebDriver> drivers = new HashMap<>();

    private DriverWrapper() {
    }
    
    public static WebDriver setDriver(Browsers browser) {
        //System.out.println("setDriver()  browser = " + browser.name());
        //driver = browser.runBrowser();
        drivers.put(Thread.currentThread().getId(), browser.runBrowser());
        return drivers.get(Thread.currentThread().getId());
    }
    
    public static WebDriver getDriver() {
        //System.out.println("****ID Thread = " + Thread.currentThread().getId());
        WebDriver driver = drivers.get(Thread.currentThread().getId());
        //if (driver == null) {
        //    System.out.println("****driver == null ****ID Thread = " + Thread.currentThread().getId());
        //}
        //
        if (driver == null) {
            driver = setDriver(Browsers.DEFAULT_TEMPORARY);
        }
        return driver;
    }
    
    public static void getUrl(String url) {
        getDriver().get(url);
    }
    
    public static void deleteCookies() {
        getDriver().manage().deleteAllCookies();
    }
    
    public static void quit() {
//        if (driver != null) {
//            driver.quit();
//        }
        for (Map.Entry<Long, WebDriver> driverEntry : drivers.entrySet()) {
            if (driverEntry.getValue() != null) {
                driverEntry.getValue().quit();
            }
        }
    }
    
}
