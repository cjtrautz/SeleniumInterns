package com.ontraport.app.selenium.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

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
		
		List<WebElement> finder = new ArrayList<WebElement>();
		while(finder.isEmpty() == true){
			finder=driver.findElements(By.xpath("//a[normalize-space(text())='" + "Message: List" +"']"));
			System.out.println(finder.isEmpty());
			if(finder.isEmpty() == true){
				AssertJUnit.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//div[7]/div[1]/div/div[3]/div/ul/li[4]/a[1]/span[@class='ussr-icon ussr-icon-seek-next ussr-state-disabled']")));
				driver.findElement(By.xpath("//div[7]/div[1]/div/div[3]/div/ul/li[4]/a[1]/span[@class='ussr-icon ussr-icon-seek-next']")).click();
			}
		}
		Assert.assertTrue(isLinkPresentIntable (driver, "Message: List"));
		driver.findElement(By.cssSelector("a.ussr-icon.ussr-icon-circle-file")).click();
		Thread.sleep (3000);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-circle-pin-n")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-circle-file")).click();
		Thread.sleep(5000);
		
		List<WebElement> finder2 = new ArrayList<WebElement>();
		while(finder2.isEmpty() == true){
			finder2=driver.findElements(By.xpath("//div[7]/div[1]/div/div[3]/div/ul/li[4]/a[1]/span[@class='ussr-icon ussr-icon-seek-next ussr-state-disabled']"));
			System.out.println(finder2.isEmpty());
			Assert.assertFalse(isLinkPresentIntable (driver, "Message: List"));
			if(finder2.isEmpty() == true){
				driver.findElement(By.xpath("//div[7]/div[1]/div/div[3]/div/ul/li[4]/a[1]/span[@class='ussr-icon ussr-icon-seek-next']")).click();
			}
		}
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
