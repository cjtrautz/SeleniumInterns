package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule_HasBeenOnSeq extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRule_HasBeenOnSeq() throws Exception {
		//driver.get(baseUrl + "/");
		//login
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SelHBOSq"+Calendar.getInstance().getTimeInMillis();
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

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
		
		
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Has been on a sequence for a certain amount of time");
		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Sequence", "Any Sequence");
		
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("1");

		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select...", "Days");
		Thread.sleep(3000);
				
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		//appUtilities.setHundredRecordsPerPage(driver);

		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		driver.findElement(By.xpath("//a[normalize-space(text())='" + ruleName +"']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("RuleNameAssertion",ruleName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		Assert.assertEquals("Any Sequence", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("1", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("Days", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Logout
		//appUtilities.logOutOfApp(driver);
	}




}
