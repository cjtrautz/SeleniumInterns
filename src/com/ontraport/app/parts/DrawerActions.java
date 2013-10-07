package com.ontraport.app.parts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.ApiSettings_Create;
import com.ontraport.app.pages.Contact_Export;
import com.ontraport.app.pages.Facebook_ListAll;
import com.ontraport.app.pages.Message_Edit;
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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Add/Remove Tags')]")
    private WebElement uiAddRemoveTag;
    
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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Template')]")
    private WebElement uiDeleteTemplate;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete')]")
    private WebElement uiDelete;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Role')]")
    private WebElement uiDeleteRole;
    
    @FindBy(how = How.XPATH,
            using = "//input[@class='remove_role_btn']")
    private WebElement uiRemoveRole;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete User')]")
    private WebElement uiDeleteUser;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Send E-Mail')]")
    private WebElement uiSendEmail;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//div[@class='control_buttons']//span[text()='Delete']")
        private WebElement uiReassignDelete;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='E-mail name']/following-sibling::div/button")
        private WebElement emailNameDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
        private WebElement drillDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]")
        private WebElement actionPane;
    
    @FindBy(how = How.XPATH,
            using = "//input[@placeholder='Select Tag']/following-sibling::button[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-drilldownselect-button-menu-toggle ')]")
        private WebElement dropDownButton;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' component-subscription-target-done-button ')]")
        private WebElement submitButton;
    
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
        return (Contact_Export) new Contact_Export().init();
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
    public DrawerActions clickDeleteTemplate ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteTemplate.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteRole ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteRole.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickRemoveRole ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiRemoveRole.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickDeleteUser ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDeleteUser.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
    }
    public DrawerActions clickDelete ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiReassignDelete.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickSendEmail ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiSendEmail.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
        
    }
    public DrawerActions clickEmailNameDropDown ()
    {
        waitForAjax(driver, 20);
        emailNameDropDown.click();
        return this;
    }
    public Message_Edit selectDropDown ( int i )
    {
        waitForAjax(driver, 20);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//li"));
        options.get(i-1).click();
        return (Message_Edit) new Message_Edit().init();
    }
    public DrawerActions clickAddRemoveTags ()
    {
        waitForAjax(driver, 20);
        uiAddRemoveTag.click();
        return this;
        
    }
    public DrawerActions clickTagDropDown ()
    {
        waitForAjax(driver, 20);
        dropDownButton.click();
        return this;
        
    }
    public DrawerActions selectDrillDown ( String string )
    {
        waitForAjax(driver, 20);
        drillDown.findElement(By.xpath(".//li/div[text()='" + string + "']")).click();
        return this;
        
    }
    public DrawerActions clickSubmit ()
    {
        waitForAjax(driver, 20);
        submitButton.click();
        return this;
        
    }
}
