package com.softserve.homework09;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.test.TestRunner;

public class updateCurrency extends TestRunner {

    @DataProvider(parallel = true)
    public Object[][] searchCurrencies() {
        return new Object[][] {
                { Currencies.EURO },

        };
    }

    @Test(dataProvider = "searchCurrencies")
    public void checkCurrency(Currencies currency) {

        HomePage homePage = loadApplication()
                .chooseCurrency(currency);

        Assert.assertTrue(homePage.getCurrencyText().contains("€"));

    }
}
