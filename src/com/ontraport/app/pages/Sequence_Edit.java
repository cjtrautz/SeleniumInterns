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

public class Sequence_Edit extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-send-fields ')]//div[contains(concat(' ', @class, ' '),' ussr-component-send_from ')]//button")
    private WebElement toggleSendFrom;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-send-fields ')]//div[contains(concat(' ', @class, ' '),' ussr-component-form-control ')]//button")
    private WebElement toggleEmailFrom;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement drillDownPaneGone;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']/ancestor::div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement drillDownPaneWhole;
    
    @FindBy(
    how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']/ancestor::div/following-sibling::div[@class='ussr-component-drilldownselect-listview-bottom-padding ussr-corner-bottom']")
    private WebElement drillDownPanePadding;

    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-theme-sequence-email']//button")
    private WebElement emailStep;
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='subscribers (0)']")
    private WebElement subsicribers;
    
    @FindBy(
            how = How.XPATH,
            using = "//li/span[text()='Complaints']")
    private WebElement complaints;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_steps ')]//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_step ')]")
    private List<WebElement> steps;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' preview_data_box ')]")
    private WebElement preview;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-target-message-selector ')]")
    private WebElement messageSelector;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-send_from ')]")
    private WebElement sendFields;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-sequence-editor-rule-name ')]//input")
    private WebElement ruleName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-rule-editor-target-conditions ')]")
    private WebElement ifEvents;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-rule-editor-target-actions ')]")
    private WebElement thenEvents;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Fulfillment Name']/following-sibling::div")
    private WebElement fulfillmentDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Specific Event']/preceding-sibling::div/a[contains(concat(' ', @class, ' '),' ussr-form-input-radiobutton ')]/span[contains(concat(' ', @class, ' '),' ussr-icon-radiobutton-selected ')]")
    private WebElement stepRadioButtonSelected;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(concat(' ', @class, ' '),' ontraport_components_form_control_drill_down_select_field_selector ')]//input")
    private WebElement fieldDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@data-tabindex='status']/a")
    private WebElement statsTab;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@data-tabindex='status']//span[contains(concat(' ', @class, ' '),' ussr-component-section-title ')]")
    private WebElement statsTitle;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-target-message-selector ')]//button")
    private WebElement toggleMessageSelector;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@data-tabindex='steps']/a")
    private WebElement stepsTab;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' sequence_action_bar ')]/span[contains(concat(' ', @class, ' '),' sequence_actions ')]")
    private WebElement stepsTitle;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@data-tabindex='subscribers']/a")
    private WebElement subscribersTab;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@data-tabindex='subscribers']//span[contains(concat(' ', @class, ' '),' ussr-component-section-title ')]")
    private WebElement subscribersTitle;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Settings']")
    private WebElement settings;
    
    public Sequence_Edit verifySequenceStepAndExpand (String step, int index)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_steps ')]//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_step ')]"))));
        System.out.println("past the wait");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-pane-editor-back']")));
        wait.until(ExpectedConditions.visibilityOf(subsicribers));
        //wait.until(ExpectedConditions.visibilityOf(sequenceNameInput));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        wait.until(ExpectedConditions.visibilityOf(complaints));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(steps.size());
            steps.get(index-1).findElement(By.xpath(".//div[normalize-space(.)='" + step + "']"));
            System.out.println("found it");
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(IndexOutOfBoundsException e1)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;   
        }
        catch(NoSuchElementException e2){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }

