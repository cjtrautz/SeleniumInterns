package com.ontraport.app.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class OPPackage_View extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='http://ontraport.com/legal-terms/']")
    private WebElement terms;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='//ontraport.com/legal-abuse']")
    private WebElement abuseDesk;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' add_package ')]")
    private WebElement addPackage;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(@href, '#!/contact/export')]")
    private WebElement export;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-export ')]")
    private WebElement exportPage;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' oap_cancellation ')]")
    private WebElement cancelAccount;

    public OPPackage_View clickAddPackage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addPackage));
        addPackage.click();
        return this;
        
    }

    public OPPackage_View clickExportItFirst ()
    {
        AbstractPart.waitForAjax(driver, 20);
        export.click();
        return this;
    }

    public OPPackage_View verifyExport ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!exportPage.isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public OPPackage_View verifyAbuseDesk ()
    {
        AbstractPart.waitForAjax(driver, 20);
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        if(!allWindows.isEmpty())
        {
            for ( String windowId : allWindows)
            {
                try
                {
                    if(driver.switchTo().window(windowId).getTitle().contains("ONTRAPORT | Legal – Abuse Desk"))
                    {
                        break;
                    }
                }
                catch(NoSuchWindowException e)
                {
                    e.printStackTrace();
                }
            }
        }
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(25, TimeUnit.SECONDS);
            System.out.println(driver.getCurrentUrl());
            if(!driver.getCurrentUrl().equals("http://ontraport.com/legal-terms/"))
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                driver.switchTo().window(parentWindow);
                return null; 
            }
            abuseDesk.isDisplayed();
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
        }
        catch(NoSuchElementException e){
            driver.manage()
            .timeouts()
            .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
            driver.switchTo().window(parentWindow);
            return null;
        }
        driver.close();
        driver.switchTo().window(parentWindow);
        return this;
    }

    public OPPackage_View clickHere ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(terms));
        terms.click();
        return this;
    }

    public OPPackage_View clickCancelAccount ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancelAccount));
        cancelAccount.click();
        return this;
    }
    
}
