package com.ontraport.app.parts.bb;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class Paginator extends AbstractPart
{
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ',@class,' '),' ussr-component-paginator ')]/following-sibling::div//button")
    private WebElement uiToggleRecordsPerPagePane;
    @FindBy(how=How.XPATH,
            using="//div[contains(concat(' ',@class,' '),' ussr-component-paginator ')]/following-sibling::div//div[contains(concat(' ',@class,' '),' ussr-component-drilldownselect-listview ')]")
    private WebElement uiToggleRecordsPerPageList;
    
    public Boolean isDisplayed ()
    {
        try
        {
            wait(1).until(ExpectedConditions.visibilityOf(uiToggleRecordsPerPagePane));
            return uiToggleRecordsPerPagePane.isDisplayed();
        }
        catch (NoSuchElementException nsee)
        {
            return false;
        }
        catch (TimeoutException te)
        {
            return false;
        }
    }
    public Paginator clickFirstPage ()
    {
        return this;
    }
    public Paginator clickPreviousPage ()
    {
        return this;
    }
    public Paginator clickNextPage ()
    {
        return this;
    }
    public Paginator clickLastPage ()
    {
        return this;
    }
    public Paginator goToPage ()
    {
        return this;
    }
    public Paginator toggleRecordsPerPagePane ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleRecordsPerPagePane));
        uiToggleRecordsPerPagePane.click();
        return this;
    }
    public Paginator openRecordsPerPagePane ()
    {
        toggleRecordsPerPagePane();
        return this;
    }
    public Paginator closeRecordsPerPagePane ()
    {
        toggleRecordsPerPagePane();
        return this;
    }
    public Paginator clickRecordsPerPage (int count)
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiToggleRecordsPerPageList));
        uiToggleRecordsPerPageList.findElement(By.xpath(".//li[@data-val='"+count+"']")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiToggleRecordsPerPageList)));
        return this;
    }
}
