package com.ontraport.app.selenium.tests;

import java.util.Calendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class CreateRule extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();

	@Test
	public void testCreateRule() throws Exception {

		//driver.get(baseUrl + "/");
		//login
		//appUtilities.loginToApp(driver, "tester", "passphrases are easy to break");
		WebDriver driver;
		try {
			driver = getDriver();
		} catch (Exception e) {
			System.out.println("get Driver failed");
			driver = new FirefoxDriver();
			e.printStackTrace();
		}
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		String ruleName = "SelRule" + varTimeStamp;
		String Search = String.valueOf(varTimeStamp);
		driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

		//Click Rules
		driver.findElement(By.xpath("//*[@class='primary-nav-sub-item']/a//span[text()='Rules']")).click();
		//Click on New Rule
		driver.findElement(By.xpath("//*[@id='panelbuttonbar']/div//span[text()='New Rule']")).click();
		//Type the Rule Name
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).click();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")).sendKeys(ruleName);

        selectRuleDropDown (driver, "WHEN THIS HAPPENS:","Select Trigger...", "A Certain field is updated");
        selectRuleDropDown(driver, "WHEN THIS HAPPENS:", "Select Field...", "City");

        selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition (optional)...", "Field is this value");
        selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Field...", "First Name");

        selectRuleDropDown(driver, "IF THIS IS TRUE:", "Select Condition...", "Equal To");


        driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Enter Value...']")).sendKeys("selenium");

        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div/input")).sendKeys("change");
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//div[.='Change the value of a field']")).click();
        selectRuleDropDown(driver, "THEN DO THIS:", "Select Field...", "Last Name");

        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[1]/div/div/input")).click();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[1]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@class='ussr-component-helper-field-display-rule-editor']/div[3]/div[2]/div/div[1]/div/div[2]/div[2]/div[1]/div/table/tbody/tr/td[4]/span[1]/div/div/input")).sendKeys("selenium");

        driver.findElement(By.xpath("//button//span[text()='Save']")).click();

        driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']/div[1]")).click();
        driver.findElement(By.xpath("//input[@type='search']")).clear();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Search);
        driver.findElement(By.xpath("//span[@class='ussr-icon ussr-icon-search']")).click();

        AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//a[normalize-space(text())='" + ruleName +"']")));
        driver.findElement(By.xpath("//aside[@id='ussr-chrome-sidebar']//span[.='Contacts']")).click();

        //Logout
        //appUtilities.logOutOfApp(driver);
	}

        driver.findElement(By.xpath("//button//span[text()='Save']")).click();

	public void selectRuleDropDown (WebDriver driver, String ruleDesc, String placeHolder, String option) throws InterruptedException{
		driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+ placeHolder +"']]/descendant::button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]/descendant::li/div[normalize-space(text())='"+option+"']")));
		driver.findElement(By.xpath("//div[div[text()='"+ruleDesc+"']]//div[input[normalize-space(@placeholder)='"+placeHolder+"']]/descendant::li/div[normalize-space(text())='"+option+"']")).click();

	}
}