//        try{
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_steps ')]//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_step ')]//div[@class='step_drop']/span")));
//        }
//        catch(TimeoutException e)
//        {
//            System.out.println("timed out sequence");
//        }
        steps.get(index-1).findElement(By.xpath(".//div[normalize-space(.)='" + step + "']")).click();
        //List<WebElement> steps2 = driver.findElements(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_steps ')]//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_step ')]"));
        //steps2.get(index-1).findElement(By.xpath(".//div[@class='step_drop']/span")).click();
        
        return this;
    }
    public Sequence_Edit verifyEmailName (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = messageSelector.findElement(By.xpath(".//input")).getAttribute("value");
            if(compare.equals(name)!=true)
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
    
    public Sequence_Edit verifySendFrom (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(sendFields.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = sendFields.findElement(By.xpath(".//input")).getAttribute("value");
            if(compare.equals(name)!=true)
            {
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
    public Sequence_Edit verifyEmailMessage (String step)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            preview.findElement(By.xpath(".//p[normalize-space(text())='" + step + "']"));
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
    public Sequence_Edit verifyRuleName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(ruleName.getAttribute("value"));
            String compare = ruleName.getAttribute("value");
            if(compare.equals(name)!=true)
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
    public Sequence_Edit verifyIfText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            ifEvents.findElement(By.xpath(".//span[normalize-space(text())='" + string + "']"));
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
    public Object verifyIfDropDownInputs ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            List<WebElement> inputs= ifEvents.findElements(By.xpath(".//input"));
            String compare = inputs.get(i-1).getAttribute("value");
            if(compare.equals(string)!=true)
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
    public Sequence_Edit verifyThenText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            thenEvents.findElement(By.xpath(".//span[normalize-space(text())='" + string + "']"));
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
    public Sequence_Edit verifyFulfillmentDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(fulfillmentDropDownInput.findElement(By.xpath(".//button")).getAttribute("value"));
            String compare = fulfillmentDropDownInput.findElement(By.xpath(".//button")).getAttribute("value");
            if(compare.equals("0")==true)
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
    public Sequence_Edit verifySpecificEventSelected ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(steps.size());
            if(stepRadioButtonSelected.isDisplayed()!=true)
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
    public Sequence_Edit verifyEventFieldDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = fieldDropDownInput.getAttribute("value");
            System.out.println(fieldDropDownInput.getAttribute("value"));
            if(compare.equals(string)!=true)
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
    public Sequence_Edit clickStats ()
    {
        AbstractPart.waitForAjax(driver, 20);
        statsTab.click();
        return this;
    }
    public Sequence_Edit verifyStatsTitle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            if(!statsTitle.isDisplayed())
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
    public Sequence_Edit clickSubscribers ()
    {
        AbstractPart.waitForAjax(driver, 20);
        subscribersTab.click();
        return this;
        
    }
    public Sequence_Edit verifySubscriptionsTitle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            if(!subscribersTitle.isDisplayed())
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
    public Sequence_Edit clickEditSteps ()
    {
        AbstractPart.waitForAjax(driver, 20);
        stepsTab.click();
        return this;
        
    }
    public Sequence_Edit verifyAddAStepTitle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(messageSelector.findElement(By.xpath(".//input")).getAttribute("value"));
            if(!stepsTitle.isDisplayed())
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
    public Sequence_Edit clickSettings ()
    {
        AbstractPart.waitForAjax(driver, 20);
        settings.click();
        return this;
        
    }
    public Sequence_Edit clickAddEmailStep ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(emailStep));
        emailStep.click();
        //wait.until(ExpectedConditions.visibilityOf(emailBody));
        return this;
        
    }

    public Sequence_Edit openEmailNamePane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleMessageSelector));
        toggleMessageSelector.click();
        return this;
        
    }
    public Sequence_Edit selectDrillDownEmailName ( String option )
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
    public Sequence_Edit selectDrillDown ( String option )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDownPaneWhole));
        wait.until(ExpectedConditions.visibilityOf(drillDownPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownPanePadding));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li/span[contains(text(), 'Create New Message')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li/div[contains(text(), '" + option + "')]")));
        drillDownPane.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(drillDownPaneGone)));
        return this;
        
    }
    public Sequence_Edit selectDrillDownByIndex ( int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(drillDownPane));
        List<WebElement> messages = drillDownPane.findElements(By.xpath(".//li"));
        messages.get(index-1).click();
        return this;
        
    }

    public Sequence_Edit openEmailFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleEmailFrom));
        toggleEmailFrom.click();
        return this;
        
    }

    public Sequence_Edit openSendFromPane ()
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
    public Sequence_Edit verifySequenceStep ( String step, int index )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_steps ')]//div[contains(concat(' ', normalize-space(@class), ' '),' sequence_step ')]"))));
        System.out.println("past the wait");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-pane-editor-back']")));
        wait.until(ExpectedConditions.visibilityOf(subsicribers));
        //wait.until(ExpectedConditions.visibilityOf(sequenceNameInput));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        wait.until(ExpectedConditions.visibilityOf(complaints));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println(steps.size());
            steps.get(index-1).findElement(By.xpath(".//div[normalize-space(.)='" + step + "']"));
            System.out.println("found it");
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(IndexOutOfBoundsException e1)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;   
        }
        catch(NoSuchElementException e2){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        return this;
    }

}
