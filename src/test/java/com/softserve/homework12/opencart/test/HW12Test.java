package com.softserve.homework12.opencart.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.homework12.opencart.data.Currencies;
import com.softserve.homework12.opencart.pages.DropdownComponent;
import com.softserve.homework12.opencart.pages.HomePage;

public class HW12Test extends TestRunner {
	
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
        homePageReload.getAddButtonMacBook().click();
        presentationSleep(1);
 
        Assert.assertTrue(homePageReload.getCartButtonText().contains("1 item(s) - 472.33€"));
    	presentationSleep();
    }

}
