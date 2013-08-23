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


public class SelectAll extends OntraportFirefoxTest {
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
		//Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[@title='Select All']")).click();
		Thread.sleep(3000);
		
		
		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		String txt = driver.findElement(By.cssSelector("body")).getText().trim();
		System.out.println (txt.length());
		if (! (txt.length()==0)){
			Assert.fail("Select btn not working fine");
		}else{
			Assert.assertTrue(true);
		}
		
		//Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		appUtilities.logOutOfApp(driver);

	}
	
}
