package org.sample;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.baseMethod.GlobalLib;

public class Methods {
	public static void main(String[] args) throws IOException, InterruptedException {
		GlobalLib global = new GlobalLib();
		global.launchChrome("http://adactinhotelapp.com/");
		String userName = global.getData("Data", 0, 1);
		String password = global.getData("Data", 1, 1);
		String location = global.getData("Data", 2, 1);
		String hotels = global.getData("Data", 3, 1);
		String roomType = global.getData("Data", 4, 1);
		String numRoom = global.getData("Data", 5, 1);
		String checkin = global.getData("Data", 6, 1);
		String checkout = global.getData("Data", 7, 1);
		String adult = global.getData("Data", 8, 1);
		String children = global.getData("Data", 9, 1);
		String firstname = global.getData("Data", 10, 1);
		String lastname = global.getData("Data", 11, 1);
		String adress = global.getData("Data", 12, 1);
		String cardno = global.getData("Data", 13, 1);
		String cardtype = global.getData("Data", 14, 1);
		String exmonth = global.getData("Data", 15, 1);
		String exyear = global.getData("Data", 16, 1);
		String cvv = global.getData("Data", 17, 1);
		WebElement txtUserName = global.findElementId("username");
		global.sendKeys(txtUserName, userName);
		WebElement txtPassword = global.findElementId("password");
		global.sendKeys(txtPassword, password);
		WebElement btnLogin = global.findElementId("login");
		global.click(btnLogin);

		WebElement txtLOcation = global.findElementId("location");
		global.sendKeys(txtLOcation, location);
		WebElement txtHotels = global.findElementId("hotels");
		global.sendKeys(txtHotels, hotels);
		WebElement txtRoomType = global.findElementId("room_type");
		global.sendKeys(txtRoomType, roomType);
		WebElement txtRoomNum = global.findElementId("room_nos");
		global.sendKeys(txtRoomNum, numRoom);
		WebElement txtCheckin = global.findElementId("datepick_in");
		global.sendKeys(txtCheckin, checkin);
		WebElement txtCheckout = global.findElementId("datepick_out");
		global.sendKeys(txtCheckout, checkout);
		WebElement txtAdult = global.findElementId("adult_room");
		global.sendKeys(txtAdult, adult);
		WebElement txtChild = global.findElementId("child_room");
		global.sendKeys(txtChild, children);
		WebElement btnSubmit = global.findElementId("Submit");
		global.click(btnSubmit);
		WebElement rbtnSelect = global.findElementId("radiobutton_0");
		global.click(rbtnSelect);
		WebElement btnContinue = global.findElementId("continue");
		global.click(btnContinue);
		WebElement txtFirst = global.findElementId("first_name");
		global.sendKeys(txtFirst, firstname);
		WebElement txtLast = global.findElementId("last_name");
		global.sendKeys(txtLast, lastname);
		WebElement txtAdress = global.findElementId("address");
		global.sendKeys(txtAdress, adress);
		WebElement txtCcNum = global.findElementId("cc_num");
		global.sendKeys(txtCcNum, cardno);
		WebElement txtCcType = global.findElementId("cc_type");
		global.sendKeys(txtCcType, cardtype);
		WebElement txtExpMon = global.findElementId("cc_exp_month");
		global.sendKeys(txtExpMon, exmonth);
		WebElement txtExpYear = global.findElementId("cc_exp_year");
		global.sendKeys(txtExpYear, exyear);
		WebElement txtCvv = global.findElementId("cc_cvv");
		global.sendKeys(txtCvv, cvv);
		WebElement btnBookNow = global.findElementId("book_now");
		global.click(btnBookNow);
		Thread.sleep(15000);
		WebElement orderNum = global.findElementId("order_no");
		String orderNo = global.getAttribute(orderNum, "value");
		System.out.println(orderNo);
		
		global.inputData("Data", 18, 1, orderNo);
		global.inputDataCell("Data", 18, 0, "Order No");
		System.out.println("Done.............");

	}
}
