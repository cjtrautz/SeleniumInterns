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

public class CreateUserFieldEditor extends OntraportFirefoxTest{
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
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String sectionName = "SelSec"+varTimeStamp;
		String title = "selTitle"+varTimeStamp;
		String fieldName = "SelField"+varTimeStamp;

		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='User Field Editor']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]")).click();
		
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='User Info']")));	
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
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='User Info']")));			}catch(Exception e1){}
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
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='User Info']")));			}catch(Exception e1){}
		}
        }
        driver.findElement(By.xpath("//div[normalize-space(text())='Section Description']")).click();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).click();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).clear();
        driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).sendKeys(title);
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='"+ sectionName + "']")).click();
        
        WebElement section = driver.findElement(By.xpath("//div[normalize-space(text())='" + title + "']/following-sibling::div"));
        section.findElement(By.xpath(".//div/div[2]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-name']/div/div/div/input")).sendKeys(fieldName);
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-fieldedit-sub-location-type']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();

        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Save']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space(text())='Data']")));	
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.linkText("Personal Settings")).click();
        
        Thread.sleep(3000);
        //Actions dragger = new Actions(driver);
		//WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div/div[4]/div[3]/div/div/div[2]"));
		//System.out.println ("here");
        driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='User Info']")));
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
    				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text())='User Info']")));
    				//System.out.println ("here4");
    			}
    			catch(Exception e1){
    				//System.out.println ("here5");

    			}
    		}
        }
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//span[normalize-space(text())='" +(sectionName)+"']")));
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[normalize-space(text())='" +(title)+"']")));
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//label[normalize-space(text())='" +(fieldName)+"']")));

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

        
	}

}
