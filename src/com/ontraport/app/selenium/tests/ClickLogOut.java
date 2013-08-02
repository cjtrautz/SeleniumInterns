
package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class ClickLogOut extends OntraportFirefoxTest {
AppUtilities appUtilities = new AppUtilities();
	
	
	@Test
	public void testClickPackage() throws Exception {
		//baseUrl = "http://app.ontraport.com";
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		//Thread.sleep(3000);
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

		appUtilities.logOutOfApp(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='sod-drawer-handle']/div")));
		Assert.assertTrue("Log out succesfull-confirming by checking the existance of Login link", appUtilities.isElementPresent(driver, By.xpath("//div[@id='sod-drawer-handle']/div")));
		
	}

}
