package com.softserve.edu;

import org.testng.annotations.Test;

public class TestNGTest10 {

	@Test
	public void method1() {
		System.out.println("This is method 1");
	}

	@Test(dependsOnMethods = { "method1", "method3" })
	public void method2() {
		System.out.println("This is method 2");
	}

	@Test(dependsOnMethods = { "method1" })
	public void method3() {
		System.out.println("This is method 3");
		//throw new RuntimeException("ha-ha-ha");
	}

}