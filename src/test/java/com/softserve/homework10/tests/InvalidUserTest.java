package com.softserve.homework10.tests;

import com.softserve.homework10.data.IUser;
import com.softserve.homework10.data.UserRepository;
import com.softserve.homework10.pages.EditAccountPage;
import com.softserve.homework10.pages.LoginPage;
import com.softserve.homework10.pages.UnsuccessfulLoginPage;
import com.softserve.homework10.data.IUser;
import com.softserve.homework10.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class InvalidUserTest extends TestRunner {

        private HomePage homePage;
        private UnsuccessfulLoginPage unsuccessfulLoginPage;
        private EditAccountPage editAccountPage;
        private LoginPage loginPage;

    @DataProvider
    public Object[][] dataFailed() {
        return new Object[][] {
                { UserRepository.get().getInvalidUser() },
        };
    }

    @Test(dataProvider = "dataFailed")
    public void UnsuccessfulLoginPage(IUser invalidUser) {
        //
        // Steps
        EditAccountPage editAccountPage = loadApplication()
                .gotoLoginPage()
                .unsuccessfulLoginPage(invalidUser);
                //.unsuccessfulLoginPage(IUser)
               // .gotoEditAccountRight();

        // Check
        Assert.assertEquals(unsuccessfulLoginPage.getAlertWarningText(), invalidUser.getFirstname());



    }
}
