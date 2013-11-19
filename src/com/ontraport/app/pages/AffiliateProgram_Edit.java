package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class AffiliateProgram_Edit extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Program Name')]/following-sibling::div/div")
    private WebElement programNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Program Type')]/following-sibling::div/span")
    private WebElement programTypeDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'How much Information on Referral do you want to share with affiliate')]/following-sibling::div/span")
    private WebElement informationInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Show affiliates information on declined charges')]/following-sibling::div/span")
    private WebElement affiliatesInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Show affiliates complete purchase history for each referred client')]/following-sibling::div/span")
    private WebElement completePurchase;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Notify someone when affiliate has earned a commission with an email')]/following-sibling::div")
    private WebElement notifyInput;

    public AffiliateProgram_Edit verifyName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!programNameInput.getText().equals(string))
                {
                return null;
                }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public AffiliateProgram_Edit verifyType ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!programTypeDropDownInput.getText().equals(string))
                {
                return null;
                }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public AffiliateProgram_Edit verifyInformation ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!informationInput.getText().equals(string))
                {
                return null;
                }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public AffiliateProgram_Edit verifyShowDeclined ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!affiliatesInput.getText().equals(string))
                {
                return null;
                }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public AffiliateProgram_Edit verifyShowPurchaseHistory ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!completePurchase.getText().equals(string))
                {
                return null;
                }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public AffiliateProgram_Edit verifyNotify ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!notifyInput.getText().equals(string))
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
