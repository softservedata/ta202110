package com.softserve.homework09.tests;

import com.softserve.homework09.pages.HomePage;
import com.softserve.homework09.pages.EditAccountPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softserve.homework09.pages.DropdownComponent1;

public class ChangeCurrencyTest extends TestRunner {

    private HomePage homePage;
    private DropdownComponent1 dropdownComponent1;

    @DataProvider
    public Object[][] currencychosen() {
        return new Object[][] {

                { dropdownComponent1.getCurrency() },
        };
    }

    @Test(dataProvider = "currencychosen")
    public void checkSuccessful(DropdownComponent1 currency) {
        //
        // Steps
        ClickCurrency clickCurrency = setCurrency()
                .gotoHomePage()
                .successfulCurrencyclick(currency)
                .successfulChoice(EURO)
                .gotoHomePage();


        // Check
        HomePage homePage = editAccountPage
        .gotoLogoutRight()
        .gotoContinue();


        Assert.assertEquals(dropdownComponent1.getCurrencyText());
       
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
     
}

    private DropdownComponent1 setCurrency() {
    }

/
}
