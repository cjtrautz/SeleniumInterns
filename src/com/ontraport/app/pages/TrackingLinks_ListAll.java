package com.ontraport.app.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class TrackingLinks_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td/a")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newTrackedLink;

    public TrackingLinks_Create clickNewTrackedLink ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(newTrackedLink));
        newTrackedLink.click();
        return (TrackingLinks_Create) new TrackingLinks_Create().init();
    }

    public TrackingLinks_ListAll verifyTrackedLink ( String string )
    {

        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public TrackingLinks_Edit clickTrackedLink ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']")).click();
        return (TrackingLinks_Edit) new TrackingLinks_Edit().init();
    }

    public TrackingLinks_ListAll selectAll ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        uiSelectAll.click();
        return this;
    }

    public TrackingLinks_ListAll verifyNoTrackedLinks ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(emptyCell.isDisplayed()!=true)
                {
                return null;
                }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
}
