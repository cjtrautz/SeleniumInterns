package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class LeadScoring_SubscriptionToSequencePaused_Step extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testLeadScoring_SubscriptionToSequencePaused_Step () throws Exception{

		//logging with https://app.ontraport.com
		driver.get(baseUrl + "/");
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String seqName = "StepSeqEmail"+Calendar.getInstance().getTimeInMillis();

		//Click on Sequences
		driver.findElement(By.xpath("//li[@class='primary-nav-sub-item']/a//span[normalize-space(text())='Sequences']")).click();
		Thread.sleep(1000);

		//Click on New Sequence
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Sequence']")).click();
		Thread.sleep(1000);

		//click on create->Step Sequence
		driver.findElement(By.xpath("//div[div[*/text()='Step Sequence']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		Thread.sleep(6000);

		//Give the sequence name
		driver.findElement(By.xpath("//div[@class='ussr-pane-editor-name ussr-pane-editor-name']//input[@type='text']")).clear();
		driver.findElement(By.xpath("//div[@class='ussr-pane-editor-name ussr-pane-editor-name']//input[@type='text']")).sendKeys(seqName);

		Thread.sleep(3000);
		//Click on Email button
		driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-email']//span[normalize-space(text())='Email']")).click();

		//Select Email Name, Email from and send from; Always select the first value in the dropdown list
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

		appUtilities.selectRuleDropDown (driver, "CONTACT SCORING CONDITIONS:","Select Condition", "Subscription to a sequence is paused");
		Thread.sleep(2000);
		appUtilities.selectRuleDropDown (driver, "CONTACT SCORING CONDITIONS:","Select Sequence", seqName);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']//input")).clear();
		driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']//input")).sendKeys("11");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='LEAD SCORING']")).click();
		Thread.sleep(5000);

		Assert.assertEquals("Lead Scoring Assertion","Subscription", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[1]")).getText().trim());
		Assert.assertEquals("Lead Scoring Assertion", seqName, driver.findElement(By.xpath("(//input[@type='text'])")).getAttribute("value").trim());
		Assert.assertEquals("Lead Scoring Assertion","is paused", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[3]")).getText().trim());
		Assert.assertEquals("Lead Scoring Assertion", "11", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());

		Thread.sleep(2000);
		//return to initial state
		driver.findElement(By.xpath("//div[@class='sem-delete-statement display-inline-block ussr-round-left ussr-texture-flat-light ussr-helper-cursor-pointer ussr-border-solid-all']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='component-score-editor-degredation clearfix ussr-border-solid-tb ussr-texture-flat-light']//input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(1000);
		//Logout
		appUtilities.logOutOfApp(driver);
}

}
