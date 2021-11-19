package com.softserve.homework10;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.EditAccountPage;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.test.TestRunner;

public class InvalidLoginTest extends TestRunner {

	UnsuccessfulLoginPage unsuccessfulLoginPage;
	
    @DataProvider
    public Object[][] dataUnSuccessful() {
        return new Object[][] {
            { UserRepository.get().getInvalidUser() },
        };
    }
    
    @Test(dataProvider = "dataUnSuccessful")
    public void checkUnSuccessful(IUser user) {
  
       UnsuccessfulLoginPage unSuccessfulLoginPage = 
    	        loadApplication()
                .gotoLoginPage()
                .unsuccessfulLoginPage(user);
      
       Assert.assertEquals(unSuccessfulLoginPage.getAlertWarningText(), UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE );
          
    }
    
}
