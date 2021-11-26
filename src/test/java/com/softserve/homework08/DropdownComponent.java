package com.softserve.homework08;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Ignore

public class DropdownComponent {

    private WebDriver driver;

    private WebElement currencyeuro;
    private WebElement currencydollar;
    private WebElement currencypound;


    public DropdownComponent (WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        currencyeuro = driver.findElement(By.xpath("//button[@name='EUR']"));
        currencydollar = driver.findElement(By.xpath("//button[@name='USD']"));
        currencypound = driver.findElement(By.xpath("//button[@name='GBP']"));
    }

    // Page Object

    // currency euro
    public WebElement getCurrencyeuro() {
        // return driver.findElement(By.xpath("//button[@name='EUR']"));
        return getCurrencyeuro();
    }

    public String getCurrencyeuroText() {
        return getCurrencyeuro().getText();
    }

    public void clickCurrencyeuro() {
        getCurrencyeuro().click();
    }

    // currency dollar
        public WebElement getCurrencydollar() {
            // return driver.findElement(By.xpath("//button[@name='USD']"));
            return getCurrencydollar();
        }

        public String getCurrencydollarText() {
            return getCurrencydollar().getText();
        }

        public void clickCurrencydollar() {
            getCurrencydollar().click();
        }

    // currency pound
    public WebElement getCurrencypound() {
        // return driver.findElement(By.xpath("//button[@name='GBP']"));
        return getCurrencypound();
    }

    public String getCurrencydollarText() {
        return getCurrencypound().getText();
    }

    public void clickCurrencypound() {
        getCurrencypound().click();
    }



}



