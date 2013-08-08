package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateSMSMessage extends OntraportFirefoxTest{
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
		String Search =  String.valueOf(varTimeStamp);
		String smsName = "test" + varTimeStamp;
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Messages']")).click();
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New Message']")).click();
        
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div/div[4]/a/button")).click();
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).sendKeys(smsName);
        
        driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[1]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[1]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[1]/div/div/input")).sendKeys("test");
        
        driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[4]/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]/div[5]/div/div/div/input")).click();
        driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();
        
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + smsName + "']")));
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + smsName + "']")).click();
        
        Assert.assertEquals("TaskNameAssertion",smsName, driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).getAttribute("value"));
		Assert.assertEquals("TaskNameAssertion","test", driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[1]/div/div/input")).getAttribute("value"));
		Assert.assertEquals("TaskNameAssertion","[First Name]", driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[5]/div/div/div/textarea")).getAttribute("value"));
        
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
