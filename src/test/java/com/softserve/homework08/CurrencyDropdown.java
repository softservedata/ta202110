package com.softserve.homework08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.TopPart;

public class CurrencyDropdown extends TopPart{

    private WebDriver driver;
    //
    private WebElement euro;
    private WebElement poundSterling;
    private WebElement usDollar;

    public CurrencyDropdown(WebDriver driver) {
    	super(driver);
        initElements();
    }

    private void initElements() {
        euro = driver.findElement(By.xpath("//button[contains(text(),'Euro')]"));
        poundSterling = driver.findElement(By.xpath("//button[contains(text(),'Pound Sterling')]"));
        usDollar = driver.findElement(By.xpath("//button[contains(text(),'US Dollar')]"));
    }

    // Page Object

    // Euro
    public WebElement getEuro() {
        return euro;
    }

    public String getEuroText() {
        return getEuro().getText();
    }

    public void selectEuro() {
        getEuro().click();
    }

    // Pound Sterling
    public WebElement getPoundSterling() {
        return poundSterling;
    }

    public String getPoundSterlingText() {
        return getPoundSterling().getText();
    }

    public void selectPoundSterling() {
    	getPoundSterling().click();
    }

    // US Dollar
    public WebElement getUSDollar() {
        return usDollar;
    }

    public String getUSDollarText() {
        return getUSDollar().getText();
    }

    public void selectUSDollar() {
    	getUSDollar().click();
    }

    // Functional

    // Business Logic

}
