package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.WordPress_Edit;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class WordPress_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newWebsite;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    

    public WordPress_TypeSelection clickNewWebsite ()
    {
        AbstractPart.waitForAjax(driver, 20);
        newWebsite.click();
        return (WordPress_TypeSelection) new WordPress_TypeSelection().init();
    }

    public WordPress_ListAll verifyLandingPage ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[contains(normalize-space(text()), '" + string + "')]"));
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

    public WordPress_Edit clickPage ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + string + "']")));
        uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']")).click();
        return (WordPress_Edit) new WordPress_Edit().init();
    }

    public WordPress_ListAll selectAllOnPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        uiSelectAll.click();
        return this;
        
    }

    public WordPress_ListAll verifyNoWordPressSite ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS);
            emptyCell.isDisplayed();
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
    
}
