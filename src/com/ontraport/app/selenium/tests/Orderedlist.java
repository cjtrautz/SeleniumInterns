
package com.ontraport.app.selenium.tests;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;


public class Orderedlist extends OntraportFirefoxTest {
AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testCreateRule() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get(baseUrl + "/#!/contact/settings");
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']/section/nav/ul/li/nav/ul/li[4]/a/span/span")).click();
		driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']/span[2]")).click();
		Thread.sleep(20000);
		//click create new
		driver.findElement(By.xpath("//button[@value='\"+$l(']")).click();

		//the workaround
		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body")));
		driver.findElement(By.cssSelector("body")).sendKeys("Selenium Test");
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Select All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Insert/Remove Numbered List']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Source']")).click();
		Thread.sleep(3000);
		
		String Orderedlist = driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).getAttribute("value").trim();
		
		Assert.assertTrue("Assert Existance Of ol tag", Orderedlist.contains("<ol>"));
		Assert.assertTrue("Assert Existance Of list tag", Orderedlist.contains("<li>"));
		
		// delselecting code here
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Source']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Select All']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Insert/Remove Numbered List']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Source']")).click();
		Thread.sleep(5000);
		
		Orderedlist = driver.findElement(By.cssSelector("textarea.cke_source.cke_enable_context_menu")).getAttribute("value").trim();
	
		Assert.assertEquals("Assert Existance Of ol tag", false, Orderedlist.contains("<ol>"));
		Assert.assertEquals("Assert Existance Of list tag", false, Orderedlist.contains("<li>"));
		
		driver.switchTo().defaultContent();
		
		appUtilities.logOutOfApp(driver);

	}
	
}
