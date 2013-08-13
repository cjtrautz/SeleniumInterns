package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class AddGroup extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testAddGroup() {
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String Search =  String.valueOf(varTimeStamp);
		String name = "Selenium" + varTimeStamp;
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		driver.findElement(By.xpath("//div[@id='ontraport_panel_action_group_edit']/span[1]")).click();
        driver.findElement(By.xpath("//div[@class='group_editor_name']/span/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='group_editor_name']/span/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='group_editor_name']/span/div/div/input")).sendKeys(name);
        driver.findElement(By.xpath("//div[@class='group_editor_public']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//tr[@class='sem_condition_row']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//tr[@class='sem_condition_row']/td[2]/span/div/div/button")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='contains']")).click();
        driver.findElement(By.cssSelector("input.ussr-border-solid-all")).click();
        driver.findElement(By.cssSelector("input.ussr-border-solid-all")).clear();
        driver.findElement(By.cssSelector("input.ussr-border-solid-all")).sendKeys(name);
        driver.findElement(By.xpath("//div[@class='group-editor-button-wrapper-left']//button[.='Save']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='<br>']")).click();
        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[.='" +name+ "']")));
           
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
