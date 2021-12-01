package com.softserve.homework08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.TopPart;

public class DropdownComponent extends TopPart {

    private WebDriver driver;
    //
    private WebElement currencyEUR;
    private WebElement currencyGBP;
    private WebElement currencyUSD;

    protected DropdownComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {

        currencyEUR = driver.findElement(By.xpath("//button[@name='EUR']"));
        currencyGBP = driver.findElement(By.xpath("//button[@name='GBP']"));
        currencyUSD = driver.findElement(By.xpath("//button[@name='USD']"));
    }

    // currency Euro
    public WebElement getCurrencyEUR() {
        return currencyEUR;
    }

    public String getCurrencyEURText() {
        return getCurrencyEUR().getText();
    }

    public void clickCurrencyEUR() {
        getCurrencyEUR().click();
    }

    // currency Pound Sterling
    public WebElement getCurrencyGBP() {
        return currencyGBP;
    }

    public String getCurrencyGBPText() {
        return getCurrencyGBP().getText();
    }

    public void clickCurrencyGBP() {
        getCurrencyGBP().click();
    }

    // currency US Dollar
    public WebElement getCurrencyUSD() {
        return currencyUSD;
    }

    public String getCurrencyUSDText() {
        return getCurrencyUSD().getText();
    }

    public void clickCurrencyUSD() {
        getCurrencyUSD().click();
    }
}