package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class TrackingUrlHistory_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td/a")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;

    public TrackingUrlHistory_ListAll verifyURL ( String string )
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

    public TrackingUrlHistory_ListAll selectAll ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        uiSelectAll.click();
        return this;
    }

    public TrackingUrlHistory_ListAll verifyNoURL ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            emptyCell.isDisplayed();
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
}
