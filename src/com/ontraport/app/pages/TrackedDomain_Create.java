package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class TrackedDomain_Create extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ontraport_components_form_control_input_text ')]//input")
    private WebElement urlInput;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]//span[text()='Save']")
    private WebElement save;

    public TrackedDomain_Create enterURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(urlInput));
        urlInput.sendKeys(string);
        return this;
    }

    public TrackedDomain_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (TrackedDomain_ListAll) new TrackedDomain_ListAll().init();
    }
    
}
