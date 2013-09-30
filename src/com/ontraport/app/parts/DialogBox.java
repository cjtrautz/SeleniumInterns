package com.ontraport.app.parts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.pages.WordPress_TypeSelection;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class DialogBox extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]")
    private WebElement uiDialogBox;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]//span[text()='OK' or text()='Ok' or text()='ok']")
    private WebElement uiOk;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]//span[text()='Cancel']")
    private WebElement uiCancel;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]//span[contains(concat(' ', normalize-space(@class), ' '), ' ussr-icon-close ')]")
    private WebElement uiClose;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]//span[text()='Close']")
    private WebElement uiClose2;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-chrome-panel-action-drawer-content ')]")
    private WebElement actionPane;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-fieldedit-sub-location-name ')]//input")
    private WebElement fieldName;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-fieldedit-sub-location-type ')]//button")
    private WebElement fieldTypeDropDown;
    @FindBy(how = How.XPATH,
            using = "//ul[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-drilldownselect-ul ')]")
    private WebElement fieldDropDownPane;
    @FindBy(how = How.XPATH,
            using = "//div[@class='ussr-dialog-buttons']/button[span[contains(text(), 'Save')]]")
    private WebElement saveButton;
    @FindBy(how = How.XPATH,
            using = "//label[contains(text(), 'Add Option')]/following-sibling::div/input")
    private WebElement addOptionInput;
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-pane-field-editor-new-section']//span[normalize-space(text())='add new section']")
    private WebElement newSectionButton;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' component-custom-value-creator-target-save-button ')]/span[contains(text(), 'Add')]")
    private WebElement addButton;
    @FindBy(how = How.XPATH,
            using = "//div[text()='Errors have prevented you from advancing to the next step. Please make sure you have accepted (checked) all the terms of the Usage Agreement']")
    private WebElement usageAgreement;
    @FindBy(how = How.XPATH,
            using = "//input[@name='domaintype']")
    private WebElement hostedDomainRadioButton;
    @FindBy(how = How.XPATH,
            using = "//div[@style='margin-bottom: 10px;']//input[@type='TEXT']")
    private WebElement hostedDomainInput;
    @FindBy(how = How.XPATH,
            using = "//input[@value='Accept' and @class='btn2']")
    private WebElement buttonAccept;
    @FindBy(how = How.XPATH,
            using = "//div[@class='create_button_class']//td[text()='Shape']")
    private WebElement shapeButton;
    @FindBy(how = How.XPATH,
            using = "//a[text()='Upload']")
    private WebElement uploadTab;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-file-uploader-target-url ')]//input")
    private WebElement urlInput;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-file-uploader-target-go-button ')]")
    private WebElement uploadGo;
    @FindBy(how = How.XPATH,
            using = "//a[text()='Browse']")
    private WebElement browseTab;
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;
    @FindBy(how = How.XPATH,
            using = "//thead[@class='ussr-component-collection-head']/tr/th")
    private WebElement uiSelectAll;
    
    public DialogBox clickOk ()
    {
        waitForAjax(driver, 20);
        uiOk.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
    }
    public DialogBox clickCancel ()
    {
        waitForAjax(driver, 20);
        uiCancel.click();
        return this;
    }
    public DialogBox clickClose ()
    {
        waitForAjax(driver, 20);
        uiClose.click();
        return this;
    }
    public Boolean isDisplayed ()
    {
        waitForAjax(driver, 20);
        try
        {
            if (uiDialogBox.isDisplayed())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
    public DialogBox enterFieldName ( String string )
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(fieldName));
        fieldName.sendKeys(string);
        return this;
        
    }
    public DialogBox clickFieldTypeDropDown ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(fieldTypeDropDown));
        fieldTypeDropDown.click();
        wait(5).until(ExpectedConditions.visibilityOf(fieldDropDownPane));
        return this;
        
    }
    public DialogBox clickSave (String string)
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait(5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']"))));
        return this;
        
    }
    public DialogBox selectField ( String string )
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(fieldDropDownPane));
        wait(5).until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[contains(text(), '" + string + "')]")));
        fieldDropDownPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")).click();
        return this;
        
    }
    public DialogBox enterAddOption ( String string )
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(addOptionInput));
        addOptionInput.sendKeys(string);
        return this;
        
    }
    public DialogBox clickAdd ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(addButton));
        addButton.click();
        return this;
        
    }
    public DialogBox verifyUsageAgreement ()
    {
        waitForAjax(driver, 20);
        try
        {
            if (uiDialogBox.isDisplayed())
            {
                
            }
            else
            {
                return null;
            }
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
    try
    {
        if (usageAgreement.isDisplayed())
        {
            return this;
        }
        else
        {
            return null;
        }
    }
    catch (NoSuchElementException e)
    {
        return null;
    }
    }
    public DialogBox clickUseHostedDomain ()
    {
        waitForAjax(driver, 20);
        hostedDomainRadioButton.click();
        return this;
        
    }
    public DialogBox enterHostedDomainName ( String string )
    {
        waitForAjax(driver, 20);
        hostedDomainInput.sendKeys(string);
        return this;
        
    }
    public DialogBox clickAccept ()
    {
        waitForAjax(driver, 20);
        buttonAccept.click();
        return this;
        
    }
    public DialogBox clickShape ()
    {
        waitForAjax(driver, 20);
        shapeButton.click();
        return this;
        
    }
    public WordPress_ListAll clickClose2 ()
    {
        waitForAjax(driver, 20);
        uiClose2.click();
        return PageFactory.initElements(driver, WordPress_ListAll.class);
    }
    public DialogBox clickUpload ()
    {
        waitForAjax(driver, 20);
        uploadTab.click();
        return this;
        
    }
    public DialogBox enterURL ( String string )
    {
        waitForAjax(driver, 20);
        urlInput.click();
        return this;
        
    }
    public DialogBox clickGo ()
    {
        waitForAjax(driver, 20);
        uploadGo.click();
        return this;
        
    }
    public DialogBox clickBrowse ()
    {
        waitForAjax(driver, 20);
        browseTab.click();
        return this;
        
    }
    public DialogBox verifyAttachement ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']"));
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
    public DialogBox selectAll ()
    {

        AbstractPart.waitForAjax(driver, 20);
        uiSelectAll.click();
        return this;
        
    }
    public Object verifyNoAttachement ()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
