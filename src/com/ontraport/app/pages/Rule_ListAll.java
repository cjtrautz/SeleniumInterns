package com.ontraport.app.pages;

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
        wait.until(ExpectedConditions.visibilityOf(rulesTitle));
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ontraport_panel_action_new']")));
        newRule.click();
        return PageFactory.initElements(driver, Rule_Create.class);

    }
    public Rule_ListAll selectAllOnPage ()
    {
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(rulesTitle));
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        //wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        uiSelectAll.click();
        return this;
        
    }
    
    public Rule_ListAll verifyRule (String rule)
    {
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
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(7, TimeUnit.SECONDS);
            emptyCell.isDisplayed();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(StaleElementReferenceException d)
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
    
    public Rule_Edit clickRule (String rule)
    {
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
        return PageFactory.initElements(driver, Rule_Edit.class);
    }
    public Rule_ListAll selectRule (String rule)
    {
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(rulesTitle));
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        //wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        
        int attempts = 0;
        while(attempts < 2) {
            try {
                System.out.println(attempts);
                driver.findElement(By.xpath("//tbody[@class='ussr-component-collection-body']//tr//td[span[contains(., '" + rule + "')]]/preceding-sibling::td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-checkbox ')]/a")).click();
                break;
            } catch(StaleElementReferenceException e) {
            }
            
            attempts++;
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBody.findElement(By.xpath(".//tr//td[span[contains(., '" + rule + "')]]/preceding-sibling::td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-checkbox ')]/a/span")))));
        //uiCollectionBody.findElement(By.xpath(".//tr//td[span[contains(., '" + rule + "')]]/preceding-sibling::td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-checkbox ')]/a/span")).click();
        return this;
        
    }
    
    
}
