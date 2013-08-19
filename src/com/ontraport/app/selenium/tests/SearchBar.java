package com.ontraport.app.selenium.tests;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class SearchBar extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	String firstName="SrchFN";
	String lastName="SrchLN";
	String emailId;
	
	
	@Test
	public void testCreateContact() throws Exception {
		//baseUrl = "http://app.ontraport.com";
		driver.get(baseUrl + "/");
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		Thread.sleep (5000);
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Contact']")).click();
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		System.out.println (varTimeStamp);
		WebElement fNameTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "First Name");
		fNameTxtBox.clear();
		fNameTxtBox.sendKeys(firstName);
		
		WebElement lNameTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "Last Name");
		lNameTxtBox.clear();
		lNameTxtBox.sendKeys(lastName);
		
		
		emailId = "selenium"+varTimeStamp+"@test.com";
		WebElement emailTxtBox = appUtilities.getTextBoxOnTheLabel (driver, "E-Mail");
		emailTxtBox.clear();
		emailTxtBox.sendKeys(emailId);
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ("Fname"+varTimeStamp) +"']")));

		
		//Logout
		appUtilities.logOutOfApp(driver);
	}
	
	
	@Test
	public void testSearchForFieldSetAsColumn () throws Exception{
		driver.get(baseUrl + "/");
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		Thread.sleep(5000);
		String srchTxt = firstName;
		
		fillSearchField (driver, srchTxt);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//table[@class='ussr-table-striped']//td/span/a")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue("Assert Search String Availability", appUtilities.isTextPresent(driver, srchTxt));

		//Logout
		appUtilities.logOutOfApp(driver);
	}
	
	
	@Test
	public void testSearchDeleteUserInput () throws Exception{
		driver.get(baseUrl + "/");
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		Thread.sleep(5000);
		String srchTxt = firstName;
		
		fillSearchField (driver, srchTxt);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a.ussr-form-input-type-search-clear.position-absolute-right > span.ussr-icon.ussr-icon-close")).click();
		String val = driver.findElement(By.xpath("//input[@type='search']")).getAttribute("value").trim();
		
		
		Assert.assertTrue("Assert Search Clear Text Functionality", (val.length()==0));

		//Logout
		appUtilities.logOutOfApp(driver);
	}
	
	@Test
	public void testSearchForFieldClickOutside () throws Exception{
		driver.get(baseUrl + "/");
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		Thread.sleep(5000);
		String srchTxt = firstName;
		
		fillSearchField (driver, srchTxt);
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//table[@class='ussr-table-striped']//td/span/a")).click();
		Thread.sleep(5000);
		
		Assert.assertTrue("Assert Search String Availability", appUtilities.isTextPresent(driver, srchTxt));

		//Logout
		appUtilities.logOutOfApp(driver);
	}
	
	
	@Test
	public void testSearchForFieldHitEnterKey () throws Exception{
		driver.get(baseUrl + "/");
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		Thread.sleep(5000);
		String srchTxt = firstName;
		
		fillSearchField (driver, srchTxt);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//table[@class='ussr-table-striped']//td/span/a")).click();
		Thread.sleep(5000);
		
		Assert.assertTrue("Assert Search String Availability", appUtilities.isTextPresent(driver, srchTxt));

		//Logout
		appUtilities.logOutOfApp(driver);
	}
	
	@Test
	public void testSearchMagnifyingGlass () throws Exception{
		driver.get(baseUrl + "/");
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		Thread.sleep(5000);
		String srchTxt = firstName;
		
		fillSearchField (driver, srchTxt);
		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-search")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//table[@class='ussr-table-striped']//td/span/a")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue("Assert Search String Availability", appUtilities.isTextPresent(driver, srchTxt));

		//Logout
		appUtilities.logOutOfApp(driver);
	}
	
	
	@Test
	public void testSearchTypeText () throws Exception{
		driver.get(baseUrl + "/");
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		Thread.sleep(5000);
		String srchTxt = firstName;
		
		fillSearchField (driver, srchTxt);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.TAB);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//table[@class='ussr-table-striped']//td/span/a")).click();
		Thread.sleep(5000);
		
		Assert.assertTrue("Assert Search String Availability", appUtilities.isTextPresent(driver, srchTxt));

		//Logout
		appUtilities.logOutOfApp(driver);
	}
	
	public void fillSearchField (WebDriver driver, String searchString){
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(searchString);
	}
	
	
	
}
