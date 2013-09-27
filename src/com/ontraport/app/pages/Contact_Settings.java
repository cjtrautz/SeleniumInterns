package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Contact_Import;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Contact_Settings extends AbstractPage
{

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-list-item-desc' and text()='Add/Edit/Delete fields that make up your contact records.']")
    private WebElement fieldEditor;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-list-item-desc' and text()='Route new leads to the right user.']")
    private WebElement leadRouting;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-list-item-desc' and text()='Use this tool to import leads directly into your system.']")
    private WebElement importContacts;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-list-item-desc' and text()='Set your lead scoring rules.']")
    private WebElement leadScoring;
    
    public Field_Editor clickFieldEditor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(leadRouting));
        fieldEditor.click();
        return PageFactory.initElements(driver, Field_Editor.class);
    }

    public LeadRouter_ListAll clickLeadRouting ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(fieldEditor));
        leadRouting.click();
        return PageFactory.initElements(driver, LeadRouter_ListAll.class);
    }

    public Contact_Import clickImportContacts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(importContacts));
        importContacts.click();
        return PageFactory.initElements(driver, Contact_Import.class);
    }

    public Contact_ScoreEdit clickLeadScoring ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(leadScoring));
        leadScoring.click();
        return PageFactory.initElements(driver, Contact_ScoreEdit.class);
    }
    
}
