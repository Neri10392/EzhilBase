package org.sample;

import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class5 {
	@BeforeMethod
	private void time() {
Date date = new Date();
System.out.println(date);
	}
	@AfterTest
	private void time1() {
		Date date = new Date();
		System.out.println(date);
	}
	
	@Test
	private void method1() {
System.out.println("Method 1");
	}
	
	@Test
	private void method2() {
System.out.println("Method 2");
	}

	@Test
	private void method3() {
System.out.println("Method 3");
	}
	
	@Test
	private void method4() {
System.out.println("Method 4");
	}
	
	@Test
	private void method5() {
System.out.println("Method 5");
	}
	
	@Test
	private void method6() {
System.out.println("Method 6");
	}
}
