package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class EditGroupPermIEditYouView extends OntraportFirefoxTest{
	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testEditGroupPermIEditYouView() throws InterruptedException {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='731 test']")).click();
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_group_edit']//span[.='Manage Groups']")).click();
        driver.findElement(By.xpath("//div[@class='group_editor_public']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Only I can edit, everyone can view']")).click();
        driver.findElement(By.xpath("//div[@class='group-editor-button-wrapper-left']//button[.='Save']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_group_edit']//span[.='Manage Groups']")).click();
        //driver.findElement(By.xpath("//div[@class='group_editor_public']/span/div/div/input")).click();
		Thread.sleep(1000);
        Assert.assertEquals("RuleNameAssertion","Only I can edit, everyone can view", driver.findElement(By.xpath("//div[@class='group_editor_public']/span/div/div/input")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_group_edit']//span[.='Manage Groups']")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='<br>']")).click();
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Group: All']")).click();
        
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

	}

}
