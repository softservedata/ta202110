package com.softserve.edu.HW8;

import com.softserve.edu.opencart.pages.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyDropdown extends TopPart {

    private WebDriver driver;

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

    public void clickEuro() {
        getEuro().click();
    }
    // PoundSterling
    public WebElement getPoundSterling() {
        return PoundSterling;
    }

    public String getPoundSterlingText() {
        return getPoundSterling().getText();
    }

    public void clickPoundSterling() {
        getPoundSterling().click();
    }
    // USDollar
    public WebElement getUSDollar() {
        return USDollar;
    }

    public String getUSDollarText() {
        return getUSDollar().getText();
    }

    public void clickUSDollar() {
        getUSDollar().click();
    }
}
