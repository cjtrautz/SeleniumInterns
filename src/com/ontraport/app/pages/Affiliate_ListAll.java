package com.ontraport.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Affiliate_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    public Affiliate_ListAll verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(driver.getCurrentUrl());
            System.out.println(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/affiliate/listAll");
            if(!driver.getCurrentUrl().equals(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/affiliate/listAll"))
            {
                return null; 
            }
            uiCollectionBody.isDisplayed();
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
}
