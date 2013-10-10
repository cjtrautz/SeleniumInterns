package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Message_Edit extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' target-send-name ')]//input")
    private WebElement sendOutNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[contains(concat(' ', @class, ' '),' ussr-icon-mail-closed-moving-2 ')]")
    private WebElement sendTestEmail;
    
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
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement mailFromPane;
    
    @FindBy(
            how = How.XPATH,
            using = "//span[@class='ussr-message-notification']")
    private WebElement notification;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' target-send-name ')]")
    private WebElement sendName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' target-reply ')]")
    private WebElement reply;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' target-subject ')]")
    private WebElement subject;
    
    @FindBy(how = How.XPATH,
            using = "//span[contains(concat(' ', normalize-space(@style), ' '),'/js/ontraport/boxes/images/transp.png')]")
    private WebElement shape;
    
    @FindBy(how = How.XPATH,
            using = "//tbody//tr[contains(concat(' ', normalize-space(@class), ' '),' outcome_rules ')]//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-text ')]/span/a")
    private WebElement taskOutcomes;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
    private WebElement iFrame;
    
    @FindBy(how = How.XPATH,
            using = "//body")
    private WebElement body;
    
    @FindBy(how = How.XPATH,
            using = "//textarea")
    private WebElement textArea;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")
    private WebElement messageNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[span[text()='Save']]")
    private WebElement save;
    
    public Message_Edit enterMessageName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-name ')]//input")));
        messageNameInput.click();
        messageNameInput.sendKeys(name); 
        return this;
    }
    
    public Message_Edit verifySendName (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(sendName.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = sendName.findElement(By.xpath(".//input")).getAttribute("value");
            if(compare.equals(name)!=true)
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
    
    public Message_Edit verifyReplyTo (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(reply.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = reply.findElement(By.xpath(".//input")).getAttribute("value");
            if(compare.equals(name)!=true)
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
    
    public Message_Edit verifySubject (String name)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(subject.findElement(By.xpath(".//input")).getAttribute("value"));
            String compare = subject.findElement(By.xpath(".//input")).getAttribute("value");
            if(compare.equals(name)!=true)
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
    public Message_Edit verifyBody (String stuff)
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            driver.switchTo().frame(iFrame);
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("/html//body[normalize-space(.)='" + stuff + "']"));
            driver.switchTo().defaultContent();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        
        
        return this;
    }

    public Message_Edit verifyOutcome ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
            try
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
                System.out.println(taskOutcomes.getText());
                String compare = taskOutcomes.getText();
                if(compare.equals(name)!=true)
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
    
    public Message_Edit enterSendOutName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        sendOutNameInput.sendKeys(name);
        return this;
        
    }

    public Message_Edit enterReplyToEmail ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        replyToEmailInput.sendKeys(name);
        return this;
        
    }

    public Message_Edit openMailFromPane ()
    {
        AbstractPart.waitForAjax(driver, 20);
        toggleMailFromPane.click();
        return this;
        
    }

    public Message_Edit selectMailFrom ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        List<WebElement> selectionOptions = mailFromPane.findElements(By.xpath(".//li/div"));
        selectionOptions.get(i-1).click();
        return this;
        
    }

    public Message_Edit enterSubject ( String subject )
    {
        AbstractPart.waitForAjax(driver, 20);
        subjectInput.sendKeys(subject);
        return this;
        
    }
    public Message_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (Message_ListAll) new Message_ListAll().init();
    }
    
    public Contact_ListAll clickSave2 ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }

    public Message_Edit verifyTextArea ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println(textArea.getAttribute("value"));
            String compare = textArea.getAttribute("value");
            if(compare.equals(name)!=true)
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

    public Message_Edit clickSendTestEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        sendTestEmail.click();
        return this;
        
    }

    public Message_Edit verifyEmailSent ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!notification.isDisplayed())
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

    public Message_Edit verifyShape ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!shape.isDisplayed())
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

    public Message_Edit verifyTextSize ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            //System.out.println("here");
            //System.out.println("here2");
            //System.out.println(driver.findElement(By.xpath("/html//body")).getText());
            driver.findElement(By.xpath("//font[@size='" + string + "PX']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.switchTo().defaultContent();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return null;
        }
        return this;
    }
}
