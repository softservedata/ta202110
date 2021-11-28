package com.softserve.homework08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.TopPart;

public class CurrencyDropdown extends TopPart{

    private WebDriver driver;
    //
    private WebElement Euro;
    private WebElement PoundSterling;
    private WebElement USDollar;

    public CurrencyDropdown(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        Euro = driver.findElement(By.xpath("//button[@name='EUR']"));
        PoundSterling = driver.findElement(By.xpath("//button[@name='GBP']"));
        USDollar = driver.findElement(By.xpath("//button[@name='USD']"));
    }

    // Page Object

    // Euro
    public WebElement getEuro() {
        return Euro;
    }

    public String getEuroText() {
        return getEuro().getText();
    }

    public void selectEuro() {
        getEuro().click();
    }

    // Pound Sterling
    public WebElement getPoundSterling() {
        return PoundSterling;
    }

    public String getPoundSterlingText() {
        return getPoundSterling().getText();
    }

    public void selectPoundSterling() {
        getPoundSterling().click();
    }

    // US Dollar
    public WebElement getUSDollar() {
        return USDollar;
    }

    public String getUSDollarText() {
        return getUSDollar().getText();
    }

    public void selectUSDollar() {
        getUSDollar().click();
    }
}
