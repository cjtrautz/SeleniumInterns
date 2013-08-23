package com.ontraport.app.selenium.tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import java.util.ArrayList;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;


public class AddNewSection extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	

	@Test
	public void testAddNewSection() throws Exception {

		//driver.get(baseUrl + "/");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String sectionTitle = "SelTitle"+varTimeStamp;
		String sectionDesc = "SelDesc"+varTimeStamp;
		
		System.out.println(sectionTitle);
		System.out.println(sectionDesc);
		
		// login

		//appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		//Click Settings
		/*for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']"), driver)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}*/
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")));
		driver.findElement(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")));
	
		//Click Field Editor
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='Contact Information']")));
		
		//List<WebElement> draggablePartOfScrollbarTest = new ArrayList<WebElement>();
		//draggablePartOfScrollbarTest = driver.findElements(By.xpath("//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']"));
		//System.out.println(draggablePartOfScrollbarTest.isEmpty());
		//if(!draggablePartOfScrollbarTest.isEmpty()){
		Actions dragger = new Actions(driver);
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']"));
		int numberOfPixelsToDragTheScrollbarDown = 100;

		for (int i=10;i<2000;i=i+numberOfPixelsToDragTheScrollbarDown){
			try{    		
	    		        	
				dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Contact Information']")));
			}catch(Exception e1){}
		}
		//}
	    //ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"));	    
	    //Click ADD NEW SECTION
	    driver.findElement(By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']")).click();
	    //System.out.println(draggablePartOfScrollbarTest.isEmpty());
	    //if(!draggablePartOfScrollbarTest.isEmpty()){
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Contact Information']")));	    
	    
    	for (int i=5;i<100;i=i+numberOfPixelsToDragTheScrollbarDown){
    		try{
	    		
    			//try { if (isElementPresent(By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"))) break; } catch (Exception e) {}
    			//Actions dragger = new Actions(driver);
    			//WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']"));    	
    			dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
    			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Contact Information']")));	    	        
    		}catch(Exception e1){}
    	} 
		
	    //}
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ussr-component-section-titlebar ussr-border-solid-bottom']//span[normalize-space(text())='Untitled'])")));	    
	    //driver.findElement(By.xpath("//div[2]/div/section/div/div/div[4]/div[1]/div[1]/div[3]/div[1]/span[3]")).click();
        //driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).click();
	    driver.findElement(By.xpath("(//div[@class='ussr-component-section-titlebar ussr-border-solid-bottom']//span[normalize-space(text())='Untitled'])")).click();
	    driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).clear();
	    driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).sendKeys(sectionTitle);

	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div[normalize-space(text())='Section Description']")));	    
	    
	    //driver.findElement(By.xpath("//div[2]/div/section/div/div/div[4]/div[1]/div[1]/div[3]/div[3]")).click();
        //driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).click();
	    driver.findElement(By.xpath("//div//div[normalize-space(text())='Section Description']")).click();
	    driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).clear();
	    driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).sendKeys(sectionDesc);
	    //driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='Edit Contact Fields']"));
	    Thread.sleep(3000);


	    
		//Click Save
		//driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();

		//Click Field Editor
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[normalize-space(text())='Section Description']")));	    
		
		
		//Thread.sleep(6000);
	    //if(!draggablePartOfScrollbarTest.isEmpty()){
	    	//Actions dragger = new Actions(driver);
	    	//WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']"));    	
	    draggablePartOfScrollbar = driver.findElement(By.xpath("//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']"));
	    for (int i=10;i<500;i=i+numberOfPixelsToDragTheScrollbarDown){
	    	try{
	    		
	   			//try { if (isElementPresent(By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"))) break; } catch (Exception e) {}
	        	
	   			dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,100).release().perform();
	   			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Contact Information']")));	    
	   		}catch(Exception e1){}
    	}
//	    }
		//AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='ussr-component-section-titlebar ussr-border-solid-bottom']//span[@class='ussr-component-section-title big ussr-helper-text-transform-uppercase' and normalize-space(text())='"+sectionTitle+"']")));
		//AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='ussr-component-section-description ussr-widget-editinplace' and normalize-space(text())='"+sectionDesc+"']")));
	    
	    
	    
	    
	    
	   
	    AssertJUnit.assertTrue(driver.getPageSource().contains(sectionTitle));
	    AssertJUnit.assertTrue(driver.getPageSource().contains(sectionDesc));
			
	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	    driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='OK']")).click();

	}
	
	
	
	private boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}