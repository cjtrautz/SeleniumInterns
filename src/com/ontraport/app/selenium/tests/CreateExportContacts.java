package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateExportContacts extends OntraportFirefoxTest{
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
		DateFormat dateFormat = new SimpleDateFormat("M_d_yyyy");
		   //get current date time with Date()
		Date date = new Date();

		String name = dateFormat.format(date);
		
		System.out.println(name);
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']/tr[1]/td[1]/a")).click();
	    driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']/tr[2]/td[1]/a")).click();
	    driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//a[normalize-space(.)='Export Contacts']")).click();
	    
	    driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display']//button[normalize-space(.)='<br>']")).click();
	    driver.findElement(By.xpath("//div[@class='ussr-component-drilldownselect-menu-wrapper']//div[.='First Name']")).click();
	    
	    driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-checkbox-empty")).click();
	    
	    driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Export']")).click();
        Thread.sleep(2000);
        
	    driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
	   
        driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='EXPORTED LISTS']")).click();
        
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[contains(text(),'" + name + "')]")));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();


	}

}
