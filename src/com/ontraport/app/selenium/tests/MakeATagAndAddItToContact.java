
package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class MakeATagAndAddItToContact extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testMakeATagAndAddItToContact() throws Exception{
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
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String tagName = "SelAddTag" + varTimeStamp;
		Thread.sleep (5000);
		String contactName = appUtilities.selectNonBlankLastNameContactLink(driver);
		System.out.println("contactName:"+contactName);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.linkText("Add/Remove Tags")).click();
		appUtilities.selectItemSpan(driver, "Select Tag", "Create New Tag");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.ussr-border-solid-all")).clear();
		driver.findElement(By.cssSelector("input.ussr-border-solid-all")).sendKeys(tagName);
		
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Tag']]/descendant::button/span[normalize-space(text())='Save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button/span[normalize-space(text())='Submit']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[normalize-space(text())='" + contactName + "']")).click();
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//a[.='Sequences and Tags']")).click();
		String xpathOfTag = "//div[label[normalize-space(text())='Contact Tags']]/descendant::li[normalize-space(text())='" + tagName + "']";
		Assert.assertTrue("Checking for tag added in Sequences and Tags", appUtilities.isElementPresent(driver, By.xpath(xpathOfTag)));
		
		//appUtilities.logOutOfApp(driver);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		
		

		
	}	
}
