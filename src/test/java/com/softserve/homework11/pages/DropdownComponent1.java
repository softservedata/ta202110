package com.softserve.homework11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownComponent1 {

    private WebDriver driver;

    private WebElement currency;
    private WebElement currency1;
    private WebElement currency2;


    public DropdownComponent1(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        currency = driver.findElement(By.xpath("//button[@name='EUR']"));
        currency1 = driver.findElement(By.xpath("//button[@name='USD']"));
        currency2 = driver.findElement(By.xpath("//button[@name='GBP']"));

    }

    // Page Object

    // currency
    public static WebElement getCurrency() {
        return getCurrency();
    }

    public static String getCurrencyText() {
        return getCurrency().getText();
    }

    public void clickCurrency() {
        getCurrency().click();
    }




}



