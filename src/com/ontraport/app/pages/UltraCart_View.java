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
            using = "//div[contains(text(), 'Add this key to the Ultracart configuration menu under OfficeAutoPilot: ')]")
    private WebElement ultraCartKey;

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
        return this;
    }
    
}
