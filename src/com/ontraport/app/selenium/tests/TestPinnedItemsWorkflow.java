package com.ontraport.app.selenium.tests;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class TestPinnedItemsWorkflow extends OntraportFirefoxTest {
AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testPinnedItemsWorkFlow () throws Exception{
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Messages']")).click();
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-circle-pin-s")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-circle-file")).click();
		Thread.sleep(5000);
		Assert.assertTrue(isLinkPresentIntable (driver, "Message: List"));
		driver.findElement(By.cssSelector("a.ussr-icon.ussr-icon-circle-file")).click();
		Thread.sleep (3000);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-circle-pin-n")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-circle-file")).click();
		Thread.sleep(5000);
		
		Assert.assertFalse(isLinkPresentIntable (driver, "Message: List"));
		driver.findElement(By.cssSelector("a.ussr-icon.ussr-icon-circle-file")).click();
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	}
	
	
	public boolean isLinkPresentIntable (WebDriver driver, String gateWayName){
		List<WebElement> findElements = driver.findElements(By.xpath("//table[contains(@class,'ussr-workflow-menu-section-list-type-pinned')]//a"));
		Iterator<WebElement> iterator = findElements.iterator();
		while (iterator.hasNext()) {
			WebElement webElement = (WebElement) iterator.next();
			String linkText = webElement.getText().trim();
			System.out.println("linkname:"+linkText);
			System.out.println(webElement.getText().trim().length());
			if (linkText.equalsIgnoreCase(gateWayName.trim())){
				return true;
			}
			
		}
		
		return false;
	}
	
}
