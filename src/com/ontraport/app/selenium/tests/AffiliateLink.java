package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class AffiliateLink extends OntraportFirefoxTest{
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
		driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
		driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='SOFTWARE AFFILIATE LINKS']")).click();
		String Website = driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[3]/div[2]")).getText();
		driver.get(Website);
		
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//li[@id='menu-item-9']//a[.='Features']")));

        driver.navigate().back();
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	}

}
