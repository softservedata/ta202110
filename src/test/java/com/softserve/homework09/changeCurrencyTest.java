package com.softserve.homework09;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.test.TestRunner;

public class changeCurrencyTest extends TestRunner {

    @DataProvider
    public Object[][] dataCurrencies() {
        return new Object[][] { 
            { Currencies.EURO },
        };
    }
    
    @Test(dataProvider = "dataCurrencies")
    public void changeCurrency(Currencies currency) {
      
        HomePage homePage = loadApplication()
                .chooseCurrency(currency);

        Assert.assertTrue(homePage.getCurrencyText().contains("€"));
    }
}
