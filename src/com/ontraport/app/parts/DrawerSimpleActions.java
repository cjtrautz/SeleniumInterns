package com.ontraport.app.parts;

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
            using = "//div[a[span[text()='Actions']]]/descendant::a/span[@class='ussr-icon ussr-icon-mail-closed']")
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
        wait(3).until(ExpectedConditions.visibilityOf(collection));
        wait(3).until(ExpectedConditions.visibilityOf(toggleActionsPane));
        toggleActionsPane.click();
        return this; 
    }
    public DrawerSimpleActions close () { return this; }
    public DrawerSimpleActions clickAddPermissionException ()
    {
        wait(3).until(ExpectedConditions.visibilityOf(deleteException));
        addPermissionException.click();
        return this; 
        
    }
    public DrawerSimpleActions clickDeleteException ()
    {
        wait(3).until(ExpectedConditions.visibilityOf(deleteException));
        deleteException.click();
        return this;
        
    }
    public DrawerSimpleActions clickDelete ()
    {
        delete.click();
        return this;
        
    }
}
