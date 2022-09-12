package org.sample;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseMethod.GlobalLib;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Junit extends GlobalLib{
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();}

	@AfterClass
	public static void afterClass() {
		driver.quit();}

	@Before
	public void before() {
		Date date = new Date();
		System.out.println(date);}

	@After
	public void after() {
		Date date = new Date();
		System.out.println(date);}

	@Test

	public void login() throws InterruptedException {
		String url = driver.getCurrentUrl();
		boolean b = url.contains("act");
		Assert.assertTrue("Verify Url", b);
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys("ezhilvannan");
		String name = txtUserName.getAttribute("value");
		Assert.assertEquals("verify UserName", "ezhilvannan", name);

		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("123!@#asd");
		String pass = txtPassword.getAttribute("value");
		Assert.assertEquals("verify Password", "123!@#asd", pass);
		Thread.sleep(300);

		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();

	}

}
