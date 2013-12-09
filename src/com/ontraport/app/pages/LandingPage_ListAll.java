package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.LandingPage_TypeSelection;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class LandingPage_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newLandingPage;

    public LandingPage_TypeSelection clickNewLandingPage ()
    {
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        wait.until(ExpectedConditions.visibilityOf(newLandingPage));
        newLandingPage.click();
        return (LandingPage_TypeSelection) new LandingPage_TypeSelection().init();
    }

    public LandingPage_ListAll verifyLandingPage ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }

    public LandingPage_Edit clickPage ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']")).click();
        return (LandingPage_Edit) new LandingPage_Edit().init();
    }

    public LandingPage_ListAll selectLandingPage ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//tr//td[span[contains(., '" + string + "')]]/preceding-sibling::td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-checkbox ')]/a")).click();
        return this;
        
    }

    public LandingPage_ListAll verifyNoLandingPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(emptyCell.isDisplayed()!=true)
                {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
                }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }

    public LandingPage_ListAll verifyThisPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-title ')]/span[text()='Landing Pages']")).isDisplayed())
            {
                return null;
            }
            if(!uiCollectionBody.isDisplayed())
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
