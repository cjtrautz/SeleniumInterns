package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class PastePlainText extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testPaste() throws Exception {
		driver.get(baseUrl + "/");
		String msgName = "Sel"+Calendar.getInstance().getTimeInMillis();
		String message1= "Selenium Test";
		String message2= "testing text";
		
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");

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
		driver.findElement(By.cssSelector("body")).sendKeys(message1);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]"));
		
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[input[normalize-space(@placeholder)='Insert Merge Field']]/descendant::button"));
		appUtilities.selectItem(driver, "Insert Merge Field", "First Name");
		
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		String emailText1= driver.findElement(By.cssSelector("body")).getText().trim();
		System.out.println("Email Message 1: "+emailText1);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(3000);
		
		appUtilities.setHundredRecordsPerPage(driver);
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (msgName) +"']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[normalize-space(text())='" + (msgName) +"']")).click();
		
		driver.findElement(By.xpath("//a[@title='Paste as plain text']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//textarea[@class='cke_dialog_ui_input_textarea']")).click();
		driver.findElement(By.xpath("//textarea[@class='cke_dialog_ui_input_textarea']")).clear();
		driver.findElement(By.xpath("//textarea[@class='cke_dialog_ui_input_textarea']")).sendKeys(message2);
		driver.findElement(By.xpath("//a[@title='OK']")).click();
		Thread.sleep(2000);

		//Assertion of Text pasted
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		String emailText2= driver.findElement(By.cssSelector("body")).getText().trim();
		System.out.println("Email Message 2: "+emailText2);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();

		Assert.assertNotEquals("Strings before and after", emailText1, emailText2);
		Assert.assertTrue(emailText2.contains(message2)); 
		
		//logout
		appUtilities.logOutOfApp(driver);
	}

}
