
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

public class DeleteSingleContact extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void testDeleteContact() throws Exception {
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		//login	
		//Thread.sleep(5000);
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
		
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Contact']")).click();
		//Thread.sleep(3000);
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		System.out.println (varTimeStamp);
		WebElement fNameTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "First Name");
		fNameTxtBox.clear();
		fNameTxtBox.sendKeys("Fname"+varTimeStamp);
		
		WebElement lNameTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "Last Name");
		lNameTxtBox.clear();
		lNameTxtBox.sendKeys("lastname"+varTimeStamp);
		
		
		String emailId = "selenium"+varTimeStamp+"@test.com";
		WebElement emailTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "E-Mail");
		emailTxtBox.clear();
		emailTxtBox.sendKeys(emailId);
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (emailId) +"']")));

		driver.findElement(By.xpath("//span[a[normalize-space(text())='"+emailId+"']]")).click();
		driver.findElement(By.linkText("Delete Contacts")).click();		
		driver.findElement(By.xpath("//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Ok']")).click();
		
		driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		Thread.sleep(1000);
		AssertJUnit.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (emailId) +"']")));
		//appUtilities.logOutOfApp(driver);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}
	

}
