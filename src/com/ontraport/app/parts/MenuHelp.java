package com.ontraport.app.parts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.pages.ApiSettings_Edit;
import com.ontraport.app.pages.Support_Home;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class MenuHelp extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//li[@class='ussr-header-nav-option-help']/a[@href='javascript://']")
    private WebElement helpButton;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='/Zendesk/redirect?redirect_to=http%3A%2F%2Fsupport.ontraport.com']/span")
    private WebElement support;
    
    @FindBy(how = How.XPATH,
            using = "//a[@onclick='script: Zenbox.show();']/span")
    private WebElement email;
    
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-help-menu-content-feedback ')]/a/span")
    private WebElement feedback;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-help-menu')]")
    private WebElement helpMenu;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-help-menu') and @style='display: none;']")
    private WebElement helpMenuGone;
    
    
    public MenuHelp open () { 
        AbstractPart.waitForAjax(driver, 20);
        helpButton.click();
        return this;     
    }
    public MenuHelp close () 
    { 
        AbstractPart.waitForAjax(driver, 20);
        helpButton.click();
        return this;  
    }
    public Support_Home clickSupport ()
    {
        AbstractPart.waitForAjax(driver, 20);
        support.click();
        return (Support_Home) new Support_Home().init();
    }
    public MenuHelp clickEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        email.click();
        return this;  
    }
    public Support_Home clickFeedback ()
    {
        AbstractPart.waitForAjax(driver, 20);
        feedback.click();
        return (Support_Home) new Support_Home().init();     
    }
    public MenuHelp verifyOpened ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(!helpMenu.isDisplayed())
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
    public MenuHelp verifyClosed ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(helpMenuGone.isDisplayed())
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
