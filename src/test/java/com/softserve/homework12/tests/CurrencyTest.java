package com.softserve.homework12.tests;


import com.softserve.homework12.data.Currencies;
import com.softserve.homework12.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CurrencyTest extends TestRunner {

    @DataProvider//(parallel = true)
    public Object[][] searchCurrencies() {
        return new Object[][] {
                { Currencies.EURO },
                { Currencies.POUND_STERLING },
                { Currencies.US_DOLLAR },
        };
    }

    @Test(dataProvider = "searchCurrencies")
    public void checkFirst(Currencies currency) {
        //
        // Steps
        HomePage homePage = loadApplication()
                .chooseCurrency(currency)
                .getCurrencyText()
        //.scrollToProduct(searchProduct.getProduct());
        //
        // Check
        Assert.assertTrue(homePage.getCurrencyText().contains("€"));
        Assert.assertTrue(homePage.getCurrencyText().contains("£"));
        Assert.assertTrue(homePage.getCurrencyText().contains("$"));

        //

    }
}
