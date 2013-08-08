package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateSectionWithFields extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void test() throws InterruptedException {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);

		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String sectionName = "SelSec"+varTimeStamp;
		String title = "selTitle"+varTimeStamp;
		String fieldName1 = "SelCheck"+varTimeStamp;
		String fieldName2 = "SelDropdown"+varTimeStamp;
		String fieldName3 = "SelDate"+varTimeStamp;
		String fieldName4 = "SelList"+varTimeStamp;
		String fieldName5 = "SelLong"+varTimeStamp;
		String fieldName6 = "SelNumeric"+varTimeStamp;
		String fieldName7 = "SelPrice"+varTimeStamp;
		String fieldName8 = "SelState"+varTimeStamp;
		String fieldName9 = "Seltext"+varTimeStamp;
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")));
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Contact Information']")));	
        Thread.sleep(3000);
        int numberOfPixelsToDragTheScrollbarDown = 100;
        
        Thread.sleep(2000);
        List<WebElement> scroller = driver.findElements(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
        //System.out.println (scroller.isEmpty());
        if(scroller.get(0).isDisplayed()){
        	Actions dragger = new Actions(driver);
        	WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
        	driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]")).click();
        	for (int i=10;i<2000;i=i+numberOfPixelsToDragTheScrollbarDown){
        		try{

        			dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Contact Information']")));	}catch(Exception e1){}
        	}
        }
        driver.findElement(By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[.='add new section']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='Untitled']")).click();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).click();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).clear();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).sendKeys(sectionName);
        Thread.sleep(1000);
        List<WebElement> scroller3 = driver.findElements(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
        //System.out.println (scroller.isEmpty());
        if(scroller3.get(0).isDisplayed()){
        	Actions dragger3 = new Actions(driver);
        	WebElement draggablePartOfScrollbar3 = driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
        	driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]")).click();
        	for (int i=10;i<2000;i=i+numberOfPixelsToDragTheScrollbarDown){
        		try{

        			dragger3.moveToElement(draggablePartOfScrollbar3).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Contact Information']")));	}catch(Exception e1){}
        	}
        }
        driver.findElement(By.xpath("//div[normalize-space(text())='Section Description']")).click();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).click();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).clear();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).sendKeys(title);
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='"+ sectionName + "']")).click();
        
        WebElement section1 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section1.findElement(By.xpath(".//div/div[2]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName1);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Checkbox']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();

        WebElement section2 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section2.findElement(By.xpath(".//div/div[2]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName2);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Dropdown']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        
        WebElement section3 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section3.findElement(By.xpath(".//div/div[2]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName3);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Date']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        
        WebElement section4 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section4.findElement(By.xpath(".//div/div[3]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName4);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='List Selection']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        
        List<WebElement> scroller4 = driver.findElements(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
        //System.out.println (scroller.isEmpty());
        if(scroller4.get(0).isDisplayed()){
        	Actions dragger4 = new Actions(driver);
        	WebElement draggablePartOfScrollbar4 = driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
        	driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]")).click();
        	for (int i=10;i<2000;i=i+numberOfPixelsToDragTheScrollbarDown){
        		try{

        			dragger4.moveToElement(draggablePartOfScrollbar4).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Contact Information']")));	}catch(Exception e1){}
        	}
        }
        
        WebElement section5 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section5.findElement(By.xpath(".//div/div[2]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName5);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Long Text']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        
        WebElement section6 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section6.findElement(By.xpath(".//div/div[4]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName6);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Numeric']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        
        WebElement section7 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section7.findElement(By.xpath(".//div/div[4]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName7);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Price']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        
        WebElement section8 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section8.findElement(By.xpath(".//div/div[4]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName8);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='State']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        
        WebElement section9 = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section9.findElement(By.xpath(".//div/div[4]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName9);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Text']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
        
        driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
        
        Thread.sleep(3000);
        //Actions dragger = new Actions(driver);
        //WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
        //System.out.println ("here");
        driver.navigate().refresh();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Contact Information']")));
        Thread.sleep(3000);

        List<WebElement> scroller2 = driver.findElements(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
        System.out.println (scroller2.isEmpty());
        System.out.println (scroller2.get(0).isDisplayed());
        if(scroller2.get(0).isDisplayed()){
        	driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]")).click();
        	WebElement draggablePartOfScrollbar2 = driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
            Actions dragger2 = new Actions(driver);

            for (int i=10;i<2000;i=i+numberOfPixelsToDragTheScrollbarDown){
            	//System.out.println ("here2");

            	try{
            		//System.out.println ("here3");
    
            		dragger2.moveToElement(draggablePartOfScrollbar2).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
            		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='Contact Information']")));
            		//System.out.println ("here4");
            	}
            	catch(Exception e1){
            		//System.out.println ("here5");

            	}
            }
        }
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//span[normalize-space(text())='" +(sectionName)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[normalize-space(text())='" +(title)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName1)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName2)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName3)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName4)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName5)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName6)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName7)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName8)+"']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName9)+"']")));

        //WebElement field1 = driver.findElement(By.xpath("//div[preceding-sibling::label[normalize-space(text())='" +(fieldName1)+"']]"));
        //AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[preceding-sibling::label[normalize-space(text())='" +(fieldName1)+"']].//a/span[@class='ussr-icon ussr-icon-checkbox-empty']")));

        //field1.findElement(By.xpath(".//a/span[@class='ussr-icon ussr-icon-checkbox-empty']"));
        driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	    driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='OK']")).click();

        
	}
	

}
