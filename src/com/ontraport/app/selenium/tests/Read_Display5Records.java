package com.ontraport.app.selenium.tests;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class Read_Display5Records extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRead_Display5Records() throws Exception {
		driver.get(baseUrl + "/");
		//login
		appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::button")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[label[text()='RECORDS']]/descendant::li/div[text()='5']")).click();
	Thread.sleep(5000);
	
	Assert.assertEquals("Number of Records Assertion","1-5", driver.findElement(By.xpath("//*[@id='ussr-chrome-panel-pane']/footer/div/div[1]/ul/li[1]/span[2]")).getText().trim());
	
	//Logout
	appUtilities.logOutOfApp(driver);
      }
	}
