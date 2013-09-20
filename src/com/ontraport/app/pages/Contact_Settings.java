package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

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
    
    public Field_Editor clickFieldEditor ()
    {
        wait.until(ExpectedConditions.visibilityOf(leadRouting));
        fieldEditor.click();
        return PageFactory.initElements(driver, Field_Editor.class);
    }

    public LeadRouter_ListAll clickLeadRouting ()
    {
        wait.until(ExpectedConditions.visibilityOf(fieldEditor));
        leadRouting.click();
        return PageFactory.initElements(driver, LeadRouter_ListAll.class);
    }
    
}
