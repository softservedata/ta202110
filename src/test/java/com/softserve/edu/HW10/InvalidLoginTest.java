package com.softserve.edu.HW10;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.test.TestRunner;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.LoginPage;
import com.softserve.edu.opencart.pages.UnsuccessfulLoginPage;

public class InvalidLoginTest extends TestRunner {

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][]{
                {UserRepository.get().getInvalidUser()},
        };
    }

    @Test(dataProvider = "dataSuccessful")
    public void checkSuccessful(IUser user) {
        //
        // Steps
        LoginPage loginPage = loadApplication()
                .gotoLoginPage();
        loginPage.unsuccessfulLoginPage(user);
        presentationSleep();
        //
        // Verify
        UnsuccessfulLoginPage unsuccessfulLoginPage = new UnsuccessfulLoginPage(driver);
        Assert.assertTrue(unsuccessfulLoginPage.getAlertWarning().isDisplayed());
    }
}
