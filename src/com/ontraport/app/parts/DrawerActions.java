package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.ApiSettings_Create;
import com.ontraport.app.pages.Contact_Export;
import com.ontraport.app.tools.AbstractPart;

public class DrawerActions extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_group_actions']")
    protected WebElement      uiToggleDrawerActions;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Export Contacts')]")
    private WebElement uiExportContacts;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Contacts')]")
    private WebElement uiDeleteContacts;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Facebook App')]")
    private WebElement uiDeleteFacebookApp;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Router')]")
    private WebElement uiDeleteRouter;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Product')]")
    private WebElement uiDeleteProduct;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete API KEY')]")
    private WebElement uiDeleteAPI;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Tag')]")
    private WebElement uiDeleteTag;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete List')]")
    private WebElement uiDeleteList;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Rule')]")
    private WebElement uiDeleteRule;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Sequences')]")
    private WebElement uiDeleteSequences;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Message')]")
    private WebElement uiDeleteMessage;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Gateway')]")
    private WebElement uiDeleteGateway;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete')]")
    private WebElement uiDelete;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]")
        private WebElement actionPane;
    
    public DrawerActions clickDeleteContacts ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteContacts.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        
        return this;
    }
    public DrawerActions open ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiToggleDrawerActions.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
    }
    public DrawerActions close ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiToggleDrawerActions.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
    }
    public DrawerActions clickDeleteRouter ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteRouter.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
    }
    public DrawerActions clickDeleteAPIKey ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteAPI.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteTag ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteTag.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteSequences ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteSequences.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public Contact_Export clickExportContacts ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiExportContacts.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return PageFactory.initElements(driver, Contact_Export.class);
    }
    public DrawerActions clickDeleteFacebookApp ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteFacebookApp.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteList ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteList.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteMessage ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteMessage.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteProduct ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteProduct.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteRule ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteRule.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteGateway ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteGateway.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteLandingPage ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDelete.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteWordPressSite ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDelete.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
}
