package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateTaskCopy extends OntraportFirefoxTest {

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
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search = String.valueOf(varTimeStamp);
		String taskName = "SelAddTag"+varTimeStamp;
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Messages']")).click();
	    driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New Message']")).click();
        
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div/div[4]/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='718 task']")).click();
        
	    driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).sendKeys(taskName);
	    
        driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[5]/div/div/div/textarea")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[5]/div/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[5]/div/div/div/textarea")).sendKeys("test");
	   
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
	    Thread.sleep(3000);
        
	    driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]/div[5]/div/div/div/input")).click();
        driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();
		
        Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + taskName +"']")));
	    driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + taskName + "']")).click();
        
		Assert.assertEquals("TaskNameAssertion",taskName, driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
		Assert.assertEquals("TaskSubjectAssertion","test", driver.findElement(By.xpath("//textarea[@placeholder='Type in your message here...']")).getAttribute("value"));

		driver.findElement(By.xpath("//div[@class='ussr-component-location-editor']/div[1]/div[5]/div/div/div/textarea")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
