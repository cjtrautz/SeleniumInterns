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

public class CreateFulfillmentSequence extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void testCreateFulfillmentSequence() {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);

		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		String seqName = "test" + varTimeStamp;
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Sequences']")).click();
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New Sequence']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-section-components']//button[normalize-space(.)='Create']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")));

        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).sendKeys(seqName);

        driver.findElement(By.xpath("//span[@class='ussr-theme-sequence-fulfillment']//button[normalize-space(.)='Fulfillment']")).click();
        driver.findElement(By.xpath("//div[@class='sequence_editor']/div[2]/div[3]/div/div[2]/div[3]/div/div[2]/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-3-n")).click();

        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]/div[5]/div/div/div/input")).click();
        driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();

        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + "Step" + "']")));
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + seqName + "']")));
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + seqName + "']")).click();

        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='sequence_editor']//div[.=' FULFILLMENT']")));

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
