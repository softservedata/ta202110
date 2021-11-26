package com.softserve.edu.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.EditAccountPage;
import com.softserve.edu.opencart.pages.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Owner(value = "OWNER First name")
@Epic("EPIC AllureTest")
@Feature("FEATURE SearchAllureTes")
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
            { UserRepository.get().getHahaha() },
            //{ UserRepository.get().getAwdrt() },
        };
    }
    
    @Description("TEST DESCRIPTION: class SearchAllureTest; findByXPath().")
    @Severity(SeverityLevel.BLOCKER)
    @Story("STORY SearchAllureTest")
    @Issue("SSITAGT-1")
    @Link(name = "LINK goto site", url = "http://taqc-opencart.epizy.com/?i=1")
    @TmsLink(value = "TL-678")
    //
    @Test(dataProvider = "dataSuccessful")
    public void checkSuccessful(IUser user) {
        logger.info("Test checkSuccessful(), user = " + user + " started");
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
