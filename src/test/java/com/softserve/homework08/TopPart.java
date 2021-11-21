package com.softserve.homework08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TopPart {

	private WebDriver driver;
	private WebElement currency;

	public TopPart(WebDriver driver) {
		this.driver = driver;
		initElements();
	}
	
	private void initElements( ) {
		currency = driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
	}
	
	public WebElement getCurrency() {
		return currency;
	}

    public String getCurrencyText() {
        return getCurrency().getText();
    }

    public void clickCurrency() {
        getCurrency().click();
    }
}
