package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-events ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement whenDrillDownSelectPane;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement ifDrillDownSelectPane;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement thenDrillDownSelectPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//button//span[text()='Save']")
    private WebElement saveButton;

    public Rule_Create enterRuleName ( String name )
    {
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
    
    public Rule_Create enterIfInput ( String value, int index )
    {
        wait.until(ExpectedConditions.visibilityOf(ifEvents));
        List<WebElement> ifInputs = ifEvents.findElements(By.xpath(".//input"));
        ifInputs.get(index-1).sendKeys(value);
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

    public Rule_Create selectWhenDrillDownPaneOption (String string )
    {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(whenDrillDownSelectPane)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(".//li"))));
        whenDrillDownSelectPane.findElement(By.xpath(".//li[div[text()='" + string + "']]")).click();
        return this;
        
    }
    
    public Rule_Create selectIfDrillDownPaneOption (String string )
    {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ifDrillDownSelectPane)));
        ifDrillDownSelectPane.findElement(By.xpath(".//li/div[text()='" + string + "']")).click();
        return this;
        
    }
    
    public Rule_Create selectThenDrillDownPaneOption (String string )
    {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(thenDrillDownSelectPane)));
        thenDrillDownSelectPane.findElement(By.xpath(".//li/div[text()='" + string + "']")).click();
        return this;
        
    }

    public void openThenActionPane ( int index )
    {
        wait.until(ExpectedConditions.visibilityOf(thenEvents));
        List<WebElement> thenDropDowns = thenEvents.findElements(By.xpath(".//button"));
        thenDropDowns.get(index-1).click();
        
    }

    public Rule_ListAll clickSave ()
    {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        return PageFactory.initElements(driver, Rule_ListAll.class);
    }
    
}
