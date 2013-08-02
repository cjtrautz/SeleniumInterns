package com.ontraport.app.selenium.tests;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeleteALP extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
		
	@Test
	public void testDeleteALP () throws Exception{
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
		String lpName = "SelLP"+varTimeStamp;
		String Search =  String.valueOf(varTimeStamp);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		appUtilities.navigateTo (driver, "Sites==Landing Page");

		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[normalize-space(text())='New Landing Page']")).click();
		driver.findElement(By.xpath("//div[div[*/text()='Easy Pages']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-form-input-wrapper']/input")));

		driver.findElement(By.xpath("//div[@class='ussr-form-input-wrapper']/input")).click();

		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(lpName);
		
		driver.findElement(By.xpath("//div[@class='menu_button_class']//td[normalize-space(text())='Page URL:']")).click();
		//select radio button
		//driver.findElement(By.xpath("//*[*[normalize-space(text())='Use a Hosted Domain']]/descendant::input")).click();
		fillThePopUp (driver, "Use a Hosted Domain", "seleniumlandingpage");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.btn2")));
		driver.findElement(By.cssSelector("input.btn2")).click();
		
		driver.findElement(By.xpath("//div[@id='layer_box']/div[contains(normalize-space(text()),'New Item')]")).click();
		driver.findElement(By.xpath("//div[@class='ussr-dialog-content jb-ace-scroll-target']//div[@class='create_button_class']//td[contains(normalize-space(text()),'Shape')]")).click();
		//driver.findElement(By.xpath("//div[@class='ontraport_components_dialog']//input[@value='Accept']")).click();
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (lpName) +"']")));
		//driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();

		//Thread.sleep(10000);

		//Delete LP
		driver.findElement(By.xpath("//a[normalize-space(text())='"+(lpName)+"']/parent::span")).click();
		//Thread.sleep(10000);

		driver.findElement(By.linkText("Delete")).click();
		//Thread.sleep(10000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")));
		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")).click();
		//Thread.sleep(10000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")));
		driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		//Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		Thread.sleep(1000);
		Assert.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" +(lpName)+"']")));
		//appUtilities.logOutOfApp(driver);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}
	
	
	
	public void fillThePopUp (WebDriver driver, String domaintType, String domainName){
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='ontraport_components_dialog']//div[@class='blue_box']"));
		Iterator<WebElement> itr = findElements.iterator();
		System.out.println("size:"+findElements.size());
		while (itr.hasNext()) {
			System.out.println("===============================================");
			WebElement mainDivEle = (WebElement) itr.next();
			System.out.println(mainDivEle.getText());
			if (mainDivEle.getText().toLowerCase().contains(domaintType.toLowerCase())){
				mainDivEle.findElement(By.xpath(".//input[@class='inpt_radio standard_input']")).click();
				mainDivEle.findElement(By.xpath(".//input[@class='inpt_text standard_input']")).sendKeys(domainName);
				break;
			}
			
		}
		
	}
	
}
