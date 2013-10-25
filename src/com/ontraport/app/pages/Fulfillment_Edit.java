package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Fulfillment_Edit extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-chrome-panel-pane-header ')]//div[@class='ussr-pane-editor-back']")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-fulfillment-target-fields ')]//button[span[text()='<br>']]")
    private WebElement toggleFieldSelector;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-fulfillment-target-fields ')]//button")
    private List<WebElement> fieldsButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Cancel']")
    private WebElement cancel;
    
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownSelect;
    
    @FindBy(how = How.XPATH,
            using = "//label[text()='Fulfillment list name']/following-sibling::div/input[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input ')]")
    private WebElement fulfillmentListNameInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-fulfillment-target-task-comp ')]//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-checkbox-empty ')]")
    private WebElement emptyCreateATask;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-fulfillment-target-task-comp ')]//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-checkbox-checked ')]")
    private List<WebElement> checkedCreateATask;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-fulfillment-target-unsub-comp ')]//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-checkbox-empty ')]")
    private WebElement emptyUnsubscribeContacts;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-fulfillment-target-unsub-comp ')]//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-checkbox-checked ')]")
    private List<WebElement> checkedUnsubscribeContacts;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-recipient-list-target-add ')]")
    private WebElement addRecipient;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-target-scheduled-date-input ')]//input")
    private WebElement dueDateBox;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-fulfillment-target-task-owner ')]//button")
    private WebElement ownerDropDownButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-fulfillment-target-task-owner ')]//input")
    private WebElement ownerDropDownInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-recipient-message-target-delete-button ')]/a")
    private List<WebElement> deleteNotification;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-frequency-scheduler-target-time ')]//input")
    private WebElement frequencySchedulerTimeInput;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-frequency-scheduler-target-frequency ')]//button")
    private WebElement frequencySchedulerButton;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-frequency-scheduler-target-frequency ')]//input")
    private WebElement frequencySchedulerInput;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-frequency-scheduler-target-aux ')]//button")
    private WebElement frequencyAuxilarySchedulerButton;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-frequency-scheduler-target-aux ')]//input")
    private WebElement frequencyAuxilarySchedulerInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-recipient-message-target-email-box ')]//input")
    private List<WebElement> emailAddressInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-recipient-message-target-message-topic-box ')]//input")
    private List<WebElement> subjectInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-recipient-message-target-message-body-box ')]//textarea")
    private List<WebElement> messageInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-fulfillment-target-fields ')]")
    private WebElement fulfillmentTargetFields;    
    
    public Fulfillment_Edit verifyFulfillmentName (String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(fulfillmentListNameInput));
            String compare = fulfillmentListNameInput.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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
    
    public Fulfillment_Edit verifyFrequencyScheduler (String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(frequencySchedulerTimeInput));
            String compare = frequencySchedulerTimeInput.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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
    public Fulfillment_Edit verifyFieldValue (int index, String value)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(fulfillmentTargetFields));
            List<WebElement> fulfillmentFieldAreas= fulfillmentTargetFields.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-sortablelist-option ')]/span"));
            String compare = fulfillmentFieldAreas.get(index-1).getText();
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public Fulfillment_Edit openSchedularPanePrimary ()
    {
        AbstractPart.waitForAjax(driver, 20);
        frequencySchedulerButton.click();
        return this;
    }

    public Fulfillment_Edit selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        drillDownSelect.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }

    public Fulfillment_Edit openSchedularPaneAuxilary ()
    {
        AbstractPart.waitForAjax(driver, 20);
        frequencyAuxilarySchedulerButton.click();
        return this;
    }

    public Fulfillment_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(save)));
        save.click();
        return (Fulfillment_ListAll) new Fulfillment_ListAll().init();
    }

    public Fulfillment_Edit enterEmailAddress ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        emailAddressInput.get(i-1).clear();
        emailAddressInput.get(i-1).sendKeys(string);
        return this;
    }

    public Fulfillment_Edit enterEmailSubject ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        subjectInput.get(i-1).clear();
        subjectInput.get(i-1).sendKeys(string);
        return this;
    }

    public Fulfillment_Edit enterEmailMessage ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        messageInput.get(i-1).clear();
        messageInput.get(i-1).sendKeys(string);
        return this;
    }

    public Fulfillment_Edit verifySchedular ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(frequencySchedulerInput));
            String compare = frequencySchedulerInput.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public Fulfillment_Edit verifyDay ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(frequencyAuxilarySchedulerInput));
            String compare = frequencyAuxilarySchedulerInput.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public Fulfillment_Edit verifySubject ( int i, String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(subjectInput.get(i-1)));
            String compare = subjectInput.get(i-1).getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public Fulfillment_Edit verifyEmail ( int i, String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(subjectInput.get(i-1)));
            String compare = emailAddressInput.get(i-1).getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public Fulfillment_Edit verifyMessage ( int i, String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(subjectInput.get(i-1)));
            String compare = messageInput.get(i-1).getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public Fulfillment_Edit clickAddRecipient (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        if(i>subjectInput.size())
        {
            addRecipient.click();
            return this;
        }
        return this;
    }

    public Fulfillment_Edit deleteSendNotification ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        deleteNotification.get(i-1).click();
        return this;
    }

    public Fulfillment_Edit verifyNoFulfillment ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        System.out.println(driver.findElements(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-recipient-message-target-message-topic-box ')]")).size());
        if(i>=subjectInput.size())
        {
        return this;
        }
        return null;
    }

    public Fulfillment_Edit clickUsubscribeContactFromFulfillmentAfterSend ()
    {
        AbstractPart.waitForAjax(driver, 20);
        if(!checkedUnsubscribeContacts.get(0).isDisplayed())
        {
        emptyUnsubscribeContacts.click();
        }
        return this;
    }

    public Fulfillment_Edit verifyUsubscribeContactFromFulfillmentAfterSendChecked ()
    {
        AbstractPart.waitForAjax(driver, 20);
        if(checkedUnsubscribeContacts.get(0).isDisplayed())
        {
            return this;
        }
        return null;
    }

    public Fulfillment_Edit checkCreateATask ()
    {
        AbstractPart.waitForAjax(driver, 20);
        if(checkedCreateATask.get(0).isDisplayed())
        {
            return this;
        }
        emptyCreateATask.click();
        return this;
    }

    public Fulfillment_Edit verifyCreateATaskChecked ()
    {
        AbstractPart.waitForAjax(driver, 20);
        if(checkedCreateATask.get(0).isDisplayed())
        {
            return this;
        }
        return null;
    }

    public Fulfillment_Edit enterDueDateBox ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        dueDateBox.sendKeys(string);
        return this;
    }

    public Fulfillment_Edit verifyDueDateBox ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(dueDateBox));
            String compare = dueDateBox.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public Fulfillment_Edit clickOwnerDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ownerDropDownButton.click();
        return this;
    }

    public Fulfillment_Edit verifyOwner ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(ownerDropDownInput));
            String compare = ownerDropDownInput.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public Fulfillment_Edit openFieldPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(toggleFieldSelector)));
        toggleFieldSelector.click();
        return this;
    }

    public Fulfillment_Edit selectAllFields ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fieldsButton.get(2))));
        fieldsButton.get(2).click();
        return this;
    }

    public Fulfillment_Edit verifyNumberOfFields ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(fulfillmentTargetFields));
            List<WebElement> fulfillmentFieldAreas= fulfillmentTargetFields.findElements(By.xpath(".//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-sortablelist-option ')]/span"));
            System.out.println(fulfillmentFieldAreas.size());
            if(fulfillmentFieldAreas.size()==i)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return this;
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
        
        return null;
    }

    public Fulfillment_Edit clearAllFields ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fieldsButton.get(2))));
        fieldsButton.get(1).click();
        return this;
    }

    public Fulfillment_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        back.click();
        return (Fulfillment_ListAll) new Fulfillment_ListAll().init();
    }

    public Fulfillment_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        cancel.click();
        return (Fulfillment_ListAll) new Fulfillment_ListAll().init();
    }

  
}
