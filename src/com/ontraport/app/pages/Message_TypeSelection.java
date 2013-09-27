package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Message_TypeSelection extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[div[*/text()='E-Mail']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement emailMessage;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[div[*/text()='Task']]/descendant::button[*[normalize-space(text())='Create']]")
    private WebElement taskMessage;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-type-selection-type ')][1]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-button-menu-toggle ')]")
    private WebElement emailDropDownButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-type-selection-type ')][3]//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-button-menu-toggle ')]")
    private WebElement taskDropDownButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-type-selection-type ')][3]//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]")
    private WebElement taskDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-type-selection-type ')][1]//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]")
    private WebElement emailDropDownPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-state-active ')]//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement dropDownCollection;

    public Message_CreateEmail clickEmailCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(emailMessage));
        emailMessage.click();
        return (Message_CreateEmail) new Message_CreateEmail().init();
    }
    public Message_TypeSelection clickEmailCopy ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(emailDropDownButton));
        emailDropDownButton.click();
        return this;
    }
    public Message_CreateEmail selectEmailCopyOption (String option)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(emailDropDownPane));
        wait.until(ExpectedConditions.visibilityOf(dropDownCollection));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[contains(text(), '" + option + "')]")));
        dropDownCollection.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        return (Message_CreateEmail) new Message_CreateEmail().init();
    }
    public Message_CreateTask selectTaskCopyOption (String option)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskDropDownPane));
        wait.until(ExpectedConditions.visibilityOf(dropDownCollection));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[contains(text(), '" + option + "')]")));
        dropDownCollection.findElement(By.xpath(".//li/div[contains(text(), '" + option + "')]")).click();
        return (Message_CreateTask) new Message_CreateTask().init();
    }
    public Message_CreateTask clickTaskCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskMessage));
        taskMessage.click();
        return (Message_CreateTask) new Message_CreateTask().init();
    }
    public Message_TypeSelection clickTaskCopy ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taskDropDownButton));
        taskDropDownButton.click();
        return this;
        
    }
    
}
