package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Message_CreateTask extends AbstractPage
{  
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement taskNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-when ')]//input")
    private WebElement taskWhenNotification;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_name ')]//input")
    private WebElement taskSubject;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_date ')]//input")
    private WebElement taskDueDate;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_owner ')]//button")
    private WebElement ownerDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_owner ')]//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement ownerDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_merge ')]//button")
    private WebElement mergeDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_merge ')]//input")
    private WebElement mergeDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target_merge ')]//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement mergeDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' task_notification_add_target ')]//span")
    private WebElement addNewNotification;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-recipient ')]//button")
    private WebElement recipientDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-recipient ')]//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement recipientDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-event ')]//button")
    private WebElement eventDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-event ')]//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement eventDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' task-outcome-target-rule-add ')]//span")
    private WebElement addNewOutcome;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-quick-view-object-rules-target-name ')]//input")
    private WebElement outcomeNameDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'OUTCOME NAME')]/following-sibling::div//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement outcomeNameDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[contains(concat(' ', @class, ' '),' create-new ')]")
    private WebElement createNewOutcomeOption;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-quick-object-creator-target-sub-comp ')]//input")
    private WebElement outcomeNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(concat(' ', @class, ' '),' ussr-component-quick-object-creator-target-sad-button ')]//button")
    private WebElement selectOutcomeName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-rule-editor-target-actions ')]//button")
    private WebElement actionsDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-rule-editor-target-actions ')]//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement actionsDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement dropDownCollection;
  
    @FindBy(
            how = How.XPATH,
            using = "//tbody//tr[contains(concat(' ', normalize-space(@class), ' '),' outcome_rules ')]//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-text ')]/span/a")
    private WebElement outcomeLine;
    
    @FindBy(
            how = How.XPATH,
            using = "//div/span[text()='Save']")
    private WebElement saveOutcome;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-editor-back']")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Cancel']]")
    private WebElement cancel;

    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;

    public Message_CreateTask enterTaskName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(concat(' ', @class, ' '),' ussr-collection-empty ')]//div[contains(., 'There are no items to display')]")));
        wait.until(ExpectedConditions.visibilityOf(taskNameInput));
        taskNameInput.click();
        taskNameInput.sendKeys(string);
        return this;
        
    }

    public Message_CreateTask enterTaskSubjectName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskSubject));
        taskSubject.sendKeys(string);
        return this;
        
    }

    public Message_CreateTask enterDueDate ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskDueDate));
        taskDueDate.sendKeys(string);
        return this;
        
    }

    public Message_CreateTask clickAssigneeDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ownerDropDown));
        ownerDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(ownerDropDownPane));
        return this;
        
    }

    public Message_CreateTask selectDropDownOption ( String option )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(dropDownCollection));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[contains(text(), '" + option + "')]")));
        dropDownCollection.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        return this;
        
    }

    public Message_CreateTask clickMergeFieldsDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mergeDropDown));
        mergeDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(mergeDropDownPane));
        return this;
        
    }

    public Message_CreateTask clickAddNewNotification ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addNewNotification));
        addNewNotification.click();
        return this;
        
    }

    public Message_CreateTask clickWhoDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(recipientDropDown));
        recipientDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(recipientDropDownPane));
        return this;
        
    }

    public Message_CreateTask clickWhenDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(eventDropDown));
        eventDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(eventDropDownPane));
        return this;
        
    }

    public Message_CreateTask clickAddNewOutcome ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addNewOutcome));
        addNewOutcome.click();
        return this;
        
    }

    public Message_CreateTask clickOutcomeNameDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(outcomeNameDropDown));
        outcomeNameDropDown.click();
        return this;
        
    }

    public Message_CreateTask selectCreateNewOutcome ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dropDownCollection));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", createNewOutcomeOption);
        wait.until(ExpectedConditions.visibilityOf(createNewOutcomeOption));
        createNewOutcomeOption.click();
        return this;
        
    }

    public Message_CreateTask enterOutcomeName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(outcomeNameInput));
        outcomeNameInput.click();
        outcomeNameInput.clear();
        outcomeNameInput.sendKeys(string);
        return this;
        
    }

    public Message_CreateTask clickOutcomeThenDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", actionsDropDown);
        wait.until(ExpectedConditions.visibilityOf(actionsDropDown));
        actionsDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(actionsDropDownPane));
        return this;
        
    }

    public Message_CreateTask clickSelect ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(selectOutcomeName));
        selectOutcomeName.click();       
        return this;
        
    }

    public Message_CreateTask clickSaveOutcome ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", saveOutcome);
        //wait.until(ExpectedConditions.visibilityOf(saveOutcome));
        saveOutcome.click();
        //wait.until(ExpectedConditions.visibilityOf(outcomeLine));
        return this;
        
    }

    public Message_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click(); 
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ontraport_panes_message']"))));
        return (Message_ListAll) new Message_ListAll().init();
    }

    public Message_CreateTask enterWhenDays ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        taskWhenNotification.clear();
        taskWhenNotification.sendKeys(string);       
        return this;
    }

    public Message_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        back.click(); 
        return (Message_ListAll) new Message_ListAll().init();
    }

    public Message_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        cancel.click(); 
        return (Message_ListAll) new Message_ListAll().init();
    }

    public Message_CreateTask enterMergeFieldPane ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mergeDropDownInput));
        mergeDropDownInput.sendKeys(string);
        return this;
    }

    
    
}
