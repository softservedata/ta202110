package com.softserve.homework02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HW02BracketsTest {

	private static HW02Brackets brackets;
	
	@Test
	void test1() {
		brackets = new HW02Brackets();
		
		boolean extected = true;
		boolean actual = brackets.verifyBrackets("((  test() ... )) ()");
		
		Assertions.assertEquals(extected, actual);
	}
	
	@Test
	void test2() {
		brackets = new HW02Brackets();
		
		boolean extected = false;
		boolean actual = brackets.verifyBrackets(") (()) (");
		
		Assertions.assertEquals(extected, actual);
	}

}
