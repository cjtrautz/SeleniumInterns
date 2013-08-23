package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class LeadScoring_ContactSubscribedToTag extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testLeadScoring_ContactSubscribedToTag () throws Exception{
		
		//logging with https://app.ontraport.com
		driver.get(baseUrl + "/");
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String tagName = "SelTag"+Calendar.getInstance().getTimeInMillis();
		
		//Create a New Tag
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//ul[@class='ussr-corner-bl']/li/a[text()='Admin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a/div[text()='MANAGE TAGS']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Tag']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(tagName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		appUtilities.setHundredRecordsPerPage (driver);
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (tagName) +"']")));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='LEAD SCORING']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
		Thread.sleep(2000);
		
		appUtilities.selectRuleDropDown (driver, "CONTACT SCORING CONDITIONS:","Select Condition", "If Contact is subscribed to Tag");
		Thread.sleep(2000);
		appUtilities.selectRuleDropDown (driver, "CONTACT SCORING CONDITIONS:","Select Tag", tagName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']//input")).clear();
		driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']//input")).sendKeys("10");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='LEAD SCORING']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("Lead Scoring Assertion","If Contact is subscribed to Tag:", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span/span[1]")).getText().trim());
		Assert.assertEquals("Tag Assertion", tagName, driver.findElement(By.xpath("(//input[@type='text'])")).getAttribute("value").trim());
		Assert.assertEquals("Tag Assertion", "10", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());
		Thread.sleep(2000);
		
		//return to initial state
		driver.findElement(By.xpath("//div[@class='sem-delete-statement display-inline-block ussr-round-left ussr-texture-flat-light ussr-helper-cursor-pointer ussr-border-solid-all']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(2000);
		//Logout
		appUtilities.logOutOfApp(driver);
}


}
