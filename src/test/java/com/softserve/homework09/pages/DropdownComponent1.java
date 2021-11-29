package com.softserve.homework09.pages;

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

    // currency1
    public static WebElement getCurrency1() {
        return getCurrency1();
    }

    public static String getCurrency1Text() {
        return getCurrency1().getText();
    }

    public void clickCurrency1() { getCurrency1().click();}

    // currency1
    public static WebElement getCurrency2() {
        return getCurrency2();
    }

    public static String getCurrency2Text() {
        return getCurrency2().getText();
    }

    public void clickCurrency2() {
        getCurrency2().click();
    }




}



