package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class TrackingContent_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;

    public TrackingContent_ListAll verifyContent ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
}
