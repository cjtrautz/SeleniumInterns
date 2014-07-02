package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Contact_ScoreEdit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-addline ')]//div[@class='ussr-icon ussr-icon-plus']")
    private WebElement addNewCondition;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component ussr-component-form_control_input_checkbox ')]//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-checkbox-empty ')]")
    private WebElement emptyCheckBox;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-component ussr-component-form_control_input_checkbox ')]//span[contains(concat(' ', normalize-space(@class), ' '),' ussr-icon-checkbox-checked ')]")
    private WebElement checkedCheckBox;
    
    @FindBy(how = How.XPATH,
            using = "//textarea")
    private WebElement textarea;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-back ')]")
    private WebElement back;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(., 'Cancel')]")
    private WebElement cancel;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button")
    private WebElement dropDownButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button")
    private List<WebElement> dropDownButtons;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//input")
    private List<WebElement> dropDownInputs;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]")
    private WebElement conditions;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@class), ' '),' sem-statement-score ')]//input")
    private WebElement score;
    
    @FindBy(how = How.XPATH,
            using = "//ul[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-ul ')]")
    private WebElement drillDownList;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_rule_editor_score_editor_sentence_wrapper ')]//input")
    private WebElement scoreInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-score-editor-degredation ')]//input")
    private WebElement scoreDegradation;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]//span[text()='Save']")
    private WebElement saveButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule_segment ')]")
    private WebElement firstCondition;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule_segment ')]//div[contains(@style,'left: -16px')]/a/span")
    private WebElement trashCan;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(text(),'CONTACT SCORING CONDITIONS:')]")
    private WebElement contactScoringCondition;

    public Contact_ScoreEdit clickAddNewCondition ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(addNewCondition));
            addNewCondition.click();
        }
        catch(StaleElementReferenceException e)
        {
            wait.until(ExpectedConditions.visibilityOf(addNewCondition));
            addNewCondition.click();
        }
        return this;
        
    }

    public Contact_ScoreEdit clickDropDownCondition ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dropDownButton));
        dropDownButton.click();
        return this;
        
    }

    public Contact_ScoreEdit selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDownList));
        wait.until(ExpectedConditions.visibilityOf(drillDownList.findElement(By.xpath(".//li/div[contains(text(), \"" + string + "\")]"))));
        wait.until(ExpectedConditions.elementToBeClickable(drillDownList.findElement(By.xpath(".//li/div[contains(text(), \"" + string + "\")]"))));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", drillDownList.findElement(By.xpath(".//li/div[contains(text(), \"" + string + "\")]")));
        drillDownList.findElement(By.xpath(".//li/div[contains(text(), \"" + string + "\")]")).click();
        return this;
        
    }
    public Contact_ScoreEdit selectDrillDown2 ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDownList));
        wait.until(ExpectedConditions.visibilityOf(drillDownList.findElement(By.xpath(".//li/span[contains(text(), '" + string + "')]"))));
        drillDownList.findElement(By.xpath(".//li/span[contains(text(), '" + string + "')]")).click();
        return this;
        
    }

    public Contact_ScoreEdit enterPointScore ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(scoreInput));
        scoreInput.clear();
        scoreInput.sendKeys(string);
        return this;
        
    }

    public Contact_ScoreEdit enterDegradationPercent ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(scoreDegradation));
        scoreDegradation.clear();
        scoreDegradation.sendKeys(string);
        return this;
        
    }

    public Contact_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }

    public Contact_ScoreEdit verifyText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//span[text()=\"" + string +"\"]"));
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

    public Contact_ScoreEdit verifyConditionDrillDown ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(conditions));
            String compare = conditions.findElement(By.xpath(".//input")).getAttribute("value");
            System.out.println(compare);
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

    public Contact_ScoreEdit verifyPointScore ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(score));
            String compare = score.getAttribute("value");
            System.out.println(compare);
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

    public Contact_ScoreEdit verifyDegradationPercent ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(conditions));
            String compare = driver.findElement(By.xpath("//span[text()='Leads lose']/following-sibling::span//input")).getAttribute("value");
            System.out.println(compare);
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

    public Contact_ScoreEdit clickDeleteCondition ()
    {
        AbstractPart.waitForAjax(driver, 20);
        Actions action = new Actions(driver);
        try{
            action.moveToElement(firstCondition).perform();
        }
        catch(StaleElementReferenceException e)
        {
            action.moveToElement(firstCondition).perform();
        }
        wait.until(ExpectedConditions.visibilityOf(trashCan));
        trashCan.click();
        return this;
        
    }

    public Contact_ScoreEdit verifyNoText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//span[text()='" + string +"']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        
        return null;
    }

    public Contact_ScoreEdit clickDropDownCondition ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dropDownButtons.get(i-1)));
        dropDownButtons.get(i-1).click();
        return this;
    }

    public Contact_ScoreEdit enterDropDownCondition ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dropDownInputs.get(i-1)));
        dropDownInputs.get(i-1).sendKeys(string);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(drillDownList.findElement(By.xpath(".//li/div[contains(text(), '" + string + "')]")))));
        return this;
    }
    
    public Contact_ScoreEdit enterDropDownConditionInput ( int i, String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(dropDownInputs.get(i-1)));
        dropDownInputs.get(i-1).sendKeys(string);
        return this;
    }

    public Contact_ScoreEdit verifyConditionDrillDown ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            wait.until(ExpectedConditions.visibilityOf(dropDownInputs.get(i-1)));
            String compare = dropDownInputs.get(i-1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Contact_ScoreEdit verifyConditionInput ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            wait.until(ExpectedConditions.visibilityOf(dropDownInputs.get(i-1)));
            String compare = dropDownInputs.get(i-1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Contact_ScoreEdit verifyNoDropDowns ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(0, TimeUnit.SECONDS);
            if(dropDownInputs.size()>0)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        driver.manage()
        .timeouts()
        .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        return this;
    }

    public Contact_ScoreEdit enterDropDownConditionTextArea ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(textarea));
        textarea.sendKeys(string);
        return this;
    }

    public Contact_ScoreEdit verifyConditionDrillDownTextarea ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            wait.until(ExpectedConditions.visibilityOf(textarea));
            String compare = textarea.getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Contact_ScoreEdit clickCheckBox ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(emptyCheckBox));
        emptyCheckBox.click();
        return this;
    }

    public Contact_ScoreEdit verifyCheckbox ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {

            if(!checkedCheckBox.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Contact_ScoreEdit verifyConditionDrillDownContains ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(contactScoringCondition));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(conditions));
            String compare = conditions.findElement(By.xpath(".//input")).getAttribute("value");
            System.out.println(compare);
            if(compare.contains(string)!=true)
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

    public Contact_Settings clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (Contact_Settings) new Contact_Settings().init();
    }

    public Contact_Settings clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        return (Contact_Settings) new Contact_Settings().init();
    }
    
}
