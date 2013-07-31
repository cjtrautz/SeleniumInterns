package com.ontraport.app.selenium.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class AddTab extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	
	
	@Test
	public void testAddTab () throws Exception{
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		
		String tabName = "6test" + varTimeStamp;
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		//driver.get("http://ontraport.com.dev" + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		
		//Click Messages
		//for (int second = 0;; second++) {
		//	if (second >= 60) fail("timeout");
		//	try { if (isElementPresent(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']"), driver)) break; } catch (Exception e) {}
		//		Thread.sleep(1000);
		//}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")));
		driver.findElement(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")).click();
		//Click Field Editor
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")));
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-chrome-panel-pane-header-bottom ussr-theme-orange']//span[@class='ussr-icon ussr-icon-plus']")));
		//Thread.sleep(6000);

		//Click "ADD TAB"
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//a[.='Add Tab']")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-modelid='ontraport_models_view_piece_tab_113'")));
		//driver.findElement(By.cssSelector("a.jb-overflowmenu-menu-secondary-handle > span.ussr-icon.ussr-icon-carat-2-n")).click();
        //driver.findElement(By.cssSelector("a.jb-overflowmenu-menu-secondary-handle > span.ussr-icon.ussr-icon-carat-2-s")).click();
        //Thread.sleep(6000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'ussr-component-tab')]")));
		//driver.findElement(By.xpath("//li[contains(@class, 'ussr-component-tab')]")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//text()[contains(.,'Untitled')]")));
		//driver.findElement(By.cssSelector("a.jb-overflowmenu-menu-secondary-handle > span.ussr-icon.ussr-icon-carat-2-n")).click();
		//driver.findElement(By.cssSelector("a.jb-overflowmenu-menu-secondary-handle > span.ussr-icon.ussr-icon-carat-2-s")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Untitled')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Untitled')])[2]")).click();
		//JavascriptLibrary jsLib = new JavascriptLibrary(); 
        //jsLib.callEmbeddedSelenium(driver,"triggerMouseEventAt", driver.findElement(By.xpath(("//a[contains(text(),'Untitled')]"))),"click");
        //JavascriptExecutor js = null;
        //if(driver instanceof JavascriptExecutor){
        //	js= (JavascriptExecutor) driver;
        //}
        //js.executeScript("document.getElemen);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", element);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Untitled')])[2]")));
        //element.click();
        //driver.findElement(By.xpath(("//a[contains(text(),'Untitled')]"))).click();
        //driver.findElement(By.xpath("//a[@data-href='tab_15'")).click();
		driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input.text-transform-uppercase")).clear();
		driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input.text-transform-uppercase")).sendKeys(tabName);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div[2]/div[2]/ul")).click();
		//Click Save
		//driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();		
				
				
		//Click Messages
		//for (int second = 0;; second++) {
		//	if (second >= 60) fail("timeout");
		//	try { if (isElementPresent(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']"), driver)) break; } catch (Exception e) {}
		//		Thread.sleep(1000);
		//	}

		//Click Field Editor
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")));
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.jb-overflowmenu-menu-secondary-handle > span.ussr-icon.ussr-icon-carat-2-s")));
		driver.findElement(By.cssSelector("a.jb-overflowmenu-menu-secondary-handle > span.ussr-icon.ussr-icon-carat-2-s")).click();
		assertTrue(isElementPresent(By.xpath("//a[contains(text(),'"+tabName+"')]"), driver));

		
		
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
