package com.ontraport.app.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Rule_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newRule;
    
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td[2]//span")
    private WebElement uiCollectionBodyRow1;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-title ')]/span[text()='Rules']")
    private WebElement rulesTitle;

    public Rule_Create clickNewRule ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(rulesTitle));
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ontraport_panel_action_new']")));
        newRule.click();
        return (Rule_Create) new Rule_Create().init();

    }
    public Rule_ListAll selectAllOnPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(rulesTitle));
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
            wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        }
        catch(StaleElementReferenceException e1)
        {
            wait.until(ExpectedConditions.visibilityOf(rulesTitle));
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
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
    
    public Rule_ListAll verifyRule (String rule)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + rule + "']"));
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
    
    public Rule_ListAll verifyNoRule ()
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
    
    public Rule_Edit clickRule (String rule)
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(rulesTitle));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBodyRow1)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiSelectAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + rule + "']"))));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a")));
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + rule + "']")));
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + rule + "']")));
        }
        catch(TimeoutException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + rule + "']")));
        }
        try
        {
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + rule + "']")).click();
        }
        catch(StaleElementReferenceException e)
        {
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + rule + "']")).click();
        }
        return (Rule_Edit) new Rule_Edit().init();
    }
    public Rule_ListAll selectRule (String rule)
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(rulesTitle));
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
            wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + rule + "']")));
        }
        catch(StaleElementReferenceException e1)
        {
            wait.until(ExpectedConditions.visibilityOf(rulesTitle));
            wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
            wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@class='ussr-component-collection-body']//a[normalize-space(text())='" + rule + "']")));
        }
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
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBody.findElement(By.xpath(".//tr//td[span[contains(., '" + rule + "')]]/preceding-sibling::td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-checkbox ')]/a/span")))));
        //uiCollectionBody.findElement(By.xpath(".//tr//td[span[contains(., '" + rule + "')]]/preceding-sibling::td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-checkbox ')]/a/span")).click();
        return this;
        
    }
    public Rule_ListAll verifyRuleFired ( String rule )
    {
        AbstractPart.waitForAjax(driver, 20);
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        // get current date time with Date()
        Date date = new Date();
        String name = dateFormat.format(date);
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + rule + "']/ancestor::td/following-sibling::td[@class='ussr-component-collection-cell ussr-component-collection-cell-type-timestamp']/span/a[contains(text(),'" + name + "')]"));
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
