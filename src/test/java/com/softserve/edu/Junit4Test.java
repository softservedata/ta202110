package com.softserve.edu;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class Junit4Test {
    private int number;

    public Junit4Test(int number) {
        this.number = number;
        System.out.println("Constructor Junit4Test() done");
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
            { 1 }, { 2 }, { 3 }, { 4 }
        };
        return Arrays.asList(data);
    }

    @Test
    public void pushTest() {
        System.out.println("Parameterized Number is : " + number);
    }
}
