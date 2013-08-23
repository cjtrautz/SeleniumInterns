package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class SendFromAddress extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void testSendFromAddress() throws InterruptedException {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		//long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.linkText("Admin")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']/div[1]/div[2]/ul/li[1]/a/div[1]")).click();
        driver.findElement(By.xpath("//div[@class='sender_add']//button[normalize-space(.)='Add E-Mail']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']/input")).sendKeys("njcross1990@gmail.com");
        driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//button[.='Add E-Mail']")).click();
        driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("njcross1990");
        driver.findElement(By.id("Passwd")).click();
        driver.findElement(By.id("Passwd")).clear();
        driver.findElement(By.id("Passwd")).sendKeys("Lughead1");
        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.xpath("//div[@id=':5']/div/div[1]/div[1]/div/div/div[4]/div")).click();
        driver.findElement(By.xpath("//span[contains(@id, ':')]//b[.='Mail Sender Confirmation']")).click();
        driver.findElement(By.xpath("//div[contains(@id,':')]/a[2]")).click();
        driver.get("https://app.ontraport.com/");
       try{
        	driver.switchTo().alert().accept();
        }
       catch(NoAlertPresentException e){
    	  
       }
        
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.linkText("Admin")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']/div[1]/div[2]/ul/li[1]/a/div[1]")).click();
        Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Make Default']")));
		
		
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//td[span[.='Confirmed'] and preceding-sibling::td[.='njcross1990@gmail.com']]")));

		//delete it
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]")).click();
        //WebElement straw = driver.findElement(By.xpath("//div[@class='sender_collection_target']/table/tbody"));
		WebElement straw2 = driver.findElement(By.xpath("//tr/td[following-sibling::td[.='njcross1990@gmail.com']]/span[2]"));
        straw2.click();
        driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
      
	}

}
