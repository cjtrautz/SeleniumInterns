package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class EnsureColumnPencil extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testEnsureColumnPencil() {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		Actions action = new Actions(driver);
   
		WebElement email = driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Email']"));
		action.moveToElement(email).build().perform();
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']/th[2]/div/a[3]/span")).isDisplayed());
		
		WebElement OfficePhone = driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Office Phone']"));
		action.moveToElement(OfficePhone).build().perform();
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']/th[3]/div/a[3]/span")).isDisplayed());
		
		WebElement LastActivity = driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Last Activity']"));
		action.moveToElement(LastActivity).build().perform();
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']/th[4]/div/a[3]/span")).isDisplayed());
	    
		WebElement DateAdded = driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Date Added']"));
		action.moveToElement(DateAdded).build().perform();
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']/th[5]/div/a[3]/span")).isDisplayed());
	    
		WebElement ContactId = driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Contact ID']"));
		action.moveToElement(ContactId).build().perform();
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']/th[6]/div/a[3]/span")).isDisplayed());
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
