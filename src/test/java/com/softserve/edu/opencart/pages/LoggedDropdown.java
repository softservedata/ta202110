package com.softserve.edu.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.search.Search;
import com.softserve.edu.opencart.tools.search.SearchStrategy;

public class LoggedDropdown {

    //private WebDriver driver;
    protected Search search;
    //
    private WebElement myAccount;
    private WebElement orderHistory;
    private WebElement transactions;
    private WebElement downloads;
    private WebElement logout;

    //protected LoggedDropdown(WebDriver driver) {
    protected LoggedDropdown() {
        //this.driver = driver;
        search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
//        myAccount = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/account')]"));
//        orderHistory = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/order')]"));
//        transactions = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/transaction')]"));
//        downloads = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/download')]"));
//        logout = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/logout')]"));
        //
        myAccount = search.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/account')]");
        orderHistory = search.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/order')]");
        transactions = search.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/transaction')]");
        downloads = search.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/download')]");
        logout = search.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'account/logout')]");
    }

    // Page Object

    // myAccount
    public WebElement getMyAccount() {
        return myAccount;
    }

    public String getMyAccountText() {
        return getMyAccount().getText();
    }

    public void clickMyAccount() {
        getMyAccount().click();
    }

    // orderHistory
    public WebElement getOrderHistory() {
        return orderHistory;
    }

    public String getOrderHistoryText() {
        return getOrderHistory().getText();
    }

    public void clickOrderHistory() {
        getOrderHistory().click();
    }

    // transactions
    public WebElement getTransactions() {
        return transactions;
    }

    public String getTransactionsText() {
        return getTransactions().getText();
    }

    public void clickTransactions() {
        getTransactions().click();
    }

    // downloads
    public WebElement getDownloads() {
        return downloads;
    }

    public String getDownloadsText() {
        return getDownloads().getText();
    }

    public void clickDownloads() {
        getDownloads().click();
    }

    // logout
    public WebElement getLogout() {
        return logout;
    }

    public String getLogoutText() {
        return getLogout().getText();
    }

    public void clickLogout() {
        getLogout().click();
    }

    // Functional

    // Business Logic

}
