package com.softserve.homework11.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.homework11.opencart.data.IUser;
import com.softserve.homework11.opencart.data.UserRepository;
import com.softserve.homework11.opencart.pages.LoginPage;
import com.softserve.homework11.opencart.pages.UnsuccessfulLoginPage;

public class UnLoginTest extends TestRunner {

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][] {
            { UserRepository.get().notValidUser() },
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
        // Check
        UnsuccessfulLoginPage unsuccessfulLoginPage = new UnsuccessfulLoginPage(driver);
        Assert.assertTrue(unsuccessfulLoginPage.getAlertWarning().isDisplayed());
    }
    
}
