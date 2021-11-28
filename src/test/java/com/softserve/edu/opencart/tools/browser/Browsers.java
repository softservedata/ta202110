package com.softserve.edu.opencart.tools.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//
// Factory method pattern
//

interface Browser {
    WebDriver getBrowser(); // Factory method
}

class FirefoxTemporary implements Browser {
    public WebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}

class FirefoxWithoutUI implements Browser {
    public WebDriver getBrowser() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }
}

class ChromeTemporary implements Browser {
    public WebDriver getBrowser() {
        //System.out.println("***ChromeTemporary START");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //return new ChromeDriver();
        return driver;
    }
}

class ChromeWithoutUI implements Browser {
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-proxy-server");
        options.addArguments("--ignore-certificate-errors");
        return new ChromeDriver(options);
    }
}

public enum Browsers {
    DEFAULT_TEMPORARY(new ChromeTemporary()),
    FIREFOX_TEMPORARY(new FirefoxTemporary()),
    FIREFOX_WITHOUTUI(new FirefoxWithoutUI()),
    CHROME_TEMPORARY(new ChromeTemporary()),
    CHROME_WITHOUTUI(new ChromeWithoutUI());
    //
    private Browser browser;

    private Browsers(Browser browser) {
        this.browser = browser;
    }

    public WebDriver runBrowser() {
        //WebDriver driver = browser.getBrowser();
        // TODO move to strategy
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        //return driver;
        return browser.getBrowser();
    }
}
