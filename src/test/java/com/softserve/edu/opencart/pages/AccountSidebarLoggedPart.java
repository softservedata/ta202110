package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarLoggedPart extends AccountSidebarPart {

    private WebElement editAccountRight;
    private WebElement passwordRight;
    private WebElement logoutRight;

    public AccountSidebarLoggedPart(WebDriver driver) {
        super(driver);
        initElements();
        //ApplicationStatus.get().setLogged(true);
    }

    private void initElements() {
        // init elements
        editAccountRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/edit')]"));
        passwordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/password')]"));
        logoutRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/logout')]"));
    }

    // Page Object

    // editAccountRight
    public WebElement getEditAccountRight() {
        return editAccountRight;
    }

    public String getEditAccountRightText() {
        return getEditAccountRight().getText();
    }

    public void clickEditAccountRight() {
        getEditAccountRight().click();
    }

    // passwordRight
    public WebElement getPasswordRight() {
        return passwordRight;
    }

    public String getPasswordRightText() {
        return getPasswordRight().getText();
    }

    public void clickPasswordRight() {
        getPasswordRight().click();
    }

    // logoutRight
    public WebElement getLogoutRight() {
        return logoutRight;
    }

    public String getLogoutRightText() {
        return getLogoutRight().getText();
    }

    public void clickLogoutRight() {
        getLogoutRight().click();
    }

    // Functional

    // Business Logic

    public EditAccountPage gotoEditAccountRight() {
        clickEditAccountRight();
        return new EditAccountPage(driver);
    }

    public AccountLogoutPage gotoLogoutRight() {
        clickLogoutRight();
        return new AccountLogoutPage(driver);
    }

    public MyAccountPage gotoMyAccountRight() {
        clickMyAccountRight();
        return new MyAccountPage(driver);
    }

}
