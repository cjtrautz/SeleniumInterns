package com.ontraport.app.selenium.tests;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;


import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class DeleteAllRules extends OntraportFirefoxTest {
	AppUtilities appUtilities = new AppUtilities();
	
	@Test
	public void testDeleteAllRules() throws Exception {
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

		//driver.get(baseUrl + "/");
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		appUtilities.navigateTo (driver, "Contacts");
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Delete All Rules
		do {
			driver.findElement(By.xpath("//thead[@class='ussr-component-collection-head']//a")).click();
			driver.findElement(By.linkText("Delete Rule")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")));
			driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']//span[normalize-space(text())='Ok']/parent::button")).click();
			Thread.sleep(3000);			
		} while (!driver.getPageSource().contains("There are no items to display"));
		//appUtilities.logOutOfApp(driver);
		AssertJUnit.assertTrue(driver.getPageSource().contains("There are no items to display"));

	    driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();


}
}
