package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	static WebDriver driver;
	  String  data;
	 // int Celltype;
	 
		public static void getDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
		}
		public static void loadUrl(String url) {
	    driver.get(url);
	    
	}
		public static void maximize() {
	driver.manage().window().maximize();
	}	
		public WebElement findElementById(String id) {
			WebElement findElement = driver.findElement(By.id(id));
			return findElement;
		
		}
			
			
		public WebElement findElementByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;		
		}
		public WebElement findElementByClassName(String className) {
	WebElement findElement = driver.findElement(By.className(className));
	return findElement;

		}
		public WebElement findElementByXpath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}

		public WebElement findElementBytageName(String tagName) {
		WebElement findElement = driver.findElement(By.tagName(tagName));
		return findElement;
	}

		public WebElement findElementBylinkText(String linkText) {
	WebElement findElement = driver.findElement(By.linkText(linkText));
	return findElement;

		}	
		public WebElement findElementBypartialLinkText(String partialLinkText) {
		WebElement findElement = driver.findElement(By.partialLinkText(partialLinkText));
		return findElement;

		}
		public static void close() {
			driver.close();

		}
		public void navigateBack() {
			driver.navigate().back();
		}
		
		public void navigateto(String url) {
		driver.navigate().to(url);
		}
		public 	List<WebElement> options(WebElement element) {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			return options;
		}
		
		public void accept() {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		}
		public void dismiss() {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}
		public Alert sendKeys(String name) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(name);
			alert.accept();
			return alert;
		} 
		
		private Alert getText(String getText) {
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	return alert;

		}
		
		public void moveToElement(WebElement element) {
			Actions actions = new Actions(driver);
			 actions.moveToElement(element).perform();
		}
		
		public void doubleClick(WebElement element) {
			Actions ac = new Actions(driver);
		 ac.doubleClick(element).perform();

		}
		
		private void contextClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();

		}
		
		private void JavascriptExecutor() {
			JavascriptExecutor executor = (org.openqa.selenium.JavascriptExecutor) driver;
			
		}
		public Actions click(WebElement element) {
		Actions ac = new Actions(driver);
		Actions click = ac.click(element);
		click.perform();
		
		return click;
		}
		public WebElement sendKeys(WebElement element,String keys) {
			Actions ac = new Actions(driver);
			Actions sendKeys = ac.sendKeys(element, keys);
			sendKeys.perform();
			return element;
		}
		
		
		
			public WebElement enterText(WebElement element, String data) {
				Actions ac = new Actions(driver);
				Actions l = ac.sendKeys(element,data);
				l.perform();
				return element;
			}
		
			public Actions sendKeys(WebElement element,	WebElement data) {
				Actions ac = new Actions(driver);
				 ac.sendKeys(data).perform();
				return ac;
			
		
			}
		
		public Select getSelect(WebElement element, int index) {
			Select se = new Select(element);
			se.selectByIndex(index);
			return se;
		
		
		}
		public WebElement keyPress(WebElement element) throws AWTException {
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_CONTROL);
			ro.keyPress(KeyEvent.VK_A);
			return element;
			
		}
		public WebElement backspce(WebElement element) throws AWTException {
			Robot ro = new Robot();
			ro.keyPress(KeyEvent.VK_BACK_SPACE);
			ro.keyRelease(KeyEvent.VK_BACK_SPACE);
			return element;
			
		}
			public WebElement keyRelease(WebElement element) throws AWTException {
				Robot ro = new Robot();
			ro.keyRelease(KeyEvent.VK_A);
			ro.keyRelease(KeyEvent.VK_CONTROL);
			return element;
		}
		public WebElement getAttribute(WebElement element,String id,String value) {
			WebElement findElement = driver.findElement(By.id(id));
			String attribute = findElement.getAttribute(value);
			return findElement;
		}
		public static WebDriver switchto(WebElement element) {
WebDriver frame = driver.switchTo().frame(element);
return frame;
		}
		public String getData(String excelpath,String sheetname,int row, int cell) throws IOException {
			File file = new File(excelpath);
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new HSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetname);
	Row row2 = sheet.getRow(row);
	Cell cell2 = row2.getCell(cell);
	int type = cell2.getCellType();
	if (type==1) {
		 data = cell2.getStringCellValue();
	}
	if (type==0) {
		if (DateUtil.isCellDateFormatted(cell2)) {
			Date date = cell2.getDateCellValue();
			SimpleDateFormat dateformte = new SimpleDateFormat("dd/MM/yyyy");
			 data = dateformte.format(date);
		} else {
			double d = cell2.getNumericCellValue();
			long l = (long) d;
			 data = String.valueOf(l);

		}
	}
	return data;

		}
}
