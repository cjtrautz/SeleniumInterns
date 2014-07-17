package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Purchase_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;

    public Purchase_ListAll verifyPurchase ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
            if(!uiCollectionBody.findElement(By.xpath(".//td[contains(., '" + string + "')]")).isEnabled())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }    
}
