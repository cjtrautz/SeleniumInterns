package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Task_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]")
        private WebElement actionPane;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//div[div[contains(concat(' ', normalize-space(@class), ' '), ' user-leading-container ')] or table[tbody[tr[td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]]]]]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id='ui-datepicker-div']")
    private WebElement datePicker;
    
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th/a")
    private List<WebElement> headerCells;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td//a")
    private List<WebElement> cells;
    
    @FindBy(how=How.XPATH,
            using="//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-text ')]//a")
    private WebElement subjectTask;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', normalize-space(@class), ' '),' component-target-send-fields ')]")
    private WebElement sendTargets;
    
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ', @class, ' '),' ussr-chrome-panel-action-drawer-content ')]//div[contains(concat(' ', @class, ' '),' ussr-component-message_sender ')]//div")
    private WebElement emailSendPane;

    public Task_ListAll verifyTask ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
        String compare = subjectTask.getText();
        if(compare.equals(string)!=true)
        {
            return null;
        }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Task_ListAll selectAll ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        uiSelectAll.click();
        return this;
    }

    public Task_ListAll verifySendEmailPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(sendTargets));
            System.out.println(sendTargets.isDisplayed());
            if(!sendTargets.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Task_ListAll verifyAssignee ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        int i = 0;
        for(i=0; i<headerCells.size(); i++)
        {
            System.out.println(headerCells.get(i).getText());
            if(headerCells.get(i).getText().contains("ASSIGNEE"))
            {
                break;
            }
        }
        if(!cells.get(i).getText().contains(string))
        {
            return null;
        }
        return this;
    }

    public Task_ListAll verifyDateSelector ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(datePicker));
        if(!datePicker.isDisplayed())
        {
            return null;
        }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Object verifyNoTasks ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!emptyCell.isDisplayed())
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
