package com.ontraport.app.parts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.tools.AbstractPart;

public class MenuWorkflow extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-workflow']/a[@href='javascript://']")
    protected WebElement workflowOpen;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' pinned-paginator ')]//span[@class='ussr-component-paginator-page-span']")
    protected WebElement pageSpan;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-workflow-menu-close ')]//a[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon ')]")
    protected WebElement workflowClose;
    
    @FindBy(how = How.XPATH,
            using = "//table[contains(concat(' ', normalize-space(@class), ' '),' ussr-workflow-menu-section-list-type-pinned ')]")
    private WebElement pinTable;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' pinned-paginator ')]")
    private WebElement pinPaginator;
    
    @FindBy(how = How.XPATH,
            using = "//table[contains(concat(' ', normalize-space(@class), ' '),' ussr-workflow-menu-section-list-type-unedited ')]")
    private WebElement uneditedTable;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' unedited-paginator ')]")
    private WebElement uneditedPaginator;
    
    @FindBy(how = How.XPATH,
            using = "//table[contains(concat(' ', normalize-space(@class), ' '),' ussr-workflow-menu-section-list-type-work-flow ')]")
    private WebElement workflowTable;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' workflow-paginator ')]")
    private WebElement workflowPaginator;
    
    public MenuWorkflow open () 
    { 
        waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(workflowOpen));
        workflowOpen.click();
        return this; 
        
    }

    public MenuWorkflow close ()
    {
        waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(workflowClose));
        //workflowClose.click();
        Actions action = new Actions(driver);
        action.click(workflowClose).build().perform();
        return this; 
        
    }
    public MenuWorkflow verifyPinnedWorkflow ( String string )
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

    public MenuWorkflow verifyNoPinnedWorkflow ( String string )
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

    public MenuWorkflow verifyUneditedWorkflow ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> finder = new ArrayList<WebElement>();
        while(finder.isEmpty() == true){
            AbstractPart.waitForAjax(driver, 20);
            int i = uneditedTable.findElements(By.xpath(".//tr")).size();
            System.out.println(i);
            if(uneditedTable.findElements(By.xpath(".//tr")).size()==1)
            {
                return null;
            }
            finder=uneditedTable.findElements(By.xpath(".//a[normalize-space(text())='" + string +"']"));
            //System.out.println(finder.isEmpty());
            if(finder.isEmpty() == true){  
                try
                {
                    uneditedPaginator.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-seek-next']")).click();
                }
                catch(NoSuchElementException e)
                {
                    return null;
                }
            }
            
        }
        return this;
    }

    public Message_Edit clickUneditedWorkflow ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        uneditedTable.findElement(By.xpath(".//a[normalize-space(text())='" + string +"']")).click();
        return (Message_Edit) new Message_Edit().init();
    }

    public MenuWorkflow verifyNoUneditedWorkflow ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> finder = new ArrayList<WebElement>();
        while(finder.isEmpty() == true){
            AbstractPart.waitForAjax(driver, 20);
            int i = uneditedTable.findElements(By.xpath(".//tr")).size();
            System.out.println(i);
            if(uneditedTable.findElements(By.xpath(".//tr")).size()==1)
            {
                return this;
            }
            finder=uneditedTable.findElements(By.xpath(".//a[normalize-space(text())='" + string +"']"));
            //System.out.println(finder.isEmpty());
            if(finder.isEmpty() == true){  
                try
                {
                    uneditedPaginator.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-seek-next']")).click();
                }
                catch(NoSuchElementException e)
                {
                    return this;
                }
            }
            
        }
        return null;
    }

    public MenuWorkflow verifyWorkflowItem ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> finder = new ArrayList<WebElement>();
        while(finder.isEmpty() == true){
            AbstractPart.waitForAjax(driver, 20);
            int i = workflowTable.findElements(By.xpath(".//tr")).size();
            System.out.println(i);
            if(workflowTable.findElements(By.xpath(".//tr")).size()==1)
            {
                return null;
            }
            finder=workflowTable.findElements(By.xpath(".//a[normalize-space(text())='" + string +"']"));
            //System.out.println(finder.isEmpty());
            if(finder.isEmpty() == true){  
                try
                {
                    workflowPaginator.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-seek-next']")).click();
                }
                catch(NoSuchElementException e)
                {
                    return null;
                }
            }
            
        }
        return this;
    }

    public Message_Edit clickWorkflowItem ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        workflowTable.findElement(By.xpath(".//a[normalize-space(text())='" + string +"']")).click();
        return (Message_Edit) new Message_Edit().init();
    }

    public MenuWorkflow verifyNoWorkflowItem ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> finder = new ArrayList<WebElement>();
        while(finder.isEmpty() == true){
            AbstractPart.waitForAjax(driver, 20);
            int i = workflowTable.findElements(By.xpath(".//tr")).size();
            System.out.println(i);
            if(workflowTable.findElements(By.xpath(".//tr")).size()==1)
            {
                return this;
            }
            finder=workflowTable.findElements(By.xpath(".//a[normalize-space(text())='" + string +"']"));
            //System.out.println(finder.isEmpty());
            if(finder.isEmpty() == true){  
                try
                {
                    workflowPaginator.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-seek-next']")).click();
                }
                catch(NoSuchElementException e)
                {
                    return this;
                }
            }
            
        }
        return null;
    }

    public MenuWorkflow verifyPagination ()
    {
        AbstractPart.waitForAjax(driver, 20);
        System.out.println(pageSpan.getText());
        if(!pageSpan.getText().equals("1-9"))
        {
            return null;
        }
        AbstractPart.waitForAjax(driver, 20);
        pinPaginator.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-seek-next']")).click();
        AbstractPart.waitForAjax(driver, 20);
        System.out.println(pageSpan.getText());
        if(!pageSpan.getText().equals("10-18"))
        {
            return null;
        }
        AbstractPart.waitForAjax(driver, 20);
        pinPaginator.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-seek-next']")).click();
        AbstractPart.waitForAjax(driver, 20);
        System.out.println(pageSpan.getText());
        if(!pageSpan.getText().equals("19-20"))
        {
            return null;
        }
        return this;
    }

}
