package com.softserve.edu;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest4 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t@BeforeTest TestNGTest4 class");
    }

    @Test(timeOut = 1000)
    public void infinity() {
        long current = System.currentTimeMillis();
        long start = current;
        long print = current;
        while (current - start < 1000) {
            current = System.currentTimeMillis();
            if (current - print > 100) {
                print = current;
                System.out.println("Time = " + (current - start));
            }
        }
    }
}
