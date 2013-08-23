package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class UploadVideo extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testUploadVideo() {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String movieName = "SelMovie" + varTimeStamp;
		String Search =  String.valueOf(varTimeStamp);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='VIDEO MANAGER']")).click();
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']/span[1]")).click();
        driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']/input")).sendKeys(movieName);
        driver.findElement(By.xpath("//div[@class='ussr-component-file-uploader-button']/form/input")).click();
        
        Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_S);        // S
		    r.keyRelease(KeyEvent.VK_S);
		    r.keyPress(KeyEvent.VK_P);        // P
		    r.keyRelease(KeyEvent.VK_P);
		    r.keyPress(KeyEvent.VK_A);        // A
		    r.keyRelease(KeyEvent.VK_A);
		    r.keyPress(KeyEvent.VK_C);        // C
		    r.keyRelease(KeyEvent.VK_C);
		    r.keyPress(KeyEvent.VK_E);        // E
		    r.keyRelease(KeyEvent.VK_E);
		    r.keyPress(KeyEvent.VK_T);        // T
		    r.keyRelease(KeyEvent.VK_T);
		    r.keyPress(KeyEvent.VK_E);        // E
		    r.keyRelease(KeyEvent.VK_E);
		    r.keyPress(KeyEvent.VK_S);        // S
		    r.keyRelease(KeyEvent.VK_S);
		    r.keyPress(KeyEvent.VK_T);        // T
		    r.keyRelease(KeyEvent.VK_T);

		    r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
		    r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='VIDEO MANAGER']")).click();
        driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Thumbnail']")).click();
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='"+movieName + "']")));
        //driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='asdfwefw']")).click();
        
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
