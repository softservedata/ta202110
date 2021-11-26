package com.softserve.homework09.tests;

import com.softserve.homework09.data.Currency;
import com.softserve.homework09.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.softserve.homework09.pages.DropdownComponent1;

public class ChangeCurrency {

    @Test(dataProvider = "currencychosen")
    public void checkSuccessful(Currency currency) {
        //
        // Steps
        ChooseCurrency chooseCurrency = makechoice()
                .gotoHomePage()
                .successfulCurrencyclick(dollar, euro, pound)
                .successfulChoice(currency)
                .gotoHomePage();

        //
        // Check
        
        Assert.assertEquals(chooseCurrency.getCurrencyText());
       
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
     
}
