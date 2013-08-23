package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class LeadScoring_ContactSubscribedToSeq_Date extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testContactSubscribedToSeq_Date () throws Exception{
		
		//logging with https://app.ontraport.com
		driver.get(baseUrl + "/");
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis(); 
		String seqName = "DateEmail"+Calendar.getInstance().getTimeInMillis();
		
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
		
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='LEAD SCORING']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
		Thread.sleep(1000);
		
		appUtilities.selectRuleDropDown (driver, "CONTACT SCORING CONDITIONS:","Select Condition", "If Contact is subscribed to Sequence");
		Thread.sleep(2000);
		appUtilities.selectRuleDropDown (driver, "CONTACT SCORING CONDITIONS:","Select Sequence", seqName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']//input")).clear();
		driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']//input")).sendKeys("1");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='LEAD SCORING']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("Lead Scoring Assertion","If Contact is subscribed to Sequence:", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span/span[1]")).getText().trim());
		Assert.assertEquals("Tag Assertion", seqName, driver.findElement(By.xpath("(//input[@type='text'])")).getAttribute("value").trim());
		Assert.assertEquals("Tag Assertion", "1", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());
		Thread.sleep(2000);
		//return to initial state
		driver.findElement(By.xpath("//div[@class='sem-delete-statement display-inline-block ussr-round-left ussr-texture-flat-light ussr-helper-cursor-pointer ussr-border-solid-all']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(1000);
		//Logout
		appUtilities.logOutOfApp(driver);
}
}
