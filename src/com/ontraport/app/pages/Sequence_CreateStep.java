package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Sequence_CreateStep extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-theme-sequence-email ')]/following-sibling::div[contains(concat(' ', normalize-space(@class), ' '),' step_details ')]")
    private WebElement sequenceEmailDetail;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-menu ') and div[ul[@class='ussr-component-drilldownselect-ul']]]")
    private WebElement drillDownMenuIf;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-menu ') and div[ul[@class='ussr-component-drilldownselect-ul']]]")
    private WebElement drillDownMenuThen;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='subscribers (0)']")
    private WebElement subsicribers;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe")
    private WebElement iframe;
    
    @FindBy(
            how = How.XPATH,
            using = "//p")
    private WebElement paragraph;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='step_bar']")
    private WebElement stepBar;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement sequenceNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' sequence_steps ')]/div")
    private List<WebElement> steps;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-message-edit-button ')]")
    private WebElement messageEdit;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' preview_data_subject ')]")
    private WebElement messageSubject;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-message-selector ')]//input")
    private WebElement emailNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(concat(' ', @class, ' '),' step_details_time ')]//button")
    private WebElement stepTimeDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-sequence-editor-rule-name ')]//input")
    private WebElement ruleName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-message-selector ')]//button")
    private WebElement toggleMessageSelector;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[contains(concat(' ', @class, ' '),' create-new ')]")
    private WebElement createNew;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'ussr-component-quick-object-creator-target-sub-comp')]//input")
    private WebElement objectCreatorName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='component-target-send-fields']//div[contains(concat(' ', @class, ' '),' ussr-component-form_control_drill_down_select_object_selector ')]//button")
    private WebElement assigneeDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-scheduled-date-input ')]//input")
    private WebElement taskDueDate;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-send-fields ')]//div[contains(concat(' ', @class, ' '),' ussr-component-form-control ')]//button")
    private WebElement toggleEmailFrom;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-send-fields ')]//div[contains(concat(' ', @class, ' '),' ussr-component-send_from ')]//button")
    private WebElement toggleSendFrom;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-theme-sequence-email']//button")
    private WebElement emailStep;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-theme-sequence-task']//button")
    private WebElement taskStep;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-theme-sequence-postcard']//button")
    private WebElement postcardStep;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-theme-sequence-rule']//button")
    private WebElement ruleStep;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-theme-sequence-fulfillment']//button")
    private WebElement fulfillmentStep;
    
    @FindBy(
    how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownPane;
    
    @FindBy(
            how = How.XPATH,
                    using = "//span[@class='ussr-component-quick-object-creator-target-sae-button']")
            private WebElement saveAndEdit;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-drilldownselect-listview ')]")
    private WebElement drillDownPaneGone;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']/ancestor::div[contains(concat(' ', @class, ' '),' ussr-component-drilldownselect-listview ')]")
    private WebElement drillDownPaneWhole;
    
    @FindBy(
    how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']/ancestor::div/following-sibling::div[@class='ussr-component-drilldownselect-listview-bottom-padding ussr-corner-bottom']")
    private WebElement drillDownPanePadding;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-editor-back']")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='step_handle']")
    private List<WebElement> stepDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' step_delete ')]")
    private List<WebElement> stepDelete;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='step_handle']")
    private List<WebElement> stepMove;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-message-preview ') and contains(text(), 'No E-Mail selected.')]")
    private WebElement emailBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ontraport_components_sequence_rule ')]")
    private WebElement ruleBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' sequence_step_editor_shell ')]//div[contains(concat(' ', @class, ' '),' ussr-theme-sequence-fulfillment ')]")
    private WebElement fulfillmentBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-rule-editor-target-conditions ')]")
    private WebElement ifTarget;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-rule-editor-target-actions ')]")
    private WebElement thenTarget;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Fulfillment Name']/following-sibling::div//button")
    private WebElement fulfillmentDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Message Name']/following-sibling::div/input[@placeholder='Enter Name']")
    private WebElement messageNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[normalize-space(.)='Save as Draft']")
    private WebElement saveAsDraft;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement ifDrillDownSelectPaneWait;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement ifDrillDownSelectPane;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement thenDrillDownSelectPaneWait;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement thenDrillDownSelectPane;


    public Sequence_CreateStep enterSequenceName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-pane-editor-back']")));
        wait.until(ExpectedConditions.visibilityOf(subsicribers));
        //wait.until(ExpectedConditions.visibilityOf(sequenceNameInput));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        wait.until(ExpectedConditions.visibilityOf(sequenceNameInput));
        sequenceNameInput.click();
        sequenceNameInput.sendKeys(name);
        return this;
        
    }

    public Sequence_CreateStep clickAddEmailStep ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(emailStep));
        emailStep.click();
        //wait.until(ExpectedConditions.visibilityOf(emailBody));
        return this;
        
    }

    public Sequence_CreateStep openEmailNamePane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleMessageSelector));
        toggleMessageSelector.click();
        return this;
        
    }
    public Sequence_CreateStep selectDrillDownEmailName ( String option )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDownPaneWhole));
        wait.until(ExpectedConditions.visibilityOf(drillDownPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownPanePadding));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li/span[contains(text(), 'Create New Message')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li/div[contains(text(), '" + option + "')]")));
        drillDownPane.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(drillDownPaneGone)));
        //wait.until(ExpectedConditions.stalenessOf(drillDownPane));
        return this;
        
    }
    public Sequence_CreateStep selectDrillDown ( String option )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(drillDownPaneWhole));
        wait.until(ExpectedConditions.visibilityOf(drillDownPane));
        //wait.until(ExpectedConditions.visibilityOf(drillDownPanePadding));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li/span[contains(text(), 'Create New Message')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li/div[contains(text(), \"" + option + "\")]")));
        drillDownPane.findElement(By.xpath(".//li/div[contains(text(), \"" + option + "\")]")).click();
        //wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(drillDownPaneGone)));
        return this;
        
    }
    public Sequence_CreateStep selectDrillDownByIndex ( int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(drillDownPane));
        List<WebElement> messages = drillDownPane.findElements(By.xpath(".//li"));
        messages.get(index-1).click();
        return this;
        
    }

    public Sequence_CreateStep openEmailFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleEmailFrom));
        toggleEmailFrom.click();
        return this;
        
    }

    public Sequence_CreateStep openSendFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleSendFrom));
        toggleSendFrom.click();
        return this;
        
    }

    public Sequence_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (Sequence_ListAll) new Sequence_ListAll().init();

    }
    
    public Sequence_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-pane-editor-back']")));
        back.click();
        return (Sequence_ListAll) new Sequence_ListAll().init();
    }

    public Sequence_CreateStep clickAddRuleStep ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ruleStep));
        ruleStep.click();
        wait.until(ExpectedConditions.visibilityOf(ruleBody));
        return this;
        
    }

    public Sequence_CreateStep enterRuleName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ruleName));
        ruleName.sendKeys(string);
        return this;
        
    }

    public Sequence_CreateStep openIfPane ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifTarget));
        List<WebElement> dropDowns = ifTarget.findElements(By.xpath(".//button"));
        dropDowns.get(i-1).click();
        return this;
        
    }
    
    public Sequence_CreateStep openThenPane ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(ifTarget));
        List<WebElement> dropDowns = thenTarget.findElements(By.xpath(".//button"));
        dropDowns.get(i-1).click();
        return this;
        
    }

    public Sequence_CreateStep selectIfOption ( String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        //wait.until(ExpectedConditions.visibilityOf(ifDrillDownSelectPaneWait));
        wait.until(ExpectedConditions.visibilityOf(ifDrillDownSelectPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownMenuIf));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li[div[text()='" + string + "']]")));
        ifDrillDownSelectPane.findElement(By.xpath(".//li[div[text()='" + string + "']]")).click();
        return this;
        
    }
    public Sequence_CreateStep selectThenOption ( String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        //wait.until(ExpectedConditions.visibilityOf(thenDrillDownSelectPaneWait));
        wait.until(ExpectedConditions.visibilityOf(thenDrillDownSelectPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownMenuThen));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li[div[text()='" + string + "']]")));
        thenDrillDownSelectPane.findElement(By.xpath(".//li[div[text()='" + string + "']]")).click();
        return this;
        
    }

    public Sequence_CreateStep clickAddFulfillmentStep ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(fulfillmentStep));
        fulfillmentStep.click();
        wait.until(ExpectedConditions.visibilityOf(fulfillmentBody));
        return this;
        
    }

    public Sequence_CreateStep openFulfillmentDropDownPane ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(fulfillmentDropDown));
        fulfillmentDropDown.click();
        return this;
    }

    public Sequence_CreateStep enterMessageName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        messageNameInput.sendKeys(string);
        return this;
    }

    public Sequence_CreateStep clickSaveAsDraft ()
    {
        AbstractPart.waitForAjax(driver, 20);
        saveAsDraft.click();
        return this;
    }

    public Sequence_CreateStep clickSendAtDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(stepTimeDropDown));
        stepTimeDropDown.click();
        return this;
    }

    public Message_Edit clickSaveAndEdit ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(saveAndEdit));
        saveAndEdit.click();
        return (Message_Edit) new Message_Edit().init();
    }

    public Sequence_CreateStep verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(driver.getCurrentUrl());
            System.out.println(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/sequence/create&type=step");
            if(!driver.getCurrentUrl().contains(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/sequence/create"))
            {
                return null;
            }
            if(!driver.getCurrentUrl().contains("&type=step"))
            {
                return null; 
            }

        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Sequence_CreateStep verifyEmailName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!emailNameInput.getAttribute("value").equals(string))
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Sequence_CreateStep verifyPageFromStepCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(driver.getCurrentUrl());
            System.out.println(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/sequence/create&type=step");
            if(!driver.getCurrentUrl().contains(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/sequence/create&workHash"))
            {
                System.out.println("here1");
                return null; 
            }
            if(!driver.getCurrentUrl().contains("&type=step"))
            {
                System.out.println("here2");
                return null; 
            }
        }
        catch(Exception e){
            System.out.println("here4");
            return null;
        }
        
        return this;
    }

    public Message_Edit clickEdit ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(messageEdit));
        messageEdit.click();
        return (Message_Edit) new Message_Edit().init();
    }

    public Sequence_CreateStep verifyEmailSubject ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(messageSubject.getText());
            if(!messageSubject.getText().contains(string))
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Sequence_CreateStep verifyEmailBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.switchTo().frame(iframe);
        try
        {
            if(!paragraph.getText().contains(string))
            {
                driver.switchTo().defaultContent();
                return null; 
            }
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            return null;
        }
        driver.switchTo().defaultContent();
        return this;
    }

    public Sequence_CreateStep clickStepDropDown ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(stepDropDown.get(i-1)));
        stepDropDown.get(i-1).click();
        return this;
    }

    public Sequence_CreateStep clickStepHandleAndMove ( int i, int j )
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        action.clickAndHold(stepMove.get(i-1)).build().perform();
        action.moveByOffset(j, j).build().perform();
        action.release().build().perform();
        return this;
    }

    public Sequence_CreateStep verifyEmailStepNumber ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(steps.get(i-1).getAttribute("class"));
            if(!steps.get(i-1).getAttribute("class").contains("ussr-theme-sequence-email"))
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Sequence_CreateStep clickStepDelete ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", stepDelete.get(i-1));
        wait.until(ExpectedConditions.visibilityOf(stepDelete.get(i-1)));
        stepDelete.get(i-1).click();
        return this;
    }

    public Sequence_CreateStep verifySteps (int i)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(steps.size());
            if(steps.size()!=i)
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Sequence_CreateStep verifyEmailStepMinimized ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            if(sequenceEmailDetail.isDisplayed())
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return null;
    }

    public Sequence_CreateStep verifyEmailStepMaximized ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!sequenceEmailDetail.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        return this;
    }

    public Sequence_CreateStep clickAddTaskStep ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskStep));
        taskStep.click();
        return this;
    }

    public Sequence_CreateStep clickTaskNameDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleMessageSelector));
        toggleMessageSelector.click();
        return this;
    }

    public Sequence_CreateStep enterDueDateTask ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskDueDate));
        taskDueDate.click();
        taskDueDate.clear();
        taskDueDate.sendKeys(string);
        return this;
    }

    public Sequence_CreateStep openAssigneePane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(assigneeDropDown));
        assigneeDropDown.click();
        return this;
    }

    public Sequence_CreateStep clickAddPostcardStep ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(postcardStep));
        postcardStep.click();
        return this;
    }

    public Sequence_CreateStep clickPostcardNameDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleMessageSelector));
        toggleMessageSelector.click();
        return this;
    }

    public Sequence_CreateStep clickCreateNewMessage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createNew));
        createNew.click();
        return this;
    }

    public Sequence_CreateStep enterName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(objectCreatorName));
        objectCreatorName.sendKeys(string);
        return this;
    }


    
}
