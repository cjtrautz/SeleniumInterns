package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class ClickTasks extends OntraportFirefoxTest  {

	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testCreateRule() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Tasks")).click();
		Assert.assertEquals("Tasks", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div/div")).getText());
		appUtilities.logOutOfApp(driver);
		
	}
}
	
