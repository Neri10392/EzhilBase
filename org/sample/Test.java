package org.sample;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseMethod.GlobalLib;

public class Test extends GlobalLib {
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		launchChrome("http://adactinhotelapp.com/");
	}

	@AfterClass
	public static void close() {
		closeAll();

	}

	@Before
	public void beforeMethod() {
		Date date = new Date();
		System.out.println(date);
	}

	@After
	public void afterMethod() {
		Date date = new Date();
		System.out.println(date);
	}

	@org.junit.Test
	public void test() throws IOException, InterruptedException {
		String userName = getData("Data", 0, 1);
		String password = getData("Data", 1, 1);
		String location = getData("Data", 2, 1);
		String hotels = getData("Data", 3, 1);
		String roomType = getData("Data", 4, 1);
		String numRoom = getData("Data", 5, 1);
		String checkin = getData("Data", 6, 1);
		String checkout = getData("Data", 7, 1);
		String adult = getData("Data", 8, 1);
		String children = getData("Data", 9, 1);
		String firstname = getData("Data", 10, 1);
		String lastname = getData("Data", 11, 1);
		String adress = getData("Data", 12, 1);
		String cardno = getData("Data", 13, 1);
		String cardtype = getData("Data", 14, 1);
		String exmonth = getData("Data", 15, 1);
		String exyear = getData("Data", 16, 1);
		String cvv = getData("Data", 17, 1);
		WebElement txtUserName = findElementId("username");
		sendKeys(txtUserName, userName);
		WebElement txtPassword = findElementId("password");
		sendKeys(txtPassword, password);
		WebElement btnLogin = findElementId("login");
		click(btnLogin);

		WebElement txtLOcation = findElementId("location");
		sendKeys(txtLOcation, location);
		WebElement txtHotels = findElementId("hotels");
		sendKeys(txtHotels, hotels);
		WebElement txtRoomType = findElementId("room_type");
		sendKeys(txtRoomType, roomType);
		WebElement txtRoomNum = findElementId("room_nos");
		sendKeys(txtRoomNum, numRoom);
		WebElement txtCheckin = findElementId("datepick_in");
		sendKeys(txtCheckin, checkin);
		WebElement txtCheckout = findElementId("datepick_out");
		sendKeys(txtCheckout, checkout);
		WebElement txtAdult = findElementId("adult_room");
		sendKeys(txtAdult, adult);
		WebElement txtChild = findElementId("child_room");
		sendKeys(txtChild, children);
		WebElement btnSubmit = findElementId("Submit");
		click(btnSubmit);
		WebElement rbtnSelect = findElementId("radiobutton_0");
		click(rbtnSelect);
		WebElement btnContinue = findElementId("continue");
		click(btnContinue);
		WebElement txtFirst = findElementId("first_name");
		sendKeys(txtFirst, firstname);
		WebElement txtLast = findElementId("last_name");
		sendKeys(txtLast, lastname);
		WebElement txtAdress = findElementId("address");
		sendKeys(txtAdress, adress);
		WebElement txtCcNum = findElementId("cc_num");
		sendKeys(txtCcNum, cardno);
		WebElement txtCcType = findElementId("cc_type");
		sendKeys(txtCcType, cardtype);
		WebElement txtExpMon = findElementId("cc_exp_month");
		sendKeys(txtExpMon, exmonth);
		WebElement txtExpYear = findElementId("cc_exp_year");
		sendKeys(txtExpYear, exyear);
		WebElement txtCvv = findElementId("cc_cvv");
		sendKeys(txtCvv, cvv);
		WebElement btnBookNow = findElementId("book_now");
		click(btnBookNow);
		Thread.sleep(15000);
		WebElement orderNum = findElementId("order_no");
		String orderNo = getAttribute(orderNum, "value");
		System.out.println(orderNo);

		inputData("Data", 18, 1, orderNo);
		inputDataCell("Data", 18, 0, "Order No");
		System.out.println("Done.............");

	}

}
