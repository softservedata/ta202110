package com.softserve.homework12;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest5 {

    @BeforeClass(groups = "method4")
    public void beforeClass() {
        System.out.println("\t\t@BeforeClass");
    }

    @BeforeMethod(groups = {"method1", "method4"})
    public void beforeMethod() {
        System.out.println("\t\t\t@BeforeMethod");
    }

    @Test(groups = "method1")
    public void testingMethod1() {
        System.out.println("Method - testingMethod1( )");
    }

    @Test(groups = "method2")
    public void testingMethod2() {
        System.out.println("Method - testingMethod2( )");
    }

    @Test(groups = "method1")
    public void testingMethod1_1() {
        System.out.println("Method - testingMethod1_1( )");
    }

    @Test(groups = "method4")
    public void testingMethod4() {
        System.out.println("Method - testingMethod4( )");
    }
}