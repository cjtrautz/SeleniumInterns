package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule_IfContactSubscribedFulfillmentList extends OntraportFirefoxTest{

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRule_HasBeenOnSeq() throws Exception {
		driver.get(baseUrl + "/");
		//login

		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SCntSubFul"+Calendar.getInstance().getTimeInMillis();

		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Contact is created");
		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Recharge all declined transactions");
		Thread.sleep(3000);
		
		
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "If Contact is subscribed to Fulfillment List");
		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Fulfillment List", "Any Fulfillment List");
		Thread.sleep(3000);
				
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		appUtilities.setHundredRecordsPerPage(driver);

		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		driver.findElement(By.xpath("//a[normalize-space(text())='" + ruleName +"']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("RuleNameAssertion",ruleName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		Assert.assertEquals("Any Fulfillment List", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("Rule When it happens assertion","Contact is created", driver.findElement(By.cssSelector("span.sem-statement-text-wrapper")).getText().trim());
		Assert.assertEquals("Rule:Then Do this Assertion", "Recharge all declined transactions", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/span")).getText().trim());


		//Logout
		appUtilities.logOutOfApp(driver);
	}




}
