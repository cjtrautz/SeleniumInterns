package com.ontraport.app.selenium.tests;



import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class OpensDrawerRule extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testOpensDrawerRule() throws Exception {
		
		//driver.get(baseUrl + "/");
		//login
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		
		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Actions']")));
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='Actions']")).click();

		
		String actionTxt= driver.findElement(By.xpath("//div[@class='ussr-chrome-panel-action-drawer-content ussr-texture-flat-light']")).getText().trim();
		System.out.println(actionTxt);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ussr-chrome-panel-action-drawer-content ussr-texture-flat-light']")).isDisplayed());
		Assert.assertTrue(actionTxt.contains("Delete Rule"));
		Assert.assertTrue(actionTxt.contains("Unpause Rule"));
		Assert.assertTrue(actionTxt.contains("Pause Rule"));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		
		//Logout
		//appUtilities.logOutOfApp(driver);
	}
	
	

	
	
	

}
