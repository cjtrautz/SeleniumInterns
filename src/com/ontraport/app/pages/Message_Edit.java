package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Message_Edit extends AbstractPage
{
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
            using = "//tbody//tr[contains(concat(' ', normalize-space(@class), ' '),' outcome_rules ')]//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-text ')]/span/a")
    private WebElement taskOutcomes;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
    private WebElement iFrame;
    
    @FindBy(how = How.XPATH,
            using = "//body")
    private WebElement body;
    
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
    
    
}
