package org.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.baseMethod.GlobalLib;

public class Testng extends GlobalLib {

	public static void main(String[] args) throws InterruptedException {

		launchChrome("http://adactinhotelapp.com/");
		
		Login login = new Login();
		
		WebElement txtUsername = login.getTxtUsername();
		txtUsername.sendKeys("ezhilvannan");
		WebElement password = login.getPassword();
		password.sendKeys("123!@#asd");
		WebElement login2 = login.getLogin();
		login2.click();

		Search search = new Search();

		
		WebElement location = search.getLocation();
		Select select = new Select(location);
		select.selectByVisibleText("London");
		WebElement hotels = search.getHotels();
		Select select1 = new Select(hotels);
		select1.selectByIndex(3);
		WebElement roomtype = search.getRoomtype();
		Select select2 = new Select(roomtype);
		select2.selectByIndex(1);
		WebElement roomNum = search.getRoomNum();
		Select select3 = new Select(roomNum);
		select3.selectByIndex(1);
		search.getCheckIn().sendKeys("09/11/2021");
		search.getCheckOut().sendKeys("13/11/2021");
		WebElement adults = search.getAdults();
		Select select4 = new Select(adults);
		select4.selectByIndex(1);
		WebElement child = search.getChild();
		Select select5 = new Select(child);
		select5.selectByIndex(1);
		search.getSearch().click();

		OrderId id = new OrderId();

		id.getRadioBtn().click();
		id.getCont().click();

		id.getFirstName().sendKeys("EzhilVannan");
		id.getLastName().sendKeys("Lenin");
		id.getAddress().sendKeys("Periyakottai, Needamangalam, Thiruvarur");
		id.getCcNum().sendKeys("1234567890123456");
		WebElement ccType = id.getCcType();
		Select s = new Select(ccType);
		s.selectByIndex(1);
		WebElement expMonth = id.getExpMonth();
		Select s1 = new Select(expMonth);
		s1.selectByIndex(5);
		WebElement expYear = id.getExpYear();
		Select s2 = new Select(expYear);
		s2.selectByVisibleText("2022");
		id.getCvv().sendKeys("322");
		id.getBookNow().click();
		Thread.sleep(15000);
		WebElement orderId = id.getOrderId();
		String data = orderId.getAttribute("value");
		System.out.println(data);

	}

}
