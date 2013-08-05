package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class AddColumn extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();
	@Test
	public void test() {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		/*First Name
		 * Last Name
		 * Email
		 * Title
		 * Company
		 * custom field
		 * Address
		 * City
		 * State
		 * Zip Code
		 * Country
		 * Fax
		 * SMS Number
		 * Office Phone
		 * Birthday
		 * Website
		 */
		String columnToAdd= "First Name";
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.cssSelector("span.ussr-icon.ussr-icon-plus")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[2]/table/thead/tr/th/div/div/button")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//div[.='" +columnToAdd + "']")).click();
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[4]/div[1]/div[2]/div/div/a[1]/span")).click();
        assertTrue(appUtilities.isElementPresent(driver, By.xpath("//tr[@class='sem-collection-header-display']//a[.='" + columnToAdd + "']")));
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
