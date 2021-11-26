package com.softserve.homework09.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownComponent1 {

    private WebDriver driver;

    private WebElement currency;



    public DropdownComponent1(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        currency = driver.findElement(By.xpath("//button[@name='EUR']"));

    }

    // Page Object

    // currency
    public WebElement getCurrency() {
        // return driver.findElement(By.xpath("//button[@name='EUR']"));
        return getCurrency();
    }

    public String getCurrencyText() {
        return getCurrency().getText();
    }

    public void clickCurrency() {
        getCurrency().click();
    }




}



