package com.ontraport.app.selenium.tests;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Rules_AddATask extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testRules_AddATask() throws Exception {
		driver.get(baseUrl + "/");
		String taskName = "SelRule"+Calendar.getInstance().getTimeInMillis();
		String ruleName = "SelRule"+Calendar.getInstance().getTimeInMillis();
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		//Create a New Task
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Messages']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Message']")).click();
		driver.findElement(By.xpath("//div[div[*/text()='Task']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(taskName);
		Thread.sleep(2000);
		appUtilities.getTextBoxOnTheLabel(driver, "Task Subject").sendKeys("This is new Task!");
		appUtilities.getTextBoxOnTheLabel(driver, "Due Date").sendKeys("1");
		Thread.sleep(2000);
		selectItem("Select User", "Pin Chen");
		Thread.sleep(2000);
		selectItem("Insert Merge Field", "First Name");
		selectItem("Insert Merge Field", "First Name");
		driver.findElement(By.xpath("//*[@class='task_notification_control']//span")).click();
		Thread.sleep(2000);
		fillTaskOwnerNotification (driver);
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		Thread.sleep(4000);
		
		WebElement scrollElement = driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]"));
		appUtilities.scrollUntillElementFound(driver, scrollElement, By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div[4]/div"));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select OUTCOME NAME...']]/descendant::button")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("span.ussr-component-drilldownselect-subMenu-item-label.text-overflow-ellipsis")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("Selenium Outcome");
		driver.findElement(By.xpath("//div/span[text()='Select']")).click();
		Thread.sleep(2000);
		selectItem("Select Action...", "Recharge all declined transactions");
		driver.findElement(By.xpath("//div/span[text()='Save']")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(2000);
		appUtilities.setHundredRecordsPerPage(driver);
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (taskName) +"']")));
		
		//Create the new rule
		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Contact is created");
		Thread.sleep(2000);
		
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Add Task");
		Thread.sleep(3000);	
		
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Message", taskName);
		Thread.sleep(3000);
	
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
		Assert.assertEquals("Rule:Then Do this Assertion", "Send a", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[1]")).getText().trim());
		Assert.assertEquals("Email Assertion",taskName, driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value").trim());
		
		//Logout
		appUtilities.logOutOfApp(driver);
}


public void selectItem(String itemLink, String itemName ){
	
	
	try {
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='"+ (itemLink) +"']]/descendant::button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[input[@placeholder='"+ (itemLink) +"']]/descendant::li/div[text()='"+ (itemName) +"']")).click();
	} catch (InterruptedException e) {

	}
}

public void fillTaskOwnerNotification (WebDriver driver){
	String[] str = {"Contact Owner", "After Task is Assigned"} ;
	List<WebElement> childElement = driver.findElements(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]"));
	Iterator< WebElement> childItr = childElement.iterator();
	for (int i = 0; i < childElement.size()-1; i++) {
		WebElement ele = childItr.next();
		ele.findElement(By.xpath(".//button")).click();
		driver.findElement(By.xpath("//li/div[text()='"+str[i] + "']")).click();
		//li/div[text()='After Task is Assigned']
		
	}
	
	driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("1");
	
}
}