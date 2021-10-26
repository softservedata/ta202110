package com.softserve.homework02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(JUnitPlatform.class)
public class BracketsTest {

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
    void testBrackets1() {
        System.out.println("\t\t@Test correct Brackets 1");

        Brackets brackets = new Brackets();

        boolean actual;
        boolean expected;

        expected = true;
        actual = brackets.verifyBrackets("()");
    }

    @Test
    void testBrackets2() {
        System.out.println("\t\t@Test correct Brackets 2");

        Brackets brackets = new Brackets();

        boolean actual;
        boolean expected;

        expected = true;
        actual = brackets.verifyBrackets("(((first))) (2ng) ((one more))");
    }

    @Test
    void testBrackets3() {
        System.out.println("\t\t@Test wrong Brackets 3");

        Brackets brackets = new Brackets();

        boolean actual;
        boolean expected;

        expected = false;
        actual = brackets.verifyBrackets("(");
    }


    @Test
    void testBrackets4() {
        System.out.println("\t\t@Test wrong Brackets 4");

        Brackets brackets = new Brackets();

        boolean actual;
        boolean expected;

        expected = false;
        actual = brackets.verifyBrackets(")");
    }

    @Test
    void testBrackets5() {
        System.out.println("\t\t@Test wrong Brackets 5");

        Brackets brackets = new Brackets();

        boolean actual;
        boolean expected;

        expected = false;
        actual = brackets.verifyBrackets(")(");
    }

    @Test
    void testBrackets6() {
        System.out.println("\t\t@Test wrong Brackets 6");

        Brackets brackets = new Brackets();

        boolean actual;
        boolean expected;

        expected = false;
        actual = brackets.verifyBrackets("(()))(");
    }
}
