package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class QueuedMessage_ListAll extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//thead/tr/th[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-select-all-rows ')]/a[@href='javascript://']")
    private WebElement selectAll;
    
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;

    public QueuedMessage_ListAll clickSelectAll ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(selectAll));
        Actions action = new Actions(driver);
        action.click(selectAll).build().perform();
        return this;
    }
    
    public QueuedMessage_ListAll verifyNoMessages ()
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
