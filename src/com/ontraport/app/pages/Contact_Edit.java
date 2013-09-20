package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

public class Contact_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-note-create-target-text ')]//textarea")
    private WebElement textArea;
    
    @FindBy(
            how = How.XPATH, 
            using = "//a[normalize-space(text())='Notes and Tasks']")
    private WebElement notesAndTasksTab;
    
    @FindBy(
            how = How.XPATH, 
            using = "//div[@class='ussr-component-sub-collection-add-new']/span[text()='NEW Note']")
    private WebElement newNote;
    
    @FindBy(
            how = How.XPATH, 
            using = "//span[normalize-space(text())='Save']")
    private WebElement saveNote;
    
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
  
    @FindBy(how = How.XPATH,
            using = "//div[@class='ussr-component-tab-container']/div[2]/div[2]//table")
    private WebElement taskBody;
    
    @FindBy(how = How.XPATH,
            using = "//span[text()='Contact Information']")
    private WebElement contactInformationTitle;
    
    public Contact_Edit clickNotesAndTasksTab ()
    {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(contactInformationTitle)));
        notesAndTasksTab.click();
        return this;
        
    }

    public Contact_Edit clickNewNote ()
    {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBody)));
        newNote.click();
        return this;
        
    }

    public Contact_Edit enterNote ( String string )
    {
        textArea.sendKeys(string);
        return this;
        
    }

    public Contact_Edit clickSaveNote ()
    {
        saveNote.click();
        return this;
        
    }
    
    public Contact_Edit selectAllOnPage ()
    {
        driver.manage()
        .timeouts()
        .implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(taskBody)));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiSelectAll)));
        uiSelectAll.click();
        return this;
        
    }
    
    public Contact_Edit verifyNote (String note)
    {
        try
        {
            driver.manage()
            .timeouts()
<<<<<<< HEAD
            .implicitlyWait(8, TimeUnit.SECONDS);
=======
            .implicitlyWait(5, TimeUnit.SECONDS);
>>>>>>> b9afb0ebe45e75744f33e843429e8dfc3a7345f2
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + note + "']"));
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
    
    public Contact_Edit verifyNoNote (String note)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[@class='ussr-component-tab-container']/div[1]//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]"));
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
    
}
