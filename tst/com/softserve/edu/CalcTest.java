package com.softserve.edu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
    private static Calc calc;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass setUpBeforeClass()");
        calc = new Calc();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("@AfterClass tearDownAfterClass()");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("\t@Before setUp()");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\t@After tearDown()");
    }

    //@Test
    public void testOne() {
        System.out.println("\t\t@Test testOne()");
        /*-
        //int i = 0;
        double i = 0;
        i = 10 / i;
        System.out.println("\t\t\ti = " + i);
        */
        //throw new RuntimeException("hahaha");
        Assert.assertEquals(4, 1+3);
        //fail("Not yet implemented");
    }

    @Test
    public void testAdd1() {
        System.out.println("\t\t@Test testAdd1()");
        //
        //Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 4;
        actual = calc.add(2, 2);
        Assert.assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd2() {
        System.out.println("\t\t@Test testAdd2()");
        //
        //Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 4;
        actual = calc.add(1, 3);
        Assert.assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv1() {
        System.out.println("\t\t@Test testDiv1()");
        //
        //Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 5;
        actual = calc.div(20, 4);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testDiv2() {
        System.out.println("\t\t@Test testDiv2()");
        //
        //Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 2.5;
        actual = calc.div(20, 8);
        Assert.assertEquals(expected, actual, 0.001);
    }
}
