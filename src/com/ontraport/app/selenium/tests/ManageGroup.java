package com.ontraport.app.selenium.tests;


import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class ManageGroup extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testMakeATagAndAddItToContact() throws Exception{
		driver.get(baseUrl + "/");
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String groupName = "SelGroup";
		
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Manage Groups']")).click();
		appUtilities.selectItem(driver, "Select Permission...", "Everyone can view & Edit");
		driver.findElement(By.xpath("//input[@type='text' and normalize-space(@placeholder)='Enter Group Name...']")).sendKeys(groupName);
		appUtilities.selectItem(driver, "Select Field...", "Last Name");
		appUtilities.selectItem(driver, "Select Condition...", "contains");
		Thread.sleep (3000);
		driver.findElement(By.xpath("//input[@type='text' and normalize-space(@placeholder)='Enter Value...']")).sendKeys("Sel");
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		Thread.sleep(5000);
		System.out.println("value:"+driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));

		Assert.assertEquals(groupName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		appUtilities.logOutOfApp(driver);
	
	}
	
	
	@Test
	public void testMakeAGroupWithTextField() throws Exception{
		driver.get(baseUrl + "/");
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(3000);
		fillGroupBasicDetails (driver, "Text group", "Everyone can view & Edit", "SelText", "equals");
		driver.findElement(By.xpath("//input[@type='text' and normalize-space(@placeholder)='Enter Value...']")).sendKeys("test");
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		Thread.sleep(5000);
		
		
		System.out.println("value:"+driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));

		Assert.assertEquals("Text group", driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		appUtilities.logOutOfApp(driver);
	
	}
	
	
	@Test
	public void testMakeAGroupWithCheckbox() throws Exception{
		driver.get(baseUrl + "/");
		String groupName = "Chkbox group";
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(3000);
		fillGroupBasicDetails (driver, groupName, "Everyone can view & Edit", "SelText", "equals");
		driver.findElement(By.xpath("//input[@type='text' and normalize-space(@placeholder)='Enter Value...']")).sendKeys("test");
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		Thread.sleep(5000);
		
		
		System.out.println("value:"+driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));

		Assert.assertEquals(groupName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		appUtilities.logOutOfApp(driver);
	
	}
	
	
	@Test
	public void testMakeAGroupWithLongText() throws Exception{
		driver.get(baseUrl + "/");
		String groupName = "Long Text group";
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(3000);
		fillGroupBasicDetails (driver, groupName, "Everyone can view & Edit", "SelLongText", "equals");
		
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		Thread.sleep(5000);
		
		
		System.out.println("value:"+driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));

		Assert.assertEquals(groupName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value").trim());
		appUtilities.logOutOfApp(driver);
	
	}
	
	@Test
	public void testMakeAGroupWithState() throws Exception{
		driver.get(baseUrl + "/");
		String groupName = "State grop";
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(3000);
		fillGroupBasicDetails (driver, groupName, "Everyone can view & Edit", "State", "equals");
		appUtilities.selectItem(driver, "Select...", "Alabama");
		
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(groupName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value").trim());
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Manage Groups']")).click();
		Thread.sleep(5000);
		Assert.assertEquals("State", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("equals", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		Assert.assertEquals("Alabama", driver.findElement(By.xpath("(//input[@type='text'])[6]")).getAttribute("value"));
		
		appUtilities.logOutOfApp(driver);
	
	}
	
	
	@Test
	public void testMakeAGroupWithNumericField() throws Exception{
		driver.get(baseUrl + "/");
		String groupName = "Numeric group";
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(3000);
		fillGroupBasicDetails (driver, groupName, "Everyone can view & Edit", "SelNumeric", "equals");
		driver.findElement(By.xpath("//input[@type='text' and normalize-space(@placeholder)='Enter Value...']")).sendKeys("1");
		
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(groupName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value").trim());
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Manage Groups']")).click();
		Thread.sleep(5000);
		Assert.assertEquals("SelNumeric", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("equals", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		Assert.assertEquals("1", driver.findElement(By.xpath("(//input[@type='text'])[7]")).getAttribute("value"));
		
		appUtilities.logOutOfApp(driver);
	
	}
	
	
	@Test
	public void testMakeAGroupWithDateField() throws Exception{
		driver.get(baseUrl + "/");
		String groupName = "Date grp";
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(3000);
		fillGroupBasicDetails (driver, groupName, "Everyone can view & Edit", "SelDate", "equals");
		driver.findElement(By.xpath("//input[@type='text' and normalize-space(@placeholder)='Enter Value...']")).sendKeys("1/1/2013");
		
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(groupName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value").trim());
		Assert.assertTrue(appUtilities.isTextPresent(driver, "No contacts yet... let's create some"));
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Manage Groups']")).click();
		Thread.sleep(5000);
		Assert.assertEquals("SelDate", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("equals", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		
		
		appUtilities.logOutOfApp(driver);
	
	}
	
	
	
	@Test
	public void testMakeAGroupWithPriceField() throws Exception{
		driver.get(baseUrl + "/");
		String groupName = "Numeric group";
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		Thread.sleep(3000);
		fillGroupBasicDetails (driver, groupName, "Everyone can view & Edit", "SelPrice", "equals");
		driver.findElement(By.xpath("//input[@type='text' and normalize-space(@placeholder)='Enter Value...']")).sendKeys("1");
		
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		Thread.sleep(5000);
		
		Assert.assertEquals(groupName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value").trim());
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Manage Groups']")).click();
		Thread.sleep(5000);
		Assert.assertEquals("SelPrice", driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value"));
		Assert.assertEquals("equals", driver.findElement(By.xpath("(//input[@type='text'])[5]")).getAttribute("value"));
		Assert.assertEquals("1.00", driver.findElement(By.xpath("(//input[@type='text'])[7]")).getAttribute("value"));
		
		appUtilities.logOutOfApp(driver);
	
	}
	
	
	
	public void fillGroupBasicDetails (WebDriver driver, String groupName, String permission, String fieldName, String condition){
	
					
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Manage Groups']")).click();
		appUtilities.selectItem(driver, "Select Permission...", permission);
		driver.findElement(By.xpath("//input[@type='text' and normalize-space(@placeholder)='Enter Group Name...']")).sendKeys(groupName);
		selectDropDownByTyping(driver, "Select Field...", fieldName);
		appUtilities.selectItem(driver, "Select Condition...", condition);
		try {
			Thread.sleep (3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	 
	


}
