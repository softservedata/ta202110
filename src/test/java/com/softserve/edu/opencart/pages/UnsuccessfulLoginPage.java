package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulLoginPage extends LoginPage {

    public static final String EXPECTED_LOGIN_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
    public static final String EXPECTED_LOCK_MESSAGE = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    //
    private WebElement alertWarning;

    public UnsuccessfulLoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertWarning = driver.findElement(By.cssSelector(".alert.alert-danger"));
    }

    // Page Object

    // alertWarning
    public WebElement getAlertWarning() {
        return alertWarning;
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }

    // Functional

    // Business Logic

}
