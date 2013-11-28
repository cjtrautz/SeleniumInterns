package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
            using = "//label[contains(text(), 'Program Name')]/following-sibling::div/input")
    private WebElement programNameEditInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Program Name')]/following-sibling::button")
    private WebElement programNameEditSave;
    
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
            using = "//label[contains(text(), 'Show affiliates information on declined charges')]/following-sibling::div/a")
    private WebElement affiliatesInputCheckbox;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Show affiliates information on declined charges')]/following-sibling::button")
    private WebElement affiliatesSave;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Show affiliates complete purchase history for each referred client')]/following-sibling::div/span")
    private WebElement completePurchase;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Show affiliates complete purchase history for each referred client')]/following-sibling::div/a")
    private WebElement completePurchaseCheckBox;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Show affiliates complete purchase history for each referred client')]/following-sibling::button")
    private WebElement completePurchaseSave;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Notify someone when affiliate has earned a commission with an email')]/following-sibling::div")
    private WebElement notifyInput;

    @FindBy(
            how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-drilldownselect-sub-menu-link ')]")
    private WebElement customEmail;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-custom-value-creator-target-component ')]//input")
    private WebElement customEmailInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-custom-value-creator-target-save-button ')]//span")
    private WebElement selectButton;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-chrome-panel-pane-header-back']")
    private WebElement back;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;

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

    public AffiliateProgram_Edit clickProgramName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(programNameInput));
        programNameInput.click();
        return this;
    }

    public AffiliateProgram_Edit enterNewProgramName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(programNameEditInput));
        programNameEditInput.sendKeys(string);
        return this;
    }

    public AffiliateProgram_Edit clickSaveProgramName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(programNameEditSave));
        programNameEditSave.click();
        return this;
    }

    public AffiliateProgram_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (AffiliateProgram_ListAll) new AffiliateProgram_ListAll().init();
    }

    public AffiliateProgram_Edit clickProgramType ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(programTypeDropDownInput));
        programTypeDropDownInput.click();
        return this;
    }

    public AffiliateProgram_Edit selectProgramType ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }

    public AffiliateProgram_Edit clickinformation ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(informationInput));
        informationInput.click();
        return this;
    }

    public AffiliateProgram_Edit clickShowDeclined ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(affiliatesInput));
        affiliatesInput.click();
        return this;
    }

    public AffiliateProgram_Edit checkShowDeclined ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(affiliatesInputCheckbox));
        affiliatesInputCheckbox.click();
        return this;
    }

    public AffiliateProgram_Edit clickSaveShowDeclined ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(affiliatesSave));
        affiliatesSave.click();
        return this;
    }

    public AffiliateProgram_Edit clickShowPurchaseHistory ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(completePurchase));
        completePurchase.click();
        return this;
    }

    public AffiliateProgram_Edit checkShowPurchaseHistory ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(completePurchaseCheckBox));
        completePurchaseCheckBox.click();
        return this;
    }

    public AffiliateProgram_Edit clickSavePurchaseHistory ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(completePurchaseSave));
        completePurchaseSave.click();
        return this;
    }

    public AffiliateProgram_Edit clickNotify ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(notifyInput));
        notifyInput.click();
        return this;
    }

    public AffiliateProgram_Edit createCustomEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(customEmail));
        customEmail.click();
        return this;
    }

    public AffiliateProgram_Edit enterCustomEmail (String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(customEmailInput));
        customEmailInput.click();
        customEmailInput.clear();
        customEmailInput.sendKeys(string);
        return this;
    }

    public AffiliateProgram_Edit clickSelect ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(selectButton));
        selectButton.click();
        return this;
    }

}
