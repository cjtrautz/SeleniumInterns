package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateAffiliateTrackingPixel extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void test() {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.linkText("Admin")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='Get Affiliate Tracking Pixel']")).click();
        
		AssertJUnit.assertTrue(driver.findElement(By.tagName("html")).getText().contains("Additional Fields"));
        
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
