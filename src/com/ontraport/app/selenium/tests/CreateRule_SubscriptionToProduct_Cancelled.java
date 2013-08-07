package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule_SubscriptionToProduct_Cancelled extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRule_SubscriptionToProduct_Cancelled() throws Exception {
		driver.get(baseUrl + "/");
		//login

		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SelRSubSeqUP"+Calendar.getInstance().getTimeInMillis();

		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Subscription to product is Charged, Cancelled, or Completed");
		Thread.sleep(2000);
		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Subscription Product", "Any Subscription Product");
		Thread.sleep(5000);
		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select...", "Cancelled");
		Thread.sleep(5000);

		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Recharge all declined transactions");
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

		Assert.assertEquals("Rule When it happens assertion","Subscription to", driver.findElement(By.cssSelector("span.sem-statement-text-wrapper")).getText().trim());
		Assert.assertEquals("Sequence type Assertion","Any Subscription Product", driver.findElement(By.xpath("(//input[@type='text'])[2]")).getAttribute("value").trim());
		Assert.assertEquals("Assertion","Cancelled", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());
		Assert.assertEquals("Rule:Then Do this Assertion", "Recharge all declined transactions", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/span")).getText().trim());
		

		//Logout
		appUtilities.logOutOfApp(driver);
	}

}
