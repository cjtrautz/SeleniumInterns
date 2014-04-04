package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class AffiliateProgram_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(@class, 'input_text_NAME_name')]//input")
    private WebElement programNameInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Program Type')]/following-sibling::div/button")
    private WebElement programTypeDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'How much Information on Referral do you want to share with affiliate')]/following-sibling::div/button")
    private WebElement informationDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Notify someone when affiliate has earned a commission with an email')]/following-sibling::div/button")
    private WebElement notifyDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Show affiliates information on declined charges')]/following-sibling::div/a")
    private WebElement declinedCheckbox; 
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(), 'Show affiliates complete purchase history for each referred client')]/following-sibling::div/a")
    private WebElement purchaseCheckbox; 
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@data-val='custom_val']")
    private WebElement customEmail;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-custom-value-creator-target-component ')]//input")
    private WebElement newEmailInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' component-custom-value-creator-target-save-button ')]")
    private WebElement select;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]//span[contains(text(), 'Save')]")
    private WebElement save;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-component-form_control_drill_down_select_object_selector ')]//button")
    private WebElement emailSendDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', @class, ' '),' ontraport_components_button ')]//span[contains(text(), 'Cancel')]")
    private WebElement cancel;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', @class, ' '),' ussr-pane-editor-back ')]")
    private WebElement back;

    public AffiliateProgram_Create enterProgramName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(programNameInput));
        programNameInput.click();
        programNameInput.sendKeys(string);
        return this;
    }

    public AffiliateProgram_Create clickProgramTypeDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(programTypeDropDown));
        programTypeDropDown.click();
        return this;
    }

    public AffiliateProgram_Create selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string +"')]")).click();
        return this;
    }

    public AffiliateProgram_Create clickInfoGiveDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(informationDropDown));
        informationDropDown.click();
        return this;
    }
    
    public AffiliateProgram_Create clickNotifySomeoneDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(notifyDropDown));
        notifyDropDown.click();
        return this;
    }
    
    public AffiliateProgram_Create createCustomEmail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(customEmail));
        customEmail.click();
        return this;
    }

    public AffiliateProgram_Create enterCustomEmail ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newEmailInput));
        newEmailInput.sendKeys(string);
        return this;
    }

    public AffiliateProgram_Create clickSelect ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(select));
        select.click();
        return this;
    }

    public AffiliateProgram_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (AffiliateProgram_ListAll) new AffiliateProgram_ListAll().init();
    }

    public AffiliateProgram_Create clickShowAffiliateInfoOnDelinedCharges ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(declinedCheckbox));
        declinedCheckbox.click();
        return this;
    }

    public AffiliateProgram_Create clickShowAffiliatePurchaseHistory ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(purchaseCheckbox));
        purchaseCheckbox.click();
        return this;
    }

    public AffiliateProgram_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        return (AffiliateProgram_ListAll) new AffiliateProgram_ListAll().init();
    }

    public AffiliateProgram_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (AffiliateProgram_ListAll) new AffiliateProgram_ListAll().init();
    }

    public AffiliateProgram_Create clickEmailDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(emailSendDropDown));
        emailSendDropDown.click();
        return this;
    }
    
    public Contact_Edit clickSaveToContact ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        AbstractPart.waitForAjax(driver, 20);
        return (Contact_Edit) new Contact_Edit().init();
    }
    
}
