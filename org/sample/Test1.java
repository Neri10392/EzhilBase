package org.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.baseMethod.GlobalLib;

public class Test1 extends GlobalLib {
WebDriver driver;
@Test(groups = "smoke")
	private void launch() {
		launchChrome("https://www.facebook.com/");
		System.out.println("M1");
	}
@Test(groups = "smoke")
	private void text() {
		WebElement txtuser = findElementId("email");
		sendKeys(txtuser, "Ezhilvannan");
		System.out.println("M2");
	}
@Test(groups = "reg" , dependsOnGroups = "smoke")
	private void pass() {
		WebElement txtpass = findElementId("pass");
		sendKeys(txtpass, "12334566");
		System.out.println("M3");
	}
@Test(groups = "reg" , dependsOnGroups = "smoke")
	private void login() {
		findElementName("login").click();
		System.out.println("M4");
	}
}
