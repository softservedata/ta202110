package com.softserve.edu.homework8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyComponent {

    private WebDriver driver;
    private WebElement euroCurrency;
    private WebElement dollarCurrency;
    private WebElement poundCurrency;

    protected CurrencyComponent(WebDriver driver)
    {
        this.driver = driver;
        initElements();
    }
    private void initElements ()
    {
        euroCurrency = driver.findElement(By.xpath("//button[@name = 'EURO']"));
        dollarCurrency = driver.findElement(By.xpath("//button[@name = 'USD']"));
        poundCurrency = driver.findElement(By.xpath("//button[@name = 'GBP']"));
    }
    //EURO
    public void selectEuro (){
        euroCurrency.click();
    }
    //USD
    public void selectDollar (){
        dollarCurrency.click();
    }
    //GBP
    public void selectPound (){
        poundCurrency.click();
    }

}
