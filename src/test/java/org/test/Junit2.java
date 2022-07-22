package org.test;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
@RunWith(Suite.class)
@SuiteClasses({General.class,Class1.class})
public class Junit2 extends BaseClass1 {
	static WebDriver driver;
	 static BaseClass1 c;
	@BeforeClass
	public static void beforeClass() throws InterruptedException {
		c.getDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public static void afterClass() {
    driver.quit();

	}
	@Before
	public void before() {
long timeMillis = System.currentTimeMillis();
System.out.println(timeMillis);
	}
	@Test
	public void test() throws InterruptedException {

	WebElement element = driver.findElement(By.id("email"));

	element.sendKeys("23567");

	}
	@After
	
	public void after() {
		long timeMillis = System.currentTimeMillis();
		System.out.println(timeMillis);
			

	}
}
/*
	@Before
    public void before() throws IOException {
		TakesScreenshot screenshort = (TakesScreenshot) driver;
File findElement1 = screenshort.getScreenshotAs(OutputType.FILE);
File file = new File("F:\\Sakthivel files\\before.png");
FileUtils.copyFile(findElement1, file);
}
	
	@Test
	public void test() {
		
		WebElement findElement = driver.findElement(By.xpath("//div[contains(@class,'_8opv')]"));
	
		WebElement findElement5 = driver.findElement(By.xpath("//div[contains(@class,'30ny')]"));
	WebElement findElement1 = driver.findElement(By.id("email"));
	findElement1.sendKeys("sakthivelvadivel");
    String attribute = findElement1.getAttribute("value");
	System.out.println(attribute);
	WebElement ll = driver.findElement(By.id("pass"));
	ll.sendKeys("67890");
	WebElement element = driver.findElement(By.id("u_0_5_SK"));
	element.click();

	}
	
	@After
	public void after() throws IOException {
File screen =screenshort.getScreenshotAs(OutputType.FILE);
File file1 = new File("F:\\Sakthivel files\\after.png");
FileUtils.copyFile(screen, file1);
	
	}
} */