package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Message_CreateEmail extends AbstractPage
{
    @FindBy(
            how = How.CSS,
            using = "body")
    private WebElement body;
    
    @FindBy(
            how = How.TAG_NAME,
            using = "iframe")
    private WebElement iFrame;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement messageNameInput;
    
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
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement mailFromPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;

    public Message_CreateEmail enterMessageName ( String name )
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        messageNameInput.click();
        messageNameInput.sendKeys(name); 
        return this;
    }

    public Message_CreateEmail enterSendOutName ( String name )
    {
        sendOutNameInput.sendKeys(name);
        return this;
        
    }

    public Message_CreateEmail enterReplyToEmail ( String name )
    {
        replyToEmailInput.sendKeys(name);
        return this;
        
    }

    public Message_CreateEmail openMailFromPane ()
    {
        toggleMailFromPane.click();
        return this;
        
    }

    public Message_CreateEmail selectMailFrom ( int i )
    {
        List<WebElement> selectionOptions = mailFromPane.findElements(By.xpath(".//li/div"));
        selectionOptions.get(i-1).click();
        return this;
        
    }

    public Message_CreateEmail enterSubject ( String subject )
    {
        subjectInput.sendKeys(subject);
        return this;
        
    }

    public Message_CreateEmail enterMessageBody ( String string )
    {
        driver.switchTo().frame(iFrame);
        body.sendKeys(string);
        driver.switchTo().defaultContent();
        return this;
        
    }

    public Message_CreateEmail openMergeFieldPane ()
    {
        toggleMergeFieldPane.click();
        return this;
        
    }

    public Message_CreateEmail selectMergeField ( String string )
    {
        mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")).click();
        return this;
    }

    public Message_ListAll clickSave ()
    {
        save.click();
        return (Message_ListAll) new Message_ListAll().init();
    }
    
}
