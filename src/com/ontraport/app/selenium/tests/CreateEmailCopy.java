package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

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

public class CreateEmailCopy extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void test() {
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
	    long varTimeStamp= Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		String msgName = "Sel"+varTimeStamp;
		//String smsName = "SelSMS";
		System.out.println(msgName);
		
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Messages']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Message']")).click();
				
		driver.findElement(By.xpath("//div[@class='ussr-component-section-components']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='email message']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(msgName);
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Send out name']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Send out name']]/descendant::input")).sendKeys("Selenium Test");
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Reply to email']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Reply to email']]/descendant::input")).sendKeys("selenium@test.com");
		
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::li[1]/div")));
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select Mail From']]/descendant::li[1]/div")).click();
		
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Subject']]/descendant::input")).clear();
		driver.findElement(By.xpath("//div[label[normalize-space(text())='Subject']]/descendant::input")).sendKeys("Selenium Test");
		
		//the workaround
		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body")));
		driver.findElement(By.cssSelector("body")).sendKeys("Selenium Test");
		//Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]")));
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/div[4]/div[3]/div/div/div[2]"));
		
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[input[normalize-space(@placeholder)='Insert Merge Field']]/descendant::button"));
		appUtilities.selectItem(driver, "Insert Merge Field", "First Name");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[4]/button[3]")));

		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[4]/button[3]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[label[text()='RECORDS']]/descendant::button")));
		//driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='100']")));
		//driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='100']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[normalize-space(text())='" + (msgName) +"']")));
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//*[normalize-space(text())='" + (msgName) +"']")));
		//appUtilities.logOutOfApp(driver);
		driver.findElement(By.xpath("//*[normalize-space(text())='" + (msgName) +"']")).click();

        Assert.assertEquals("TaskNameAssertion",msgName, driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).getAttribute("value"));
        Assert.assertEquals("TaskNameAssertion","Selenium Test", driver.findElement(By.xpath("//div[label[normalize-space(text())='Send out name']]/descendant::input")).getAttribute("value"));
        Assert.assertEquals("TaskNameAssertion","selenium@test.com", driver.findElement(By.xpath("//div[label[normalize-space(text())='Reply to email']]/descendant::input")).getAttribute("value"));
        Assert.assertEquals("TaskNameAssertion","Selenium Test", driver.findElement(By.xpath("//div[label[normalize-space(text())='Subject']]/descendant::input")).getAttribute("value"));
        driver.switchTo().frame(1);
        Assert.assertEquals("TaskNameAssertion","testSelenium Test[First Name]", driver.findElement(By.xpath("/html[@class='CSS1Compat']/body")).getText());
		driver.switchTo().defaultContent();
		
	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();



	}

}
