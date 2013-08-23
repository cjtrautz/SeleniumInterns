package com.ontraport.app.selenium.tests;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;


public class PreviewButton extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testPreviewButton() throws Exception {
		driver.get(baseUrl + "/");
		String msgName = "Sel"+Calendar.getInstance().getTimeInMillis();
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		//Create any message
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Messages']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Message']")).click();
		
		driver.findElement(By.xpath("//div[div[*/text()='E-Mail']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(msgName);
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Send out name']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Send out name']]/descendant::input")).sendKeys("Selenium Test");
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Reply to email']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Reply to email']]/descendant::input")).sendKeys("selenium@test.com");
		
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::li[1]/div")).click();
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Subject']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Subject']]/descendant::input")).sendKeys("Selenium Test");
		
		//the workaround
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("body")).sendKeys("Selenium Test");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]"));
		
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[input[normalize-space(@placeholder)='Insert Merge Field']]/descendant::button"));
		appUtilities.selectItem(driver, "Insert Merge Field", "First Name");
		
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		String emailText1= driver.findElement(By.cssSelector("body")).getText().trim();
		System.out.println("Email Message: "+emailText1);
		driver.findElement(By.cssSelector("body")).getText().trim();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(3000);
		
		appUtilities.setHundredRecordsPerPage(driver);
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (msgName) +"']")));
		
		//Navigate to Preview Button
		//workaround for asserting pop up window
		driver.findElement(By.xpath("//*[normalize-space(text())='" + (msgName) +"']")).click();
		
		//Handle all windows
		String mainwindhandle=driver.getWindowHandle();
		String emailText2=null;
		driver.findElement(By.xpath("//button//span[text()='Preview']")).click();
		Thread.sleep(3000);
		Set s=driver.getWindowHandles();
		Iterator ite=s.iterator();
		while(ite.hasNext())
		{
		    String popupHandle=ite.next().toString();
		    //Switching to the pop-up window 
		    if(!popupHandle.contains(mainwindhandle))
		    {
		                driver.switchTo().window(popupHandle);
		                String pageTitle= driver.getTitle();
		                System.out.println("Page Title: "+pageTitle);
		        		emailText2= driver.findElement(By.xpath("//html//body")).getText().trim();
		        		System.out.println("Email Message at Preview Page: +++++++++ "+emailText2);
		        		driver.switchTo().defaultContent();
		                driver.switchTo().window(mainwindhandle);          
		    }
		}
		Thread.sleep(3000);
		
		Assert.assertEquals("Email Message Assertion", emailText1, emailText2);
		
		//logout
		appUtilities.logOutOfApp(driver);	
}
}