package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Message_CreateSMS extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement messageNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-form_control_drill_down_select_field_selector_merge_field_inserter ')]//button")
    private WebElement toggleMergeFieldPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement mailFromPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;

    public Message_CreateSMS enterMessageName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        messageNameInput.click();
        messageNameInput.sendKeys(name); 
        return this;
    }
    public Message_CreateSMS openMergeFieldPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        toggleMergeFieldPane.click();
        return this;
        
    }

    public Message_CreateSMS selectMergeField ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='[Warning! This message contains merge fields; it could produce very large output.]']")));
        driver.findElement(By.xpath("//textarea")).sendKeys("Sel");
        return this;
    }

    public Message_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (Message_ListAll) new Message_ListAll().init();
    }
}