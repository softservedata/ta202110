package com.softserve.homework12;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite SecondTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite SecondTest");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t@BeforeTest SecondTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\t@AfterTest SecondTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t@BeforeClass SecondTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t@AfterClass SecondTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t@BeforeMethod SecondTest, ThreadId = " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t@AfterMethod SecondTest, ThreadId = " + Thread.currentThread().getId());
    }

    @Test
    public void f1() {
        System.out.println("\t\t\t\t@Test f1() SecondTest, ThreadId = " + Thread.currentThread().getId());
    }

    @Test
    public void f2() {
        System.out.println("\t\t\t\t@Test f2() SecondTest, ThreadId = " + Thread.currentThread().getId());
    }

    @Test
    public void f3() {
        System.out.println("\t\t\t\t@Test f3() SecondTest, ThreadId = " + Thread.currentThread().getId());
    }
}
