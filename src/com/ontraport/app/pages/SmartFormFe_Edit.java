package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class SmartFormFe_Edit extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' rules_transaction_success ')]//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-import-wizard-target-rule-add-button ')]")
    private WebElement addRuleOnSuccess;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-quick-view-object-rules-target-name ')]//input")
    private WebElement ruleName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button")
    private WebElement ifDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button")
    private WebElement thenDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' fe-control-save ')]")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-quick-view-object-rules-target-save ')]//span")
    private WebElement saveRule;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//input")
    private List<WebElement> thenInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#fe-mode-settings']")
    private WebElement settings;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@href='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Tags')]/following-sibling::div//button")
    private WebElement tagDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Tags')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' component-subscription-simple-list-target ')]")
    private WebElement tagList;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Sequences')]/following-sibling::div//button")
    private WebElement sequenceDropDown;
    
    

    public SmartFormFe_Edit clickSettings ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(settings));
        settings.click();
        return this;
    }

    public SmartFormFe_Edit clickTagDropDown ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(tagDropDown));
        tagDropDown.click();
        return this;
    }

    public SmartFormFe_Edit selectDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }

    public SmartFormFe_Edit clickSequenceDropDown ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(sequenceDropDown));
        sequenceDropDown.click();
        return this;
    }

    public SmartFormFe_Edit clickAddRule ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(addRuleOnSuccess));
        addRuleOnSuccess.click();
        return this;
    }

    public SmartFormFe_Edit enterRuleName ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(ruleName));
        ruleName.sendKeys(string);
        return this;
    }

    public SmartFormFe_Edit clickIfDropDown ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(ifDropDown));
        ifDropDown.click();
        return this;
    }

    public SmartFormFe_Edit clickThenDropDown ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(thenDropDown));
        thenDropDown.click();
        return this;
    }

    public SmartFormFe_Edit enterThenInput ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(thenInput.get(i-1)));
        thenInput.get(i-1).sendKeys(string);
        return this;
    }

    public SmartFormFe_Edit clickRuleSave ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(saveRule));
        saveRule.click();
        return this;
    }

    public SmartFormFe_Edit clickSave ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return this;
    }

    public Object verifyTag ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(tagList));
            if(!tagList.findElement(By.xpath(".//li[contains(., '" + string + "')]")).isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }
    

    
}
