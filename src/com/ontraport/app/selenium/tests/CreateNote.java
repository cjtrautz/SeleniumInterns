package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateNote extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void test() throws InterruptedException {
		
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		String noteName = "test" + varTimeStamp;
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']/tr[1]/td[2]/span/a")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//a[.='Notes']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Date']")));
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//span[.='NEW Note']")).click();
        driver.findElement(By.cssSelector("textarea.ussr-form-input")).click();
        driver.findElement(By.cssSelector("textarea.ussr-form-input")).clear();
        driver.findElement(By.cssSelector("textarea.ussr-form-input")).sendKeys(noteName);
        driver.findElement(By.xpath("//td[@class='ussr-component-collection-row-accordian-view-cell']//button[normalize-space(.)='Save']")).click();
        
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[4]/div/div[1]/div/div[2]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[4]/div/div[1]/div/div[2]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[4]/div/div[1]/div/div[2]/div/div/div/input")).sendKeys(Search);
  
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();
        //Thread.sleep(3000);
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='"+noteName+"']")));
        
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
