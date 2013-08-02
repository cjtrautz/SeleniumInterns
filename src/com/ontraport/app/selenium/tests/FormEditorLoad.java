package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class FormEditorLoad extends OntraportFirefoxTest{

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
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Smart Forms']")).click();
        driver.findElement(By.xpath("//div[@id='ontraport_panel_action_new']//span[.='New Smart Form']")).click();
        //wait for driver.findElement(By.xpath("//div[@id='fe-mode-design']//button[.='Add Field']")).click();
        AssertJUnit.assertTrue(driver.findElement(By.name("submit-button")).getAttribute("value").equals("Submit"));
            
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

       
	}

}
