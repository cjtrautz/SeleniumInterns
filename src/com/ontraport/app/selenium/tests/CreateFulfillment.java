package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateFulfillment extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateFulfillment() {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String fulfillmentName = "Selfulfillment" + varTimeStamp;	
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		
		driver.findElement(By.xpath("//div[2]/header/nav/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='FULFILLMENT MANAGER']")).click();
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New Fulfillment List']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[1]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[1]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[1]/div/div/input")).sendKeys(fulfillmentName);
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[2]/div[2]/div/span[4]/div/div/button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='12:00am']")));
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='12:00am']")).click();
        //driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[4]/div[2]/div/div/a/span[1]")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[6]/div[2]/div/div/div[1]/span/div/div/button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[.='First Name']")));
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[.='First Name']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + fulfillmentName + "']")).click();

        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='" + fulfillmentName + "']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='First Name']")));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
