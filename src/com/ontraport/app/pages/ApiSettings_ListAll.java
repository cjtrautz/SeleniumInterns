package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.ApiSettings_Create;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class ApiSettings_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td[2]//span")
    private WebElement uiCollectionBodyRow1;
    
    @FindBy(
            how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement selectAll;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement additionalFields;
    
    @FindBy(
            how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement collection;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-title ')]/span[text()='API Keys']")
    private WebElement apiTitle;

    public ApiSettings_Create clickNewApiKey ()
    {
        additionalFields.click();
        return (ApiSettings_Create) new ApiSettings_Create().init();
    }
    
    public ApiSettings_ListAll verifyAPIKey (String api)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            collection.findElement(By.xpath(".//a[normalize-space(text())='" + api + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    
    public ApiSettings_ListAll verifyNoAPIKey ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            collection.findElement(By.xpath(".//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public ApiSettings_ListAll selectAllOnPage ()
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
    
    public ApiSettings_Edit clickAPI (String api)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(apiTitle));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBodyRow1)));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(selectAll)));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + api + "']"))));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(apiTitle));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBodyRow1)));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(selectAll)));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + api + "']"))));
        }
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a")));
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + api + "']")));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + api + "']")));
        }
        try
        {
            collection.findElement(By.xpath(".//a[normalize-space(text())='" + api + "']")).click();
        }
        catch(StaleElementReferenceException e)
        {
            collection.findElement(By.xpath(".//a[normalize-space(text())='" + api + "']")).click();
        }
        return (ApiSettings_Edit) new ApiSettings_Edit().init();
    }

    public ApiSettings_ListAll verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(driver.getCurrentUrl());
            System.out.println(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/api_settings/listAll");
            if(!driver.getCurrentUrl().equals(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/api_settings/listAll"))
            {
                return null; 
            }
            collection.isDisplayed();
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    

}
