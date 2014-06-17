package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Fulfillment_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//label[text()='Fulfillment list name']/following-sibling::div[@class='ussr-form-input-wrapper']/input")
    private WebElement fulfillmentListNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(concat(' ', @class, ' '),' ussr-component-frequency-scheduler-time ')]//button")
    private WebElement toggleTimeSchedulerSelector;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-recipient-message-target-email-box ')]//input")
    private WebElement emailNotificationInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-recipient-message-target-message-topic-box ')]//input")
    private WebElement emailSubjectInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-recipient-message-target-message-body-box ')]//textarea")
    private WebElement emailBodyInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-fulfillment-target-fields ')]//button[span[text()='<br>']]")
    private WebElement toggleFieldSelector;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownSelectPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement save;

    public Fulfillment_Create enterFulfillmentListName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fulfillmentListNameInput)));
        fulfillmentListNameInput.sendKeys(name);
        return this;
        
    }

    public Fulfillment_Create openSendTimePane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(toggleTimeSchedulerSelector)));
        toggleTimeSchedulerSelector.click();
        return this;
        
    }

    public Fulfillment_Create selectTime ( String option )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(drillDownSelectPane)));
        drillDownSelectPane.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        return this;
    }

    public Fulfillment_Create openFieldPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(toggleFieldSelector)));
        toggleFieldSelector.click();
        return this;
        
    }

    public Fulfillment_Create selectField ( String option )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(drillDownSelectPane)));
        drillDownSelectPane.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        return this;
        
    }

    public Fulfillment_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(save)));
        save.click();
        return (Fulfillment_ListAll) new Fulfillment_ListAll().init();
    }

    public Fulfillment_Create enterEmailNotification ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(emailNotificationInput)));
        emailNotificationInput.sendKeys(string);
        return this;
    }

    public Fulfillment_Create enterEmailSubject ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(emailSubjectInput)));
        emailSubjectInput.sendKeys(string);
        return this;
    }

    public Fulfillment_Create enterEmailMessage ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(emailBodyInput)));
        emailBodyInput.sendKeys(string);
        return this;
    }
    
}
