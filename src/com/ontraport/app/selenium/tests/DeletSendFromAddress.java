
package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeletSendFromAddress extends OntraportFirefoxTest {
	
AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testDeleteSendFromAddress() throws InterruptedException{
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String emailId = "DelSendEmail@email.com";
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

		
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//ul[@class='ussr-corner-bl']/li/a[text()='Admin']")).click();
		
		driver.findElement(By.xpath("//div[div[text()='E-Mail']]/descendant::a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span[text()='Add E-Mail']]")));
		driver.findElement(By.xpath("//button[span[text()='Add E-Mail']]")).click();

		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(emailId);

		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button/span[text()='Add E-Mail']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains(emailId));
		driver.findElement(By.xpath("//tr[td[text()='"+emailId+"']]/descendant::td/span[text()='Remove']")).click();
		Thread.sleep(3000);
		Assert.assertFalse(driver.getPageSource().contains(emailId));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//appUtilities.logOutOfApp(driver);
		
	}

}
