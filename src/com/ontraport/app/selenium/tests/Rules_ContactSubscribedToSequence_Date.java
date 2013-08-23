package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Rules_ContactSubscribedToSequence_Date extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testRules_ContactSubscribedToSequence_Date () throws Exception{
		
		//logging with https://app.ontraport.com
		driver.get(baseUrl + "/");
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis(); 
		String seqName = "DatSeqEmail"+Calendar.getInstance().getTimeInMillis();
		String ruleName = "SelRSeq"+Calendar.getInstance().getTimeInMillis();
		
		//Click on Sequences
		driver.findElement(By.xpath("//li[@class='primary-nav-sub-item']/a//span[normalize-space(text())='Sequences']")).click();
		Thread.sleep(1000);
		//Click on New Sequence
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Sequence']")).click();
		Thread.sleep(1000);
		//click on create->Date Sequence
		//driver.findElement(By.xpath("//button[@value=''+$l(']")).click();   //for ontraport.com
		driver.findElement(By.xpath("//div[div[*/text()='Date Sequence']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		Thread.sleep(5000);
		
		//Give the sequence name		
		driver.findElement(By.xpath("//div[@class='ussr-pane-editor-name ussr-pane-editor-name']//input[@type='text']")).clear();
		driver.findElement(By.xpath("//div[@class='ussr-pane-editor-name ussr-pane-editor-name']//input[@type='text']")).sendKeys(seqName);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-email']//button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='step_detail_radio']//input[@value='field']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']//input[@placeholder='Select Field...']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@data-val='birthday']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']//input[@placeholder='Select Time To Send...']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@data-val='12:00:am']")).click();
		Thread.sleep(2000);
		appUtilities.selectItemBasedOnIndex(driver, "Select e-mail", 2);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']//input[@placeholder='Select mail from']")).click();
		driver.findElement(By.xpath("//div[@class='ussr-component-drilldownselect-listview sem-listview jb-ace-scroll-target']//li[@data-val='tester@sendpepper.com']")).click();
		Thread.sleep(3000);
		
		appUtilities.selectItemBasedOnIndex(driver, "Select Send From...", 1);
		Thread.sleep(3000);
		
		//Save the Email Step Sequence
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Save']")).click();
		
		appUtilities.setHundredRecordsPerPage (driver);
		
		//To find the created sequence in the List
		Assert.assertTrue(appUtilities.isElementPresent(driver,By.xpath("//span[@class='ussr-component-collection-cell-data-wrapper']/a[normalize-space(text())='" + seqName +"']")));
		
		//Creating the new Rule 
		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Contact is created");
		Thread.sleep(2000);
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "If Contact is subscribed to Sequence");
		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Sequence", seqName );
		Thread.sleep(3000);	
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

		Assert.assertEquals("Rule When it happens assertion","Contact is created", driver.findElement(By.cssSelector("span.sem-statement-text-wrapper")).getText().trim());
		Assert.assertEquals("Rule Condition Assertion","If Contact is subscribed to Sequence:", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span/span[1]")).getText().trim());
		Assert.assertEquals("Sequence type Assertion",seqName, driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());
		Assert.assertEquals("Rule:Then Do this Assertion", "Recharge all declined transactions", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span")).getText().trim());
		
		//Logout
		appUtilities.logOutOfApp(driver);
	}

}
