package com.softserve.homework11.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.homework11.opencart.data.IUser;
import com.softserve.homework11.opencart.data.UserRepository;
import com.softserve.homework11.opencart.pages.EditAccountPage;
import com.softserve.homework11.opencart.pages.HomePage;

public class LoginTest extends TestRunner {

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][] {
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
