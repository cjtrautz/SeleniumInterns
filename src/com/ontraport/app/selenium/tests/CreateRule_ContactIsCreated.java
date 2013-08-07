package com.ontraport.app.selenium.tests;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule_ContactIsCreated extends OntraportFirefoxTest {

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
		String ruleName = "SelRule"+varTimeStamp;

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Contact is created");
		Thread.sleep(5000);
		
		selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Recharge all declined transactions");
		Thread.sleep(3000);		

		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]/div[5]/div/div/div/input")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();

		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		
		driver.findElement(By.xpath("//a[normalize-space(text())='" + ruleName +"']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("RuleNameAssertion",ruleName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		Assert.assertEquals("Rule:When This Happens Assertion", "Contact is created", driver.findElement(By.cssSelector("span.sem-statement-text-wrapper")).getText());
		Assert.assertEquals("Rule:Then Do this Assertion", "Recharge all declined transactions", driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/span")).getText());
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Logout
		//appUtilities.logOutOfApp(driver);
	}


	public void selectRuleDropDown (WebDriver driver, String ruleDesc, String placeHolder, String option){
		System.out.println("**************************************************************");
		System.out.println("ruleDesc:" + ruleDesc);
		System.out.println("placeHolder:" + placeHolder);
		System.out.println("option:" + option);
		WebElement drop = driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+ placeHolder +"']]/descendant::button"));
		drop.click();



		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]/descendant::li/div[normalize-space(text())='"+option+"']")).click();
		List<WebElement> childEleP = driver.findElements(By.xpath("//div[div[text()='"+ruleDesc
				+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]//li/div"));
		//Iterator<WebElement> childEleIteratorP = childEleP.iterator();
		System.out.println("*************ChildItems************");
		System.out.println("Number:"+childEleP.size());

		for (int i = 0; i < childEleP.size(); i++) {
			drop.sendKeys(Keys.ARROW_DOWN);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> childEle = driver.findElements(By.xpath("//div[div[text()='"+ruleDesc
					+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]//li/div"));
			Iterator<WebElement> childEleIterator = childEle.iterator();
			while (childEleIterator.hasNext()) {
				WebElement webElement = (WebElement) childEleIterator.next();
				System.out.println(webElement.getText());
				if (webElement.getText().trim().equalsIgnoreCase(option.trim())){
					webElement.click();
					return;
				}

			}
		}


	}




}
