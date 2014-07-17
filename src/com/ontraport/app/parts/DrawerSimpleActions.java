package com.ontraport.app.parts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPart;

public class DrawerSimpleActions extends AbstractPart
{
    @FindBy(
            how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement collection;
    
    @FindBy(
            how = How.XPATH,
            using = "//a/span[text()='Actions']")
    private WebElement toggleActionsPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-sub-collection-add-new ')]")
    private WebElement addPermissionException;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[a[span[text()='Actions']]]/descendant::a/span[@class='ussr-icon ussr-icon-trashcan']")
    private WebElement deleteException;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-sub-collection-target-group-actions ')]//span[@class='ussr-icon ussr-icon-trashcan']")
    private WebElement delete;
    
    public DrawerSimpleActions open () 
    { 
        waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", toggleActionsPane);
        wait(10).until(ExpectedConditions.visibilityOf(collection));
        wait(10).until(ExpectedConditions.visibilityOf(toggleActionsPane));
        toggleActionsPane.click();
        return this; 
    }
    public DrawerSimpleActions close () { return this; }
    public DrawerSimpleActions clickAddPermissionException ()
    {
        waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", addPermissionException);
        wait(10).until(ExpectedConditions.visibilityOf(addPermissionException));
        addPermissionException.click();
        return this; 
        
    }
    public DrawerSimpleActions clickDeleteException ()
    {
        waitForAjax(driver, 20);
        wait(3).until(ExpectedConditions.visibilityOf(deleteException));
        deleteException.click();
        return this;
        
    }
    public DrawerSimpleActions clickDelete ()
    {
        waitForAjax(driver, 20);
        wait(3).until(ExpectedConditions.visibilityOf(delete));
        delete.click();
        return this;
        
    }
}
