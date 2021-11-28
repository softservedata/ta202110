package com.softserve.edu.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.EditAccountPage;
import com.softserve.edu.opencart.pages.HomePage;

public class RegisterTest extends TestRunner {

    @DataProvider
    public Object[][] dataRegister() {
        return new Object[][] {
            { UserRepository.get().getNewUser() },
        };
    }

    @Test(dataProvider = "dataRegister")
    public void checkRegister(User newValidUser) {
        //
        // TODO
        //
        // Precondition
        System.out.println("\nCreate new User:\n" + newValidUser);
        // LOG
        //
        // Steps
        EditAccountPage editAccountPage = loadApplication()
                .gotoRegisterPage()
                .successfullRegisterUser(newValidUser)
                .continueMyAccountPage()
                .gotoEditAccountRight();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstNameFieldText(), newValidUser.getFirstname());
        //
        // Steps
        HomePage homePage = editAccountPage
                .gotoContinue()
                .gotoLogoutRight()
                .gotoContinue();
        //
        // Check
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
        //
        // Steps
        editAccountPage = homePage.gotoLoginPage()
                //.successfulLogin(newValidUser.getEmail(), newValidUser.getPassword())
                .successfulLogin(newValidUser)
                .gotoEditAccountRight();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstNameFieldText(),
                newValidUser.getFirstname());
        //
        // Return to previous state
        // Steps
        homePage = editAccountPage
                .gotoContinue()
                .gotoLogoutRight()
                .gotoContinue();
        //
        // Check
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
        //
        // Return to previous state
    }

}
