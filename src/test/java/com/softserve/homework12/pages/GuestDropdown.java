package com.softserve.homework12.pages;


import com.softserve.homework12.tools.search.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestDropdown {

    private WebDriver driver;
    protected Search search;
    //
    private WebElement register;
    private WebElement login;

    public GuestDropdown(WebDriver driver) {
        //public GuestDropdown() {
        this.driver = driver;
        //search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        register = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]"));
        login = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/login')]"));
        //
//        register = search.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]");
//        login = search.xpath("//div[@id='top-links']//a[contains(@href,'account/login')]");
    }

    // Page Object

    // register
    public WebElement getRegister() {
        // return driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]"));
        return register;
    }

    public String getRegisterText() {
        return getRegister().getText();
    }

    public void clickRegister() {
        getRegister().click();
    }

    // login
    public WebElement getLogin() {
        return login;
    }

    public String getLoginText() {
        return getLogin().getText();
    }

    public void clickLogin() {
        getLogin().click();
    }

    // Functional

    // Business Logic

}