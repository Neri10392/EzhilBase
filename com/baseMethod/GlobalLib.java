
package com.baseMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalLib {
	  public static WebDriver driver;

	public void inputDataCell(String sheetname, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\Welcome\\Desktop\\ARun\\Framework.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
	}

	public void inputData(String sheetname, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\Welcome\\Desktop\\ARun\\Framework.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	public String getData(String sheetName, int rowNum, int cellnum) throws IOException {
		String data = null;
		File file = new File("C:\\Users\\Welcome\\Desktop\\ARun\\Framework.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellnum);
		int type = cell.getCellType();
		if (type == 1) {
			data = cell.getStringCellValue();
		}
		if (type == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				data = dateFormat.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				data = String.valueOf(l);
			}
		}
		return data;

	}

	public void enterUrl(String url) {
		driver.get(url);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void sendKeys(WebElement element, String keys) {
		element.sendKeys(keys);
	}

	public void click(WebElement element) {
		element.click();
	}


	public void alertOk() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void alertCancel() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public String getText(WebElement element) {
		String data = element.getText();
		return data;
	}

	public String getAttribute(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	public static void closeAll() {
		driver.quit();
	}

	public static void closeCurrent() {
		driver.close();
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void selectText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	public void selectIndex(WebElement element, int i) {
		Select select = new Select(element);
		select.selectByIndex(i);

	}

	public void typeJs( WebElement element, String name) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].setAttribute('value'," + name + "')", element);
	}

	public void clickJs( WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);
	}

	public static void launchChrome(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void launchFirefox(String url) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(url);
	}

	public void launchIe(String url) {
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.get(url);
	}

	public void switchChildId( String id) {
		driver.switchTo().window(id);
	}

	public void switchChildTitle( String title) {
		driver.switchTo().window(title);
	}

	public void switchChildUrl( String url) {
		driver.switchTo().window(url);
	}

	public void switchFrameIndex( String url, int i) {
		driver.get(url);
		driver.switchTo().frame(i);
	}

	public void switchFrameId( String url, String id) {
		driver.get(url);
		driver.switchTo().frame(id);
	}

	public void switchFrameName( String url, String name) {
		driver.get(url);
		driver.switchTo().frame(name);
	}

	public void switchFrameElement( String url, WebElement element) {
		driver.get(url);
		driver.switchTo().frame(element);
	}

	public String alertgetText() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		return text;
	}

	public void selectgetOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
	}

	public void getAll(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
	}

	public void getFirst(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();

	}

	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public void deselectIndex(WebElement element, int i) {
		Select select = new Select(element);
		select.deselectByIndex(i);
	}

	public void deselectValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	public void deselectText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);

	}

	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void dragAndDrop( WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClick( WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void doubleClick( WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void sendKeysAction( WebElement element, String text) {
		Actions action = new Actions(driver);
		action.sendKeys(element, text);
	}

	public void keyDown( WebElement element, String key) {
		Actions action = new Actions(driver);
		action.keyDown(element, key);
	}

	public void keyUp( WebElement element, String key) {
		Actions action = new Actions(driver);
		action.keyUp(element, key);
	}

	public void switchToParent() {
		driver.switchTo().parentFrame();
	}

	public void switchtoDefault() {
		driver.switchTo().defaultContent();
	}

	public WebElement findElementxpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public WebElement findElementId(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;

	}

	public WebElement findElementName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	public WebElement findElementClass(String classname) {
		WebElement element = driver.findElement(By.className(classname));
		return element;
	}

	public List<WebElement> findElementsxpath(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;
	}

	public void findElementsId(String id) {
		driver.findElements(By.id(id));
	}

	public void findElemenstName(String name) {
		driver.findElements(By.name(name));
	}

	public void findElementsClass(String classname) {
		driver.findElements(By.className(classname));
	}

	public void alertSendKeys( String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
	}

	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public Set<String> windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;

	}

	public Object getAttributeJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("return argument[0].getAttribute('value')", element);
		return executeScript;
	}

	public void scrollDownJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);
	}

	public void scrollUpJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(true)", element);
	}

}
