package com.ontraport.app.parts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(how=How.XPATH,
            using="//span[contains(concat(' ',@class,' '),' ussr-icon-seek-2-next ')]")
    private WebElement next;
    @FindBy(how=How.XPATH,
            using="//span[contains(concat(' ',@class,' '),' ussr-icon-seek-2-prev ')]")
    private WebElement previous;
    @FindBy(how=How.XPATH,
            using="//span[contains(concat(' ',@class,' '),' ussr-icon-seek-2-first ')]")
    private WebElement firstPage;
    @FindBy(how=How.XPATH,
            using="//span[contains(concat(' ',@class,' '),' ussr-icon-seek-2-last ')]")
    private WebElement lastPage;
    @FindBy(how=How.XPATH,
            using="//input[contains(concat(' ',@class,' '),' ussr-component-paginator-current-page ')]")
    private WebElement pageInput;
    @FindBy(how=How.XPATH,
            using="//li[contains(concat(' ',@class,' '),' ussr-component-paginator-page-count ')]")
    private WebElement pageCount;
    @FindBy(how=How.XPATH,
            using="//li[contains(concat(' ',@class,' '),' ussr-component-paginator-label ')]")
    private WebElement paginatorlabel;
    public Boolean isDisplayed ()
    {
        waitForAjax(driver, 20);
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
        waitForAjax(driver, 20);
        firstPage.click();
        return this;
    }
    public Paginator clickPreviousPage ()
    {
        waitForAjax(driver, 20);
        previous.click();
        return this;
    }
    public Paginator clickNextPage ()
    {
        waitForAjax(driver, 20);
        next.click();
        return this;
    }
    public Paginator clickLastPage ()
    {
        waitForAjax(driver, 20);
        lastPage.click();
        return this;
    }
    public Paginator goToPage (String page)
    {
        waitForAjax(driver, 20);
        pageInput.click();
        waitForAjax(driver, 20);
        pageInput.clear();
        waitForAjax(driver, 20);
        pageInput.sendKeys(Keys.BACK_SPACE + page);
        waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.RETURN).build().perform();
        paginatorlabel.click();
        return this;
    }
    public Paginator toggleRecordsPerPagePane ()
    {
        waitForAjax(driver, 20);
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
        waitForAjax(driver, 20);
        wait(20).until(ExpectedConditions.visibilityOf(uiToggleRecordsPerPageList));
        uiToggleRecordsPerPageList.findElement(By.xpath(".//li[@data-val='"+count+"']")).click();
        wait(1).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiToggleRecordsPerPageList)));
        return this;
    }
    public String getPages ()
    {
        waitForAjax(driver, 20);
        wait(20).until(ExpectedConditions.visibilityOf(pageCount));
        String text = pageCount.getText();
        return text;
    }
    public Object verifyPageNumber ( String pages )
    {
        waitForAjax(driver, 20);
        try
        {
            pages = pages.trim();
            System.out.println(pageInput.getAttribute("value"));
            System.out.println(pages);
            System.out.println(pageInput.getAttribute("value").equals(pages));
            if(pageInput.getAttribute("value").trim().equals(pages))
            {
                return pages;
            }
            else
            {
                return null;
            }
        }
        catch (NoSuchElementException nsee)
        {
            return null;
        }
        catch (TimeoutException te)
        {
            return null;
        }

        
    }
}
