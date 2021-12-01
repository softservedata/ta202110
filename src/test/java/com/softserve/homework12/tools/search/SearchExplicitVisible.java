package com.softserve.homework12.tools.search;


import com.softserve.homework12.tools.browser.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchExplicitVisible extends Search {
    private final Long EXPLICITLY_WAIT_SECONDS = 10L;
    private WebDriverWait driverWait;

    public SearchExplicitVisible() {
        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driverWait = new WebDriverWait(DriverWrapper.getDriver(), Duration.ofSeconds(EXPLICITLY_WAIT_SECONDS));
    }

    protected WebDriverWait getDriverWait() {
        return driverWait;
    }

    @Override
    public WebElement getWebElement(By by) {
        return getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Override
    public WebElement getWebElement(By by, WebElement fromWebElement) {
        return getWebElements(by, fromWebElement).get(0);
    }

    @Override
    public List<WebElement> getWebElements(By by) {
        return getDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    @Override
    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        return getDriverWait().until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(fromWebElement, by));
    }

}