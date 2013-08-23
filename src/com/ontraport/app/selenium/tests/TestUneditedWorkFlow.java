package com.ontraport.app.selenium.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class TestUneditedWorkFlow extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testUneditedWorkflow ()throws Exception {
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
		String gateWayName = "SelGW"+varTimeStamp;
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='sem-collection-header-display']//a[.='Email']")));
		clickOnNonBlankLastNameContactLink(driver);
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Actions']")).click();
		driver.findElement(By.linkText("Log Transaction")).click();
				
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[input[normalize-space(@placeholder)='Select Gateway...']]/descendant::button")));
		appUtilities.selectItemSpan(driver, "Select Gateway...", "Create New Gateway");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Name']")));
		driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(gateWayName);

		driver.findElement(By.xpath("//button/span[text()='Save as Draft']")).click();
		driver.findElement(By.xpath("//button[@value='Cancel']")).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.ussr-icon.ussr-icon-circle-file")));
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-circle-file")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ussr-workflow-menu-box']//th[normalize-space(.)='workflow']")));
		
		//boolean b = isUnEditItemsLogAvaialable(gateWayName, driver);
		//System.out.println(b);
		//AssertJUnit.assertEquals(true, b);
		List<WebElement> finder = new ArrayList<WebElement>();
		while(finder.isEmpty() == true){
			finder=driver.findElements(By.xpath("//a[normalize-space(text())='Gateway: " + (gateWayName) +"']"));
			//System.out.println(finder.isEmpty());
			if(finder.isEmpty() == true){
				AssertJUnit.assertFalse(appUtilities.isElementPresent(driver, By.xpath("//div[7]/div/div/div[2]/div/ul/li[4]/a/span[@class='ussr-icon ussr-icon-seek-next ussr-state-disabled']")));
				driver.findElement(By.xpath("//div[@class='ussr-workflow-menu-box']/div[2]/div/ul/li[4]/a[1]/span")).click();
			}
		}
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='Gateway: " + (gateWayName) +"']")));
		driver.findElement(By.cssSelector("a.ussr-icon.ussr-icon-circle-file")).click();
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
	}
	
	public void clickOnNonBlankLastNameContactLink (WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='ussr-table-striped']")));
		List<WebElement> findElements = driver.findElements(By.xpath("//table[@class='ussr-table-striped']//td[2]/span/a"));
		Iterator<WebElement> iterator = findElements.iterator();
		while (iterator.hasNext()) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("linkname:"+webElement.getText());
			System.out.println(webElement.getText().trim().length());
			System.out.println("");
			if (webElement.getText().trim().length()!=0){
				webElement.click();
				return;
			}
			
		}
	}
	
	
	public boolean isUnEditItemsLogAvaialable(String gatewayname, WebDriver driver) throws InterruptedException{
		String nxtBtnXpath = "//div[table[contains(@class,'ussr-workflow-menu-section-list-type-unedited')]]/descendant::a[@class='ussr-paginator-control-next']/span";
		String disabledNxtBtnXpath = "//div[table[contains(@class,'ussr-workflow-menu-section-list-type-unedited')]]/descendant::a[@class='ussr-paginator-control-next']/span[@class='ussr-icon ussr-icon-seek-next ussr-state-disabled']";
		//String logLinkXpath = "//table[contains(@class,'ussr-workflow-menu-section-list-type-unedited')]//a[text()='Gateway: "+gatewayname+"']";
		String gtName = "Gateway: "+gatewayname;
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
		List<WebElement> findElements = driver.findElements(By.xpath("//table[contains(@class,'ussr-workflow-menu-section-list-type-unedited')]//a"));
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
