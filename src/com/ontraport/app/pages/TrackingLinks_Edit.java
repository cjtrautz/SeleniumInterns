package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class TrackingLinks_Edit extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' uid_editor_component__pane_nav_tabs__tab_0__203_editor_component__pane_nav_tabs__tab_0__203__name_TYPE_ontraport_components_form_control_input_text_NAME_name ')]//input")
    private WebElement nameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' uid_editor_component__pane_nav_tabs__tab_0__203_editor_component__pane_nav_tabs__tab_0__203__name_TYPE_ontraport_components_form_control_input_text_NAME_name ')]//div[@class='ussr-form-input']")
    private WebElement nameDisplayed;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' uid_editor_component__pane_nav_tabs__tab_0__203_editor_component__pane_nav_tabs__tab_0__203__name_TYPE_ontraport_components_form_control_input_text_NAME_name ')]//button")
    private WebElement nameSave;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' uid_editor_component__pane_nav_tabs__tab_0__203_editor_component__pane_nav_tabs__tab_0__203__url_TYPE_ontraport_components_form_control_input_text_NAME_url ')]//input")
    private WebElement urlInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' uid_editor_component__pane_nav_tabs__tab_0__203_editor_component__pane_nav_tabs__tab_0__203__url_TYPE_ontraport_components_form_control_input_text_NAME_url ')]//div[@class='ussr-form-input']")
    private WebElement urlDisplayed;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' uid_editor_component__pane_nav_tabs__tab_0__203_editor_component__pane_nav_tabs__tab_0__203__url_TYPE_ontraport_components_form_control_input_text_NAME_url ')]//button")
    private WebElement urlSave;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-chrome-panel-pane-header-back ')]")
    private WebElement back;

    public TrackingLinks_Edit enterName ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(string);
        return this;
    }

    public TrackingLinks_Edit enterDestinationURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(urlInput));
        urlInput.click();
        urlInput.clear();
        urlInput.sendKeys(string);
        return this;
    }

    public TrackingLinks_Edit verifyName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            String compare = nameDisplayed.getText();
            System.out.println(compare);
            if (compare.equals(string) != true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public TrackingLinks_Edit verifyDestinationLink ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            String compare = urlDisplayed.getText();
            System.out.println(compare);
            if (compare.equals(string) != true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public TrackingLinks_Edit clickName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(nameDisplayed));
        nameDisplayed.click();
        return this;
    }

    public TrackingLinks_Edit clickSaveName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(nameSave));
        nameSave.click();
        return this;
    }

    public TrackingLinks_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (TrackingLinks_ListAll) new TrackingLinks_ListAll().init();
    }

    public TrackingLinks_Edit clickDestinationURL ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(urlDisplayed));
        urlDisplayed.click();
        return this;
    }

    public TrackingLinks_Edit clickSaveDestinationURL ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(urlSave));
        urlSave.click();
        return this;
    }
    
}
