package com.ontraport.app.parts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        wait(10).until(ExpectedConditions.visibilityOf(helpButton));
        Actions actions = new Actions(driver);
        actions.click(helpButton).build().perform();
        return this;     
    }
    public MenuHelp close () 
    { 
        AbstractPart.waitForAjax(driver, 20);
        //wait(10).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(helpButton)));
        Actions actions = new Actions(driver);
        actions.click(helpButton).build().perform();
        return this;  
    }
    public Support_Home clickSupport ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(support));
        support.click();
        return (Support_Home) new Support_Home().init();
    }
    public MenuHelp clickEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(email));
        email.click();
        return this;  
    }
    public Support_Home clickFeedback ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(10).until(ExpectedConditions.visibilityOf(feedback));
        feedback.click();
        return (Support_Home) new Support_Home().init();     
    }
    public MenuHelp verifyOpened ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            wait(10).until(ExpectedConditions.visibilityOf(helpMenu));
            if(!helpMenu.isDisplayed())
            {
                return null;
            }
        }
        catch(Exception e){
            return null;
        }
        
        return this;
    }
    public MenuHelp verifyClosed ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(helpMenuGone.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }
}
