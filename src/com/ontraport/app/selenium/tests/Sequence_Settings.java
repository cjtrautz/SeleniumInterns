package com.ontraport.app.selenium.tests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;
public class Sequence_Settings extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void Update_RunSequenceOnWeekend() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
				
		//Click Sequence
		driver.findElement(By.xpath("//*[@id='ussr-chrome-sidebar']//span[normalize-space(text())='Sequences']")).click();
		driver.findElement(By.xpath("//tr[1]//td[@class='ussr-component-collection-cell ussr-component-collection-cell-type-text']//span//a")).click();
		Thread.sleep(3000);
		//Click Settings
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Settings']")).click();
		Thread.sleep(3000);
		
		//Select First Check box
		WebElement element= driver.findElement(By.xpath("//div[label[normalize-space(text())='Run this sequence only on weekends']]//span[@class='ussr-icon ussr-icon-checkbox-empty']"));
		boolean displayed=element.isDisplayed();
		System.out.println("Is displayed?? "+ displayed);
		
		if(displayed){
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Run this sequence only on weekends']]//span[@class='ussr-icon ussr-icon-checkbox-empty']")).click();
		}else
		{
			driver.findElement(By.xpath("//div[label[normalize-space(text())='Run this sequence only on weekends']]//span[@class='ussr-icon ussr-icon-checkbox-checked']")).click();
			System.out.println("Selecting the 'Run this sequence only on weekends' check box");
			driver.findElement(By.xpath("//div[label[normalize-space(text())='Run this sequence only on weekends']]//span[@class='ussr-icon ussr-icon-checkbox-empty']")).click();
		}
		//Save Settings
		driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Save Settings']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Save']")).click();
		
		//Click Sequence
		driver.findElement(By.cssSelector("span.primary-nav-item-label")).click();
		driver.findElement(By.xpath("//*[@id='ussr-chrome-sidebar']//span[normalize-space(text())='Sequences']")).click();
		//Click Settings
		driver.findElement(By.xpath("//tr[1]//td[@class='ussr-component-collection-cell ussr-component-collection-cell-type-text']//span//a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Settings']")).click();
		
		//Verify the Checked option from Setting
		Assert.assertTrue("Is Selected", driver.findElement(By.xpath("//div[label[normalize-space(text())='Run this sequence only on weekends']]//span[@class='ussr-icon ussr-icon-checkbox-checked']")).isEnabled());
				
		//Logout
		appUtilities.logOutOfApp(driver);
	      }
	
	@Test
	public void Update_UnsubscribeContact() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
				
		//Click Sequence
		driver.findElement(By.xpath("//*[@id='ussr-chrome-sidebar']//span[normalize-space(text())='Sequences']")).click();
		driver.findElement(By.xpath("//tr[1]//td[@class='ussr-component-collection-cell ussr-component-collection-cell-type-text']//span//a")).click();
		Thread.sleep(3000);
		//Click Settings
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Settings']")).click();
		Thread.sleep(3000);
		
		//Select second Check box
		WebElement element= driver.findElement(By.xpath("//div[label[normalize-space(text())='Unsubscribe contact after last step']]//span[@class='ussr-icon ussr-icon-checkbox-empty']"));
		boolean displayed=element.isDisplayed();
		System.out.println("Is displayed?? "+ displayed);
		
		if(displayed){
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Unsubscribe contact after last step']]//span[@class='ussr-icon ussr-icon-checkbox-empty']")).click();
		}else
		{
			driver.findElement(By.xpath("//div[label[normalize-space(text())='Unsubscribe contact after last step']]//span[@class='ussr-icon ussr-icon-checkbox-checked']")).click();
			System.out.println("Selecting the 'Unsubscribe contact after last step' Check box");
			driver.findElement(By.xpath("//div[label[normalize-space(text())='Unsubscribe contact after last step']]//span[@class='ussr-icon ussr-icon-checkbox-empty']")).click();
		}
		//Save Settings
		driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Save Settings']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Save']")).click();
		
		//Click Sequence
		driver.findElement(By.cssSelector("span.primary-nav-item-label")).click();
		driver.findElement(By.xpath("//*[@id='ussr-chrome-sidebar']//span[normalize-space(text())='Sequences']")).click();
				
		//Click at First Sequence
		driver.findElement(By.xpath("//tr[1]//td[@class='ussr-component-collection-cell ussr-component-collection-cell-type-text']//span//a")).click();
		Thread.sleep(3000);
		//Click Settings
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[normalize-space(text())='Settings']")).click();
		
		//Verify the Checked option from Setting
		Assert.assertTrue("Is Selected", driver.findElement(By.xpath("//div[label[normalize-space(text())='Unsubscribe contact after last step']]//span[@class='ussr-icon ussr-icon-checkbox-checked']")).isEnabled());
				
		//Logout
		appUtilities.logOutOfApp(driver);
	      }
}