package com.softserve.homework10.opencart.test;

import org.testng.annotations.Test;

import com.softserve.homework10.opencart.data.Currencies;
import com.softserve.homework10.opencart.pages.DropdownComponent;
import com.softserve.homework10.opencart.pages.HomePage;

import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class CurrencyTest extends TestRunner {
	
    @DataProvider
    public Object[][] selectCurrency() {
        return new Object[][] {
            { Currencies.EURO },
        };
    }
    
    @Test(dataProvider = "selectCurrency")
    public void checkCurrency(Currencies currency) {
    	
        HomePage homePage = loadApplication()
        		.gotoHomePage();
        homePage.clickCurrency();
        DropdownComponent dropdownComponent = new DropdownComponent(driver);
        dropdownComponent.chooseCurrency(currency);

        HomePage homePageReload = new HomePage(driver);    
        Assert.assertTrue(homePageReload.getCurrencyText().contains("€"));
    	presentationSleep();
    }

}
