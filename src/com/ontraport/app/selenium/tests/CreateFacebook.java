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

public class CreateFacebook extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateFacebook() throws InterruptedException {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		String appName = "SelSite"+varTimeStamp;
		
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
	    driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
	    
	    driver.findElement(By.xpath("//div[@class='ussr-settings']//div[.='FACEBOOK']")).click();
	    driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New Facebook App']")).click();
	    
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[1]/div/div/input")).click();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[1]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[1]/div/div/input")).sendKeys(appName);
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[2]/div/div/input")).click();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[2]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[2]/div/div/input")).sendKeys(appName);
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[3]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[3]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[3]/div/div/input")).sendKeys(appName);
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[4]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[4]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[4]/div/div/input")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[5]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[5]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[5]/div/div/input")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[6]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[6]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[6]/div/div/input")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[8]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[8]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[8]/div/div/input")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[9]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[9]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[9]/div/div/input")).sendKeys("0");
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[7]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[7]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-components']/div[7]/div/div/input")).sendKeys("0");
	    
	    driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
	    
	    driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]/div[5]/div/div/div/input")).click();
	    driver.findElement(By.xpath("//input[@type='search']")).clear();
	 	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();
		
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(.)='Name your App']")));

        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + appName + "']")));
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + appName + "']")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Facebook Data']")));

        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='ussr-component-section-components']/div[3]/div/div/div[normalize-space(.)='" + appName + "']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='ussr-component-section-components']/div[2]/div/div/div[normalize-space(.)='" + appName + "']")));
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='ussr-component-section-components']/div[1]/div/div/div[normalize-space(.)='" + appName + "']")));
		
        driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
