package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

public class Field_Editor extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-section-titlebar ')]")
    private WebElement sectionTitle;
    
    @FindBy(
            how = How.CSS,
            using = "input.ussr-widget-editinplace-input")
    private WebElement input;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']")
    private WebElement newSectionButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button/span[text()='Save']")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button/span[text()='Cancel']")
    private WebElement cancel;

    public Field_Editor clickAddNewSection ()
    {
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        newSectionButton.click();
        return this;
        
    }

    public Field_Editor enterSectionTitle ( String oldTitle, String newTitle )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        WebElement titleToEdit = driver.findElement(By.xpath("//span[normalize-space(text())='" + oldTitle + "']"));
        titleToEdit.click();
        input.sendKeys(newTitle+Keys.ENTER);
        return this;
    }

    public Field_Editor enterSectionDescription ( String title, String oldDescription, String newDescription )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        WebElement descriptionToEdit = driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']/ancestor::div/following-sibling::div[text()='" + oldDescription + "']"));
        descriptionToEdit.click();
        input.sendKeys(newDescription+Keys.ENTER);
        return this;
    }

    public Contact_Settings clickSave ()
    {
        save.click();
        return PageFactory.initElements(driver, Contact_Settings.class);
    }

    public Contact_Settings clickCancel ()
    {
        cancel.click();
        return PageFactory.initElements(driver, Contact_Settings.class);
        
    }
    public Field_Editor verifySection (String title, String description)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']"));
            driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']/ancestor::div/following-sibling::div[text()='" + description + "']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
        
    }
    public Field_Editor verifyNotSection (String title)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[normalize-space(text())='" + title + "']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        
        return null;
        
    }

    public Field_Editor clickDeleteSection (String title)
    {
        WebElement deleteSection = driver.findElement(By.xpath("//div[span[text()='" + title + "']]/following-sibling::div[@class='ussr-component-section-columns-wrapper']//button[span[text()='Delete Section']]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", deleteSection);
        deleteSection.click();
        return this;
    }
    
    public Field_Editor clickTitle ()
    {
        sectionTitle.click();
        return this;
    }
    
}
