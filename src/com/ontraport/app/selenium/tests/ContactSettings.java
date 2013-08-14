package com.ontraport.app.selenium.tests;

import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;

import com.ontraport.app.selenium.tools.OntraportFirefoxTest;

public class ContactSettings extends OntraportFirefoxTest {

	AppUtilities appUtilities = new AppUtilities();
	//String sectionName;
	String sectionName="SelDesc1376397235997";
	
	@Test
	public void testPreConditionAddNewSection() throws Exception {

		driver.get(baseUrl + "/");
		long varTimeStamp = Calendar.getInstance().getTimeInMillis();
		sectionName = "SelTitle"+varTimeStamp;
		String sectionDesc = "SelDesc"+varTimeStamp;
		System.out.println(sectionName);
		System.out.println(sectionDesc);
		
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");

		//Click Settings
		appUtilities.isElementPresent(driver, By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']"));
		driver.findElement(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")).click();
		Thread.sleep(3000);
	
		//Click Field Editor
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		Thread.sleep(10000);
		
		String scrollElement = "//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']";
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath(scrollElement));
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"));
		
	    Thread.sleep(5000);
	    
	    //Click ADD NEW SECTION
	    driver.findElement(By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']")).click();
	    Thread.sleep(5000);
	    
	    appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[@class='ussr-component-section-titlebar ussr-border-solid-bottom']//span[normalize-space(text())='Untitled']"));
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//div[@class='ussr-component-section-titlebar ussr-border-solid-bottom']//span[normalize-space(text())='Untitled']")).click();
	    driver.findElement(By.xpath("//div[*[text()='Section Description']]/descendant::input")).clear();
	    driver.findElement(By.xpath("//div[*[text()='Section Description']]/descendant::input")).sendKeys(sectionName);

	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//div//div[normalize-space(text())='Section Description']")).click();
	    driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).clear();
	    driver.findElement(By.cssSelector("input.ussr-widget-editinplace-input")).sendKeys(sectionDesc);
	    
		//Click Save
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();

		//Click Field Editor
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		Thread.sleep(6000);
		
		
		Thread.sleep(6000);
		draggablePartOfScrollbar = driver.findElement(By.xpath("//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']"));
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"));
		//AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='ussr-component-section-titlebar ussr-border-solid-bottom']//span[@class='ussr-component-section-title big ussr-helper-text-transform-uppercase' and normalize-space(text())='"+sectionTitle+"']")));
		//AssertJUnit.assertTrue(appUtilities.isElementPresent(driver, By.xpath("//div[@class='ussr-component-section-description ussr-widget-editinplace' and normalize-space(text())='"+sectionDesc+"']")));
	    
	    AssertJUnit.assertTrue(driver.getPageSource().contains(sectionName));
	    AssertJUnit.assertTrue(driver.getPageSource().contains(sectionDesc));
	    
	    appUtilities.logOutOfApp(driver);
			
	}
	
	
	@Test
	public void testAddFieldCheckBox () throws InterruptedException{
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelChkbox";

		
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");

		//Click Settings
		appUtilities.isElementPresent(driver, By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']"));
		driver.findElement(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")).click();
		Thread.sleep(3000);
	
		//Click Field Editor
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		appUtilities.waitForElement(driver, "//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']", 10);
		
		String scrollElement = "//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']";
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath(scrollElement));
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"));
		
	    Thread.sleep(5000);
	    
		driver.findElement(By.xpath("//div[*[text()='" + sectionName +"']]/descendant::a[text()='Add Field']")).click();
		
		driver.findElement(By.xpath("//div[*[text()='Field Name']]//input")).sendKeys(fieldName);
		appUtilities.selectItem(driver, "Select Field Type...", "Checkbox");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']/button/span[text()='Save']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		appUtilities.waitForElement(driver, "//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']", 10);
		
		Assert.assertTrue("Fields Checkbox Present", appUtilities.isElementPresent(driver, By.xpath("//div[*[text()='" + sectionName +"']]/descendant::label[normalize-space(text())='"+fieldName+"']")));
		appUtilities.logOutOfApp(driver);
	}
	
	@Test
	public void testAddFieldDate (){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelDate";
		String fieldType = "Date";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	@Test
	public void testAddFieldListSelection(){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelListSelection";
		String fieldType = "List Selection";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	
	@Test
	public void testAddFieldLongText(){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelLongText";
		String fieldType = "Long Text";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	
	@Test
	public void testAddFieldNumeric(){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelNumeric";
		String fieldType = "Numeric";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	
	@Test
	public void testAddFieldPrice(){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelPrice";
		String fieldType = "Price";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	
	@Test
	public void testAddFieldState(){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelState";
		String fieldType = "State";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	@Test
	public void testAddFieldDropdown(){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelDropdown";
		String fieldType = "Dropdown";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	@Test
	public void testAddFieldText(){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelText";
		String fieldType = "Text";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	
	@Test
	public void testAddFieldImage(){
		driver.get(baseUrl + "/");
		System.out.println(sectionName);
		String fieldName = "SelImage";
		String fieldType = "Image";

		creatFieldContactSettings (fieldName, fieldType);

	}
	
	public void creatFieldContactSettings (String fieldName, String fieldType){
		// login
		appUtilities.loginToApp(driver, "tester","passphrases are easy to break");

		//Click Settings
		appUtilities.isElementPresent(driver, By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']"));
		driver.findElement(By.xpath("//li[@class='primary-nav-sub-item']//a//span[ text()='Settings']")).click();
	
	
		//Click Field Editor
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		appUtilities.waitForElement(driver, "//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']", 10);
		
		String scrollElement = "//div[@class='jb-ace-scroll-wrapper jb-ace-scroll jb-ace-scroll-orientation-vertical']//div[@class='jb-ace-scroll-scrollbar-middle']";
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath(scrollElement));
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"));
		
		waitForSpecifiedTime(5000);
	    
		driver.findElement(By.xpath("//div[*[text()='" + sectionName +"']]/descendant::a[text()='Add Field']")).click();
		
		driver.findElement(By.xpath("//div[*[text()='Field Name']]//input")).sendKeys(fieldName);
		appUtilities.selectItem(driver, "Select Field Type...", fieldType);
		waitForSpecifiedTime(3000);
		driver.findElement(By.xpath("//div[@class='ussr-dialog-buttons']/button/span[text()='Save']")).click();
		waitForSpecifiedTime(3000);
		
		driver.findElement(By.xpath("//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")).click();
		waitForSpecifiedTime(5000);
		driver.findElement(By.xpath("//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")).click();
		waitForSpecifiedTime(5000);
		appUtilities.waitForElement(driver, "//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']", 10);
		appUtilities.scrollUntillElementFound(driver, draggablePartOfScrollbar, By.xpath("//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']"));
		Assert.assertTrue("Fields "+fieldType+" Present", appUtilities.isElementPresent(driver, By.xpath("//div[*[text()='" + sectionName +"']]/descendant::label[normalize-space(text())='"+fieldName+"']")));
		appUtilities.logOutOfApp(driver);
	}
	
	public void waitForSpecifiedTime (long specifiedTimeInMilliSeconds){
		try {
			Thread.sleep(specifiedTimeInMilliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
