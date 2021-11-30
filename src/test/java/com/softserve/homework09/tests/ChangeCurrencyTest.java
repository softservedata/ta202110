package com.softserve.homework09.tests;

import com.softserve.homework09.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestRunner {

    private HomePage homePage;
    private DropdownComponent1 dropdownComponent1;
    private TopPart topPart;

    @DataProvider
    public Object[][] currencychosen() {
        return new Object[][] {

                { dropdownComponent1.clickCurrency(); },
        };
    }

    @Test(dataProvider = "currencychosen")
    public void checkSuccessful(DropdownComponent1 currency) {
        //
        // Steps
        HomePage gotoHomePage = loadApplication()
                .gotoLoginPage()
                .wait(10)
                .openDropdown()
                /*.getDropdown()
                .clickDropdown()
                .chooseCurrency(currency)
                .getCurrency()
                .getCurrencyText()
                .clickCurrency(currency)*/
                .chooseCurrency()
                .gotoHomePage();



        Assert.assertEquals(dropdownComponent1.getDropdown().wait().getCurrency().getCurrencyText());
       

   }

}
