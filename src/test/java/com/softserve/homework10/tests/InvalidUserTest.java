package com.softserve.homework10.tests;

import com.softserve.homework10.data.IUser;
import com.softserve.homework10.data.UserRepository;
import com.softserve.homework10.pages.EditAccountPage;
import com.softserve.homework10.pages.UnsuccessfulLoginPage;
import com.softserve.homework10.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class InvalidUserTest extends TestRunner {

        private HomePage homePage;
        private UnsuccessfulLoginPage unsuccessfulLoginPage;

    @DataProvider
    public Object[][] dataFailed() {
        return new Object[][] {
                { UserRepository.get().getAwdrt() },
        };
    }

    @Test(dataProvider = "dataFailed")
    public void checkFailed(IUser user) {
        //
        // Steps
        EditAccountPage editAccountPage = loadApplication()
                .gotoLoginPage()
                .failedLogin(user)
                .gotoEditAccountRight();

        // Check
        Assert.assertEquals(editAccountPage.getFirstNameFieldText(), user.getFirstname());

        // Return to Previous State
       HomePage homePage = editAccountPage
                .gotoLogoutRight()
                .gotoContinue();
        //
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }
}
