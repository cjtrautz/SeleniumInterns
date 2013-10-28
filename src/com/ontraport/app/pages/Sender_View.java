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

public class Sender_View extends AbstractPage
{
    public static String url = "/#!/sender/view";
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='sender_add']/button")
    private WebElement addEmail;

    public Sender_View clickAddEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        addEmail.click();
        return this;
        
    }

    public Sender_View verifyConfirmed ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//td[text()='" + string + "']/following-sibling::td/span[text()='Confirmed']"));
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

    public Sender_View clickRemove ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath("//td[text()='" + string + "']/preceding-sibling::td/span[text()='Remove']")).click();
        return this;
        
    }

    public Sender_View verifyNoSendFrom ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//td[text()='" + string + "']/following-sibling::td/span[text()='Confirmed']"));
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            return this;
        }
        
        return null;
    }

    public Sender_View verifyUnConfirmed ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//td[text()='" + string + "']/following-sibling::td/span[text()='Un-Confirmed']"));
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
