package com.ontraport.app.selenium.tests;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import com.ontraport.app.selenium.tools.OntraportFirefoxTest;
public class Action_ClickPartners extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateAction_ClickPartners() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SCntSubFul"+Calendar.getInstance().getTimeInMillis();
		// Partners
		driver.findElement(By.xpath("//*[@id='ussr-chrome-sidebar']//span[normalize-space(text())='Partners']")).click();
		//Assert Affiliates
		Assert.assertEquals("Affiliates", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div/div")).getText());

		//Logout
		appUtilities.logOutOfApp(driver);
	}
}
