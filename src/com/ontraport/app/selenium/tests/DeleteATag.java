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
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeleteATag extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testCreateATag() throws InterruptedException{
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String tagName = "SelTagDel" + varTimeStamp;
		String Search =  String.valueOf(varTimeStamp);
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//ul[@class='ussr-corner-bl']/li/a[text()='Admin']")).click();
		
		
		
		driver.findElement(By.xpath("//a/div[text()='MANAGE TAGS']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Tag']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(tagName);
	
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (tagName) +"']")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")));
		//driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[span[normalize-space(text())='" + tagName + "']]]/descendant::td[3]")));
		WebElement chkBox = driver.findElement(By.xpath("//tr[td[span[normalize-space(text())='" + tagName + "']]]/descendant::td[3]"));
		chkBox.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Tag")));
		driver.findElement(By.linkText("Delete Tag")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Ok']")));
		driver.findElement(By.xpath("//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Ok']")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		//driver.findElement(By.xpath("//input[@type='search']")).clear();
		//driver.findElement(By.xpath("//input[@type='search']")).sendKeys(tagName);
		//driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		//Assert.assertFalse(appUtilities.isElementPresent(driver, By.linkText(tagName)));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")));
		driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ussr-icon ussr-icon-plus']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ussr-icon ussr-icon-plus']")));
		AssertJUnit.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (tagName) +"']")));
		//appUtilities.logOutOfApp(driver);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		
	}

}
