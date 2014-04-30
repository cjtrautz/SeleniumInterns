package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.parts.DialogBox;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Contact_Import extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement collection;
    
    @FindBy(how = How.XPATH,
            using = "//table[@class='ussr-table-striped']")
    private WebElement table;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']//a[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-data ')]")
    private WebElement firstContact;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-import-wizard-target-verify-next-button ')]")
    private WebElement nextButton;
    
    @FindBy(how = How.XPATH,
            using = "//a[contains(concat(' ', normalize-space(@class), ' '),' ussr-form-input-radiobutton ') and @value='2']")
    private WebElement createNewEntryRadioButton;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-import-wizard-target-map-next-button ')]")
    private WebElement nextMapButton;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-import-wizard-target-rule-next-button ')]")
    private WebElement nextRuleButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' checkbox_confirm_1 ')]//span")
    private WebElement checkBox1;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' checkbox_confirm_2 ')]//span")
    private WebElement checkBox2;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' checkbox_confirm_3 ')]//span")
    private WebElement checkBox3;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' checkbox_confirm_4 ')]//span")
    private WebElement checkBox4;
    
    @FindBy(how = How.XPATH,
        using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-import-wizard-target-merge-next-button ')]")
    private WebElement nextButtonMerge;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]/div[contains(., 'IMPORT SETTINGS: STEP 3 OF 5')]")
    private WebElement step3;

    public Contact_Import clickFirstContactList ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(collection));
        //wait.until(ExpectedConditions.visibilityOf(table));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tfoot[@class='ussr-component-collection-foot']")));
        wait.until(ExpectedConditions.visibilityOf(firstContact));
        firstContact.click();
        return this;
        
    }

    public Contact_Import clickNext ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-import-wizard-target-verify-next-button ')]")));
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
        return this;
        
    }

    public Contact_Import clickNextMerge ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(step3));
        wait.until(ExpectedConditions.visibilityOf(nextButtonMerge));
        nextButtonMerge.click();
        return this;
    }

    public Contact_Import checkUsageAgreement ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(checkBox1));
        checkBox1.click();
        wait.until(ExpectedConditions.visibilityOf(checkBox2));
        checkBox2.click();
        wait.until(ExpectedConditions.visibilityOf(checkBox3));
        checkBox3.click();
        wait.until(ExpectedConditions.visibilityOf(checkBox4));
        checkBox4.click();
        return this;
    }

    public Contact_Import clickNextAddRules ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(nextMapButton));
        nextMapButton.click();
        return this;
    }

    public Contact_ListAll clickFinish ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(nextRuleButton));
        nextRuleButton.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }

    public Contact_Import clickCreateNewEntry ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createNewEntryRadioButton));
        createNewEntryRadioButton.click();
        return this;
        
    }
    
}
