
package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class SetTimezone extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void testSetTimezone () throws Exception{
		//driver.get(baseUrl + "/");
		String timezone = "HI";
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
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
		driver.findElement(By.linkText("Personal Settings")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='Password & Misc.']")));
		driver.findElement(By.xpath("//li/a[text()='Password & Misc.']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[label[text()='Timezone']]//span")));
		String existingTimeZone = getTimeZoneFromApp(driver);
		setTimeZone (driver, timezone, wait);
		driver.findElement(By.xpath("//span[@class='primary-nav-item-label' and normalize-space(text())='Contacts']")).click();
		
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.linkText("Personal Settings")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='Password & Misc.']")));
		driver.findElement(By.xpath("//li/a[text()='Password & Misc.']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[label[text()='Timezone']]//span")));
		String timezoneFromApp = driver.findElement(By.xpath("//div[label[text()='Timezone']]//span")).getText().trim();
		Assert.assertTrue(timezoneFromApp.equalsIgnoreCase(timezone));
		setTimeZone (driver, existingTimeZone, wait);
		//appUtilities.logOutOfApp(driver);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}
	
	public void setTimeZone (WebDriver driver, String timezone, WebDriverWait wait) throws InterruptedException{
		driver.findElement(By.xpath("//div[label[text()='Timezone']]//span")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[text()='"+timezone+"']")));
		driver.findElement(By.xpath("//li/div[text()='"+timezone+"']")).click();
	}
	
	public String getTimeZoneFromApp (WebDriver driver){
		return driver.findElement(By.xpath("//div[label[text()='Timezone']]//span")).getText().trim();
	}

}
