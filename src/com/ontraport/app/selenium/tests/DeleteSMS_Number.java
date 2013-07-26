package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeleteSMS_Number extends OntraportFirefoxTest  {
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testDeleteSMS_Number() throws Exception {

		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String name = "SelName"+varTimeStamp;
		
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//ul[@class='ussr-corner-bl']/li/a[normalize-space(text())='Admin']")).click();
		
		driver.findElement(By.xpath("//a/div[normalize-space(text())='SMS']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[normalize-space(text())='Buy Number']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
		
		appUtilities.getTextBoxOnTheLabel(driver, "Area Code").sendKeys("805");
		driver.findElement(By.xpath("//span[@class='ussr-button-text' and normalize-space(text())='Search']")).click();
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Select Number...']]/descendant::button")).click();
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Select Number...']]/descendant::li[2]/div")).click();
		driver.findElement(By.xpath("//button//span[normalize-space(text())='Buy Number']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(name);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (name) +"']")));
		driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		
		Thread.sleep (2000);
		WebElement chkBox = driver.findElement(By.xpath("//tr[td[span[a[normalize-space(text())='" + name + "']]]]/descendant::td[3]"));
		//appUtilities.mouseOverElement(driver, chkBox);
		//new Actions(driver).moveToElement(element).click().perform();
		//driver.findElement(By.xpath("//tr[td[span[a[normalize-space(text())='" + name + "']]]]/descendant::td/a/span")).click();
		chkBox.click();
		Thread.sleep (2000);
		driver.findElement(By.linkText("Delete Number")).click();		
		driver.findElement(By.xpath("//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Ok']")).click();
		Thread.sleep (3000);
		
		Assert.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (name) +"']")));
		//appUtilities.logOutOfApp(driver);
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	}

}
