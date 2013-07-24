package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testCreateRule() throws Exception {
		
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SelRule"+Calendar.getInstance().getTimeInMillis();
		
		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text' and @class='ussr-form-input ussr-form-state-default']")).clear();
		driver.findElement(By.xpath("//input[@type='text' and @class='ussr-form-input ussr-form-state-default']")).sendKeys(ruleName);
		
		selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "A Certain field is updated");
		selectRuleDropDown(driver, "WHEN THIS HAPPENS:", "Select Field...", "City");
		
		selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Field...", "First Name");
		
		selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("selenium");
		
		
		selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Add Contact to Tag");
		selectRuleDropDown(driver, "THEN DO THIS:", "Select Tag", "test");
		
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));


		//Logout
		appUtilities.logOutOfApp(driver);
	}
	
	
	public void selectRuleDropDown (WebDriver driver, String ruleDesc, String placeHolder, String option){
		driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+ placeHolder +"']]/descendant::button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]/descendant::li/div[normalize-space(text())='"+option+"']")).click();

	}

}
