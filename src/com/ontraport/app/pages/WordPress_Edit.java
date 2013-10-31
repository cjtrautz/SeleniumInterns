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

public class WordPress_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement websiteName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-hosted-domain-selector-subdomain ')]//input")
    private WebElement domainName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-sortablelist-options ')]/div")
    private WebElement membershipLevel;

    public WordPress_Edit verifyWordPressName ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = websiteName.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public WordPress_Edit verifyWordPressURL ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = domainName.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public WordPress_Edit verifyWordpressMembership ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = membershipLevel.getAttribute("value");
            System.out.println(compare);
            //System.out.println(value);
            if(compare.equals(value)!=true)
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

    public WordPress_Edit verifyHosted ( String string, String password )
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.get(string + ".affcntr.com");
        try
        {
         driver.findElement(By.xpath("//a[@href='http://" + string + ".affcntr.com/wp-login.php']")).click();
         System.out.print("ya");
         driver.findElement(By.xpath("//label[@for='user_login']/input")).sendKeys("nick@ontraport.com");
         driver.findElement(By.xpath("//label[@for='user_pass']/input")).sendKeys(password);
         driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
         driver.findElement(By.xpath("//li[@id='menu-plugins']/a")).click();
         if(!driver.findElement(By.xpath("//strong[text()='PilotPress']")).isDisplayed())
         {
             return null;
         }
        }
        catch(Exception e)
        {
            return null;
        }
        return this;
    }

    
}
