package com.ontraport.app.parts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
    
    public DrawerActions clickDeleteContacts ()
    {
        uiDeleteContacts.click();
        return this;
    }
    public DrawerActions open ()
    {
        uiToggleDrawerActions.click();
        return this;
    }
    public DrawerActions close ()
    {
        uiToggleDrawerActions.click();
        return this;
    }
    public DrawerActions clickDeleteRouter ()
    {
        uiDeleteRouter.click();
        return this;
    }
    public DrawerActions clickDeleteAPIKey ()
    {
        uiDeleteAPI.click();
        return this;
        
    }
    public DrawerActions clickDeleteTag ()
    {
        uiDeleteTag.click();
        return this;
        
    }
    public DrawerActions clickDeleteSequences ()
    {
        uiDeleteSequences.click();
        return this;
        
    }
    public Contact_Export clickExportContacts ()
    {
        uiExportContacts.click();
        return PageFactory.initElements(driver, Contact_Export.class);
    }
    public DrawerActions clickDeleteFacebookApp ()
    {
        uiDeleteFacebookApp.click();
        return this;
        
    }
    public DrawerActions clickDeleteList ()
    {
        uiDeleteList.click();
        return this;
        
    }
    public DrawerActions clickDeleteMessage ()
    {
        uiDeleteMessage.click();
        return this;
        
    }
    public DrawerActions clickDeleteProduct ()
    {
        uiDeleteProduct.click();
        return this;
        
    }
    public DrawerActions clickDeleteRule ()
    {
        uiDeleteRule.click();
        return this;
        
    }
}
