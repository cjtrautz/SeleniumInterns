package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeleteAWPSite extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void testDeleteAWPSite() throws Exception {
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String siteName = "SelSite"+varTimeStamp;
		String domain = "seleniumwp2"+varTimeStamp;
		String level = "Level 1";
		String Search =  String.valueOf(varTimeStamp);

		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Navigate to Word Press page
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Sites']")).click();
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='WordPress']")).click();
		
		
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[normalize-space(text())='New Website']")).click();
		driver.findElement(By.xpath("//div[div[*/text()='New Wordpress Site']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		
		// Enter WebSite Name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(siteName);
		
		//Enter Domain
		driver.findElement(By.xpath("//input[@value='ours']")).click();
		driver.findElement(By.xpath("//div[div[*/text()='http://']]/descendant::input")).click();
		driver.findElement(By.xpath("//div[div[*/text()='http://']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[div[*/text()='http://']]/descendant::input")).sendKeys(domain);
		
		//Enter Membership Level
		driver.findElement(By.xpath("//div[div[*/text()='Add membership level']]/descendant::input")).click();
		driver.findElement(By.xpath("//div[div[*/text()='Add membership level']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[div[*/text()='Add membership level']]/descendant::input")).sendKeys(level);
		driver.findElement(By.xpath("//span[normalize-space(text())='Add']")).click();
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-dialog-buttons']/button")));
		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']/button")).click();

		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" +(siteName)+"']")));
		//Thread.sleep(10000);

		//driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		
		//Thread.sleep(10000);

		//Delete the Website
		driver.findElement(By.xpath("//a[normalize-space(text())='"+(siteName)+"']/parent::span")).click();
		//Thread.sleep(10000);

		driver.findElement(By.linkText("Delete")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")));
		//Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		//Thread.sleep(10000);
		Assert.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" +(siteName)+"']")));
		//appUtilities.logOutOfApp(driver);
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();	
		
		
	}
	

}
