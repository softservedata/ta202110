package com.softserve.homework12.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {

	public static final String EXPECTED_IPHONE6 = "iPhone6";
    //
    private WebElement slideshow0;
    private WebElement addButtonMacBook;
    private WebElement priceMacBook;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        slideshow0 = driver.findElement(By.id("slideshow0"));
        addButtonMacBook = driver.findElement(By.xpath("//a[.='MacBook']//..//..//..//button[contains(@onclick, 'cart.add')]"));
        priceMacBook = driver.findElement(By.xpath("//a[.='MacBook']//..//..//p[@class='price']"));
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

    // MacBook
	public WebElement getAddButtonMacBook() {
		return addButtonMacBook;
	}
	
    public WebElement getPriceMacBook() {
		return priceMacBook;
	}
    
    public String getPriceMacBookText() {
		return priceMacBook.getText().split("\n")[0];
		
	}
    
    // Functional

    // Business Logic
}
