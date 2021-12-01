package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountLogoutPage extends AccountSidebarGuestPart {

    private WebElement continueButton;

    public AccountLogoutPage(WebDriver driver) {
        super(driver);
        initElements();
        //ApplicationStatus.get().setLogged(false);
    }

    private void initElements() {
        continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary[href*='common/home']"));
    }

    // Page Object

    // continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional

    // Business Logic

    public HomePage gotoContinue() {
        clickContinueButton();
        return new HomePage(driver);
    }

}
