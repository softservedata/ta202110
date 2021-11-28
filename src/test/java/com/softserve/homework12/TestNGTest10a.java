package com.softserve.homework12;

import org.testng.annotations.Test;

public class TestNGTest10a {
    @Test(priority = 3)
    public void method1() {
        System.out.println("This is method 1");
    }

    @Test(priority = 1)
    public void method2() {
        System.out.println("This is method 2");
    }

    @Test(priority = 2)
    public void method3() {
        System.out.println("This is method 3");
        //throw new RuntimeException("ha-ha-ha");
    }
}
