package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class ClickPages extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void testCreateRule() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sales")).click();
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']/section/nav/ul/li[5]/a/span[2]")).click();
		Assert.assertEquals("Landing Pages", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div/div")).getText());
		appUtilities.logOutOfApp(driver);
	}
}
