package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class AllSequenceSteps extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testAllSequenceSteps() {
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
        
        driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-email']//button[normalize-space(.)='Email']")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[3]/div/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//div[@class='from_target']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-3-n")).click();
        
        driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-sms']//button[normalize-space(.)='SMS']")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[3]/div/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//div[@class='component-target-send-fields']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-3-n")).click();
        
        driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-task']//button[normalize-space(.)='Task']")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[3]/div/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-3-n")).click();
        
        driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-postcard']//button[normalize-space(.)='Postcard']")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[3]/div/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[1]/div[2]")).click();
        
        driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-rule']//button[normalize-space(.)='Rule']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[1]/div[2]/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[2]/div[2]/div/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[2]/div[2]/div[1]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[2]/div[2]/div[1]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[2]/div[2]/div[1]/div/div/input")).sendKeys(seqName);
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Field is this value']")).click();
        driver.findElement(By.xpath("//tr[@class='sem_condition_row']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//tr[@class='sem_condition_row']/td[2]/span/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.cssSelector("input.ussr-border-solid-all")).click();
        driver.findElement(By.cssSelector("input.ussr-border-solid-all")).clear();
        driver.findElement(By.cssSelector("input.ussr-border-solid-all")).sendKeys("test");
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div/div[1]/div[3]/ul/li[1]/div")).click();
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-3-n")).click();
        
        driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-fulfillment']//button[normalize-space(.)='Fulfillment']")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[3]/div/div[2]/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-3-n")).click();
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + seqName + "']")));
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + seqName + "']")).click();
        
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']//div[.=' EMAIL']")));
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']//div[.=' SMS']")));
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']//div[.=' TASK']")));
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']//div[.=' POSTCARD']")));
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']//div[.=' FULFILLMENT']")));
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']//div[.=' RULE']")));
        
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
