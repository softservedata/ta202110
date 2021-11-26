package com.softserve.homework09.tests;

import com.softserve.homework09.data.Currency;
import com.softserve.homework09.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softserve.homework09.pages.DropdownComponent1;

public class ChangeCurrency {

    private HomePage homePage;

    @DataProvider
    public Object[][] currencychosen() {
        return new Object[][] {

                { DropdownComponent1.getCurrency() },
        };
    }

    @Test(dataProvider = "currencychosen")
    public void checkSuccessful(Currency currency) {
        //
        // Steps
        ClickCurrency clickCurrency = makechoice()
                .gotoHomePage()
                .successfulCurrencyclick(currency)
                .successfulChoice(euro)
                .gotoHomePage();


        // Check
        
        Assert.assertEquals(DropdownComponent1.getCurrencyText());
       
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
     
}
}
