package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class MessageTemplate_CreateType2 extends AbstractPage
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
            using = "//textarea")
    private WebElement plainTextEmailBody;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;

    public MessageTemplate_CreateType2 enterMessageName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        messageNameInput.click();
        messageNameInput.sendKeys(name); 
        return this;
    }

    public MessageTemplate_CreateType2 enterSendOutName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        sendOutNameInput.sendKeys(name);
        return this;
        
    }

    public MessageTemplate_CreateType2 enterReplyToEmail ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        replyToEmailInput.sendKeys(name);
        return this;
        
    }

    public MessageTemplate_CreateType2 openMailFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        toggleMailFromPane.click();
        return this;
        
    }

    public MessageTemplate_CreateType2 selectMailFrom ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> selectionOptions = mailFromPane.findElements(By.xpath(".//li/div"));
        selectionOptions.get(i-1).click();
        return this;
        
    }

    public MessageTemplate_CreateType2 enterSubject ( String subject )
    {
        AbstractPart.waitForAjax(driver, 20);
        subjectInput.sendKeys(subject);
        return this;
        
    }

    public MessageTemplate_CreateType2 enterMessageBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.switchTo().frame(iFrame);
        body.sendKeys(string);
        driver.switchTo().defaultContent();
        return this;
        
    }

    public MessageTemplate_CreateType2 openMergeFieldPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", toggleMergeFieldPane);
        toggleMergeFieldPane.click();
        return this;
        
    }

    public MessageTemplate_CreateType2 selectMergeField ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")));
        mailFromPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")).click();
        return this;
    }

    public MessageTemplate_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (MessageTemplate_ListAll) new MessageTemplate_ListAll().init();
    }

    public MessageTemplate_CreateType2 enterMessagePlainTextBody ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", plainTextEmailBody);
        plainTextEmailBody.sendKeys(string);
        return this;
        
    }
}
