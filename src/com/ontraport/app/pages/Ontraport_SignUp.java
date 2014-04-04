package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Ontraport_SignUp extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//input[@name='firstname']")
    private WebElement firstnameInput;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='lastname']")
    private WebElement lastnameInput;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='company']")
    private WebElement companyInput;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='office_phone']")
    private WebElement officePhoneInput;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='address']")
    private WebElement addressInput;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='city']")
    private WebElement cityInput;
    
    @FindBy(how = How.XPATH,
            using = "//select[@name='state']")
    private WebElement stateInput;

    @FindBy(how = How.XPATH,
            using = "//input[@name='zip']")
    private WebElement zipInput;
    
    @FindBy(how = How.XPATH,
            using = "//select[@name='country']")
    private WebElement countryInput;

    @FindBy(how = How.XPATH,
            using = "//input[@name='email']")
    private WebElement emailInput;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='email2']")
    private WebElement email2Input;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='password']")
    private List<WebElement> passInput;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='password2']")
    private WebElement pass2Input;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='agree_term']")
    private WebElement agreeInput;
    
    @FindBy(how = How.XPATH,
            using = "//input[@name='cc_name']")
    private WebElement ccname;
    @FindBy(how = How.XPATH,
            using = "//input[@name='ccnumb']")
    private WebElement ccnumb;
    @FindBy(how = How.XPATH,
            using = "//input[@name='vcode']")
    private WebElement vcode;
    @FindBy(how = How.XPATH,
            using = "//select[@name='expmonth']")
    private WebElement expmonth;
    @FindBy(how = How.XPATH,
            using = "//select[@name='expyear']")
    private WebElement expyear;
    @FindBy(how = How.XPATH,
            using = "//input[@name='billing_zip']")
    private WebElement billingZip;
    @FindBy(how = How.XPATH,
            using = "//input[@value='Create My Account Now']")
    private WebElement createAccount;
    
    public Ontraport_SignUp enterFirstName ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", firstnameInput);
        wait.until(ExpectedConditions.visibilityOf(firstnameInput));
        firstnameInput.click();
        firstnameInput.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterLastName ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", lastnameInput);
        wait.until(ExpectedConditions.visibilityOf(lastnameInput));
        lastnameInput.click();
        lastnameInput.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterBusinessName ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", companyInput);
        wait.until(ExpectedConditions.visibilityOf(companyInput));
        companyInput.click();
        companyInput.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterPhoneNumber ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", officePhoneInput);
        wait.until(ExpectedConditions.visibilityOf(officePhoneInput));
        officePhoneInput.click();
        officePhoneInput.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterAddress ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", addressInput);
        wait.until(ExpectedConditions.visibilityOf(addressInput));
        addressInput.click();
        addressInput.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterCity ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", cityInput);
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        cityInput.click();
        cityInput.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterState ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", stateInput);
        wait.until(ExpectedConditions.visibilityOf(stateInput));
        stateInput.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(string).build().perform();
        return this;
    }

    public Ontraport_SignUp enterZip ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", zipInput);
        wait.until(ExpectedConditions.visibilityOf(zipInput));
        zipInput.click();
        zipInput.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterCountry ( String string ) throws InterruptedException
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", countryInput);
        wait.until(ExpectedConditions.visibilityOf(countryInput));
        countryInput.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(string).build().perform();
        return this;
    }

    public Ontraport_SignUp enterEmailAddressAgain ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", email2Input);
        wait.until(ExpectedConditions.visibilityOf(email2Input));
        email2Input.click();
        email2Input.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterEmailAddress ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", emailInput);
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        emailInput.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterPassword ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", passInput.get(1));
        wait.until(ExpectedConditions.visibilityOf(passInput.get(1)));
        passInput.get(1).click();
        passInput.get(1).sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterPasswordAgain ( String string )
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", pass2Input);
        wait.until(ExpectedConditions.visibilityOf(pass2Input));
        pass2Input.click();
        pass2Input.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp checkAgreeToTerms ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", agreeInput);
        wait.until(ExpectedConditions.visibilityOf(agreeInput));
        agreeInput.click();
        return this;
    }

    public Ontraport_SignUp clickCreateMyAccount ()
    {
        //AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", agreeInput);
        wait.until(ExpectedConditions.visibilityOf(createAccount));
        createAccount.click();
        driver.switchTo().alert().accept();
        return this;
    }

    public Ontraport_SignUp enterNameOnCard ( String string )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ccname);
        wait.until(ExpectedConditions.visibilityOf(ccname));
        ccname.click();
        ccname.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterCard ( String string )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ccnumb);
        wait.until(ExpectedConditions.visibilityOf(ccnumb));
        ccnumb.click();
        ccnumb.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterSecurityCode ( String string )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", vcode);
        wait.until(ExpectedConditions.visibilityOf(vcode));
        vcode.click();
        vcode.sendKeys(string);
        return this;
    }

    public Ontraport_SignUp enterExpiresOnMonth ( String string )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", expmonth);
        wait.until(ExpectedConditions.visibilityOf(expmonth));
        expmonth.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(string).build().perform();
        return this;
    }

    public Ontraport_SignUp enterExpiresOnYear ( String string )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", expyear);
        wait.until(ExpectedConditions.visibilityOf(expyear));
        expyear.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(string).build().perform();
        return this;
    }

    public Ontraport_SignUp enterBillingZip ( String string )
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", billingZip);
        wait.until(ExpectedConditions.visibilityOf(billingZip));
        billingZip.click();
        billingZip.sendKeys(string);
        return this;
    }

    
}
