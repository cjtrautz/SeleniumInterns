package com.ontraport.app.selenium.tests;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateNote extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testCreateNote() throws Exception {
		//driver.get(baseUrl + "/");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String note="testnote";
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		//login
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Create a new contact
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Contact']")).click();
		
		WebElement fNameTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "First Name");
		fNameTxtBox.clear();
		fNameTxtBox.sendKeys("Fname"+varTimeStamp);
		Thread.sleep(3000);
		
		WebElement lNameTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "Last Name");
		lNameTxtBox.clear();
		lNameTxtBox.sendKeys("lastname"+varTimeStamp);
		Thread.sleep(2000);
		
		String emailId = "selenium"+varTimeStamp+"@test.com";
		WebElement emailTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "Email");
		emailTxtBox.clear();
		emailTxtBox.sendKeys(emailId);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + emailId +"']")));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[normalize-space(text())='" + emailId +"']")).click();
		Thread.sleep(1000);
		
		//navigation to notes...
		driver.findElement(By.xpath("//li[@class='ussr-component ussr-component-tab ontraport_components_tab']//a[normalize-space(text())='Notes']")).click();
		Thread.sleep(3000);
		
		//failing....from here
		driver.findElement(By.xpath("//div[@class='ussr-component-sub-collection-add-new']//span[normalize-space(text())='NEW Note']")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']//textarea")).clear();
		driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']//textarea")).sendKeys(note);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space(text())='Save']")).click();
		Thread.sleep(5000);
		
		//Assert that note created is present
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='"+ note +"']")));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Logout
		//appUtilities.logOutOfApp(driver);
		
	}
}
