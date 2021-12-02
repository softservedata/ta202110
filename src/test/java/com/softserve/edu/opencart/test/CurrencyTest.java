package com.softserve.edu.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.HomePage;

public class CurrencyTest extends TestRunner {

    @DataProvider//(parallel = true)
    public Object[][] searchCurrencies() {
        return new Object[][] {
                { Currencies.EURO },
                //{ Currencies.POUND_STERLING },
        };
    }

    @Test(dataProvider = "searchCurrencies")
    public void checkFirst(Currencies currency) {
        //
        // Steps
        HomePage homePage = loadApplication()
                //.chooseCurrency("US Dollar");
                .chooseCurrency(currency);
        //.scrollToProduct(searchProduct.getProduct());
        presentationSleep();
        //
        // Check
        Assert.assertTrue(homePage.getCurrencyText().contains("€"));
        //
        presentationSleep(4);
    }
}
