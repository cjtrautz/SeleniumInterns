package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Message_CreateEmail extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//body//p")
    private WebElement body;
    
    @FindBy(
            how = How.TAG_NAME,
            using = "iframe")
    private WebElement iFrame;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
    private WebElement iFrameMessage;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement messageNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' plaintext-copy-from ')]")
    private WebElement copyFromHTML;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class,'object_selector_NAME_send_from')]//button")
    private WebElement sendFromDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-send-name ')]//input")
    private WebElement sendOutNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-reply ')]//input")
    private WebElement replyToEmailInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-mail-from ')]//button")
    private WebElement toggleMailFromPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-subject ')]//input")
    private WebElement subjectInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-editor-merge ')]//button")
    private WebElement toggleMergeFieldPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-editor-merge ')]//input")
    private WebElement mergeFieldPaneInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' cke_button__source ')]")
    private WebElement sourceButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement mailFromPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(., 'Cancel')]")
    private WebElement cancel;
    
    @FindBy(
            how = How.XPATH,
            using = "//textarea[contains(concat(' ', @class, ' '),' cke_source ')]")
    private WebElement textareaSource;

    public Message_CreateEmail enterMessageName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        wait.until(ExpectedConditions.visibilityOf(messageNameInput));
        messageNameInput.click();
        messageNameInput.sendKeys(name); 
        return this;
    }

    public Message_CreateEmail enterSendOutName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sendOutNameInput));
        sendOutNameInput.sendKeys(name);
        return this;
        
    }

    public Message_CreateEmail enterReplyToEmail ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(replyToEmailInput));
        replyToEmailInput.sendKeys(name);
        return this;
        
    }

    public Message_CreateEmail openMailFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleMailFromPane));
        toggleMailFromPane.click();
        return this;
        
    }

    public Message_CreateEmail selectMailFrom ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mailFromPane));
        List<WebElement> selectionOptions = mailFromPane.findElements(By.xpath(".//li/div"));
        wait.until(ExpectedConditions.visibilityOf(selectionOptions.get(i-1)));
        selectionOptions.get(i-1).click();
        return this;
        
    }

    public Message_CreateEmail enterSubject ( String subject )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(subjectInput));
        subjectInput.sendKeys(subject);
        return this;
        
    }

    public Message_CreateEmail enterMessageBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.switchTo().frame(iFrameMessage);
        //body.sendKeys(string);
        ((JavascriptExecutor) driver).executeScript("document.body.innerHTML = '<p>" + string + "</p>'");
        driver.switchTo().defaultContent();
        return this;
        
    }

    public Message_CreateEmail openMergeFieldPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(toggleMergeFieldPane));
        toggleMergeFieldPane.click();
        return this;
        
    }

    public Message_CreateEmail selectMergeField ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")));
        wait.until(ExpectedConditions.visibilityOf(mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']"))));
        mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")).click();
        return this;
    }

    public Message_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (Message_ListAll) new Message_ListAll().init();
    }

    public Message_CreateEmail clickSource ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sourceButton));
        sourceButton.click();
        return this;
    }

    public Message_CreateEmail enterMessageBodySource ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(textareaSource));
        textareaSource.sendKeys(string);
        return this;
    }

    public Message_CreateEmail enterMergeFieldPane ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mergeFieldPaneInput));
        mergeFieldPaneInput.sendKeys(string);
        wait.until(ExpectedConditions.visibilityOf(mailFromPane.findElement(By.xpath(".//li/div[contains(text(), '" + string + "')]"))));
        return this;
    }

    public Message_CreateEmail clickCopyFromHTML ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(copyFromHTML));
        copyFromHTML.click();
        return this;
    }

    public Message_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        return (Message_ListAll) new Message_ListAll().init();
    }

    public Message_CreateEmail openSendFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sendFromDropDown));
        sendFromDropDown.click();
        return this;
    }

    public Message_CreateEmail selectSendFrom ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mailFromPane));
        List<WebElement> selectionOptions = mailFromPane.findElements(By.xpath(".//li/div"));
        wait.until(ExpectedConditions.visibilityOf(selectionOptions.get(i-1)));
        selectionOptions.get(i-1).click();
        return this;
    }
    
}
