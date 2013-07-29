package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeleteGateway extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testDeleteGateWay() throws Exception{
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
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String gatewayName = "SelGW" + varTimeStamp;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.xpath("//*[@class='primary-nav-item-label' and text()='Sales']")).click();
		driver.findElement(By.xpath("//li[3]//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		
		//Clicking checkbox and navigating to New Gateway page
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-textfield']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Gateway']")).click();
		
		//Typing name
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(gatewayName);
		
		//Selecting from drop down
		driver.findElement(By.xpath("//div[@class='ussr-gateway-editor']//button")).click();
		driver.findElement(By.xpath("//div//ul[@class='ussr-component-drilldownselect-ul']/li/div[normalize-space(text())='Dummy Gateway']")).click();

		//Fill the nickname field
		WebElement nicknameTxtBox = appUtilities.getTextBoxOnTheLabel(driver, "nickname");
		nicknameTxtBox.clear();
		nicknameTxtBox.sendKeys("nick"+varTimeStamp);
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(gatewayName);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (gatewayName) +"']")));
		driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[span[a[normalize-space(text())='" + gatewayName + "']]]]/descendant::td[3]")));
		WebElement chkBox = driver.findElement(By.xpath("//tr[td[span[a[normalize-space(text())='" + gatewayName + "']]]]/descendant::td[3]"));
		chkBox.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Gateway")));
		driver.findElement(By.linkText("Delete Gateway")).click();		
		driver.findElement(By.xpath("//*[@class='ussr-dialog-buttons']/button/span[normalize-space(text())='Ok']")).click();
		Thread.sleep (1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("SelGW");
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ussr-icon ussr-icon-plus']")));
		Assert.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (gatewayName) +"']")));
		//appUtilities.logOutOfApp(driver);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		
	}

}
