package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class Gateway_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement gatewayName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(.,' will fail, if the test credit card number is used, the Dummy Gateway will successfully complete the transaction.')]")
    private WebElement dummyWriting;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-targets ')]//input")
    private List<WebElement> components;

    public Gateway_Edit verifyGatewayName ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gatewayName));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = gatewayName.getAttribute("value");
            System.out.println(compare);
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

    public Gateway_Edit verifyGatewayTypeDummy ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            if(dummyWriting.isDisplayed()==false)
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

    public Gateway_Edit verifyGatewayNickName ( String value )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
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

    public Gateway_Edit verifyLogin ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyKey ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyMerchantId ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyUserId ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyPin ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        try
        {
            String compare = components.get(2).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyCustomerId ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyRefundPass ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyUsername ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        try
        {
            String compare = components.get(2).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyPassword ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(3)));
        try
        {
            String compare = components.get(3).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyNetworkMerchantUsername ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyNetworkMerchantPassword ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyUser ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyVendor ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyPartner ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        try
        {
            String compare = components.get(2).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyPWD ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(3)));
        try
        {
            String compare = components.get(3).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyDc_password ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyConnectionTicket ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyAppLogin ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyAppId ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        try
        {
            String compare = components.get(2).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyUMkey ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyUMpin ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyPayPalUser ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        try
        {
            String compare = components.get(0).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyPayPalPWD ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        try
        {
            String compare = components.get(1).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public Gateway_Edit verifyPayPalSignature ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        try
        {
            String compare = components.get(2).getAttribute("value");
            System.out.println(compare);
            if(compare.equals(string)!=true)
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
