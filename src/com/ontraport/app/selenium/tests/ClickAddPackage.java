
package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class ClickAddPackage extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	
	
	@Test
	public void testClickPackage() throws Exception {
		//baseUrl = "http://app.ontraport.com";
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Navigate to Account page
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-wrapper']//*[@class='ussr-corner-bl']//a[normalize-space(text())='Account']")).click();
		
		//Click Add a Package link
		driver.findElement(By.xpath("//div[@class='ussr-chrome-column']//span[normalize-space(text())='(Add a package)']")).click();

		//Check for pop up
		
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='ussr-dialog-header ussr-header ussr-border-solid-bottom']/span[normalize-space(text())='Add a Package']")));
		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']/descendant::button/span[normalize-space(text())='Cancel']")).click();
		//appUtilities.logOutOfApp(driver);

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
