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

public class OneShoppingCart_View extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//li[text()='Login to your 1shoppingcart account']")
    private WebElement stepOne;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[text()='Click on My Account > Status Summary to get your Merchant Id']")
    private WebElement stepTwo;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[text()='Click My Account > API > API Settings to get your Merchant API Key']")
    private WebElement stepThree;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[text()='Complete the Form below using the information obtained above']")
    private WebElement stepFour;
    
    public OneShoppingCart_View verify ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            stepOne.isDisplayed();
            stepTwo.isDisplayed();
            stepThree.isDisplayed();
            stepFour.isDisplayed();
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
