package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class TrackedDomain_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//div[div[contains(concat(' ', normalize-space(@class), ' '), ' user-leading-container ')] or table[tbody[tr[td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]]]]]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td[2]//span")
    private WebElement uiCollectionBodyRow1;
    
    @FindBy(
            how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement selectAll;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newTrackedDomain;

    public TrackedDomain_Create clickNewTrackedDomain ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newTrackedDomain));
        newTrackedDomain.click();
        return (TrackedDomain_Create) new TrackedDomain_Create().init();
    }

    public TrackedDomain_ListAll verifyDomain ( String string )
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

    public TrackedDomain_Edit clickDomain ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']")).click();
        return (TrackedDomain_Edit) new TrackedDomain_Edit().init();
    }

    public TrackedDomain_ListAll selectAll ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        }
        try
        {
            selectAll.click();
        }
        catch(StaleElementReferenceException e)
        {
            selectAll.click();
        }
        return this;
    }

    public TrackedDomain_ListAll verifyNoDomain ()
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
