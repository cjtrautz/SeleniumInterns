package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeleteMessage  extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testCreateSMS() throws Exception {
		//baseUrl = "http://app.ontraport.com";
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);

	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		String msgName = "Sel"+varTimeStamp;
		//String smsName = "SelSMS";
		System.out.println(msgName);
		
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Messages']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Message']")).click();
				
		driver.findElement(By.xpath("//div[div[*/text()='E-Mail']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(msgName);
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Send out name']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Send out name']]/descendant::input")).sendKeys("Selenium Test");
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Reply to email']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Reply to email']]/descendant::input")).sendKeys("selenium@test.com");
		
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::li[1]/div")));
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::li[1]/div")).click();
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Subject']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Subject']]/descendant::input")).sendKeys("Selenium Test");
		
		//the workaround
		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body")));
		driver.findElement(By.cssSelector("body")).sendKeys("Selenium Test");
		//Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]")));
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]"));
		
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[input[normalize-space(@placeholder)='Insert Merge Field']]/descendant::button"));
		appUtilities.selectItem(driver, "Insert Merge Field", "First Name");
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[4]/button[3]")).click();
		//Thread.sleep(6000);
		//driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='100']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[normalize-space(text())='" + (msgName) +"']")));
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (msgName) +"']")));
		
		
		
		//Delete the Website
		driver.findElement(By.xpath("//a[normalize-space(text())='"+(msgName)+"']/parent::span")).click();
		driver.findElement(By.linkText("Delete Message")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")));
		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		Assert.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" +(msgName)+"']")));
		//appUtilities.logOutOfApp(driver);
		
	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();



		

		
		
	}
}
