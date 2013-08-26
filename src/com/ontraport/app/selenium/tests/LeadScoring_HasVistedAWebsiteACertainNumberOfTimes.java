package com.ontraport.app.selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class LeadScoring_HasVistedAWebsiteACertainNumberOfTimes extends OntraportFirefoxTest{

	@Test
	public void testLeadScoring_HasVistedAWebsiteACertainNumberOfTimes() {
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']/section[1]/nav/ul/li[1]/nav/ul/li[5]/a")).click();
	    driver.findElement(By.xpath("//div[@class='ussr-section']//div[.='LEAD SCORING']")).click();
        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>()
        		{
        			public Boolean apply(WebDriver d)
        			{
        				JavascriptExecutor js = (JavascriptExecutor) d;
        				return (Boolean)js.executeScript("return jQuery.active == 0");
        			}
        		});
	    
	    driver.findElement(By.cssSelector("div.ussr-icon.ussr-icon-plus")).click();
        driver.findElement(By.xpath("//input[@placeholder='Select Condition']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'Has visited a website a certain number of times')]")).click();
        
	    driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']//button[normalize-space(.)='<br>']")).click();	        
        driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[4]/div/div/input")).click();
	    driver.findElement(By.cssSelector("div.ussr-component-drilldownselect-item-label.text-overflow-ellipsis")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[6]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[6]/div/div/input")).clear();
	    driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/span[6]/div/div/input")).sendKeys("1");
	    driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']/span[2]/div/div/input")).click();
	    driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']/span[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ontraport_components_rule_editor_score_editor_sentence_wrapper']/span[2]/div/div/input")).sendKeys("11");
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")).click();
	}

}
