package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class EnsureSequenceEditSteps extends OntraportFirefoxTest{
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
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Sequences']")).click();
	    
		driver.findElement(By.xpath("//div[2]/div/section/div/div/div[4]/div[1]/div/table/tbody/tr[1]/td[2]/span/a")).click();
        
		driver.findElement(By.xpath("//nav[@class='ussr-pane-editor-nav']//a[.='stats']")).click();
		Thread.sleep(2000);
		assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='Stats']")));

        driver.findElement(By.xpath("//nav[@class='ussr-pane-editor-nav']//a[contains(text(),'subscribers')]")).click();
		Thread.sleep(2000);
		assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='Subscriptions']")));
        
	    driver.findElement(By.xpath("//nav[@class='ussr-pane-editor-nav']//a[.='edit steps']")).click();
		Thread.sleep(2000);
		assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']/div[2]/div[contains(text(),'ADD A STEP')]")));

        driver.findElement(By.xpath("//div[@class='sequence_stats']//div[.='Overview']")).click();
        
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		
	}

}
