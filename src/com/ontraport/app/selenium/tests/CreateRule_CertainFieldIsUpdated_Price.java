package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule_CertainFieldIsUpdated_Price extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRule() throws Exception {
		//driver.get(baseUrl + "/");
		//login
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search = String.valueOf(varTimeStamp);
		String ruleName = "SelFldUpdt"+varTimeStamp;
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "A Certain field is updated");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div/input")).sendKeys("pri");
		appUtilities.selectRuleDropDownWithSearch(driver, "WHEN THIS HAPPENS:", "Select Field...", "Price");
		Thread.sleep(5000);
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Recharge all declined transactions");
		Thread.sleep(3000);		

		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		//appUtilities.setHundredRecordsPerPage (driver);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]/div[5]/div/div/div/input")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();
		
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		driver.findElement(By.xpath("//a[normalize-space(text())='" + ruleName +"']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("RuleNameAssertion",ruleName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		Assert.assertEquals("Rule:When This Happens Assertion", "Price", driver.findElement(By.xpath("(//input[@type='text'])[2]")).getAttribute("value"));
		Assert.assertEquals("Rule:Then Do this Assertion", "Recharge all declined transactions", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/span")).getText());
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Logout
		//appUtilities.logOutOfApp(driver);
	}



}
