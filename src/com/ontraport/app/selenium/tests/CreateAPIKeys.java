package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateAPIKeys  extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void test() throws InterruptedException {
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

		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		String apiName = "SelAPI"+varTimeStamp;
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-triangle-1-s")).click();
        driver.findElement(By.xpath("//li[@class='ussr-header-nav-option-user']//a[.='Admin']")).click();
        driver.findElement(By.xpath("//div[@class='ussr-settings']/div[2]/div[1]/ul/li[1]/a/div[1]")).click();
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New API Key']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div[1]/div[3]/div/div/div/input")));

        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div[1]/div[3]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div[1]/div[3]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div[1]/div[3]/div/div/div/input")).sendKeys(apiName);
        driver.findElement(By.xpath("//div[@class='ussr-form-column']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//div[@class='component-api-generate-target-add']/div/div/div/a/span[1]")).click();
        driver.findElement(By.xpath("//div[@class='component-api-generate-target-search']/div/div/div/a/span[1]")).click();
        driver.findElement(By.xpath("//div[@class='component-api-generate-target-delete']/div/div/div/a/span[1]")).click();
        driver.findElement(By.xpath("//div[@class='component-api-generate-target-create-key']/div/div/div/a/span[1]")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
		
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.ussr-icon.ussr-icon-search")));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]/div[5]/div/div/div/input")).click();
        driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
        driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();
        //Thread.sleep(2000);

		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='"+apiName+"']")));
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='"+apiName+"']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='component-api-generate-target-add']/div/div/div/a[@class='ussr-form-input ussr-form-input-type-checkbox-checked']")));
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='component-api-generate-target-search']/div/div/div/a[@class='ussr-form-input ussr-form-input-type-checkbox-checked']")));
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='component-api-generate-target-delete']/div/div/div/a[@class='ussr-form-input ussr-form-input-type-checkbox-checked']")));
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='component-api-generate-target-create-key']/div/div/div/a[@class='ussr-form-input ussr-form-input-type-checkbox-checked']")));

        driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
