package com.ontraport.app.selenium.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class AddDeleteUserPermission extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void testChangeUserInfo() throws Exception {
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
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

		//Navigate to Personal Settings
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-wrapper']//*[@class='ussr-corner-bl']//a[normalize-space(text())='Personal Settings']")).click();
		driver.findElement(By.xpath("//a/span[text()='Actions']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[a[span[text()='Actions']]]/descendant::a/span[@class='ussr-icon ussr-icon-mail-closed']")));
		driver.findElement(By.xpath("//div[a[span[text()='Actions']]]/descendant::a/span[@class='ussr-icon ussr-icon-mail-closed']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[input[normalize-space(@placeholder)='Choose an Permission Exception']]/descendant::button")));
		appUtilities.selectItem(driver, "Choose an Permission Exception", "Can View Contacts");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[input[normalize-space(@placeholder)='Select Can View Contacts...']]/descendant::button")));
		appUtilities.selectItem(driver, "Select Can View Contacts...", "All)");
		
		driver.findElement(By.xpath("//span[text()='Add Exception']")).click();
		//Thread.sleep(3000);
		//Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//td/span/a[text()='Can View Contacts']")));
		
		driver.findElement(By.xpath("//span[@class='primary-nav-item-label' and normalize-space(text())='Contacts']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.ussr-header-nav-option-user")));
		//Navigate to Personal Settings
		driver.findElement(By.cssSelector("li.ussr-header-nav-option-user")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-wrapper']//*[@class='ussr-corner-bl']//a[normalize-space(text())='Personal Settings']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Owner']")));
		//Check for changed values
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//td/span/a[text()='Can View Contacts']")));
		
		driver.findElement(By.xpath("//a/span[text()='Actions']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[a[span[text()='Actions']]]/descendant::a/span[@class='ussr-icon ussr-icon-trashcan']")));
		driver.findElement(By.xpath("//div[a[span[text()='Actions']]]/descendant::a/span[@class='ussr-icon ussr-icon-trashcan']")).click();
		
		driver.findElement(By.xpath("//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Ok']")).click();
		//Thread.sleep(3000);
		//Assert.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//td/span/a[text()='Can View Contacts']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[span[@class='ussr-state-empty']]")));
		String txt = driver.findElement(By.xpath("//div[span[@class='ussr-state-empty']]")).getText();
		System.out.println ("txt:"+txt);
		Assert.assertTrue(txt.trim().equalsIgnoreCase("There are no items to display"));
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	}

}
