package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class MakeAdditionalRole  extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testMakeARole() throws InterruptedException{
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);

		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		String roleName = "Role"+varTimeStamp;
		
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//ul[@class='ussr-corner-bl']/li/a[text()='Admin']")).click();
		
		driver.findElement(By.xpath("//a/div[text()='Team Roles & Permission Management']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Role']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(roleName);

		selectItem ("Select Role", "Administrator", driver);
		
		driver.findElement(By.xpath("//div[label[text()='Dashboard']]/descendant::a/span")).click();
		driver.findElement(By.xpath("//div[label[text()='Can Send Emails']]/descendant::a/span")).click();
		driver.findElement(By.xpath("//div[label[text()='Can Manage Sequences']]/descendant::a/span")).click();

		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ussr-icon ussr-icon-search']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (roleName) +"']")));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		
	}
	
	public void selectItem(String itemLink, String itemName, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='"+ (itemLink) +"']]/descendant::button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[input[@placeholder='"+ (itemLink) +"']]/descendant::li/div[text()='"+ (itemName) +"']")));
		driver.findElement(By.xpath("//div[input[@placeholder='"+ (itemLink) +"']]/descendant::li/div[text()='"+ (itemName) +"']")).click();
	}

}
