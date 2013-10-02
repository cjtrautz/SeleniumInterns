package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPart;

public class Pin extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//span[@class='ussr-icon ussr-icon-circle-pin-s']")
    protected WebElement unPinned;
    
    @FindBy(how = How.XPATH,
            using = "//span[@class='ussr-icon ussr-icon-circle-pin-n']")
    protected WebElement pinned;

    public Pin pin ()
    {
        waitForAjax(driver, 20);
        unPinned.click();
        return this;
        
    }

    public Pin unPin ()
    {
        waitForAjax(driver, 20);
        pinned.click();
        return this;
        
    }
    
}
