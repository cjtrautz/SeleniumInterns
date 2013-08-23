package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class SetUpOrderForm extends OntraportFirefoxTest{
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

		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		String formName = "SelOrderForm"+varTimeStamp;
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Smart Forms']")).click();
		driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New Smart Form']")).click();
		driver.findElement(By.cssSelector("div.fe-title.fe-title-user-hasnt-clicked")).click();
		driver.findElement(By.cssSelector("div.ussr-dialog-content > input[type=\"text\"]")).click();
		driver.findElement(By.cssSelector("div.ussr-dialog-content > input[type=\"text\"]")).clear();
		driver.findElement(By.cssSelector("div.ussr-dialog-content > input[type=\"text\"]")).sendKeys(formName);
		driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[.='save']")).click();
		driver.findElement(By.xpath("//div[@id='fe-mode-design']//button[.='Sell Products']")).click();	       
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/section/div/div/div[4]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/ul/li[14]/div[2]/div/div/div[2]/span")));
		driver.findElement(By.xpath("//div[2]/div/section/div/div/div[4]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/ul/li[14]/div[2]/div/div/div[2]/span")).click();
		driver.findElement(By.xpath("//div[@id='fe-style-selector-element-options']//button[.='Add products']")).click();
		driver.findElement(By.xpath("//tbody[@class='ussr-component-grid-body']/tr/td/div/input")).click();
		driver.findElement(By.cssSelector("span.model-name")).click();
		driver.findElement(By.name("name")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Dollar");
		driver.findElement(By.name("name")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='ontraport_grid_offer']/div")).click();
		driver.findElement(By.xpath("//div[@class='ontraport_grid_offer']/div")).click();

		driver.findElement(By.name("price")).click();
		//driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("1");
		driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[.='Done']")).click();
		driver.findElement(By.xpath("//div[@id='fe-style-selector-element-options']//button[.='Add payment method']")).click();
		if (!driver.findElement(By.xpath("//div[@id='fe-style-selector-element-options']/div[14]/div[2]/div/div/ul/li/select//option[2]")).isSelected()) {
			driver.findElement(By.xpath("//div[@id='fe-style-selector-element-options']/div[14]/div[2]/div/div/ul/li/select//option[2]")).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.ussr-icon.ussr-icon-trashcan")));
		driver.findElement(By.xpath("//div[@class='fe-controls']//button[.='save']")).click();
		driver.findElement(By.xpath("//div[@class='fe-controls']//button[.='back']")).click();
		
		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(.)='" + formName + "']")));
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
