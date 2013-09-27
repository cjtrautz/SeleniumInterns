package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Gateway_Edit;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Gateway_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollection;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newGateway;

    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    
    public Gateway_Create clickNewGateway ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollection));
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ontraport_panel_action_new']")));
        newGateway.click();
        return PageFactory.initElements(driver, Gateway_Create.class);
    }

    public Gateway_ListAll verifyGatewayName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollection.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']"));
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

    public Gateway_Edit clickGateway ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        try
        {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollection)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiSelectAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + string + "']"))));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollection)));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiSelectAll)));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + string + "']"))));
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a")));
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + string + "']")));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + string + "']")));
        }
        catch(TimeoutException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + string + "']")));
        }
        try
        {
            uiCollection.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']")).click();
        }
        catch(StaleElementReferenceException e)
        {
            uiCollection.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']")).click();
        }
        return PageFactory.initElements(driver, Gateway_Edit.class);
    }

    public Gateway_ListAll selectGateway ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollection));
            wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        }
        catch(StaleElementReferenceException e1)
        {
            wait.until(ExpectedConditions.visibilityOf(uiCollection));
            wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        }
        //wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        try
        {
            uiSelectAll.click();
        }
        catch(StaleElementReferenceException e2)
        {
            uiSelectAll.click();
        }
        return this;
        
    }

    public Gateway_ListAll verifyNoGateway ()
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
        catch(StaleElementReferenceException d)
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
