package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRule() throws Exception {
		driver.get(baseUrl + "/");
		//login

		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SelRule"+Calendar.getInstance().getTimeInMillis();

		System.out.println ("sdahfkljhsdaf:"+ruleName);

		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "A Certain field is updated");
		Thread.sleep(5000);
		appUtilities.selectRuleDropDown(driver, "WHEN THIS HAPPENS:", "Select Field...", "City");

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Field...", "First Name");

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");


		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("selenium");


		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Change the value of a field");
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Field...", "Last Name");

		driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("selenium");

		Thread.sleep(3000);		

		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(3000);

		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		//Logout
		appUtilities.logOutOfApp(driver);
	}




}
