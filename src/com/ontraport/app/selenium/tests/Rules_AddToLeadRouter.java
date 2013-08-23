package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Rules_AddToLeadRouter extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testRules_AddToLeadRouter() throws Exception {
		driver.get(baseUrl + "/");
		String ruleName = "SelRule"+Calendar.getInstance().getTimeInMillis();
		String routername = "SelTitle"+Calendar.getInstance().getTimeInMillis();
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		//Create a lead router
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		Thread.sleep (2000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/ul/li[3]/a/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Lead Router']")).click();
		Thread.sleep (2000);
		driver.findElement(By.xpath("//div[div[a[text()='Weighted Random']]]/descendant::a/button")).click();

		Thread.sleep (5000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(routername);
		
		driver.findElement(By.xpath("//div[@class='target-rout ussr-component ussr-component-lead_rout_target ontraport_components_lead_rout_target'][1]//button")).click();
		Thread.sleep(2000);
		String s1 = driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[1]")).getText();
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[1]")).click();
		
		driver.findElement(By.xpath("//div[@class='lead_rout_entry_row']//div[@class='header_box target-break ussr-component ussr-component-form_control_input_text ontraport_components_form_control_input_text ussr-form-cell ussr-component-form-control clearfix']//input")).clear();
		driver.findElement(By.xpath("//div[@class='lead_rout_entry_row']//div[@class='header_box target-break ussr-component ussr-component-form_control_input_text ontraport_components_form_control_input_text ussr-form-cell ussr-component-form-control clearfix']//input")).sendKeys("50");
			
		driver.findElement(By.xpath("//div/div[text()='Add User']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='target-rout ussr-component ussr-component-lead_rout_target ontraport_components_lead_rout_target'][2]//button")).click();
		
		String s2 = driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[2]")).getText();
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[2]")).click();
		
		
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("50");
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(6000);
		
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (routername) +"']")));
		
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
		
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Add to Lead Router");
		Thread.sleep(3000);	
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Lead router", routername);
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
		Assert.assertEquals("Rule:Then Do this Assertion", "Add to", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[1]")).getText().trim());
		Assert.assertEquals("Tag Assertion", routername, driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());
		
		//Logout
		appUtilities.logOutOfApp(driver);
}

}
