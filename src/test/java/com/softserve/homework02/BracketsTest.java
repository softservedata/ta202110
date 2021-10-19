package com.softserve.homework02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

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
		System.out.println("\t\t@Test testBrackets1()");

		Brackets brackets = new Brackets();
		boolean actual;
		boolean expected;

		expected = true;
		actual = brackets.verifyBrackets("()");
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testBrackets2() {
		System.out.println("\t\t@Test testBrackets2()");

		Brackets brackets = new Brackets();
		boolean actual;
		boolean expected;

		expected = true;
		actual = brackets.verifyBrackets("(())");
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testBrackets3() {
		System.out.println("\t\t@Test testBrackets3()");

		Brackets brackets = new Brackets();
		boolean actual;
		boolean expected;

		expected = true;
		actual = brackets.verifyBrackets("(())()");
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testBrackets4() {
		System.out.println("\t\t@Test testBrackets4()");

		Brackets brackets = new Brackets();
		boolean actual;
		boolean expected;

		expected = false;
		actual = brackets.verifyBrackets("(()");
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testBrackets5() {
		System.out.println("\t\t@Test testBrackets5()");

		Brackets brackets = new Brackets();
		boolean actual;
		boolean expected;

		expected = false;
		actual = brackets.verifyBrackets(")(");
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testBrackets6() {
		System.out.println("\t\t@Test testBrackets6()");

		Brackets brackets = new Brackets();
		boolean actual;
		boolean expected;

		expected = false;
		actual = brackets.verifyBrackets("())");
		Assertions.assertEquals(expected, actual);
	}

}
