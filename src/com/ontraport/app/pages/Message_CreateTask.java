package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Message_CreateTask extends AbstractPage
{  
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement taskNameInput;
    
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
            using = "//label[contains(text(),'OUTCOME NAME')]/following-sibling::div//button")
    private WebElement outcomeNameDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'OUTCOME NAME')]/following-sibling::div//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement outcomeNameDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'OUTCOME NAME')]/following-sibling::div//div[@class='ussr-component-drilldownselect-menu-wrapper']//li[contains(., 'Create New Outcome')]")
    private WebElement createNewOutcomeOption;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-custom-value-creator-target-component ')]//input")
    private WebElement outcomeNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-custom-value-creator-target-save-button ')]//span")
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
            using = "//button[span[text()='Save']]")
    private WebElement save;

    public Message_CreateTask enterTaskName ( String string )
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(concat(' ', @class, ' '),' ussr-collection-empty ')]//div[contains(., 'There are no items to display')]")));
        wait.until(ExpectedConditions.visibilityOf(taskNameInput));
        taskNameInput.click();
        taskNameInput.sendKeys(string);
        return this;
        
    }

    public Message_CreateTask enterTaskSubjectName ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(taskSubject));
        taskSubject.sendKeys(string);
        return this;
        
    }

    public Message_CreateTask enterDueDate ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(taskDueDate));
        taskDueDate.sendKeys(string);
        return this;
        
    }

    public Message_CreateTask clickAssigneeDropDown ()
    {
        wait.until(ExpectedConditions.visibilityOf(ownerDropDown));
        ownerDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(ownerDropDownPane));
        return this;
        
    }

    public Message_CreateTask selectDropDownOption ( String option )
    {
        //wait.until(ExpectedConditions.visibilityOf(dropDownCollection));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[contains(text(), '" + option + "')]")));
        dropDownCollection.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        return this;
        
    }

    public Message_CreateTask clickMergeFieldsDropDown ()
    {
        wait.until(ExpectedConditions.visibilityOf(mergeDropDown));
        mergeDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(mergeDropDownPane));
        return this;
        
    }

    public Message_CreateTask clickAddNewNotification ()
    {
        wait.until(ExpectedConditions.visibilityOf(addNewNotification));
        addNewNotification.click();
        return this;
        
    }

    public Message_CreateTask clickWhoDropDown ()
    {
        wait.until(ExpectedConditions.visibilityOf(recipientDropDown));
        recipientDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(recipientDropDownPane));
        return this;
        
    }

    public Message_CreateTask clickWhenDropDown ()
    {
        wait.until(ExpectedConditions.visibilityOf(eventDropDown));
        eventDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(eventDropDownPane));
        return this;
        
    }

    public Message_CreateTask clickAddNewOutcome ()
    {
        wait.until(ExpectedConditions.visibilityOf(addNewOutcome));
        addNewOutcome.click();
        return this;
        
    }

    public Message_CreateTask clickOutcomeNameDropDown ()
    {
        wait.until(ExpectedConditions.visibilityOf(outcomeNameDropDown));
        outcomeNameDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(outcomeNameDropDownPane));
        return this;
        
    }

    public Message_CreateTask selectCreateNewOutcome ()
    {
        wait.until(ExpectedConditions.visibilityOf(dropDownCollection));
        wait.until(ExpectedConditions.visibilityOf(createNewOutcomeOption));
        createNewOutcomeOption.click();
        return this;
        
    }

    public Message_CreateTask enterOutcomeName ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(outcomeNameInput));
        outcomeNameInput.sendKeys(string);
        return this;
        
    }

    public Message_CreateTask clickOutcomeThenDropDown ()
    {
        wait.until(ExpectedConditions.visibilityOf(actionsDropDown));
        actionsDropDown.click();
        wait.until(ExpectedConditions.visibilityOf(actionsDropDownPane));
        return this;
        
    }

    public Message_CreateTask clickSelect ()
    {
        wait.until(ExpectedConditions.visibilityOf(selectOutcomeName));
        selectOutcomeName.click();       
        return this;
        
    }

    public Message_CreateTask clickSaveOutcome ()
    {
        wait.until(ExpectedConditions.visibilityOf(saveOutcome));
        saveOutcome.click();
        wait.until(ExpectedConditions.visibilityOf(outcomeLine));
        return this;
        
    }

    public Message_ListAll clickSave ()
    {
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click(); 
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ontraport_panes_message']"))));
        return (Message_ListAll) new Message_ListAll().init();
    }

    
    
}
