package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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
            using = "//tbody[@class='ussr-component-collection-body']/tr//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-collection-cell-type-text ')]/span/a[@class='ussr-component-collection-cell-data']")
    private WebElement firstContact;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-import-wizard-target-verify-next-button ')]")
    private WebElement nextButton;
    
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
        wait.until(ExpectedConditions.visibilityOf(table));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tfoot[@class='ussr-component-collection-foot']")));
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

    public DialogBox clickNextWithFail ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(step3));
        wait.until(ExpectedConditions.visibilityOf(nextButtonMerge));
        nextButtonMerge.click();
        return PageFactory.initElements(driver, DialogBox.class);
    }
    
}
