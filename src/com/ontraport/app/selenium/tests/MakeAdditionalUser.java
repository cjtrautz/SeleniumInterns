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

public class MakeAdditionalUser extends OntraportFirefoxTest {
AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testMakeAdditionalUser() throws Exception{
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
		WebDriverWait wait = new WebDriverWait(driver, 10);
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		String emailId = "SelUsr"+varTimeStamp+"@gmail.com";
		
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//ul[@class='ussr-corner-bl']/li/a[text()='Manage Users']")).click();
		
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New User']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Agree']")));
		driver.findElement(By.xpath("//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Agree']")).click();
		
		String fname = "Selenium" + varTimeStamp;
		String lname = "Test" + varTimeStamp;
		String emailName = "Selenium" + varTimeStamp;
		appUtilities.getTextBoxOnTheLabel(driver, "First Name").sendKeys(fname);
		appUtilities.getTextBoxOnTheLabel(driver, "Last Name").sendKeys(lname);
		appUtilities.getTextBoxOnTheLabel(driver, "Email 'From' Name").sendKeys(emailName);
		appUtilities.getTextBoxOnTheLabel(driver, "Reply-To Email").sendKeys(emailId);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Password & Misc.')]")));
		//driver.findElement(By.partialLinkText("Password & Misc")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Password & Misc.')]")).click();

		appUtilities.getTextBoxOnTheLabel(driver, "New Password").sendKeys("test");
		appUtilities.getTextBoxOnTheLabel(driver, "Password Confirm").sendKeys("test");
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/div/div/button")).click();
		driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label")).click();		
		appUtilities.selectItem(driver, "Select User", "Pin Chen");
		appUtilities.selectItem(driver, "Select Timezone...", "EST");
		appUtilities.selectItem(driver, "Select Language...", "English");
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (emailId) +"']")));
	
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	}
	
}
