package org.test;





import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class General {

	public static void main(String[] args) {
		
	


	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	
		WebElement element = driver.findElement(By.id("email"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','12345')", element);
		
		WebElement element1 = driver.findElement(By.id("pass"));
		
		executor.executeScript("arguments[0].setAttribute('value','7890')", element1);
		WebElement element2= driver.findElement(By.name("login"));
		
		executor.executeScript("arguments[0].click", element2);
		
		driver.close();
		

	}
}