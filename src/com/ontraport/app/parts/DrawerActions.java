package com.ontraport.app.parts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Contact_Export;
import com.ontraport.app.pages.LandingPage_Edit;
import com.ontraport.app.pages.Message_CreateTask;
import com.ontraport.app.pages.Message_Edit;
import com.ontraport.app.pages.Sequence_Edit;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class DrawerActions extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_group_actions']")
    protected WebElement      uiToggleDrawerActions;
    
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', (@class), ' '), ' create-new ')]")
    protected WebElement createNew;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', (@class), ' '), ' ussr-component-tracking_script ')]")
    protected WebElement trackingDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', (@class), ' '), ' component-task-reschedule-target-date ')]//input")
    protected WebElement datePickerInput;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', (@class), ' '), ' ussr-cancel-click ')]")
    protected WebElement cancelButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', (@class), ' '), ' component-task-reassign-target-user ')]//button")
    protected WebElement userDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//ul/li[contains(concat(' ', normalize-space(@class), ' '), ' ussr-target-drawer-action ')]/a")
    protected WebElement cancel;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ussr-send-click ')]")
    private WebElement sendButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-target-message-selector ')]//button")
    private WebElement taskNameDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-target-date-picker ')]//input")
    private WebElement dateInput;
    
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@class), ' '), ' usser-targert-drawer-action-1 ')]//a")
    private WebElement copySequence;
    
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@class), ' '), ' usser-targert-drawer-action-0 ')]//a")
    private WebElement copyLandingPage;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-target-time-picker ')]//input")
    private WebElement timeDropDownInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-target-time-picker ')]//button")
    private WebElement timeDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Export Contacts')]")
    private WebElement uiExportContacts;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-send_from ')]//button")
    private WebElement sendFromDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-quick-object-creator-target-sub-comp ')]//input")
    private WebElement quickCreaterNameInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-reassign-click ')]")
    private WebElement saveReAssign;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-quick-object-creator-controls ')]//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-quick-object-creator-target-sad-button ')]")
    private WebElement objectCreatorSave;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Contacts')]")
    private WebElement uiDeleteContacts;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Tracked Domains')]")
    private WebElement uiDeleteTrackedDomain;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'View Tracking Script')]")
    private WebElement uiViewTrackingScript;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Pause Rule')]")
    private WebElement pauseRule;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Un-pause Rule')]")
    private WebElement unpauseRule;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Re-Assign')]")
    private WebElement reassign;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Reschedule')]")
    private WebElement reschedule;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Cancel')]")
    private WebElement cancelTask;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Delete Packages')]")
    private WebElement uiDeletePackages;
    
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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//a[contains(., 'Send E')]")
    private WebElement uiSendEmail;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]//div[@class='control_buttons']//span[text()='Delete']")
        private WebElement uiReassignDelete;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-target-message-selector ')]//button")
        private WebElement emailNameDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
        private WebElement drillDown;
    
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']/li[contains(concat(' ', normalize-space(@class), ' '), ' create-new ')]")
        private WebElement drillDownCreateNew;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]")
        private WebElement actionPane;
    
    @FindBy(how = How.XPATH,
            using = "//input[@placeholder='Select Tag']/following-sibling::button[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-drilldownselect-button-menu-toggle ')]")
        private WebElement dropDownButton;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' component-subscription-target-done-button ')]")
        private WebElement submitButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' reassign_placeholder ')]//button")
        private WebElement reassignDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-campaign-code-target-destination-url ')]//input")
        private WebElement destinationURLInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-quick-object-creator-target-sub-comp ')]//input")
        private WebElement objectCreaterInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-campaign-code-target-campaign ')]//button")
        private WebElement campaignDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-campaign-code-target-lead-source ')]//button")
        private WebElement leadSourceDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-campaign-code-target-medium ')]//button")
        private WebElement mediumDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-campaign-code-target-content ')]//button")
        private WebElement contentDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-campaign-code-target-term ')]//button")
        private WebElement termDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-campaign-code-target-action-create-url ')]")
        private WebElement createURL;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Run this sequence only on weekends']/following-sibling::div//span[@class='ussr-icon ussr-icon-checkbox-empty']")
    private WebElement onWeekendsEmptyCheckbox;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Run this sequence only on weekends']/following-sibling::div//span[@class='ussr-icon ussr-icon-checkbox-checked']")
    private WebElement onWeekendsCheckedCheckbox;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Unsubscribe contact after last step']/following-sibling::div//span[@class='ussr-icon ussr-icon-checkbox-empty']")
    private WebElement unsubcribeContactAfterLastStepEmptyCheckbox;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Show this sequence on the Subscription Management Page']/following-sibling::div//span[@class='ussr-icon ussr-icon-checkbox-empty']")
    private WebElement showSequenceOnSubscriptionManagmentPageEmptyCheckbox;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Unsubscribe contact after last step']/following-sibling::div//span[@class='ussr-icon ussr-icon-checkbox-checked']")
    private WebElement unsubcribeContactAfterLastStepCheckedCheckbox;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Show this sequence on the Subscription Management Page']/following-sibling::div//span[@class='ussr-icon ussr-icon-checkbox-checked']")
    private WebElement showSequenceOnSubscriptionManagmentPageCheckedCheckbox;
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='sequence_setting_controls']/button/span[text()='Save Settings']")
    private WebElement saveSettings;
    
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
        wait(5).until(ExpectedConditions.visibilityOf(uiToggleDrawerActions));
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
        wait(5).until(ExpectedConditions.visibilityOf(uiSendEmail));
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
    public DrawerActions checkRunOnlyOnWeekends ()
    {
        waitForAjax(driver, 20);
        onWeekendsEmptyCheckbox.click();
        return this;
        
    }
    public DrawerActions clickSaveSettings ()
    {
        waitForAjax(driver, 20);
        saveSettings.click();
        return this;
        
    }
    public DrawerActions verifyOnlyOnWeekendsChecked ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS);
            Point zero = new Point(0,0);
            if(onWeekendsCheckedCheckbox.getLocation()==zero)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
    public DrawerActions checkUnsubscribeContactAfterLastStep ()
    {
        waitForAjax(driver, 20);
        unsubcribeContactAfterLastStepEmptyCheckbox.click();
        return this;
  
    }
    public DrawerActions verifyUnsubscribeContactAfterLastStepChecked ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS);
            Point zero = new Point(0,0);
            if(unsubcribeContactAfterLastStepCheckedCheckbox.getLocation()==zero)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
    public DrawerActions uncheckRunOnlyOnWeekends ()
    {
        waitForAjax(driver, 20);
        onWeekendsCheckedCheckbox.click();
        return this;
        
    }
    public DrawerActions uncheckUnsubscribeContactAfterLastStep ()
    {
        waitForAjax(driver, 20);
        unsubcribeContactAfterLastStepCheckedCheckbox.click();
        return this;
        
    }
    public DrawerActions clickDeleteSmartForm ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(actionPane));
        uiDelete.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
    }
    public DrawerActions checkShowSequenceOnSubscriptionManaementPage ()
    {
        waitForAjax(driver, 20);
        showSequenceOnSubscriptionManagmentPageEmptyCheckbox.click();
        return this;
    }
    public DrawerActions verifyShowSequenceOnSubscriptionManaementPageChecked ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS);
            Point zero = new Point(0,0);
            if(showSequenceOnSubscriptionManagmentPageCheckedCheckbox.getLocation()==zero)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        return this;
    }
    public DrawerActions uncheckShowSequenceOnSubscriptionManaementPage ()
    {
        waitForAjax(driver, 20);
        showSequenceOnSubscriptionManagmentPageCheckedCheckbox.click();
        return this;
    }
    public DrawerActions clickCreateNew ()
    {
        waitForAjax(driver, 20);
        drillDownCreateNew.click();
        return this;
    }
    public DrawerActions enterName ( String string )
    {
        waitForAjax(driver, 20);
        quickCreaterNameInput.sendKeys(string);
        return this;
    }
    public DrawerActions clickSave ()
    {
        waitForAjax(driver, 20);
        objectCreatorSave.click();
        return this;
    }
    public DrawerActions clickSendFromDropDown ()
    {
        waitForAjax(driver, 20);
        sendFromDropDown.click();
        return this;
    }
    public DrawerActions enterTodaysDate ()
    {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        // get current date time with Date()
        Date date = new Date();
        String name = dateFormat.format(date);
        dateInput.sendKeys(name);
        driver.findElement(By.xpath("//tbody//tr//td/a[contains(concat(' ', normalize-space(@class), ' '),' ui-state-highlight ')]")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.RETURN).build().perform();
        return this;
    }
    public DrawerActions clickAtDropDown ()
    {
        waitForAjax(driver, 20);
        timeDropDown.click();
        return this;
    }
    public DrawerActions selectFutureHour ()
    {
        DateFormat dateFormat = new SimpleDateFormat("h");
        DateFormat dateFormat2 = new SimpleDateFormat("mm");
        DateFormat dateFormat3 = new SimpleDateFormat("a");
        // get current date time with Date()
        Date date = new Date();
        String name = dateFormat.format(date);
        String name2 = dateFormat2.format(date);
        String name3 = dateFormat3.format(date);
        int minutes = Integer.parseInt(name2);
        minutes = (minutes + 5)/5 *5;
        name2 = Integer.toString(minutes);
        System.out.println(name + ":" + name2 + " " + name3);
        timeDropDownInput.sendKeys(name + ":" + name2 + " " + name3);
        selectDrillDown(name + ":" + name2 + " " + name3);
        return this;
        
    }
    public DrawerActions clickSend ()
    {
        waitForAjax(driver, 20);
        sendButton.click();
        return this;
    }
    public DrawerActions clickDeletePackages ()
    {
        waitForAjax(driver, 20);
        uiDeletePackages.click();
        return this;
    }
    public DrawerActions clickReassignContacts ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(reassignDropDown));
        reassignDropDown.click();
        return this;
    }
    public DrawerActions clickCancel ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        return this;
    }
    public Sequence_Edit clickCopySequence ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(copySequence));
        copySequence.click();
        return (Sequence_Edit) new Sequence_Edit().init();
    }
    public DrawerActions clickTaskNameDropDown ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(taskNameDropDown));
        taskNameDropDown.click();
        return this;
    }
    public Message_CreateTask createNewTask ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(createNew));
        createNew.click();
        return (Message_CreateTask) new Message_CreateTask().init();
    }
    public DrawerActions clickDeleteProgram ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiDelete));
        uiDelete.click();
        return this;
    }
    public LandingPage_Edit clickCopyLandingPage ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(copyLandingPage));
        copyLandingPage.click();
        return (LandingPage_Edit) new LandingPage_Edit().init();
    }
    public DrawerActions clickPauseRule ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(pauseRule));
        pauseRule.click();
        return this;
    }
    public DrawerActions clickUnpauseRule ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(unpauseRule));
        unpauseRule.click();
        return this;
    }
    public DrawerActions clickReAssign ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(reassign));
        reassign.click();
        return this;
    }
    public DrawerActions clickUserDropDown ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(userDropDown));
        userDropDown.click();
        return this;
    }
    public DrawerActions clickReschedule ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(reschedule));
        reschedule.click();
        return this;
    }
    public DrawerActions clickDateSelectorInput ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(datePickerInput));
        datePickerInput.click();
        return this;
    }
    public DrawerActions clickCancelSendEmail ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(cancelButton));
        cancelButton.click();
        return this;
    }
    public DrawerActions clickSaveReAssign ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(saveReAssign));
        saveReAssign.click();
        return this;
    }
    public DrawerActions clickCancelTask ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(cancelTask));
        cancelTask.click();
        return this;
    }
    public DrawerActions clickDeleteTrackedLink ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiDelete));
        uiDelete.click();
        return this;
    }
    public DrawerActions clickViewTrackingScript ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiViewTrackingScript));
        uiViewTrackingScript.click();
        return this;
    }
    public DrawerActions verifyTrackingScript ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait(5).until(ExpectedConditions.visibilityOf(trackingDropDown));
            if(!trackingDropDown.isDisplayed())
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
    public DrawerActions clickDeleteTrackedDomain ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiDeleteTrackedDomain));
        uiDeleteTrackedDomain.click();
        return this;
    }
    public DrawerActions enterURL (String string)
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(destinationURLInput));
        destinationURLInput.click();
        destinationURLInput.sendKeys(string);
        return this;
    }
    public DrawerActions clickCampaignDropDown ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(campaignDropDown));
        campaignDropDown.click();
        return this;
    }
    public DrawerActions selectCreateNew ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(createNew));
        createNew.click();
        return this;
    }
    public DrawerActions enterObjectCreater (String string)
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(objectCreaterInput));
        objectCreaterInput.click();
        objectCreaterInput.sendKeys(string);
        return this;
    }
    public DrawerActions clickLeadSourceDropDown ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(leadSourceDropDown));
        leadSourceDropDown.click();
        return this;
    }
    public DrawerActions clickMediumDropDown ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(mediumDropDown));
        mediumDropDown.click();
        return this;
    }
    public DrawerActions clickContentDropDown ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(contentDropDown));
        contentDropDown.click();
        return this;
    }
    public DrawerActions clickTermDropDown ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(termDropDown));
        termDropDown.click();
        return this;
    }
    public DrawerActions clickCreateURL ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(createURL));
        createURL.click();
        return this;
    }
    public DrawerActions clickDeleteURLHistory ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiDelete));
        uiDelete.click();
        return this;
    }


}
