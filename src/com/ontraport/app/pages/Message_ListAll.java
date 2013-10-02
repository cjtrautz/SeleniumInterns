package com.ontraport.app.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Message_ListAll extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newMessageList;
    
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr")
    private WebElement uiCollectionBodyRow1;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//table[contains(concat(' ', normalize-space(@class), ' '),' ussr-workflow-menu-section-list-type-pinned ')]")
    private WebElement pinTable;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' pinned-paginator ')]")
    private WebElement pinPaginator;

    public Message_TypeSelection clickNewMessage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newMessageList));
        newMessageList.click();
        return (Message_TypeSelection) new Message_TypeSelection().init();
    }

    public Message_ListAll selectAllOnPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        uiSelectAll.click();
        return this;
        
    }
    
    public Message_ListAll verifyMessage (String message)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + message + "']"));
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
    public Message_Edit clickMessage (String message)
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.manage()
        .timeouts()
        .implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBodyRow1)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiSelectAll)));
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + rule + "']")))));
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + rule + "']")))));
        uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + message + "']")).click();
        return PageFactory.initElements(driver, Message_Edit.class);
    }
    
    public Message_ListAll verifyNoMessage ()
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

    public Message_ListAll verifyPinnedWorkflow ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> finder = new ArrayList<WebElement>();
        while(finder.isEmpty() == true){
            AbstractPart.waitForAjax(driver, 20);
            int i = pinTable.findElements(By.xpath(".//tr")).size();
            System.out.println(i);
            if(pinTable.findElements(By.xpath(".//tr")).size()==1)
            {
                return null;
            }
            finder=pinTable.findElements(By.xpath(".//a[normalize-space(text())='" + string +"']"));
            //System.out.println(finder.isEmpty());
            if(finder.isEmpty() == true){  
                try
                {
                    pinPaginator.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-seek-next']")).click();
                }
                catch(NoSuchElementException e)
                {
                    return null;
                }
            }
            
        }
        return this;
    }

    public Message_ListAll verifyNoPinnedWorkflow ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> finder = new ArrayList<WebElement>();
        while(finder.isEmpty() == true){
            AbstractPart.waitForAjax(driver, 20);
            int i = pinTable.findElements(By.xpath(".//tr")).size();
            System.out.println(i);
            if(pinTable.findElements(By.xpath(".//tr")).size()==1)
            {
                return this;
            }
            finder=pinTable.findElements(By.xpath(".//a[normalize-space(text())='" + string +"']"));
            //System.out.println(finder.isEmpty());
            if(finder.isEmpty() == true){  
                try
                {
                    pinPaginator.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-seek-next']")).click();
                }
                catch(NoSuchElementException e)
                {
                    return this;
                }
            }
            
        }
        return null;
    }
    
}
