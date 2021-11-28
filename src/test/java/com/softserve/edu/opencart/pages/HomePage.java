package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Currencies;

public class HomePage extends TopPart {

    public static final String EXPECTED_IPHONE6 = "iPhone6";
    //
    private WebElement slideshow0;
    private WebElement priceMacBook;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        slideshow0 = driver.findElement(By.id("slideshow0"));
        priceMacBook = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));
       
        
    }

    // Page Object

    // slideshow0
    public WebElement getSlideshow0() {
        return slideshow0;
    }

    public WebElement getSlideshow0FirstImage() {
        return getSlideshow0().findElement(By.xpath(".//a/img"));
    }

    public String getSlideshow0FirstImageAttributeText(String attribute) {
        return getSlideshow0FirstImage().getAttribute(attribute).trim();
    }

    public String getSlideshow0FirstImageAttributeSrcText() {
        return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_SRC);
    }

    // Functional

    // Business Logic
    
    //public HomePage chooseCurrency(String currency) {
    public HomePage chooseCurrency(Currencies currency) {
        clickCurrencyByPartialName(currency);
        return new HomePage(driver);
    }
    

    
    //  MacBook item
    public WebElement getPriceMacBook() {
		return priceMacBook;
	}
    
    public String getPriceMacBookText() {
    	return priceMacBook.getText();
		
	}
    
    public HomePage choosePriceMacBook() {
    	getPriceMacBookText();
        return new HomePage(driver);
    }
    
    public HomePage scrollToMacBook() {
        WebElement webElement = getPriceMacBook();
        scrollToElement(webElement);
        return new HomePage(driver);
    }

}
