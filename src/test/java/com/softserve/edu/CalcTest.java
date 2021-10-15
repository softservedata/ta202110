package com.softserve.edu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class CalcTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeAll setUpBeforeClass()");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("@AfterAll tearDownAfterClass()");
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("\t@BeforeEach setUp()");
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("\t@AfterEach tearDown()");
    }

    @Test
    void testAdd1() {
        System.out.println("\t\t@Test testAdd1()");
        /*-
        //int i = 0;
        double i = 0;
        i = 10 / i;
        System.out.println("\t\t\ti = " + i);
        */
        //fail("Not yet implemented");
        //
        Calc calc = new Calc();
        double actual;
        double expected;
        //
        expected = 10;
        actual = calc.add(5, 5);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void testAdd2() {
        System.out.println("\t\t@Test testAdd2()");
        //
        Calc calc = new Calc();
        double actual;
        double expected;
        //
        expected = 10;
        actual = calc.add(6, 4);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void testDiv1() {
        System.out.println("\t\t@Test testDiv1()");
        Calc calc = new Calc();
        double actual;
        double expected;
        //
        expected = 4;
        actual = calc.div(20, 5);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void testDiv2() {
        System.out.println("\t\t@Test testDiv2()");
        Calc calc = new Calc();
        double actual;
        double expected;
        //
        expected = 2.5;
        actual = calc.div(20, 8);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void testDiv3() {
        int i = 0;
        //double i = 0;
        Assertions.assertThrows(ArithmeticException.class, () -> { int k = 0 / i; });
        //i = 0 / i;
        System.out.println("\t\t\ti = " + i);
    }
}
