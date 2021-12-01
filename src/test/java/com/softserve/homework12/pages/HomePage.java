package com.softserve.homework12.pages;


import com.softserve.homework12.data.Currencies;
import com.softserve.homework12.data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TopPart {

    public static final String EXPECTED_IPHONE6 = "iPhone6";
    //
    private WebElement slideshow0;
    //
    private ProductsContainer productsContainer;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
        productsContainer = new ProductsContainer(driver);
    }

    private void initElements() {
        // init elements
        slideshow0 = driver.findElement(By.id("slideshow0"));
    }

    // Page Object

    // slideshow0
    public WebElement getSlideshow0() {
        return slideshow0;
    }

    public WebElement getSlideshow0FirstImage() {
        // return getSlideshow0().findElement(By.cssSelector("a > img"));
        return getSlideshow0().findElement(By.xpath(".//a/img"));
        // return Slideshow0.findElement(By.xpath("//a/img")); // ERROR
        // return driver.findElement(By.xpath("//div[@id='slideshow0']//a/img"));
    }

    public String getSlideshow0FirstImageAttributeText(String attribute) {
        return getSlideshow0FirstImage().getAttribute(attribute).trim();
    }

    public String getSlideshow0FirstImageAttributeSrcText() {
        return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_SRC);
    }

    // productComponentsContainer
    public ProductsContainer getProductComponentsContainer() {
        return productsContainer;
    }

    // Functional

    // Business Logic

    //product
    public HomePage chooseCurrency(Currencies currency) {
        //logger.debug("start chooseCurrency() with currency = " + currency.toString());
        clickCurrencyByPartialName(currency);
        //logger.debug("end chooseCurrency() with currency = " + currency.toString());
        return new HomePage(driver);
    }

    public HomePage scrollToProduct(Product product) {
        WebElement webElement = getProductComponentsContainer()
                .getProductComponentByName(product.getName())
                .getName();
        scrollToElement(webElement);
        return new HomePage(driver);
    }

    //read price
    public HomePage readProductPrice(Product product){
        WebElement webElement = getProductComponentsContainer()
                .getProductComponentByName(product.getName())
                .getName();
                .wait()
                .getPartialDescriptionText(product.getPrice())
                .getPrice()
        scrollToElement(webElement);
        return new HomePage(driver);
    }

    //add to shopping cart
    public HomePage addProductToShoppingCart (Product product){
        WebElement webElement = getProductComponentsContainer()

                .getProductComponentByName()
                .getPrice()
                .addProductToCart(productsContainer.clickProductComponentAddToCartButtonByName(););




    }


}