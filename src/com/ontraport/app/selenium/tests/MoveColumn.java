package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class MoveColumn extends OntraportFirefoxTest {

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
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		Actions action = new Actions(driver);
		
		Thread.sleep(3000);
		//WebElement email = driver.findElement(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Email']"));
		String tab = driver.findElement(By.xpath("//div[2]/div/section/div/div/div[4]/div[1]/div/table/thead/tr/th[2]/a")).getText();
		//System.out.println(driver.findElements(By.xpath("//*[contains(@class, 'ussr-icon ussr-icon-pencil')]")).isEmpty());
		System.out.println("tab" + tab);
		//action.moveToElement(email).build().perform();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.getElementsByClassName('ussr-icon ussr-icon-pencil')[0].click();");
		//action.moveToElement(email).perform();
		//action.moveToElement(pencil).perform();
		//pencil.click();

		Thread.sleep(1000);
		//pencil.click();
		WebElement movable = driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[2]/div"));
		action.dragAndDropBy(movable, 145, 0).perform();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[2]/div/div/a[1]/span")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[2]/div/section/div/div/div[4]/div[1]/div/table/thead/tr/th[3]/a[.='Email']")));
		Thread.sleep(3000);
	}

}
