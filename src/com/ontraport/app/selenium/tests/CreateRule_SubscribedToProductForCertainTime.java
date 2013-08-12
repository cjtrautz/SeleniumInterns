package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule_SubscribedToProductForCertainTime  extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRule_SubscribedToProductForCertainTime() throws Exception {
		driver.get(baseUrl + "/");
		//login

		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SelSubPr"+Calendar.getInstance().getTimeInMillis();

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
		
		
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Has been subscribed to a product for a certain amount of time");
		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Subscription Product", "Any Subscription Product");
		
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("10");

		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select...", "Days");
		Thread.sleep(3000);
				
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		appUtilities.setHundredRecordsPerPage(driver);

		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		driver.findElement(By.xpath("//a[normalize-space(text())='" + ruleName +"']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("RuleNameAssertion",ruleName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		Assert.assertEquals("Any Subscription Product", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("10", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("Days", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		

		

		//Logout
		appUtilities.logOutOfApp(driver);
	}




}
