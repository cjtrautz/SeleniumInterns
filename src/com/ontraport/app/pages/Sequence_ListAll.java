package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Sequence_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),'ussr-collection-empty')]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-title ')]/span[text()='Sequences']")
    private WebElement title;
    
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newSequence;
    
    @FindBy(
            how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td")
    private WebElement uiCollectionBodyRow1;

    public Sequence_TypeSelection clickNewSequence ()
    {
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        newSequence.click();
        return (Sequence_TypeSelection) new Sequence_TypeSelection().init();
    }
    
    public Sequence_ListAll verifySequence (String tag)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + tag + "']"));
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
    
    public Sequence_ListAll verifyNoTag ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
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
    
    public Sequence_ListAll verifyNoSequence ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
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
    

    public Sequence_ListAll selectAllOnPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        uiSelectAll.click();
        return this;
        
    }
    public Sequence_Edit clickSequence (String sequence)
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBodyRow1)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiSelectAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + sequence + "']"))));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a")));
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + sequence + "']")));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + sequence + "']")));
        }
        catch(TimeoutException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + sequence + "']")));
        }
        try
        {
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + sequence + "']")).click();
        }
        catch(StaleElementReferenceException e)
        {
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + sequence + "']")).click();
        }
        return (Sequence_Edit) new Sequence_Edit().init();
    }

    public Sequence_ListAll verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(driver.getCurrentUrl());
            System.out.println(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/sequence/listAll");
            if(!driver.getCurrentUrl().equals(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/sequence/listAll"))
            {
                return null; 
            }
            if(!uiCollectionBody.isDisplayed())
            {
                return null;
            }
            if(!title.isDisplayed())
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
