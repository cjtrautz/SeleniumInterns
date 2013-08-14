package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Rules_SendAMessage extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testRules_SendAMessage() throws Exception {
		driver.get(baseUrl + "/");
		String msgName = "Sel"+Calendar.getInstance().getTimeInMillis();
		String ruleName = "SelRule"+Calendar.getInstance().getTimeInMillis();
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		//Create an Email Message
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Messages']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Message']")).click();
				
		driver.findElement(By.xpath("//div[div[*/text()='E-Mail']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		Thread.sleep(6000);
		//driver.findElement(By.xpath("//input[@type='text']")).clear();
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
		
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("body")).sendKeys("Selenium Test");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]"));
		
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[input[normalize-space(@placeholder)='Insert Merge Field']]/descendant::button"));
		appUtilities.selectItem(driver, "Insert Merge Field", "First Name");
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[4]/button[3]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='100']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (msgName) +"']")));
		
		//Create the new rule
		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Contact is created");
		Thread.sleep(2000);
		
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Send an E-mail");
		Thread.sleep(3000);	
		
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Message", msgName);
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		appUtilities.setHundredRecordsPerPage (driver);
		//Assert existence of Rule Name in Rules page
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		//Click the rule name hyper link
		driver.findElement(By.xpath("//a[normalize-space(text())='" + ruleName +"']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("RuleNameAssertion",ruleName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));

		Assert.assertEquals("Rule When it happens assertion","Contact is created", driver.findElement(By.cssSelector("span.sem-statement-text-wrapper")).getText().trim());
		Assert.assertEquals("Rule:Then Do this Assertion", "Send a", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[1]")).getText().trim());
		Assert.assertEquals("Email Assertion",msgName, driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());
		
		//Logout
		appUtilities.logOutOfApp(driver);
	}

}
