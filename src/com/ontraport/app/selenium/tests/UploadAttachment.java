package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class UploadAttachment extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testUploadAttachment() throws InterruptedException {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String picURL = "http://prettycoolpics.com/wp-content/uploads/2013/07/cool_003.jpg";	
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
		driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
		driver.findElement(By.xpath("//a[@class='account-target-attachment-manager']//div[.='ATTACHMENT MANAGER']")).click();
		driver.findElement(By.xpath("//div[@class='ussr-component-carousel-wrapper']//a[.='Upload']")).click();
		driver.findElement(By.xpath("//div[@class='ussr-component-carousel-wrapper']/div[2]/div[1]/div[1]/div[1]/div/div/div/div[5]/div/div/div/input")).click();
		driver.findElement(By.xpath("//div[@class='ussr-component-carousel-wrapper']/div[2]/div[1]/div[1]/div[1]/div/div/div/div[5]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[@class='ussr-component-carousel-wrapper']/div[2]/div[1]/div[1]/div[1]/div/div/div/div[5]/div/div/div/input")).sendKeys(picURL);
		driver.findElement(By.xpath("//div[@class='ussr-component-carousel-wrapper']//button[.='Go']")).click();
		
		Thread.sleep(10000);
		WebElement test = driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/ul/table/tbody/tr/td[2]/span/a"));
		System.out.println(test.getText());

		AssertJUnit.assertTrue(test.getText().contains(picURL));
		driver.findElement(By.xpath("//div[7]/div/div[1]/a/span")).click();
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		}

}
