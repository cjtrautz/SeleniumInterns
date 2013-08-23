package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class ClickTracking extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testCreateRule() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(5000);
		//driver.findElement(By.cssSelector("a.primary-nav-item-link.ussr-state-hover > span.primary-nav-item-label")).click();
		driver.findElement(By.xpath("//li[6]/a/span[2]")).click();
		Assert.assertEquals("By Campaign", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div/div")).getText());
		appUtilities.logOutOfApp(driver);
	}
}
