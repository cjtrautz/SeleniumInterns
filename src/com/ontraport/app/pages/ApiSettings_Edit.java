package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class ApiSettings_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-api-generate-target-owner ')]//input")
    private WebElement apiOwner; 
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='component-api-generate-target-add']//a[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-checkbox-checked ')]")
    private WebElement apiAddCheckedBox;    
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='component-api-generate-target-search']//a[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-checkbox-checked ')]")
    private WebElement apiSearchCheckedBox;    
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='component-api-generate-target-delete']//a[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-checkbox-checked ')]")
    private WebElement apiDeleteCheckedBox;    
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='component-api-generate-target-create-key']//a[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-type-checkbox-checked ')]")
    private WebElement apiCreateKeyCheckedBox;    
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-api-generate-target-app-id ')]")
    private WebElement apiAppID;    
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-api-generate-target-api-key ')]")
    private WebElement apiKey; 
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-top ')]/div[@class='ussr-pane-editor-back']")
    private WebElement back; 
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header ')]//button[contains(., 'Cancel')]")
    private WebElement cancel; 
    
    public ApiSettings_Edit verifyAPIOwner (String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(apiOwner));
            String compare = apiOwner.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public ApiSettings_Edit verifyAddContacts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(apiAddCheckedBox.isDisplayed()!=true)
            {
                return null;
            }

        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public ApiSettings_Edit verifySearchContacts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(apiSearchCheckedBox.isDisplayed()!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public ApiSettings_Edit verifyDeleteContacts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(apiDeleteCheckedBox.isDisplayed()!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public ApiSettings_Edit verifyCreateKey ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(apiCreateKeyCheckedBox.isDisplayed()!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public ApiSettings_Edit verifyAppID ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(apiAppID.isDisplayed()!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public ApiSettings_Edit verifyKey ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(apiKey.isDisplayed()!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public ApiSettings_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (ApiSettings_ListAll) new ApiSettings_ListAll().init();
    }

    public ApiSettings_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        return (ApiSettings_ListAll) new ApiSettings_ListAll().init();
    }
}
