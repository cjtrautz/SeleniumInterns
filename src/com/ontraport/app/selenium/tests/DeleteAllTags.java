package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeleteAllTags extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testDeleteAllTags() throws InterruptedException{
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//ul[@class='ussr-corner-bl']/li/a[text()='Admin']")).click();
		driver.findElement(By.xpath("//a/div[text()='MANAGE TAGS']")).click();
		do {
			driver.findElement(By.xpath("//thead[@class='ussr-component-collection-head']//a")).click();
			driver.findElement(By.linkText("Delete Tag")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")).click();
			Thread.sleep(3000);			
		} while (!driver.getPageSource().contains("There are no items to display"));
		Assert.assertTrue(driver.getPageSource().contains("There are no items to display"));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		//appUtilities.logOutOfApp(driver);
		
		
	}

}
