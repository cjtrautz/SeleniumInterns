package com.ontraport.app.selenium.tests;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class MakeAPackage extends OntraportFirefoxTest {

	@Test
	public void testCreatePackage() throws Exception {
		//baseUrl = "http://app.ontraport.com";
		//driver.get(baseUrl + "/");
		//loginToApp();
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

		String packageName = varTimeStamp+"Test";
		
		//Navigate to Admin page
		driver.findElement(By.xpath("//div[@id='ussr-chrome-wrapper']//a[normalize-space(text())='tester@sendpepper.com']")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-wrapper']//*[@class='ussr-corner-bl']//a[normalize-space(text())='Admin']")).click();
		
		//Navigate to New package creation page
		driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']//*[text()='Package Manager']")).click();
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[normalize-space(text())='New Package']")).click();
		
		//Typing name Package name
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ussr-chrome-panel-pane']//div[contains(normalize-space(text()),'Add Item')]")));
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(packageName);
		
		//Add Items
		driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']//div[contains(normalize-space(text()),'Add Item')]")).click();
		
		//selectItem("Select Tag", "test");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]/div/div[2]/div/div[1]/div/div/div/button")));
		driver.findElement(By.xpath("//div[7]/div/div[2]/div/div[1]/div/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
		driver.findElement(By.xpath("//span[text()='Add Tag']")).click();
		
		//selectItem("Select Message", "Test E-Mail");
		driver.findElement(By.xpath("//div[7]/div/div[2]/div/div[2]/div/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
		driver.findElement(By.xpath("//span[text()='Add Message']")).click();
		
		//selectItem("Select Sequence", "My New Sequence");
		driver.findElement(By.xpath("//div[7]/div/div[2]/div/div[3]/div/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
		driver.findElement(By.xpath("//span[text()='Add Sequence']")).click();
		
		//selectItem("Select Landing Page", "test order");
		driver.findElement(By.xpath("//div[7]/div/div[2]/div/div[4]/div/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
		driver.findElement(By.xpath("//span[text()='Add Landing Page']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]/div/div[2]/div/div[5]/div/div/div/button")));

		
		//selectItem("Select Smart Form", "New Order Form");
		driver.findElement(By.xpath("//div[7]/div/div[2]/div/div[5]/div/div/div/button")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
		driver.findElement(By.xpath("//span[text()='Add Forms']")).click();
		
		//selectItem("Select Rule", "Selenium Rule");
		driver.findElement(By.xpath("//div[7]/div/div[2]/div/div[6]/div/div/div/button")).click();
		driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
		driver.findElement(By.xpath("//span[text()='Add Rules']")).click();

		driver.findElement(By.xpath("//span[text()='Done']")).click();	
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();
		
		//Check for the added package and open it
		/*
		for (int second = 0;; second++) {
			if (second >= 10) fail("timeout");
			try { if (isElementPresent(By.xpath("//a[normalize-space(text())='"+ packageName + "']"), driver))break; } catch (Exception e) {}
			Thread.sleep(1000);
		}*/
		
		HashMap<String, String> ruleMap = new HashMap<String, String>();
		ruleMap.put ("tag", "test");
		ruleMap.put ("message", "Test E-Mail");
		ruleMap.put ("sequence", "My New Sequence");
		ruleMap.put ("landing page", "test order");
		ruleMap.put ("form", "New Order Form");
		ruleMap.put ("rule", "Selenium Rule");
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(isElementPresent(By.xpath("//a[normalize-space(text())='" + (packageName) +"']"), driver));
		//not using the map values
		//driver.findElement(By.xpath("//a[normalize-space(text())='"+ packageName + "']")).click();
		//org.junit.Assert.assertTrue(validateItemTypesOfPackage (driver, ruleMap));
		
		//Logout
		//driver.findElement(By.cssSelector("li.ussr-header-nav-option-user"))
		//		.click();
		//driver.findElement(By.cssSelector("a[href=\"Login/logout\"]")).click();
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	}




	public void loginToApp (WebDriver driver){
		driver.findElement(By.xpath("//div[@id='sod-drawer-handle']/div")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("tester");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("passphrases are easy to break");
		driver.findElement(By.cssSelector("input.submit")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Messages']"), driver)) break; } catch (Exception e) {}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}	
	
	public void selectItem(String itemLink, String itemName, WebDriver driver){
		
		
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='"+ (itemLink) +"']]/descendant::button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[input[@placeholder='"+ (itemLink) +"']]/descendant::li/div[text()='"+ (itemName) +"']")));			
		driver.findElement(By.xpath("//div[input[@placeholder='"+ (itemLink) +"']]/descendant::li/div[text()='"+ (itemName) +"']")).click();
	}
	
	
	public boolean validateItemTypesOfPackage (WebDriver driver, HashMap<String, String> ruleMap){
		
		int count = 0;
		HashMap<String, String> fromApplication = new HashMap<String, String>();
		List<WebElement> rowElements = driver.findElements(By.xpath("//div[@class='package_manager_item_list ussr-border-solid-top']//tr"));
		Iterator<WebElement> itr = rowElements.iterator();
		while (itr.hasNext()) {
			WebElement eachRowElement = (WebElement) itr.next();
			try{
			String keyData = eachRowElement.findElement(By.xpath(".//td[3]")).getText().trim().toLowerCase();
			String valueData = eachRowElement.findElement(By.xpath(".//td[2]")).getText().trim().toLowerCase();
			fromApplication.put(keyData, valueData);
			}catch(Exception e){
				
			}
		}
		
		Set<String> keySet = ruleMap.keySet();
		for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			try {
				if (!ruleMap.get(key).equalsIgnoreCase(fromApplication.get(key))){
					count++;
				}
			} catch (Exception e) {
				// TODO: handle exception
				count++;
			}
		}
		
		if (count>0){
			return false;
		}else{
			return true;
		}
		
	}
	
}
