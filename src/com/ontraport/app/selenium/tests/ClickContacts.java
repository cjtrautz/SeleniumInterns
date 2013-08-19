package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class ClickContacts extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRule() throws Exception {
		driver.get(baseUrl + "/");
		//login	
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("span.primary-nav-item-label")).click();
		Assert.assertEquals("Contacts", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[2]/span")).getText());
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']/section/nav/ul/li/nav/ul/li[3]/a/span/span")).click();
		driver.findElement(By.cssSelector("span.primary-nav-item-label")).click();
		Assert.assertEquals("Contacts", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[2]/span")).getText());

	}
}