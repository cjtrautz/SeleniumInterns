package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Contact_Import;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Contact_Settings extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']")
    private WebElement settings;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/queued_message/listAll']")
    private WebElement scheduledBroadcasts;

    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/fieldeditor/manage']")
    private WebElement fieldEditor;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/lead_rout/listAll']")
    private WebElement leadRouting;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/contact/import']")
    private WebElement importContacts;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/contact/scoreEdit']")
    private WebElement leadScoring;
    
    public Field_Editor clickFieldEditor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(leadRouting));
        fieldEditor.click();
        return (Field_Editor) new Field_Editor().init();
    }

    public LeadRouter_ListAll clickLeadRouting ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(fieldEditor));
        leadRouting.click();
        return (LeadRouter_ListAll) new LeadRouter_ListAll().init();
    }

    public Contact_Import clickImportContacts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(importContacts));
        importContacts.click();
        return (Contact_Import) new Contact_Import().init();
    }

    public Contact_ScoreEdit clickLeadScoring ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(leadScoring));
        leadScoring.click();
        return (Contact_ScoreEdit) new Contact_ScoreEdit().init();
    }

    public Contact_Settings verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-title ')]/span[text()='Settings']")).isDisplayed())
            {
                return null;
            }
            if(!settings.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public QueuedMessage_ListAll clickScheduledBroadCasts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(scheduledBroadcasts));
        scheduledBroadcasts.click();
        return (QueuedMessage_ListAll) new QueuedMessage_ListAll().init();
    }
    
}
