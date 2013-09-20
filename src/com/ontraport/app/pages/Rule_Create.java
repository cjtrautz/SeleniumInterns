package com.ontraport.app.pages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.tools.AbstractPage;

import com.ontraport.app.tools.AbstractSuite;


public class Rule_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']/div[3]/div/div[3]/div/div/div/input")
    private WebElement nameInput;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]")
    private WebElement whenEvents;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]")
    private WebElement ifEvents;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]")
    private WebElement thenEvents;
  
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div[@class='ussr-component-drilldownselect-menu-wrapper']")
    private WebElement whenDrillDownSelectPaneWait;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement whenDrillDownSelectPane;
    
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
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-menu ') and div[ul[@class='ussr-component-drilldownselect-ul']]]")
    private WebElement drillDownMenuWhen;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-menu ') and div[ul[@class='ussr-component-drilldownselect-ul']]]")
    private WebElement drillDownMenuIf;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-menu ') and div[ul[@class='ussr-component-drilldownselect-ul']]]")
    private WebElement drillDownMenuThen;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div[@class='ussr-component-drilldownselect-menu-wrapper']//div[@class='ussr-component-drilldownselect-listview-bottom-padding ussr-corner-bottom']")
    private WebElement thenDrillDownSelectPanePaddingWait;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-rule-editor-addline']/div[contains(.,'Add New Condition')]")
    private WebElement addNewCondition;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-rule-editor-addline']/div[contains(.,'Add New Trigger')]")
    private WebElement addNewTrigger;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-rule-editor-addline']/div[contains(.,'Add New Action')]")
    private WebElement addNewAction;
 
    @FindBy(
            how = How.XPATH,
            using = "//button//span[text()='Save']")
    private WebElement saveButton;

    public Rule_Create enterRuleName ( String name )
    {
        wait.until(ExpectedConditions.visibilityOf(thenEvents));
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(name);
        return this;
        
    }

    public Rule_Create openWhenTriggerPane ( int index )
    {
        wait.until(ExpectedConditions.visibilityOf(whenEvents));
        wait.until(ExpectedConditions.visibilityOf(whenEvents.findElement(By.xpath(".//button"))));
        List<WebElement> whenDropDowns = whenEvents.findElements(By.xpath(".//button"));
        whenDropDowns.get(index-1).click();
        return this;
        
    }
    
    public Rule_Create openIfConditionPane ( int index )
    {
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        wait.until(ExpectedConditions.visibilityOf(ifEvents.findElement(By.xpath(".//button"))));
        List<WebElement> ifDropDowns = ifEvents.findElements(By.xpath(".//button"));
        ifDropDowns.get(index-1).click();
        return this;
        
    }
    public Rule_Create enterThenInput ( String value, int index )
    {
        wait.until(ExpectedConditions.visibilityOf(thenEvents));
        List<WebElement> thenInputs = thenEvents.findElements(By.xpath(".//input"));
        thenInputs.get(index-1).sendKeys(value);
        return this;
        
    }
    public Rule_Create enterThenTextArea ( String value, int index )
    {
        wait.until(ExpectedConditions.visibilityOf(thenEvents));
        List<WebElement> thenInputs = thenEvents.findElements(By.xpath(".//textarea"));
        thenInputs.get(index-1).sendKeys(value);
        return this;
        
    }
    
    public Rule_Create enterIfInput ( String value, int index )
    {
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        List<WebElement> ifInputs = ifEvents.findElements(By.xpath(".//input"));
        ifInputs.get(index-1).sendKeys(value);
        return this;
        
    }
    public Rule_Create enterIfInputCalender ( int index )
    {
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        List<WebElement> ifInputs = ifEvents.findElements(By.xpath(".//input"));
        ifInputs.get(index-1).click();
        driver.findElement(By.xpath("//tbody//tr//td/a[contains(concat(' ', normalize-space(@class), ' '),' ui-state-highlight ')]")).click();
        return this;
        
    }
    
    public Rule_Create enterWhenInput ( String value, int index )
    {
        wait.until(ExpectedConditions.visibilityOf(whenEvents));
        wait.until(ExpectedConditions.visibilityOf(whenEvents.findElement(By.xpath(".//input"))));
        List<WebElement> whenInputs = whenEvents.findElements(By.xpath(".//input"));
        whenInputs.get(index-1).sendKeys(value);
        
        return this;
        
    }
    public Rule_Create trashCondition ()
    {
        wait.until(ExpectedConditions.visibilityOf(ifEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']"))));
        Actions action = new Actions(driver);
        action.moveToElement(ifEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']")))
            .perform();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ifEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']/ancestor::div[contains(concat(' ', normalize-space(@class), ' '),' sem-delete-statement ') and @style='left: -16px;']")))));
        ifEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']/ancestor::div[contains(concat(' ', normalize-space(@class), ' '),' sem-delete-statement ') and @style='left: -16px;']")).click();
        return this;
    }
    public Rule_Create trashTrigger ()
    {
        wait.until(ExpectedConditions.visibilityOf(whenEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']"))));
        Actions action = new Actions(driver);
        action.moveToElement(whenEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']")))
            .perform();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(whenEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']/ancestor::div[contains(concat(' ', normalize-space(@class), ' '),' sem-delete-statement ') and @style='left: -16px;']")))));
        whenEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']/ancestor::div[contains(concat(' ', normalize-space(@class), ' '),' sem-delete-statement ') and @style='left: -16px;']")).click();
        return this;
    }
    public Rule_Create trashAction ()
    {
        wait.until(ExpectedConditions.visibilityOf(thenEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']"))));
        Actions action = new Actions(driver);
        action.moveToElement(thenEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']")))
            .perform();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(thenEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']/ancestor::div[contains(concat(' ', normalize-space(@class), ' '),' sem-delete-statement ') and @style='left: -16px;']")))));
        thenEvents.findElement(By.xpath(".//span[@class='ussr-icon ussr-icon-trashcan']/ancestor::div[contains(concat(' ', normalize-space(@class), ' '),' sem-delete-statement ') and @style='left: -16px;']")).click();
        return this;
    }
    public Rule_Create addNewCondition ()
    {
        wait.until(ExpectedConditions.visibilityOf(addNewCondition));
        addNewCondition.click();
        return this;
    }
    public Rule_Create addNewTrigger ()
    {
        wait.until(ExpectedConditions.visibilityOf(addNewTrigger));
        addNewTrigger.click();
        return this;
    }
    public Rule_Create addNewAction ()
    {
        wait.until(ExpectedConditions.visibilityOf(addNewAction));
        addNewAction.click();
        return this;
    }
    public Rule_Create selectWhenDrillDownPaneOption (String string )
    {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.visibilityOf(whenDrillDownSelectPaneWait));
        wait.until(ExpectedConditions.visibilityOf(whenDrillDownSelectPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownMenuWhen));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li[div[text()='" + string + "']]")));
        whenDrillDownSelectPane.findElement(By.xpath(".//li[div[text()='" + string + "']]")).click();
        return this;
        
    }
    
    public Rule_Create selectIfDrillDownPaneOption (String string )
    {
       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.visibilityOf(ifDrillDownSelectPaneWait));
        wait.until(ExpectedConditions.visibilityOf(ifDrillDownSelectPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownMenuIf));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li[div[text()='" + string + "']]")));
        ifDrillDownSelectPane.findElement(By.xpath(".//li[div[text()='" + string + "']]")).click();
        return this;
        
    }
    
    public Rule_Create selectThenDrillDownPaneOption (String string )
    {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.visibilityOf(thenDrillDownSelectPaneWait));
        wait.until(ExpectedConditions.visibilityOf(thenDrillDownSelectPanePaddingWait));
        wait.until(ExpectedConditions.visibilityOf(thenDrillDownSelectPane));
        wait.until(ExpectedConditions.visibilityOf(drillDownMenuThen));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]/following-sibling::div//ul[@class='ussr-component-drilldownselect-ul']//li[div[contains(text(), '" + string + "')]]")));
        thenDrillDownSelectPane.findElement(By.xpath(".//li[div[contains(text(), '" + string + "')]]")).click();
        return this;
        
    }

    public Rule_Create openThenActionPane ( int index )
    {
        wait.until(ExpectedConditions.visibilityOf(thenEvents));
        List<WebElement> thenDropDowns = thenEvents.findElements(By.xpath(".//button"));
        thenDropDowns.get(index-1).click();
        return this;
        
    }

    public Rule_ListAll clickSave ()
    {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//span[text()='Save']")));
        saveButton.click();
        return PageFactory.initElements(driver, Rule_ListAll.class);
    }
    public Rule_Create verifyNewRows()
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            List<WebElement> thenDropDowns = thenEvents.findElements(By.xpath(".//button"));
            thenDropDowns.get(1).isDisplayed();
            List<WebElement> ifDropDowns = ifEvents.findElements(By.xpath(".//button"));
            ifDropDowns.get(1).isDisplayed();
            List<WebElement> whenDropDowns = whenEvents.findElements(By.xpath(".//button"));
            whenDropDowns.get(1).isDisplayed();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(IndexOutOfBoundsException c)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
           return null; 
        }
        return this;
    }
    public Rule_Create verifyOneAction()
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(2, TimeUnit.SECONDS);
            List<WebElement> thenDropDowns = thenEvents.findElements(By.xpath(".//button"));
            thenDropDowns.get(1).isDisplayed();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(IndexOutOfBoundsException c)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
           return this; 
        }
        return null;
    }
    public Rule_Create verifyOneCondition()
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(2, TimeUnit.SECONDS);
            List<WebElement> ifDropDowns = ifEvents.findElements(By.xpath(".//button"));
            ifDropDowns.get(1).isDisplayed();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(IndexOutOfBoundsException c)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
           return this; 
        }
        return null;
    }
    public Rule_Create verifyOneTrigger()
    {
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(2, TimeUnit.SECONDS);
            List<WebElement> whenDropDowns = whenEvents.findElements(By.xpath(".//button"));
            whenDropDowns.get(1).isDisplayed();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(IndexOutOfBoundsException c)
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
           return this; 
        }
        return null;
    }

    
}
