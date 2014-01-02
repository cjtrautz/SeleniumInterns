package com.ontraport.app.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Support_Home extends AbstractPage
{
//    @FindBy(
//            how = How.XPATH,
//            using = "//h2[a[@href='/forums']]/following-sibling::form[@id='searchform']")
//    private WebElement featureRequest;
//    
//    @FindBy(
//            how = How.XPATH,
//            using = "//div[@id='solution_suggestion']//h2")
//    private WebElement solutionSuggestions;
//    
//    @FindBy(
//            how = How.XPATH,
//            using = "//div[@class='side-box-content']/h3")
//    private WebElement aboutOntraport;

    public Support_Home verifyPage ()
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
                    if(driver.switchTo().window(windowId).getTitle().contains("Ontraport"))
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
            if(!driver.getCurrentUrl().contains("https://support.ontraport.com"))
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                driver.switchTo().window(parentWindow);
                return null; 
            }
            System.out.println("before solution");
//            solutionSuggestions.isDisplayed();
            System.out.println("after solution");
//            aboutOntraport.isDisplayed();
            System.out.println("after about");
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

    public Support_Home verifyFeature ()
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
                    if(driver.switchTo().window(windowId).getTitle().contains("Ontraport"))
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
            if(!driver.getCurrentUrl().contains("https://support.ontraport.com"))
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                driver.switchTo().window(parentWindow);
                return null; 
            }
            if(!driver.getCurrentUrl().contains("Feature-Requests"))
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                driver.switchTo().window(parentWindow);
                return null; 
            }
            System.out.println("here");
//            featureRequest.isDisplayed();
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
        //driver.close();
        driver.switchTo().window(parentWindow);
        return this;
    }
    
}
