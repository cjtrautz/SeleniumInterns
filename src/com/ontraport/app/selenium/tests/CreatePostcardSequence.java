package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreatePostcardSequence extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void test() {
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
		String seqName = "test" + varTimeStamp;
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Sequences']")).click();
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New Sequence']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']//button[normalize-space(.)='Create']")).click();
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).sendKeys(seqName);
        
        driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-postcard']//button[normalize-space(.)='Postcard']")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[3]/div/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[1]/div[2]")).click();
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
        
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + seqName + "']")));
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + seqName + "']")).click();
        
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']//div[.=' POSTCARD']")));
	
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
