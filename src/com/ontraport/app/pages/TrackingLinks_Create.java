package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class TrackingLinks_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' uid_editor_component__pane_nav_tabs__tab_0__203_editor_component__pane_nav_tabs__tab_0__203__name_TYPE_ontraport_components_form_control_input_text_NAME_name ')]//input")
    private WebElement nameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' uid_editor_component__pane_nav_tabs__tab_0__203_editor_component__pane_nav_tabs__tab_0__203__url_TYPE_ontraport_components_form_control_input_text_NAME_url ')]//input")
    private WebElement urlInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]//span[contains(text(), 'Save')]")
    private WebElement save;

    public TrackingLinks_Create enterName ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(string);
        return this;
    }

    public TrackingLinks_Create enterDestinationURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(urlInput));
        urlInput.click();
        urlInput.clear();
        urlInput.sendKeys(string);
        return this;
    }

    public TrackingLinks_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (TrackingLinks_ListAll) new TrackingLinks_ListAll().init();
    }
    
}
