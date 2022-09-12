package org.sample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.baseMethod.GlobalLib;

public class Class4 extends GlobalLib {
	WebDriver driver;
	@Test(groups = "smoke")
	private void launch() {
		launchChrome("https://www.facebook.com/");
		System.out.println("method 1");
	}
	
	
	@Test(groups = "smoke")
	private void method1() {
		findElementId("email").sendKeys("ezhil");
		System.out.println("method 2");
	}
	
	@Test(groups = "reg" , dependsOnGroups = "smoke",alwaysRun=true)
	private void method2() {
		findElementId("pass").sendKeys("1234");
System.out.println("method 3");
	}

	@Test(groups = "smoke")
	private void method3() {
		findElementName("login").click();
System.out.println("method 4");
	}
	
	@Test(groups = "reg" , dependsOnGroups = "smoke" ,alwaysRun=true)
	private void time1() {
		driver.quit();
		System.out.println("method 5");
	}
	
//	@Test
//	private void method4() {
//		System.out.println("Method 4");
//	}
//
//	@Test
//	private void method5() {
//		System.out.println("Method 5");
//	}
//
//	@Test
//	private void method6() {
//		System.out.println("Method 6");
//	}
}
