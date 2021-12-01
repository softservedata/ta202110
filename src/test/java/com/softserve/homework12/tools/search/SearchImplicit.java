package com.softserve.homework12.tools.search;


import com.softserve.homework12.tools.browser.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SearchImplicit extends Search {
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;

    public SearchImplicit() {
        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
    }

    @Override
    public WebElement getWebElement(By by) {
        return DriverWrapper.getDriver().findElement(by);
    }

    @Override
    public WebElement getWebElement(By by, WebElement fromWebElement) {
        return fromWebElement.findElement(by);
    }

    @Override
    public List<WebElement> getWebElements(By by) {
        return DriverWrapper.getDriver().findElements(by);
    }

    @Override
    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        return fromWebElement.findElements(by);
    }

}
