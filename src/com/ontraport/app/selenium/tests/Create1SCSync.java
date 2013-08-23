package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Create1SCSync extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreate1SCSync() throws InterruptedException {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='1SHOPPINGCART SYNCING']")).click();
		Thread.sleep(3000);
        
		AssertJUnit.assertTrue(driver.findElement(By.tagName("html")).getText().contains("1. Login to your 1shoppingcart account"));
		AssertJUnit.assertTrue(driver.findElement(By.tagName("html")).getText().contains("2. Click Setup"));
		AssertJUnit.assertTrue(driver.findElement(By.tagName("html")).getText().contains("3. Put your 1shoppingcart email address (below) into the \"Order Notice Email - Secondary Destination:\" field in 1shoppingcart."));
		AssertJUnit.assertTrue(driver.findElement(By.tagName("html")).getText().contains("4. Change \"Recurring Transactions - Merchant Notifications:\" to YES."));
		AssertJUnit.assertTrue(driver.findElement(By.tagName("html")).getText().contains("5. Click 'SAVE PAGE' at the bottom."));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
