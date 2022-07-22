package org.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JunitFaceBook extends BaseClass1{
	
	@BeforeClass
	public static void test() {
getDriver();
loadUrl("https://demoqa.com/automation-practice-form");
maximize();
	}
@Test
	public void AfterClass() throws InterruptedException {
WebElement findElementById = findElementById("firstName");
sendKeys(findElementById, "sakthi");
WebElement findElementById2 = findElementById("lastName");
sendKeys(findElementById2, "vel");
WebElement findElementById3 = findElementById("userEmail");
sendKeys(findElementById3, "sajyki@gmil.com");
findElementByClassName("custom-control-label").click();
WebElement findElementById4 = findElementById("userNumber");
sendKeys(findElementById4, "7890989098");

}
@AfterClass
public static void afterClass() {
close();
}
}
