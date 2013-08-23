package com.ontraport.app.selenium.tests;

//import AppUtilities;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class TypenegativenumbersintoPage extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities(); 

	@Test
	public void testNextPage() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(Keys.CLEAR);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("-12");
		String currentPageNumber = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
		System.out.println("page number chk"+ currentPageNumber);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		currentPageNumber = driver.findElement(By.xpath("//*[contains(@class,'ussr-component-paginator-current-page')]")).getAttribute("value");
		int crntPgNo = Integer.parseInt(currentPageNumber);
		if (crntPgNo==(1)){
			Assert.assertTrue("NegativeNumber success", true);
		}else{
			Assert.assertTrue("NegativeNumber success", false);
		}
		appUtilities.logOutOfApp(driver);

	}
}
