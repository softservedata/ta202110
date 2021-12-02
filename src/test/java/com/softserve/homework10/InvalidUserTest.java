package com.softserve.homework10;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.test.TestRunner;

public class InvalidUserTest extends TestRunner {


    @DataProvider
    public Object[][] dataUnsuccessful() {
        return new Object[][] {
                { UserRepository.get().getInvalidUser() },
        };
    }

    @Test(dataProvider = "dataUnsuccessful")
    public void checkUnsuccessfulLogin(IUser user) {

        UnsuccessfulLoginPage unsuccessfulLoginPage = loadApplication()
                .gotoLoginPage()
                .unsuccessfulLoginPage(user);


        Assert.assertTrue(unsuccessfulLoginPage.getAlertWarningText()
                .contains(UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE));

    }
}