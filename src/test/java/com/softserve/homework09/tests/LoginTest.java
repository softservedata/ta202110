package com.softserve.homework09.tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.homework09.data.IUser;
import com.softserve.homework09.data.UserRepository;
import com.softserve.homework09.pages.EditAccountPage;
import com.softserve.homework09.pages.HomePage;

public class LoginTest extends TestRunner {

    /*-
    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][] {
            { "xdknxusqvjeovowpfk@awdrt.com", "awdrt123", "my" },
            { "hahaha@gmail.com", "qwerty", "hahaha" },
        };
    }
    */

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][] {
                //{ UserRepository.get().getHahaha() },
                { UserRepository.get().getAwdrt() },
        };
    }

    @Test(dataProvider = "dataSuccessful")
    public void checkSuccessful(IUser user) {
        //
        // Steps
        EditAccountPage editAccountPage = loadApplication()
                .gotoLoginPage()
                //.successfulLogin(email, password)
                .successfulLogin(user)
                .gotoEditAccountRight();
        presentationSleep();
        //
        // Check
        //Assert.assertEquals(editAccountPage.getFirstNameFieldText(), firstName);
        Assert.assertEquals(editAccountPage.getFirstNameFieldText(), user.getFirstname());
        //
        // Return to Previous State
        HomePage homePage = editAccountPage
                .gotoContinue() // optional
                .gotoLogoutRight()
                .gotoContinue();
        //
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
    }

}
