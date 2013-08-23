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

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule_AFieldMeetsGivenCriteria extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testAFieldMeetsGivenCriteriaLongText() throws Exception{
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver);
		String ruleName = "RlLTxt"+Calendar.getInstance().getTimeInMillis();
		
		navigateToNewRuleAndFillCommonFields (driver, ruleName);
		

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select Field...", "SelLongText");
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Value...']")).sendKeys("test");
				
		saveTheRuleAndCommonAssert (driver, ruleName);
		
		Assert.assertEquals("SelLongText", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("Equal To", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("test", driver.findElement(By.xpath("//textarea[@placeholder='Enter Value...']")).getAttribute("value"));
		
		appUtilities.logOutOfApp(driver);
		
		
	}
	
	@Test
	public void testAFieldMeetsGivenCriteriaNumeric() throws Exception{
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver);
		String ruleName = "RlNum"+Calendar.getInstance().getTimeInMillis();
		
		navigateToNewRuleAndFillCommonFields (driver, ruleName);
		

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select Field...", "SelNumeric");
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("1");
				
		saveTheRuleAndCommonAssert (driver, ruleName);
		
		Assert.assertEquals("SelNumeric", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("Equal To", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("1", driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).getAttribute("value"));
		
		appUtilities.logOutOfApp(driver);
		
		
	}
	
	
	@Test
	public void testAFieldMeetsGivenCriteriaPrice() throws Exception{
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver);
		String ruleName = "RlPrc"+Calendar.getInstance().getTimeInMillis();
		
		navigateToNewRuleAndFillCommonFields (driver, ruleName);
		

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select Field...", "SelPrice");
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("1.00");
				
		saveTheRuleAndCommonAssert (driver, ruleName);
		
		Assert.assertEquals("SelPrice", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("Equal To", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("1.00", driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).getAttribute("value"));
		
		appUtilities.logOutOfApp(driver);
		
		
	}
	
	
	
	@Test
	public void testAFieldMeetsGivenCriteriaCheckBox() throws Exception{
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver);
		String ruleName = "RlDt"+Calendar.getInstance().getTimeInMillis();
		
		navigateToNewRuleAndFillCommonFields (driver, ruleName);
		

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select Field...", "SelChkbox");
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-checkbox-empty")).click();
				
		saveTheRuleAndCommonAssert (driver, ruleName);
		
		Assert.assertEquals("SelChkbox", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("Equal To", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		
		
		appUtilities.logOutOfApp(driver);
		
		
	}
	
	@Test
	public void testAFieldMeetsGivenCriteriaState() throws Exception{
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver);
		String ruleName = "RlDt"+Calendar.getInstance().getTimeInMillis();
		
		navigateToNewRuleAndFillCommonFields (driver, ruleName);
		

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select Field...", "State");
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select...", "Alabama");
				
		saveTheRuleAndCommonAssert (driver, ruleName);
		
		Assert.assertEquals("State", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("Equal To", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("Alabama", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		
		appUtilities.logOutOfApp(driver);
		
	}
	
	@Test
	public void testAFieldMeetsGivenCriteriaDate() throws Exception{
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver);
		String ruleName = "RlDt"+Calendar.getInstance().getTimeInMillis();
		
		navigateToNewRuleAndFillCommonFields (driver, ruleName);
		

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select Field...", "SelDate");
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("01/01/2014");
				
		saveTheRuleAndCommonAssert (driver, ruleName);
		
		Assert.assertEquals("SelDate", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("Equal To", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("01/01/2014", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		
		
		appUtilities.logOutOfApp(driver);
		
		
	}
	
	@Test
	public void testAFieldMeetsGivenCriteriaDropDown() throws Exception{
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver);
		String ruleName = "RlDt"+Calendar.getInstance().getTimeInMillis();
		
		navigateToNewRuleAndFillCommonFields (driver, ruleName);
		

		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select Field...", "SelDropdown");
		appUtilities.selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");
		Thread.sleep(3000);
		selectRuleDropDownByTyping(driver, "IF THIS IS TRUE:", "Select...", "SelOption");
				
		saveTheRuleAndCommonAssert (driver, ruleName);
		
		Assert.assertEquals("SelDropdown", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("Equal To", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("SelOption", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		
		appUtilities.logOutOfApp(driver);
		
	}
	
	public void navigateToNewRuleAndFillCommonFields (WebDriver driver, String ruleName) throws Exception {
		

		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ruleName);

		appUtilities.selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "Contact is created");
		Thread.sleep(3000);
		appUtilities.selectRuleDropDown(driver, "THEN DO THIS:", "Select Action...", "Recharge all declined transactions");
		Thread.sleep(3000);
		
	}
	
	
	public void saveTheRuleAndCommonAssert (WebDriver driver, String ruleName) throws InterruptedException{
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		appUtilities.setHundredRecordsPerPage(driver);

		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
		driver.findElement(By.xpath("//a[normalize-space(text())='" + ruleName +"']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals("RuleNameAssertion",ruleName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
/*		Assert.assertEquals("Equal To", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
		Assert.assertEquals("10", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));

		Assert.assertEquals("Any Product", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));*/

	}
	
	
	 public void selectDropDownByTyping (WebDriver driver, String placeHolder, String option){
         System.out.println("**************************************************************");
        
         System.out.println("placeHolder:" + placeHolder);
         System.out.println("option:" + option);
         
         //driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='"+ (itemLink) +"']]/descendant::button")).click();
         WebElement drop = driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='"+ placeHolder +"']]/descendant::button"));
         drop.click();
         driver.findElement(By.xpath("//div//input[normalize-space(@placeholder)='"+ placeHolder +"']")).sendKeys(option);
   
   
         try {
               Thread.sleep(2000);
         } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
         }
         //driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]/descendant::li/div[normalize-space(text())='"+option+"']")).click();
         List<WebElement> childEleP = driver.findElements(By.xpath("//div[input[normalize-space(@placeholder)='"+placeHolder+"']]//li/div"));
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
               List<WebElement> childEle = driver.findElements(By.xpath("//div[input[normalize-space(@placeholder)='"+placeHolder+"']]//li/div"));
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
	 
	 
	 public void selectRuleDropDownByTyping (WebDriver driver, String ruleDesc, String placeHolder, String option){
			System.out.println("**************************************************************");
			System.out.println("ruleDesc:" + ruleDesc);
			System.out.println("placeHolder:" + placeHolder);
			System.out.println("option:" + option);
			WebElement drop = driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+ placeHolder +"']]/descendant::button"));
			drop.click();
			driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div//input[normalize-space(@placeholder)='"+ placeHolder +"']")).sendKeys(option);
		
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
