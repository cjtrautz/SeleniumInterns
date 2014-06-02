package com.ontraport.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class UltraCart_View extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class, 'text_NAME_ultracart_key')]//input")
    private WebElement ultraCartKey;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class, 'NAME_ultracart_last_sync')]//input")
    private WebElement ultraCartSyncInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class, 'ussr-ultracart-form-submit')]//button")
    private WebElement ultraCartSyncButton;

    public UltraCart_View keyAdding ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(ultraCartKey.isDisplayed()!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        try
        {
            if(ultraCartSyncInput.isDisplayed()!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        try
        {
            if(ultraCartSyncButton.isDisplayed()!=true)
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
    
}
