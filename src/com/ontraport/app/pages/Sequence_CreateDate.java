package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_CreateDate extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-theme-sequence-rule']//button")
    private WebElement ruleStep;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ontraport_components_sequence_rule ')]")
    private WebElement ruleBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(concat(' ', @class, ' '),' ontraport_components_form_control_drill_down_select_field_selector ')]//button")
    private WebElement fieldDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[text()='subscribers (0)']")
    private WebElement subsicribers;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement sequenceNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Specific Event']/preceding-sibling::div/a[contains(concat(' ', @class, ' '),' ussr-form-input-radiobutton ')]")
    private WebElement stepRadioButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-theme-sequence-email']//button")
    private WebElement emailStep;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-message-preview ') and contains(text(), 'No E-Mail selected.')]")
    private WebElement emailBody;
    
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
            using = "//div[contains(concat(' ', @class, ' '),' component-target-message-selector ')]//button")
    private WebElement toggleMessageSelector;
    
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
            using = "//div[contains(concat(' ', @class, ' '),' ussr-sequence-editor-rule-name ')]//input")
    private WebElement ruleName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-rule-editor-target-conditions ')]")
    private WebElement ifTarget;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement ifDrillDownSelectPaneWait;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement ifDrillDownSelectPane;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-menu ') and div[ul[@class='ussr-component-drilldownselect-ul']]]")
    private WebElement drillDownMenuIf;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-rule-editor-target-actions ')]")
    private WebElement thenTarget;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement thenDrillDownSelectPaneWait;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement thenDrillDownSelectPane;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-menu ') and div[ul[@class='ussr-component-drilldownselect-ul']]]")
    private WebElement drillDownMenuThen;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement save;
    
    public Sequence_CreateDate enterSequenceName ( String name )
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-pane-editor-back']")));
        wait.until(ExpectedConditions.visibilityOf(subsicribers));
        //wait.until(ExpectedConditions.visibilityOf(sequenceNameInput));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        sequenceNameInput.click();
        sequenceNameInput.sendKeys(name);
        return this;
        
    }

     public Sequence_CreateDate clickAddEmailStep ()
    {
        wait.until(ExpectedConditions.visibilityOf(emailStep));
        emailStep.click();
        wait.until(ExpectedConditions.visibilityOf(emailBody));
        return this;
        
    }

    public Sequence_CreateDate clickRadioButtonSpecificEvent ()
    {
        wait.until(ExpectedConditions.visibilityOf(stepRadioButton));
        stepRadioButton.click();
        return this;
        
    }

    public Sequence_CreateDate clickEventFieldDropDown ()
    {
        wait.until(ExpectedConditions.visibilityOf(fieldDropDown));
        fieldDropDown.click();
        return this;
        
    }
    public Sequence_CreateDate selectDrillDownEmailName ( String option )
    {
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
    
    public Sequence_CreateDate selectDropDown ( String option )
    {
        wait.until(ExpectedConditions.visibilityOf(drillDownPaneWhole));
        wait.until(ExpectedConditions.visibilityOf(drillDownPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownPanePadding));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li/span[contains(text(), 'Create New Message')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li/div[contains(text(), '" + option + "')]")));
        drillDownPane.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(drillDownPaneGone)));
        return this;
        
    }
    public Sequence_CreateDate openEmailNamePane ()
    {
        wait.until(ExpectedConditions.visibilityOf(toggleMessageSelector));
        toggleMessageSelector.click();
        return this;
        
    }
    public Sequence_CreateDate selectDrillDownByIndex ( int index )
    {
        wait.until(ExpectedConditions.visibilityOf(drillDownPane));
        List<WebElement> messages = drillDownPane.findElements(By.xpath(".//li/div"));
        messages.get(index-1).click();
        return this;
        
    }

    public Sequence_CreateDate openEmailFromPane ()
    {
        wait.until(ExpectedConditions.visibilityOf(toggleEmailFrom));
        toggleEmailFrom.click();
        return this;
        
    }

    public Sequence_CreateDate openSendFromPane ()
    {
        wait.until(ExpectedConditions.visibilityOf(toggleSendFrom));
        toggleSendFrom.click();
        return this;
        
    }

    public Sequence_ListAll clickSave ()
    {
        save.click();
        return (Sequence_ListAll) new Sequence_ListAll().init();
    }

    public Sequence_CreateDate clickAddRuleStep ()
    {
        wait.until(ExpectedConditions.visibilityOf(ruleStep));  
        ruleStep.click();   
        wait.until(ExpectedConditions.visibilityOf(ruleBody));

        return this;
    }

    public Sequence_CreateDate enterRuleName ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(ruleName));
        ruleName.sendKeys(string);
        return this;
        
    }

    public Sequence_CreateDate openIfPane ( int i )
    {
        wait.until(ExpectedConditions.visibilityOf(ifTarget));
        List<WebElement> dropDowns = ifTarget.findElements(By.xpath(".//button"));
        dropDowns.get(i-1).click();
        return this;
        
    }

    public Sequence_CreateDate selectIfOption ( String string )
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.visibilityOf(ifDrillDownSelectPaneWait));
        wait.until(ExpectedConditions.visibilityOf(ifDrillDownSelectPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownMenuIf));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li[div[text()='" + string + "']]")));
        ifDrillDownSelectPane.findElement(By.xpath(".//li[div[text()='" + string + "']]")).click();
        return this;
        
    }

    public Sequence_CreateDate openThenPane ( int i )
    {
        wait.until(ExpectedConditions.visibilityOf(ifTarget));
        List<WebElement> dropDowns = thenTarget.findElements(By.xpath(".//button"));
        dropDowns.get(i-1).click();
        return this;
        
    }
    
    public Sequence_CreateDate selectThenOption ( String string)
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.visibilityOf(thenDrillDownSelectPaneWait));
        wait.until(ExpectedConditions.visibilityOf(thenDrillDownSelectPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownMenuThen));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li[div[text()='" + string + "']]")));
        thenDrillDownSelectPane.findElement(By.xpath(".//li[div[text()='" + string + "']]")).click();
        return this;
        
    }

}