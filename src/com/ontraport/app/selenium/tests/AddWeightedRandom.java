package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class AddWeightedRandom extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	

	@Test
	public void testAddRoundRobin() throws Exception {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//driver.get(baseUrl + "/");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String name = "SelTitle"+varTimeStamp;
		String Search =  String.valueOf(varTimeStamp);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//appUtilities.loginToApp(driver, "tester","passphrases are easy to break");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")));
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Settings']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/ul/li[3]/a/div")));
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div/div/div/div/ul/li[3]/a/div")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Lead Router']")));
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Lead Router']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[div[a[text()='Weighted Random']]]/descendant::a/button")));
		driver.findElement(By.xpath("//div[div[a[text()='Weighted Random']]]/descendant::a/button")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='target-rout ussr-component ussr-component-lead_rout_target ontraport_components_lead_rout_target'][1]//button")));

		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
		
		//driver.findElement(By.xpath("//div/div[text()='Add User']")).click();

		//driver.findElement(By.xpath("//div/div[text()='Add User']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='target-rout ussr-component ussr-component-lead_rout_target ontraport_components_lead_rout_target'][1]//button")));
		
		driver.findElement(By.xpath("//div[@class='target-rout ussr-component ussr-component-lead_rout_target ontraport_components_lead_rout_target'][1]//button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[1]")));
		String s1 = driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[1]")).getText();
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[1]")).click();
		
		driver.findElement(By.xpath("//div[@class='lead_rout_entry_row']//div[@class='header_box target-break ussr-component ussr-component-form_control_input_text ontraport_components_form_control_input_text ussr-form-cell ussr-component-form-control clearfix']//input")).clear();
		driver.findElement(By.xpath("//div[@class='lead_rout_entry_row']//div[@class='header_box target-break ussr-component ussr-component-form_control_input_text ontraport_components_form_control_input_text ussr-form-cell ussr-component-form-control clearfix']//input")).sendKeys("50");
			
		driver.findElement(By.xpath("//div/div[text()='Add User']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='target-rout ussr-component ussr-component-lead_rout_target ontraport_components_lead_rout_target'][2]//button")));
		
		driver.findElement(By.xpath("//div[@class='target-rout ussr-component ussr-component-lead_rout_target ontraport_components_lead_rout_target'][2]//button")).click();
		
		String s2 = driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[2]")).getText();
		driver.findElement(By.xpath("//div[input[normalize-space(@placeholder)='Select...']]/descendant::li[2]")).click();
		
		
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("50");
		
		driver.findElement(By.xpath("//button//span[text()='Save']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")));
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
		driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();
		Assert.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + (name) +"']")));
		driver.findElement(By.xpath("//a[normalize-space(text())='" + (name) +"']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[2]")));
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='text'])[2]")).getAttribute("value").trim().equalsIgnoreCase(s1.trim()));
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='text'])[4]")).getAttribute("value").trim().equalsIgnoreCase(s2.trim()));
	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		
		
		//appUtilities.logOutOfApp(driver);
		
		
	}

}
