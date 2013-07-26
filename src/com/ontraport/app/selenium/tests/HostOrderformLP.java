package com.ontraport.app.selenium.tests;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class HostOrderformLP extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
		
	@Test
	public void testHostOrderformLP () throws Exception{
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
		appUtilities.navigateTo (driver, "Sites==Landing Page");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String pageName = "SelOrderPage"+varTimeStamp;
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[normalize-space(text())='New Landing Page']")).click();
		driver.findElement(By.xpath("//div[div[*/text()='Easy Pages']]/descendant::button[*[normalize-space(text())='Create']]")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(pageName);
		
		driver.findElement(By.xpath("//div[@class='menu_button_class']//td[normalize-space(text())='Page URL:']")).click();
		//select radio button
		//driver.findElement(By.xpath("//*[*[normalize-space(text())='Use a Hosted Domain']]/descendant::input")).click();
		fillThePopUp (driver, "Use a Hosted Domain", pageName);
		Thread.sleep (5000);
		driver.findElement(By.cssSelector("input.btn2")).click();
		
		//Add a title
		driver.findElement(By.xpath("//td[@id='Menu_Bar']/div/div/table/tbody/tr[2]/td[1]/div/table/tbody/tr/td[2]/input")).click();
        driver.findElement(By.xpath("//td[@id='Menu_Bar']/div/div/table/tbody/tr[2]/td[1]/div/table/tbody/tr/td[2]/input")).clear();
        driver.findElement(By.xpath("//td[@id='Menu_Bar']/div/div/table/tbody/tr[2]/td[1]/div/table/tbody/tr/td[2]/input")).sendKeys(pageName);
		
		//Add a form
		driver.findElement(By.xpath("//div[@id='layer_box']/div[contains(normalize-space(text()),'New Item')]")).click();
		driver.findElement(By.xpath("//div[@class='ussr-dialog-content jb-ace-scroll-target']//div[@class='create_button_class']//td[contains(normalize-space(text()),'Form')]")).click();
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::button")).click();
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li/span[normalize-space(text())='Smart Forms and Order Forms']")).click();
		driver.findElement(By.xpath("//div[input[@placeholder='Select...']]/descendant::li//div[@class='ussr-component-drilldownselect-item-label text-overflow-ellipsis']")).click();
				
		//Thread.sleep (5000);
		//driver.findElement(By.xpath("//div[@class='ontraport_components_dialog']//input[@value='Accept']")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(pageName);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + pageName +"']")));
		//Thread.sleep (5000);
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
	
	public void selectItem(String formLink, String formType, String formName, WebDriver driver ){
		
		
		try {
			driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='"+ (formLink) +"']]/descendant::button")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[input[@placeholder='"+ (formLink) +"']]/descendant::li/span[text()='"+ (formType) +"']")).click();
		} catch (InterruptedException e) {

		}
	}
	
}
