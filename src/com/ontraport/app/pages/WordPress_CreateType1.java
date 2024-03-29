package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class WordPress_CreateType1 extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement websiteName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-hosted-domain-target-component ')]//input")
    private WebElement domainName;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-ordered-list-builder-target-select ')]//input")
    private WebElement membershipName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-custom-value-creator-target-save-button ')]")
    private WebElement addMembershipButton;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]//span[.='Save']")
    private WebElement saveButton;

    public WordPress_CreateType1 enterWordPressSiteName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(websiteName));
        websiteName.sendKeys(string);
        return this;
        
    }


    public WordPress_CreateType1 enterDomainName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(domainName));
        domainName.sendKeys(string);
        return this;
        
    }


    public WordPress_CreateType1 enterMembershipLevel ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(membershipName));
        membershipName.sendKeys(string);
        return this;
        
    }


    public WordPress_CreateType1 clickAddMembershipLevel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addMembershipButton));
        addMembershipButton.click();
        return this;
        
    }


    public WordPress_CreateType1 clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        return this;
        
    }

    
}
