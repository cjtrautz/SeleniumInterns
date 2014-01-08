package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class Pin extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-circle-pin-s ')]")
    protected WebElement unPinned;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-circle-pin-n ')]")
    protected WebElement pinned;

    public Pin pin ()
    {
        waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(unPinned));
        unPinned.click();
        return this;
        
    }

    public Pin unPin ()
    {
        waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(pinned));
        pinned.click();
        return this;
        
    }
    
}
