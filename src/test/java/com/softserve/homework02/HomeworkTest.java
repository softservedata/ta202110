package com.softserve.homework02;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.softserve.homepage02.Brackets;

@RunWith(JUnitPlatform.class)
public class HomeworkTest {

	@Test
	 void testBrackets1() {
        System.out.println("\t\t@Test testBrackets1 true()");

        Brackets brackets = new Brackets();
        boolean actual;
        boolean expected;
        //
        expected = true;
        actual = brackets.verifyBrackets("()");
        Assertions.assertEquals(expected, actual);
    }

	@Test
    void testBrackets2() {
        System.out.println("\t\t@Test testBrackets2 true()");

        Brackets brackets = new Brackets();
        boolean actual;
        boolean expected;
        //
        expected = true;
        actual = brackets.verifyBrackets("(())");
        Assertions.assertEquals(expected, actual);
    }
	
	@Test
    void testBrackets3() {
        System.out.println("\t\t@Test testBrackets3 true()");

        Brackets brackets = new Brackets();
        boolean actual;
        boolean expected;
        //
        expected = true;
        actual = brackets.verifyBrackets("(())()");
        Assertions.assertEquals(expected, actual);
    }
	
	@Test
    void testBrackets4() {
        System.out.println("\t\t@Test testBrackets4 false()");

        Brackets brackets = new Brackets();
        boolean actual;
        boolean expected;
        //
        expected = false;
        actual = brackets.verifyBrackets("(()");
        Assertions.assertEquals(expected, actual);
    }
	
	@Test
    void testBrackets5() {
        System.out.println("\t\t@Test testBrackets5 false()");

        Brackets brackets = new Brackets();
        boolean actual;
        boolean expected;
        //
        expected = false;
        actual = brackets.verifyBrackets(")(");
        Assertions.assertEquals(expected, actual);
    }
	
	@Test
    void testBrackets6() {
        System.out.println("\t\t@Test testBrackets6 false()");

        Brackets brackets = new Brackets();
        boolean actual;
        boolean expected;
        //
        expected = false;
        actual = brackets.verifyBrackets("())");
        Assertions.assertEquals(expected, actual);
    }
	
	}

