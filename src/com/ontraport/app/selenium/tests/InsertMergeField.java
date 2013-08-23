package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class InsertMergeField extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testInsertMergeField () throws Exception {
		driver.get(baseUrl + "/");
		String msgName = "Sel"+Calendar.getInstance().getTimeInMillis();
		
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		//Create any message
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Messages']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Message']")).click();
		
		driver.findElement(By.xpath("//div[div[*/text()='E-Mail']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		Thread.sleep(6000);
		
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]"));
		
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[input[normalize-space(@placeholder)='Insert Merge Field']]/descendant::button"));
		appUtilities.selectItem(driver, "Insert Merge Field", "First Name");
		
		driver.switchTo().frame(1);
		String emailText= driver.findElement(By.cssSelector("body")).getText().trim();
		driver.findElement(By.cssSelector("body")).getText().trim();
		driver.switchTo().defaultContent();
		
		Assert.assertTrue(emailText.contains("[First Name]"));
		//logout
		appUtilities.logOutOfApp(driver);
	}
}
