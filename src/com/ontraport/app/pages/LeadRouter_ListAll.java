package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractSuite;

public class LeadRouter_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBodyRow1;
    
    @FindBy(
            how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement selectAll;
    
    @FindBy(
            how = How.XPATH,
            using = "//*[@id='panelbuttonbar']/div//span[text()='New Lead Router']")
    private WebElement newLeadRouterButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement collectionBody;

    public LeadRouter_TypeSelection clickNewLeadRouter ()
    {
        wait.until(ExpectedConditions.visibilityOf(newLeadRouterButton));
        newLeadRouterButton.click();
        return PageFactory.initElements(driver, LeadRouter_TypeSelection.class);
    }
    
    public LeadRouter_ListAll verifyRouter (String router)
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            collectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + router + "']"));
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

    public LeadRouter_ListAll verifyNoRouter ()
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            collectionBody.findElement(By.xpath(".//td[@class='ussr-collection-empty']"));
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
    
    public LeadRouter_ListAll selectAllOnPage ()
    {
        driver.manage()
        .timeouts()
        .implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBodyRow1)));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        selectAll.click();
        return this;

    }
    
    public LeadRouter_Edit clickRouter (String router)
    {
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOf(rulesTitle));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBodyRow1)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(selectAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a"))));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + rule + "']")));
        collectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + router + "']")).click();
        return PageFactory.initElements(driver, LeadRouter_Edit.class);
    }

}
