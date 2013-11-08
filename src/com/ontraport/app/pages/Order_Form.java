package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Order_Form extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='firstname']")
    private WebElement firstname;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='email']")
    private WebElement email;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='billing_address1']")
    private WebElement billingAddress;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='billing_city']")
    private WebElement billingCity;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='billing_zip']")
    private WebElement billingZip;
    
    @FindBy(
            how = How.XPATH,
            using = "//select[@name='billing_state']")
    private WebElement billingState;
    
    @FindBy(
            how = How.XPATH,
            using = "//select[@name='billing_country']")
    private WebElement billingCountry;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='payment_number']")
    private WebElement creditCardNumber;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='payment_code']")
    private WebElement cvcNumber;
    
    @FindBy(
            how = How.XPATH,
            using = "//select[@name='payment_expire_month']")
    private WebElement expMonth;
    
    @FindBy(
            how = How.XPATH,
            using = "//select[@name='payment_expire_year']")
    private WebElement expYear;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='submit-button']")
    private WebElement submitButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//h2[@class='thanks']")
    private WebElement thanks;

    public Order_Form enterFirstName ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(firstname));
        firstname.sendKeys(string);
        return this;
    }

    public Order_Form enterBillingAddress ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(billingAddress));
        billingAddress.sendKeys(string);
        return this;
    }

    public Order_Form enterBillingCity ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(billingCity));
        billingCity.sendKeys(string);
        return this;
    }

    public Order_Form enterBillingZip ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(billingZip));
        billingZip.sendKeys(string);
        return this;
    }

    public Order_Form clickState ()
    {
        wait.until(ExpectedConditions.visibilityOf(billingState));
        billingState.click();
        return this;
    }

    public Order_Form enterState ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(billingState));
        billingState.sendKeys(string);
        return this;
    }

    public Order_Form clickCountry ()
    {
        wait.until(ExpectedConditions.visibilityOf(billingCountry));
        billingCountry.click();
        return this;
    }

    public Order_Form enterCountry ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(billingCountry));
        billingCountry.sendKeys(string);
        return this;
    }

    public Order_Form enterCardNumber ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(creditCardNumber));
        creditCardNumber.sendKeys(string);
        return this;
    }

    public Order_Form enterCVCNumber ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(cvcNumber));
        cvcNumber.sendKeys(string);
        return this;
    }

    public Order_Form clickMonth ()
    {
        wait.until(ExpectedConditions.visibilityOf(expMonth));
        expMonth.click();
        return this;
    }

    public Order_Form enterMonth ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(expMonth));
        expMonth.sendKeys(string);
        return this;
    }

    public Order_Form clickYear ()
    {
        wait.until(ExpectedConditions.visibilityOf(expYear));
        expYear.click();
        return this;
    }

    public Order_Form enterYear ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(expYear));
        expYear.sendKeys(string);
        return this;
    }

    public Order_Form clickSubmit ()
    {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
        return this;
    }

    public Order_Form verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(thanks));
            if(!thanks.isDisplayed())
            {
                return null;
            } 
            String url = driver.getCurrentUrl();
            if(!url.equals("http://thankyou.ontraport.com/"))
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public Order_Form enterEmail ( String string )
    {
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(string);
        return this;
    }
    
}
