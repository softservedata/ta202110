package com.softserve.edu.HW9;

import com.softserve.edu.opencart.data.Currencies;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.HomePage;


import com.softserve.edu.opencart.test.TestRunner;

public class ChangeCurrencyTest extends TestRunner {

    @DataProvider
    public Object[][] selectCurrency() {
        return new Object[][] {
                {Currencies.EURO},
        };
    }
    @Test(dataProvider = "selectCurrency")
    public void checkCurrency(Currencies currency) {

        HomePage homePage = loadApplication()
                .gotoHomePage()
                .chooseCurrency(currency);


        Assert.assertTrue(homePage.getCurrencyText().contains("€"));

    }
}
