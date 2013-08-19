package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;
public class Action_ClickSales extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateAction_ClickSales() throws Exception {
		driver.get(baseUrl + "/");
		//login

		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SCntSubFul"+Calendar.getInstance().getTimeInMillis();
		//Click Sales
		driver.findElement(By.xpath("//*[@id='ussr-chrome-sidebar']//span[normalize-space(text())='Sales']")).click();
		//Assert Purchase
		Assert.assertEquals("Purchases", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div/div")).getText());

		//Logout
		appUtilities.logOutOfApp(driver);
	}
}
