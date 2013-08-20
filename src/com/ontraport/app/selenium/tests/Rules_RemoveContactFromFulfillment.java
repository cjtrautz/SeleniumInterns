package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Rules_RemoveContactFromFulfillment extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testRules_RemoveContactFromFulfillment() throws Exception {
		driver.get(baseUrl + "/");
		String fulfilName="SelFul"+Calendar.getInstance().getTimeInMillis();
		String ruleName = "SelRule"+Calendar.getInstance().getTimeInMillis();
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		//Create a New Fulfillment
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//ul[@class='ussr-corner-bl']/li/a[text()='Admin']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a/div[text()='FULFILLMENT MANAGER']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Fulfillment List']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(fulfilName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		driver.findElement(By.xpath("//div[text()='Daily']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
		driver.findElement(By.xpath("//div[text()='12:00am']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[6]/div[2]/div/div/div[1]/span/div/div/input")).click();
		driver.findElement(By.xpath("//div[text()='First Name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(1000);
		appUtilities.setHundredRecordsPerPage (driver);
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (fulfilName) +"']")));
		
		//Create the new rule
		//Click Rules
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Contact is created");
		Thread.sleep(2000);
		
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Remove Contact from Fulfillment List");
		Thread.sleep(3000);	
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Fulfillment List", fulfilName);
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
		Assert.assertEquals("Rule:Then Do this Assertion", "Remove Contact from Fulfillment List:", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span/span[1]")).getText().trim());
		Assert.assertEquals("Tag Assertion", fulfilName, driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());
		
		//Logout
		appUtilities.logOutOfApp(driver);
	}

}
