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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class PauseRule extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testPauseRule() throws Exception {
		
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
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String ruleName = "SelRule"+varTimeStamp;
		
		System.out.println ("sdahfkljhsdaf:"+ruleName);
		
		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);
		
		selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "A Certain field is updated");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[div[text()='WHEN THIS HAPPENS:']]//div[input[normalize-space(@placeholder)='Select Field...']]/descendant::button")));
		selectRuleDropDown(driver, "WHEN THIS HAPPENS:", "Select Field...", "City");
		
		selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[div[text()='IF THIS IS TRUE:']]//div[input[normalize-space(@placeholder)='Select Field...']]/descendant::button")));
		selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Field...", "First Name");
		
		selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("selenium");
		
/*		
		selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Add Contact to Tag");
		selectRuleDropDown(driver, "THEN DO THIS:", "Select Tag", "test");*/
		
		selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Change the value of a field");
		selectRuleDropDown(driver, "THEN DO THIS:", "Select Field...", "Last Name");
		
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("selenium");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//span[text()='Save']")));
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div/div/table/thead/tr/th[2]/a")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		
		
		driver.findElement(By.xpath("//span[a[normalize-space(text())='" + ruleName +"']]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Pause Rule")));
		driver.findElement(By.linkText("Pause Rule")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")));
		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[span[a[normalize-space(text())='"+ruleName+"']]]]")));
		String txt = driver.findElement(By.xpath("//tr[td[span[a[normalize-space(text())='"+ruleName+"']]]]")).getText().trim().toLowerCase();
		System.out.println(txt);
		
		Assert.assertTrue(txt.contains("pause"));
		
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
