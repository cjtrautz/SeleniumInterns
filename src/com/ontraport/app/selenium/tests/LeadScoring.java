package com.ontraport.app.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;
import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import com.opera.core.systems.scope.protos.ExecProtos.MouseActionOrBuilder;

public class LeadScoring extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testLeadScoringText() throws Exception{
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver);
		//Navigate to Lead Scoring page 
		appUtilities.navigateTo(driver, "Contacts==Settings");
		driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
				
		appUtilities.selectItem(driver, "Select Condition", "Field is this value");
		selectDropDownByTyping(driver, "Select Field...", "SelText");
		
		appUtilities.selectItem(driver, "Select Condition...", "Equal To");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("test");
		
		driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
		driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");

		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		Thread.sleep(5000);
		
		appUtilities.navigateTo(driver, "Contacts==Settings");
		driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
		Thread.sleep(5000);
		try{
		Assert.assertEquals("SelText", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
		Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
		Assert.assertEquals("test", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Enter Value..."))).getAttribute("value").trim());
		Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
		}catch (Exception e){
			
		}
		finally{
			driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			appUtilities.logOutOfApp(driver);
		}
	}
	
	
		@Test
		public void testLeadScoringCheckbox() throws Exception{
			driver.get(baseUrl + "/");
			//login
			appUtilities.loginToApp(driver);
			//Navigate to Lead Scoring page 
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
					
			appUtilities.selectItem(driver, "Select Condition", "Field is this value");
			selectDropDownByTyping(driver, "Select Field...", "SelChkbox");
			
			appUtilities.selectItem(driver, "Select Condition...", "Equal To");
			
			driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-checkbox-empty")).click();
			
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");

			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			try{
			Assert.assertEquals("SelChkbox", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
			Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
			Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
			}catch (Exception e){
				
			}
			finally{
				driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
				driver.findElement(By.xpath("//button//span[text()='Save']")).click();
				Thread.sleep(5000);
				appUtilities.logOutOfApp(driver);
			}
			
	
	}
		
		
		@Test
		public void testLeadScoringDate() throws Exception{
			driver.get(baseUrl + "/");
			//login
			appUtilities.loginToApp(driver);
			//Navigate to Lead Scoring page 
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
					
			appUtilities.selectItem(driver, "Select Condition", "Field is this value");
			selectDropDownByTyping(driver, "Select Field...", "SelDate");
			
			appUtilities.selectItem(driver, "Select Condition...", "Equal To");
			
			driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("01/01/2014");
			
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");

			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			try{
			Assert.assertEquals("SelDate", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
			Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
			Assert.assertEquals("01/01/2014", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Enter Value..."))).getAttribute("value").trim());
			Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
			}catch (Exception e){
				
			}
			finally{
				driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
				driver.findElement(By.xpath("//button//span[text()='Save']")).click();
				Thread.sleep(5000);
				appUtilities.logOutOfApp(driver);
			}
		}
	
		@Test
		public void testLeadScoringLongText() throws Exception{
			driver.get(baseUrl + "/");
			//login
			appUtilities.loginToApp(driver);
			//Navigate to Lead Scoring page 
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
					
			appUtilities.selectItem(driver, "Select Condition", "Field is this value");
			selectDropDownByTyping(driver, "Select Field...", "SelLongText");
			
			appUtilities.selectItem(driver, "Select Condition...", "Equal To");
			
			driver.findElement(By.xpath("//textarea")).sendKeys("test");
			
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			try{
			Assert.assertEquals("SelLongText", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
			Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
			Assert.assertEquals("test", driver.findElement(By.xpath("//textarea")).getAttribute("value").trim());
			Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
			}catch (Exception e){
				
			}
			finally{
				driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
				driver.findElement(By.xpath("//button//span[text()='Save']")).click();
				Thread.sleep(5000);
				appUtilities.logOutOfApp(driver);
			}
		}
		
		
		@Test
		public void testLeadScoringNumeric() throws Exception{
			driver.get(baseUrl + "/");
			//login
			appUtilities.loginToApp(driver);
			//Navigate to Lead Scoring page 
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
					
			appUtilities.selectItem(driver, "Select Condition", "Field is this value");
			selectDropDownByTyping(driver, "Select Field...", "SelNumeric");
			
			appUtilities.selectItem(driver, "Select Condition...", "Equal To");
			
			driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("1");
			
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");

			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			try{
			Assert.assertEquals("SelNumeric", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
			Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
			Assert.assertEquals("1", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Enter Value..."))).getAttribute("value").trim());
			Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
			}catch (Exception e){
				
			}
			finally{
				driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
				driver.findElement(By.xpath("//button//span[text()='Save']")).click();
				Thread.sleep(5000);
				appUtilities.logOutOfApp(driver);
			}
		}
	
		
		@Test
		public void testLeadScoringPrice() throws Exception{
			driver.get(baseUrl + "/");
			//login
			appUtilities.loginToApp(driver);
			//Navigate to Lead Scoring page 
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
					
			appUtilities.selectItem(driver, "Select Condition", "Field is this value");
			selectDropDownByTyping(driver, "Select Field...", "SelPrice");
			
			appUtilities.selectItem(driver, "Select Condition...", "Equal To");
			
			driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("1.00");
			
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");

			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			try{
			Assert.assertEquals("SelPrice", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
			Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
			Assert.assertEquals("1.00", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Enter Value..."))).getAttribute("value").trim());
			Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
			}catch (Exception e){
				
			}
			finally{
				driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
				driver.findElement(By.xpath("//button//span[text()='Save']")).click();
				Thread.sleep(5000);
				appUtilities.logOutOfApp(driver);
			}
		}
	
		@Test
		public void testLeadScoringState() throws Exception{
			driver.get(baseUrl + "/");
			//login
			appUtilities.loginToApp(driver);
			//Navigate to Lead Scoring page 
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
					
			appUtilities.selectItem(driver, "Select Condition", "Field is this value");
			selectDropDownByTyping(driver, "Select Field...", "State");
			
			appUtilities.selectItem(driver, "Select Condition...", "Equal To");
			
			selectDropDownByTyping(driver, "Select...", "Alabama");
			
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");

			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			try{
			Assert.assertEquals("State", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
			Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
			Assert.assertEquals("Alabama", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select..."))).getAttribute("value").trim());
			Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
			}catch (Exception e){
				
			}
			finally{
				driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
				driver.findElement(By.xpath("//button//span[text()='Save']")).click();
				Thread.sleep(5000);
				appUtilities.logOutOfApp(driver);
			}
		}
		
		
		@Test
		public void testLeadScoringDropDown() throws Exception{
			driver.get(baseUrl + "/");
			//login
			appUtilities.loginToApp(driver);
			//Navigate to Lead Scoring page 
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
					
			appUtilities.selectItem(driver, "Select Condition", "Field is this value");
			selectDropDownByTyping(driver, "Select Field...", "SelDropdown");
			
			appUtilities.selectItem(driver, "Select Condition...", "Equal To");
			
			selectDropDownByTyping(driver, "Select...", "SelOption");
			
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");

			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			try{
			Assert.assertEquals("SelDropdown", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
			Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
			Assert.assertEquals("SelOption", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select..."))).getAttribute("value").trim());
			Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
			}catch (Exception e){
				
			}
			finally{
				driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
				driver.findElement(By.xpath("//button//span[text()='Save']")).click();
				Thread.sleep(5000);
				appUtilities.logOutOfApp(driver);
			}
		}
		
		@Test
		public void testLeadScoringHasClickedATrackedLinkACertainNumberOfTimes() throws Exception{
			driver.get(baseUrl + "/");
			//login
			appUtilities.loginToApp(driver);
			//Navigate to Lead Scoring page 
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='Add New Condition']")).click();
					
			appUtilities.selectItem(driver, "Select Condition", "Has visited a website a certain number of times");
			selectDropDownByTyping(driver, "Select Website", "Any Website");
			
			appUtilities.selectItem(driver, "Select...", "Equal To");
			
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("12");

			
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).clear();
			driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).sendKeys("11");

			driver.findElement(By.xpath("//button//span[text()='Save']")).click();
			Thread.sleep(5000);
			
			appUtilities.navigateTo(driver, "Contacts==Settings");
			driver.findElement(By.xpath("//div[normalize-space(text())='LEAD SCORING']")).click();
			Thread.sleep(5000);
			try{
			Assert.assertEquals("Any Website", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Field..."))).getAttribute("value").trim());
			Assert.assertEquals("Equal To", driver.findElement(By.xpath(getIdentifierByPlaceHolder("Select Condition..."))).getAttribute("value").trim());
			Assert.assertEquals("12", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
			Assert.assertEquals("11", driver.findElement(By.xpath("//div[label[text()='Score value']]//input")).getAttribute("value").trim());
			}catch (Exception e){
				
			}
			finally{
				driver.findElement(By.xpath("//a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
				driver.findElement(By.xpath("//button//span[text()='Save']")).click();
				Thread.sleep(5000);
				appUtilities.logOutOfApp(driver);
			}
		}
		
	
	public String getIdentifierByPlaceHolder (String placeholderName){
		String identifier = "//input[normalize-space(@placeholder)='"+ placeholderName + "']";
		return identifier;
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
