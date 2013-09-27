package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class LandingPage_CreateType1 extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement landingPageName;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ')]//input[@type='TEXT']")
    private WebElement landingPageNameTitle;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ') and @style='cursor: pointer;']")
    private WebElement pageUrl;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id='layer_box']//div[text()='+ New Item']")
    private WebElement newItem;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]//span[text()='Save']")
    private WebElement save;
    
    public LandingPage_CreateType1 enterLandingPageName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageName));
        landingPageName.sendKeys(string);
        return this;
        
    }

    public LandingPage_CreateType1 enterLandingPageTitle ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageNameTitle));
        landingPageNameTitle.sendKeys(string);
        return this;
        
    }

    public LandingPage_CreateType1 clickPageURL ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(pageUrl));
        pageUrl.click();
        return this;
        
    }

    public LandingPage_CreateType1 clickNewItem ()
    {
        AbstractPart.waitForAjax(driver, 20);
        newItem.click();
        return this;
        
    }

    public LandingPage_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }
    
}
