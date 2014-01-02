package com.ontraport.app.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class WordPress_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement websiteName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-hosted-domain-selector-subdomain ')]//input[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input ')]")
    private WebElement domainName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-hosted-domain-target-component ')]//input")
    private WebElement existingDomainName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-sortablelist-options ')]/div")
    private WebElement membershipLevel;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='http://wordpress.org/extend/plugins/pilotpress/']")
    private WebElement pilotPressLink;

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

    public WordPress_Edit verifyExistingWordPressURL ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = existingDomainName.getAttribute("value");
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
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='http://" + string + ".affcntr.com/wp-login.php']"))));
         driver.findElement(By.xpath("//a[@href='http://" + string + ".affcntr.com/wp-login.php']")).click();
         System.out.print("ya");
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[@for='user_login']/input"))));
         String[] login = AbstractPage.getLogin().split("\\+");
         driver.findElement(By.xpath("//label[@for='user_login']/input")).sendKeys(login[0] + login[1]);
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[@for='user_pass']/input"))));
         driver.findElement(By.xpath("//label[@for='user_pass']/input")).sendKeys(password);
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='wp-submit']"))));
         driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@id='menu-plugins']/a"))));
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

    public WordPress_Edit verifyPilotPress ()
    {
        AbstractPart.waitForAjax(driver, 20);
        String parentWindow = driver.getWindowHandle();
        try
        {
            pilotPressLink.click();
            Set<String> allWindows = driver.getWindowHandles();
            if(!allWindows.isEmpty())
            {
                for(String windowId : allWindows)
                {
                    try
                    {
                        System.out.println(driver.switchTo().window(windowId).getTitle());
                        if(driver.switchTo().window(windowId).getTitle().equals("WordPress › PilotPress « WordPress Plugins"))
                        {
                            System.out.println(driver.getCurrentUrl());
                            if(driver.getCurrentUrl().equals("http://wordpress.org/plugins/pilotpress/"))
                            {
                                //driver.close();
                                driver.switchTo().window(parentWindow);
                                return this;
                            }
                        }
                    }
                    catch(NoSuchWindowException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                driver.switchTo().window(parentWindow);
                return null;
            }
        }
        catch(NoSuchElementException e){
            driver.switchTo().window(parentWindow);
            return null;
        }
        driver.switchTo().window(parentWindow);
        return null;
    }

    
}
