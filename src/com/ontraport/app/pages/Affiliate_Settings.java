package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Affiliate_Settings extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), \"I'll pay affiliates by\")]/following-sibling::div//button")
    private WebElement payAffiliatesByDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), \"I'll pay affiliates by\")]/following-sibling::div//input")
    private WebElement payAffiliatesByDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Pay Threshold')]/following-sibling::div//input")
    private WebElement payThresholdInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Commission is paid to')]/following-sibling::div//button")
    private WebElement commisionPaidToDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@value='1']//span[contains(concat(' ', @class, ' '),' ussr-icon-radiobutton ')]")
    private WebElement cookiesTimeRadioButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@value='0']//span[contains(concat(' ', @class, ' '),' ussr-icon-radiobutton ')]")
    private WebElement cookiesNeverRadioButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@value='0']//span[contains(concat(' ', @class, ' '),' ussr-icon-radiobutton-selected ')]")
    private WebElement cookiesNeverSelectedRadioButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' duration-value ')]//input")
    private WebElement durationValueInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Commission is paid to')]/following-sibling::div//input")
    private WebElement commisionPaidToDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Cookies will expire')]/following-sibling::div//button")
    private WebElement cookiesExpireDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Cookies will expire')]/following-sibling::div//input")
    private WebElement cookiesExpireDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-editor-back']")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]//span[contains(text(), 'Save')]")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]//span[contains(text(), 'Cancel')]")
    private WebElement cancel;

    public Affiliate_Settings clickPayAffiliatesByDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(payAffiliatesByDropDown));
        payAffiliatesByDropDown.click();
        return this;
    }

    public Affiliate_Settings selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }

    public Affiliate_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (Affiliate_ListAll) new Affiliate_ListAll().init();
    }

    public Affiliate_Settings verifyPayAffiliatesBy ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!payAffiliatesByDropDownInput.getAttribute("value").equals(string))
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Affiliate_Settings enterPayThreshold ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(payThresholdInput));
        payThresholdInput.click();
        payThresholdInput.clear();
        payThresholdInput.sendKeys(string);
        return this;
    }

    public Affiliate_Settings verifyPayThreshold ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!payThresholdInput.getAttribute("value").equals(string))
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Affiliate_Settings clickCommissionPaidToDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(commisionPaidToDropDown));
        commisionPaidToDropDown.click();
        return this;
    }

    public Affiliate_Settings verifyCommissionPaidTo ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!commisionPaidToDropDownInput.getAttribute("value").equals(string))
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Affiliate_Settings clickCookiesWillExpireDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cookiesExpireDropDown));
        cookiesExpireDropDown.click();
        return this;
    }

    public Affiliate_Settings verifyCookiesWillExpire ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!cookiesExpireDropDownInput.getAttribute("value").equals(string))
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Affiliate_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (Affiliate_ListAll) new Affiliate_ListAll().init();
    }

    public Affiliate_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        return (Affiliate_ListAll) new Affiliate_ListAll().init();
    }

    public Affiliate_Settings clickInASetTime ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cookiesTimeRadioButton));
        cookiesTimeRadioButton.click();
        return this;
    }

    public Affiliate_Settings enterCookiesInput ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(durationValueInput));
        durationValueInput.click();
        durationValueInput.clear();
        durationValueInput.sendKeys(string);
        return this;
    }

    public Affiliate_Settings verifyCookiesWillExpireInput ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!durationValueInput.getAttribute("value").equals(string))
            {
                return null; 
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        return this;
    }

    public Affiliate_Settings clickCookiesWillExpireNever ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cookiesNeverRadioButton));
        cookiesNeverRadioButton.click();
        return this;
    }

    public Object verifyCookiesWillExpireNever ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!durationValueInput.isDisplayed())
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
