package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Sequence_CreateStep extends AbstractPage
{
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
            using = "//span[@class='ussr-theme-sequence-email']//button")
    private WebElement emailStep;
    
    @FindBy(
    how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-editor-back']")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement save;

    public Sequence_CreateStep enterSequenceName ( String name )
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-pane-editor-back']")));
        wait.until(ExpectedConditions.visibilityOf(subsicribers));
        wait.until(ExpectedConditions.visibilityOf(sequenceNameInput));
        sequenceNameInput.sendKeys(name);
        return this;
        
    }

    public Sequence_CreateStep clickAddEmailStep ()
    {
        wait.until(ExpectedConditions.visibilityOf(emailStep));
        emailStep.click();
        return this;
        
    }

    public Sequence_CreateStep openEmailNamePane ()
    {
        wait.until(ExpectedConditions.visibilityOf(toggleMessageSelector));
        toggleMessageSelector.click();
        return this;
        
    }

    public Sequence_CreateStep selectDrillDown ( int index )
    {
        wait.until(ExpectedConditions.visibilityOf(drillDownPane));
        List<WebElement> messages = drillDownPane.findElements(By.xpath(".//li/div"));
        messages.get(index-1).click();
        return this;
        
    }

    public Sequence_CreateStep openEmailFromPane ()
    {
        wait.until(ExpectedConditions.visibilityOf(toggleEmailFrom));
        toggleEmailFrom.click();
        return this;
        
    }

    public Sequence_CreateStep openSendFromPane ()
    {
        wait.until(ExpectedConditions.visibilityOf(toggleSendFrom));
        toggleSendFrom.click();
        return this;
        
    }

    public Sequence_ListAll clickSave ()
    {
        save.click();
        return PageFactory.initElements(driver, Sequence_ListAll.class);
    }
    
    public Sequence_ListAll clickBack ()
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ussr-pane-editor-back']")));
        back.click();
        return PageFactory.initElements(driver, Sequence_ListAll.class);
    }

    
}
