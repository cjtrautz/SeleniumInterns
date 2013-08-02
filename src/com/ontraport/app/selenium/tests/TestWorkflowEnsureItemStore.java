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
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class TestWorkflowEnsureItemStore extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testWorkflowEnsureItemStore()throws Exception{
		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		//Thread.sleep (5000);
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String name = "Sel"+varTimeStamp;
		System.out.println (varTimeStamp);
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		
		appUtilities.selectNonBlankLastNameContactLink(driver);
		Thread.sleep (5000);
		//driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Actions']")).click();
		Thread.sleep (3000);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//a[normalize-space(.)='Send E-Mail']")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[2]/div/ul/div/div[2]/div/div/button")).click();
	    driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//li[normalize-space(.)='Create New Message']")).click();		Thread.sleep (5000);
		driver.findElement(By.cssSelector("input.ussr-border-solid-all")).clear();
		driver.findElement(By.cssSelector("input.ussr-border-solid-all")).sendKeys(name);
		driver.findElement(By.xpath("//button/span[text()='Save and Edit']")).click();
		Thread.sleep (5000);
		driver.findElement(By.xpath("//button//span[text()='Cancel']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-circle-file")).click();
		Thread.sleep(5000);
		
		Assert.assertTrue(isUnEditItemsLogAvaialable(name, driver));
		
		driver.findElement(By.cssSelector("a.ussr-icon.ussr-icon-circle-file")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();



		
		
	}
	
	
	
	public boolean isUnEditItemsLogAvaialable(String gatewayname, WebDriver driver) throws InterruptedException{
		String nxtBtnXpath = "//div[table[contains(@class,'ussr-workflow-menu-section-list-type-work-flow')]]/descendant::a[@class='ussr-paginator-control-next']/span";
		//String disabledNxtBtnXpath = "//div[table[contains(@class,'ussr-workflow-menu-section-list-type-work-flow')]]/descendant::a[@class='ussr-paginator-control-next']/span[@class='ussr-icon ussr-icon-seek-next ussr-state-disabled']";
		//String logLinkXpath = "//table[contains(@class,'ussr-workflow-menu-section-list-type-unedited')]//a[text()='Gateway: "+gatewayname+"']";
		String gtName = "Editing Message: "+gatewayname;
		int flag = 0;
		do {
			if (isLinkPresentIntable(driver, gtName)){
				return true;
			}else{	
				if (appUtilities.isElementPresent(driver, By.xpath(nxtBtnXpath))){
					driver.findElement(By.xpath(nxtBtnXpath)).click();
					Thread.sleep(3000);
					flag=1;
				}else{
					return false;
				}
			}
			
		} while (flag==1);
		return false;
		
		
	}
	
	
	public boolean isLinkPresentIntable (WebDriver driver, String gateWayName){
		//"ussr-workflow-menu-section ussr-helper-float-left"
		List<WebElement> findElements = driver.findElements(By.xpath("//table[contains(@class,'ussr-workflow-menu-section-list-type-work-flow')]//a"));
		Iterator<WebElement> iterator = findElements.iterator();
		while (iterator.hasNext()) {
			WebElement webElement = (WebElement) iterator.next();
			String linkText = webElement.getText().trim();
			System.out.println("linkname:"+linkText);
			System.out.println(webElement.getText().trim().length());
			if (linkText.equalsIgnoreCase(gateWayName.trim())){
				return true;
			}
			
		}
		
		return false;
	}
	
	
}
