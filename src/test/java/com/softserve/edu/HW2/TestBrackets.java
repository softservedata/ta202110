package com.softserve.edu.HW2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TestBrackets {
    private static Brackets brackets;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeAll setUpBeforeClass()");
        brackets = new Brackets();
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
    void testBrackets1() {
        System.out.println("\t\t@Test 1 correct");

        boolean actual;
        boolean expected;

        expected = true;
        actual = brackets.verifyBrackets("(text) ((text)) (((text)))");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBrackets2() {
        System.out.println("\t\t@Test 2 correct");

        boolean actual;
        boolean expected;

        expected = true;
        actual = brackets.verifyBrackets("()");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBrackets3() {
        System.out.println("\t\t@Test 3 incorrect");

        boolean actual;
        boolean expected;

        expected = false;
        actual = brackets.verifyBrackets("(");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void testBrackets4() {
        System.out.println("\t\t@Test 4 incorrect");

        boolean actual;
        boolean expected;

        expected = false;
        actual = brackets.verifyBrackets(")(");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBrackets5() {
        System.out.println("\t\t@Test 5 incorrect");

        boolean actual;
        boolean expected;

        expected = false;
        actual = brackets.verifyBrackets(")");
        Assertions.assertEquals(expected, actual);
    }

}
