package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class NameATab extends OntraportFirefoxTest{
AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testCreateRule() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(5000);
		
		//Get to a Tab and try to rename
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']/section/nav/ul/li/nav/ul/li[5]/a/span/span")).click();
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-textfield")).click();
		//taking long time to load edit contact fields
		Thread.sleep(12000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div[2]/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input.text-transform-uppercase")).click();
		driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input.text-transform-uppercase")).sendKeys("Lead 1aB4");
		appUtilities.logOutOfApp(driver);
		
}
}