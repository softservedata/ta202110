package com.softserve.edu;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTest6 {

    @BeforeClass
    public void beforeClass(ITestContext context) {
        // From testNG.xml
        System.out.println("\t\t+++class TestNGTest6 @BeforeClass");
        for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
            System.out.println("\t\t*** parameter: key=" + entry.getKey() + " value=" + entry.getValue());
        }
    }

    @Test
    @Parameters(value = "number")
    public void parameterIntTest(int number) {
        // From testNG.xml
        System.out.println("Parameterized Number is: " + (number + 1));
    }

    @Test
    public void checkApp() {
        // From Maven
        System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
        // From OS
        System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
    }
}