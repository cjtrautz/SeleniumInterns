package com.ontraport.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class WordPress_CreateType2 extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement websiteName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-hosted-domain-selector-subdomain ')]//input")
    private WebElement domainName;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-ordered-list-builder-target-select ')]//input")
    private WebElement membershipName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-custom-value-creator-target-save-button ')]")
    private WebElement addMembershipButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-back ')]")
    private WebElement back;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]//span[.='Save']")
    private WebElement saveButton;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]//span[.='Cancel']")
    private WebElement cancelButton;
    
    @FindBy(how = How.XPATH,
            using = "//a[@value='theirs']")
    private WebElement ownDomain;
    
    @FindBy(how = How.XPATH,
            using = "//a[@value='ours']")
    private WebElement ourDomain;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='http://']")
    private WebElement ownDomainLabel;

    @FindBy(how = How.XPATH,
            using = "//span[text()='affcntr.com']")
    private WebElement ourDomainLabel;

    public WordPress_CreateType2 enterWordPressSiteName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(websiteName));
        websiteName.sendKeys(string);
        return this;
        
    }


    public WordPress_CreateType2 enterDomainName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(domainName));
        domainName.sendKeys(string);
        return this;
        
    }


    public WordPress_CreateType2 enterMembershipLevel ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(membershipName));
        membershipName.sendKeys(string);
        return this;
        
    }


    public WordPress_CreateType2 clickAddMembershipLevel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addMembershipButton));
        addMembershipButton.click();
        return this;
        
    }


    public WordPress_CreateType2 clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        return this;
        
    }


    public WordPress_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancelButton));
        cancelButton.click();
        return (WordPress_ListAll) new WordPress_ListAll().init();
    }


    public WordPress_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (WordPress_ListAll) new WordPress_ListAll().init();
    }

    public Contact_Edit clickBackToContact ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (Contact_Edit) new Contact_Edit().init();
    }

    public WordPress_CreateType2 clickUseYourOwnDomain ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ownDomain));
        ownDomain.click();
        return this;
    }


    public WordPress_CreateType2 verifyOwnDomain ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!ownDomainLabel.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        return this;
    }


    public WordPress_CreateType2 clickUseOurDomain ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ourDomain));
        ourDomain.click();
        return this;
    }


    public WordPress_CreateType2 verifyOurDomain ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!ourDomainLabel.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        return this;
    }

    public Contact_Edit saveToContactEditor()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        
        return (Contact_Edit) new Contact_Edit().init() ;
    }
}
