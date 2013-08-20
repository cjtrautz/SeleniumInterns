package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Rules_PingAURL extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testPingAURL () throws Exception {
		driver.get(baseUrl + "/");
		String ruleName = "SelRule"+Calendar.getInstance().getTimeInMillis();
		String urlName="http://google.co.in";
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");

		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Contact is created");
		Thread.sleep(2000);
		
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Ping a URL");
		Thread.sleep(2000);	
		
		//Filling the URL area
		driver.findElement(By.xpath("//div[label[text()='URL']]//textarea")).clear();
		driver.findElement(By.xpath("//div[label[text()='URL']]//textarea")).sendKeys(urlName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']//input[@placeholder='Insert Merge Field']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='First Name']")).click();

		//Filling the Post Data Area
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='First Name']")).click();
	
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
		Assert.assertEquals("Rule:Then Do this Assertion--URL", (urlName+"[First Name]"), driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/textarea")).getAttribute("value"));
		Assert.assertEquals("Rule:Then Do this Assertion--Post Data", "[First Name]", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/div[4]/div/div/textarea")).getAttribute("value"));
		
		//Logout
		appUtilities.logOutOfApp(driver);
}

}
