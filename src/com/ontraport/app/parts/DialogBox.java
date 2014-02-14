package com.ontraport.app.parts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.Login;
import com.ontraport.app.pages.User_Create;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class DialogBox extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' fe-plugin-template ')]")
    private WebElement template;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button ')]//span[text()='Use this Template']")
    private WebElement useThisTemplate;
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@id), ' '), ' confirmation1 ')]//span")
    private WebElement confirmationBox1;
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@id), ' '), ' confirmation2 ')]//span")
    private WebElement confirmationBox2;
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@id), ' '), ' confirmation3 ')]//span")
    private WebElement confirmationBox3;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-package-manager-dialog ')]//div[@class='clearfix']")
    private List<WebElement> packageOptions;
    @FindBy(how = How.XPATH,
            using = "//textarea")
    private WebElement textarea;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-form-conditions-list-actions ')]")
    private WebElement conditionActions;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-form-conditions-list-conditions ')]")
    private WebElement conditionIf;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-list-conditions ')]")
    private WebElement redirectIf;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-list-actions ')]")
    private WebElement redirectThen;
    @FindBy(how = How.XPATH,
            using = "//tbody/tr/td[contains(concat(' ', normalize-space(@class), ' '), ' fb_fieldeditor_checkbox ')]/input[@type='checkbox']")
    private WebElement firstCheckBox;
    @FindBy(how = How.XPATH,
            using = "//div[@class='ui-dialog-buttonset']//button")
    private WebElement insertFields;
    @FindBy(how = How.XPATH,
            using = "//input[@value='Start with a blank page']")
    private WebElement startWithBlankPage;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]")
    private WebElement uiDialogBox;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-form-conditions-add ')]")
    private WebElement addFormConditions;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-redirect-conditions-add ')]")
    private WebElement addRedirect;
    @FindBy(how = How.XPATH,
            using = "//input[contains(concat(' ', normalize-space(@class), ' '), ' redirect-url ')]")
    private WebElement redirectInput;
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-condition-field ')]//select")
    private WebElement ifFieldDropDown;
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-condition-opertator ')]//select")
    private WebElement ifOperatorDropDown;
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-outcome-action ')]//select")
    private WebElement thenOutcomeActionDropDown;
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-outcome-field ')]//select")
    private WebElement thenOutcomeFieldDropDown;
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-condition-value ')]//input")
    private WebElement ifValueInput;
    @FindBy(how = How.XPATH,
            using = "//table[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-condition ')]")
    private WebElement ifEvents;
    @FindBy(how = How.XPATH,
            using = "//table[contains(concat(' ', normalize-space(@class), ' '), ' fe-design-conditions-outcome ')]")
    private WebElement thenEvents;
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '), ' target-edit ')]//a[@class='ussr-form-input ussr-form-input-type-checkbox-checked']")
    private WebElement editChecked;
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '), ' target-edit ')]//a[@class='ussr-form-input']")
    private WebElement editUnChecked;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]//span[contains(text(), 'Yes clear all')]")
    private WebElement yesClearAll;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]//span[contains(text(), 'Yes')]")
    private WebElement yes;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-carousel-target-delete-button ')]")
    private WebElement deleteButton;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-carousel-target-cancel-button ')]")
    private WebElement cancelButton;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ussr-component-carousel-target-accept-button ')]")
    private WebElement uiInsertImage;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]//input")
    private WebElement uiInput;
    @FindBy(how = How.XPATH,
            using = "//ul[contains(concat(' ', normalize-space(@class), ' '), ' ussr-componet-image-selector-target-box-ul ')]/li")
    private WebElement images;
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
            using = "//div[@class='ussr-dialog-buttons']//button[span[contains(text(), 'save') or contains(text(), 'Save')]]")
    private WebElement saveButton2;
    @FindBy(how = How.XPATH,
            using = "//div[@class='ui-dialog-buttonset']//button[span[contains(text(), 'save') or contains(text(), 'Save')]]")
    private WebElement saveButton3;
    @FindBy(how = How.XPATH,
            using = "//div[@class='ussr-dialog-buttons']//button[span[contains(text(), 'Send')]]")
    private WebElement sendButton;
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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog-buttons ')]//button[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")
    private WebElement acceptButton;
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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ') and not(contains(concat(' ', normalize-space(@style), ' '), ' display: none; '))]//input[@type='BUTTON' and @value='Accept' and not(contains(concat(' ', normalize-space(@class), ' '), ' btn2 '))]")
    private WebElement buttonAcceptHTML;
    @FindBy(how = How.XPATH,
            using = "//input[@value='Accept' and @type='BUTTON']")
    private List<WebElement> buttonAcceptColor;
    @FindBy(how = How.XPATH,
            using = "//div[@class='blue_box']/input")
    private List<WebElement> widthAndHeight;
    @FindBy(how = How.XPATH,
            using = "//div[@class='create_button_class']//td[text()='Shape']")
    private WebElement shapeButton;
    @FindBy(how = How.XPATH,
            using = "//div[@class='create_button_class']//td[text()='Image']")
    private WebElement imageButton;
    @FindBy(how = How.XPATH,
            using = "//div[@class='create_button_class']//td[text()='Gradient']")
    private WebElement gradientButton;
    @FindBy(how = How.XPATH,
            using = "//div[@class='create_button_class']//td[text()='Text Area']")
    private WebElement textAreaButton;
    @FindBy(how = How.XPATH,
            using = "//div[@class='create_button_class']//td[text()='HTML']")
    private WebElement htmlButton;
    @FindBy(how = How.XPATH,
            using = "//div[@class='create_button_class']//td[text()='Form']")
    private WebElement formButton;
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
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' sender_new_email ')]//input")
    private WebElement newEmailInput;
    @FindBy(how = How.XPATH,
            using = "//div[@class='ussr-dialog-buttons']//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]/span[text()='Add Email']")
    private WebElement addEmail;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]//button[span[text()='Agree']]")
    private WebElement uiAgree;
    @FindBy(how = How.XPATH,
            using = "//label[text()='Package Code']/following-sibling::div/input")
    private WebElement packageCodeInput;
    @FindBy(how = How.XPATH,
            using = "//div[contains(text(), 'Enter Name')]/input")
    private WebElement enterNameInput;
    @FindBy(how = How.XPATH,
            using = "//input[@placeholder='Enter product']")
    private WebElement enterProduct;
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@class), ' '), ' orderform-objectselector-list-item-add-new ')]")
    private WebElement createNew;
    @FindBy(how = How.XPATH,
            using = "//input[contains(concat(' ', normalize-space(@class), ' '), ' orderform-objectselector-create-new-name ')]")
    private WebElement createNewInput;
    @FindBy(how = How.XPATH,
            using = "//div[@class='ontraport_grid_offer']")
    private WebElement grid;
    @FindBy(how = How.XPATH,
            using = "//input[@name='price']")
    private WebElement priceInput;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ui-button ')]/span[text()='Done']")
    private WebElement done;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ') and contains(., 'Done')]")
    private WebElement done2;
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'R:')]/following-sibling::td/input")
    private WebElement rInput;
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'G:')]/following-sibling::td/input")
    private WebElement gInput;
    @FindBy(how = How.XPATH,
            using = "//td[contains(text(), 'B:')]/following-sibling::td/input")
    private WebElement bInput;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ') and not(contains(concat(' ', normalize-space(@style), ' '), ' display: none; '))]//td[contains(text(), 'R:')]/following-sibling::td/input")
    private WebElement rInputLP;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ') and not(contains(concat(' ', normalize-space(@style), ' '), ' display: none; '))]//td[contains(text(), 'G:')]/following-sibling::td/input")
    private WebElement gInputLP;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ') and not(contains(concat(' ', normalize-space(@style), ' '), ' display: none; '))]//td[contains(text(), 'B:')]/following-sibling::td/input")
    private WebElement bInputLP;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ') and not(contains(concat(' ', normalize-space(@style), ' '), ' display: none; '))]//input[@value='Accept' and @type='BUTTON']")
    private WebElement buttonAcceptColorLP;
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownSelect;
    @FindBy(how = How.XPATH,
            using = "//ul[contains(concat(' ', normalize-space(@class), ' '), ' orderform-objectselector-list ')]")
    private WebElement productDrillDownSelect;
    @FindBy(how = How.XPATH,
            using = "//input[@name='domain']")
    private WebElement subdomainInput;
    @FindBy(how = How.XPATH,
            using = "//input[@name='reply_to']")
    private WebElement repyToInput;
    @FindBy(how = How.XPATH,
            using = "//input[@name='bussname']")
    private WebElement businessNameInput;
    @FindBy(how = How.XPATH,
            using = "//input[@name='buss_add']")
    private WebElement businessAddressInput;
    @FindBy(how = How.XPATH,
            using = "//input[@name='buss_city']")
    private WebElement businessCityInput;
    @FindBy(how = How.XPATH,
            using = "//input[@name='buss_zip']")
    private WebElement businessZipInput;
    @FindBy(how = How.XPATH,
            using = "//input[@value='Submit']")
    private WebElement submitAccount;
    @FindBy(how = How.XPATH,
            using = "//button[contains(., 'Cancel Account')]")
    private WebElement cancelAccount;
    
    public DialogBox clickOk ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiOk));
        uiOk.click();
        //wait(5).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(actionPane)));
        return this;
    }
    public DialogBox clickCancel ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiCancel));
        uiCancel.click();
        return this;
    }
    public DialogBox clickClose ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiClose));
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
        wait(30).until(ExpectedConditions.visibilityOf(fieldName));
        fieldName.sendKeys(string);
        return this;
        
    }
    public DialogBox clickFieldTypeDropDown ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(fieldTypeDropDown));
        fieldTypeDropDown.click();
        wait(30).until(ExpectedConditions.visibilityOf(fieldDropDownPane));
        return this;
        
    }
    public DialogBox clickSave (String string)
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newSectionButton);
        wait(30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[normalize-space(text())='" + string + "']"))));
        return this;
        
    }
    public DialogBox clickSave ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(saveButton2));
        saveButton2.click();
        return this;
        
    }
    public DialogBox selectField ( String string )
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(fieldDropDownPane));
        wait(5).until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[contains(text(), '" + string + "')]")));
        fieldDropDownPane.findElement(By.xpath(".//li/div[normalize-space(text())='" + string + "']")).click();
        return this;
        
    }
    public DialogBox enterAddOption ( String string )
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(addOptionInput));
        addOptionInput.sendKeys(string);
        return this;
        
    }
    public DialogBox clickAdd ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(addButton));
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
        wait(30).until(ExpectedConditions.visibilityOf(hostedDomainRadioButton));
        hostedDomainRadioButton.click();
        return this;
        
    }
    public DialogBox enterHostedDomainName ( String string )
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(hostedDomainInput));
        hostedDomainInput.click();
        hostedDomainInput.clear();
        hostedDomainInput.sendKeys(string);
        return this;
        
    }
    public DialogBox clickAccept ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(acceptButton));
        acceptButton.click();
        return this;
        
    }
    public DialogBox clickShape ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(shapeButton));
        shapeButton.click();
        return this;
        
    }
    public WordPress_ListAll clickClose2 ()
    {
        waitForAjax(driver, 60);
        wait(30).until(ExpectedConditions.visibilityOf(uiClose2));
        uiClose2.click();
        return (WordPress_ListAll) new WordPress_ListAll().init();
    }
    public DialogBox clickUpload ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uploadTab));
        uploadTab.click();
        return this;
        
    }
    public DialogBox enterURL ( String string )
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(urlInput));
        urlInput.click();
        urlInput.sendKeys(string);
        return this;
        
    }
    public DialogBox clickGo ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uploadGo));
        uploadGo.click();
        return this;
        
    }
    public DialogBox clickBrowse ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(browseTab));
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
            uiCollectionBody.findElement(By.xpath(".//a[contains(normalize-space(text()), '" + string + "')]"));
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
        wait(30).until(ExpectedConditions.visibilityOf(uiSelectAll));
        uiSelectAll.click();
        return this;
        
    }
    public DialogBox verifyNoAttachement ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS);
            emptyCell.isDisplayed();
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
    public DialogBox enterEmailAddress ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(newEmailInput));
        newEmailInput.sendKeys(string);
        return this;
        
    }
    public DialogBox addEmail (String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(addEmail));
        addEmail.click();
        wait(30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[text()='" + string + "']"))));
        return this;
        
    }
    public User_Create clickAgree ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiAgree));
        uiAgree.click();
        return (User_Create) new User_Create().init();
    }
    public User_Create clickAgreeUser ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiAgree));
        Actions action = new Actions(driver);
        action.click(uiAgree).build().perform();
        action.clickAndHold(uiAgree).build().perform();
        action.release(uiAgree).build().perform();
        uiAgree.click();
        action.doubleClick(uiAgree).build().perform();
        return (User_Create) new User_Create().init();
    }
    public DialogBox verifyPopUpAddPackage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS);
            if(uiDialogBox.isDisplayed()!=true)
            {
                driver.manage()
                .timeouts()
                .implicitlyWait(AbstractSuite.DEFAULT_WAIT, TimeUnit.SECONDS);
                return null;
            }
            if(packageCodeInput.isDisplayed()!=true)
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
    public DialogBox enterName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(enterNameInput));
        enterNameInput.sendKeys(string);
        return this;
        
    }
    public DialogBox clickProductName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(enterProduct));
        enterProduct.click();
        return this;
    }
    public DialogBox selectCreateNew ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(createNew));
        createNew.click();
        return this;
    }
    public DialogBox enterProductName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(createNewInput));
        createNewInput.sendKeys(string);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.RETURN).build().perform();
        return this;
    }
    public DialogBox clickGrid ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(grid));
        grid.click();
        return this;
    }
    
    public DialogBox enterPrice ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(priceInput));
        priceInput.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.SHIFT).build().perform();
        AbstractPart.waitForAjax(driver, 20);
        action.sendKeys(Keys.LEFT).build().perform();
        AbstractPart.waitForAjax(driver, 20);
        action.sendKeys(Keys.LEFT).build().perform();
        AbstractPart.waitForAjax(driver, 20);
        action.sendKeys(Keys.LEFT).build().perform();
        AbstractPart.waitForAjax(driver, 20);
        action.sendKeys(Keys.LEFT).build().perform();
        AbstractPart.waitForAjax(driver, 20);
        action.keyUp(Keys.SHIFT).build().perform();
        priceInput.sendKeys(Keys.BACK_SPACE + string);
        return this;
    }
    public DialogBox clickDone ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(done));
        done.click();
        return this;
        
    }
    public DialogBox enterEmail ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiInput));
        uiInput.sendKeys(string);
        return this;
    }
    public DialogBox clickSend ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(sendButton));
        sendButton.click();
        return this;
    }
    public DialogBox clickTextArea ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(textAreaButton));
        textAreaButton.click();
        return this;
        
    }
    public DialogBox enterRValue ( String i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(rInput));
        rInput.click();
        rInput.clear();
        rInput.click();
        rInput.sendKeys(i);
        return this;
    }
    public DialogBox enterGValue ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(gInput));
        gInput.click();
        gInput.clear();
        gInput.click();
        gInput.sendKeys(string);
        return this;
    }
    public DialogBox enterBValue ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(bInput));
        bInput.click();
        bInput.clear();
        bInput.click();
        bInput.sendKeys(string);
        return this;
    }
    public DialogBox enterRValueLP ( String i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(rInputLP));
        rInputLP.click();
        rInputLP.clear();
        rInputLP.sendKeys(i);
        return this;
    }
    public DialogBox enterGValueLP ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(gInputLP));
        gInputLP.click();
        gInputLP.clear();
        gInputLP.sendKeys(string);
        return this;
    }
    public DialogBox enterBValueLP ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(bInputLP));
        bInputLP.click();
        bInputLP.clear();
        bInputLP.sendKeys(string);
        return this;
    }
    public DialogBox clickAcceptColor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(buttonAcceptColor.get(0)));
        buttonAcceptColor.get(0).click();
        return this;
    }
    public DialogBox clickAcceptColorLP ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(buttonAcceptColorLP));
        buttonAcceptColorLP.click();
        return this;
    }
    public DialogBox clickAcceptColor (int index)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(buttonAcceptColor.get(index)));
        buttonAcceptColor.get(index).click();
        return this;
    }
    public DialogBox clickGradient ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(gradientButton));
        gradientButton.click();
        return this;
    }
    public DialogBox clickPicture ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(imageButton));
        imageButton.click();
        return this;
    }
    public DialogBox selectPicture ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(images));
        images.findElement(By.xpath(".//img")).click();
        return this;
    }
    public DialogBox selectPicture (String here)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' ussr-componet-image-selector-target-box-ul ')]/li/img[contains(@src, '" + here + "')]"))));
        driver.findElement(By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' ussr-componet-image-selector-target-box-ul ')]/li/img[contains(@src, '" + here + "')]")).click();
        return this;
    }
    public DialogBox insertSelectedImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(uiInsertImage));
        uiInsertImage.click();
        return this;
    }
    public DialogBox clickDelete ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
        return this;
    }
    public DialogBox clickCancelPicture ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(cancelButton));
        cancelButton.click();
        return this;
    }
    public DialogBox enterHeight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(widthAndHeight.get(1)));
        widthAndHeight.get(1).clear();
        widthAndHeight.get(1).sendKeys(string);
        return this;
    }
    public DialogBox enterWidth ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(widthAndHeight.get(0)));
        widthAndHeight.get(0).clear();
        widthAndHeight.get(0).sendKeys(string);
        return this;
    }
    public DialogBox clickStartWithBlankPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(startWithBlankPage));
        startWithBlankPage.click();
        return this;
    }
    public DialogBox clickHTML ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(htmlButton));
        htmlButton.click();
        return this;
    }
    public DialogBox enterHTML ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(textarea));
        textarea.sendKeys(string);
        return this;
    }
    public DialogBox clickAcceptHTML ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(buttonAcceptHTML));
        buttonAcceptHTML.click();
        return this;
    }
    public DialogBox clickForm ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(formButton));
        formButton.click();
        return this;
    }
    public DialogBox uncheckCanEdit ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(editChecked));
        editChecked.click();
        return this;
    }
    public DialogBox verifyUncheckedCanEdit ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!editUnChecked.isDisplayed())
            {
                return null;
            }
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
        return this;
    }
    public DialogBox checkCanEdit ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(editUnChecked));
        editUnChecked.click();
        return this;
    }
    public DialogBox verifyCheckedCanEdit ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!editChecked.isDisplayed())
            {
                return null;
            }
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
        return this;
    }
    public String getPasswordCredentials ()
    {
        //wait(40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ussr-state-loading green']")));
        AbstractPart.waitForAjax(driver, 40);
        wait(30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='ontraport_components_dialog']/following-sibling::div"))));
        String stuff = driver.findElement(By.xpath("//div[@class='ontraport_components_dialog']/following-sibling::div")).getText();
        String delims= "[ \n]+";
        String[] tokens = stuff.split(delims);
        System.out.println(tokens[34]);
        return tokens[34];
    }
    public DialogBox clickTagDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(0)));
        packageOptions.get(0).findElement(By.xpath(".//button")).click();
        return this;
    }
    public DialogBox selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", drillDownSelect.findElement(By.xpath(".//li[contains(., '" + string + "')]")));
        drillDownSelect.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }
    public DialogBox selectProductDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(productDrillDownSelect));
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", productDrillDownSelect.findElement(By.xpath("//li[contains(., '" + string + "')]")));
        wait(30).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(., '" + string + "')]"))));
        driver.findElement(By.xpath("//li[contains(., '" + string + "')]")).click();
        return this;
    }
    public DialogBox clickAddTag ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(0)));
        packageOptions.get(0).findElement(By.xpath(".//span[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")).click();
        return this;
    }
    public DialogBox clickMessageDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(1)));
        packageOptions.get(1).findElement(By.xpath(".//button")).click();
        return this;
    }
    public DialogBox clickAddMessage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(1)));
        packageOptions.get(1).findElement(By.xpath(".//span[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")).click();
        return this;
    }
    public DialogBox clickSequenceDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(2)));
        packageOptions.get(2).findElement(By.xpath(".//button")).click();
        return this;
    }
    public DialogBox clickAddSequence ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(2)));
        packageOptions.get(2).findElement(By.xpath(".//span[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")).click();
        return this;
    }
    public DialogBox clickLandingPageDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(3)));
        packageOptions.get(3).findElement(By.xpath(".//button")).click();
        return this;
    }
    public DialogBox clickFormsDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(4)));
        packageOptions.get(4).findElement(By.xpath(".//button")).click();
        return this;
    }
    public DialogBox clickAddLandingPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(3)));
        packageOptions.get(3).findElement(By.xpath(".//span[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")).click();
        return this;
    }
    public DialogBox clickAddForms ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(4)));
        packageOptions.get(4).findElement(By.xpath(".//span[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")).click();
        return this;
    }
    public DialogBox clickRulesDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(5)));
        packageOptions.get(5).findElement(By.xpath(".//button")).click();
        return this;
    }
    public DialogBox clickAddRules ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(5)));
        packageOptions.get(5).findElement(By.xpath(".//span[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")).click();
        return this;
    }
    public DialogBox clickSectionDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(6)));
        packageOptions.get(6).findElement(By.xpath(".//button")).click();
        return this;
    }
    public DialogBox clickAddSections ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(6)));
        packageOptions.get(6).findElement(By.xpath(".//span[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")).click();
        return this;
    }
    public DialogBox clickStaffDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(7)));
        packageOptions.get(7).findElement(By.xpath(".//button")).click();
        return this;
    }
    public DialogBox clickAddStaff ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(packageOptions.get(7)));
        packageOptions.get(7).findElement(By.xpath(".//span[contains(concat(' ', normalize-space(@class), ' '), ' ontraport_components_button ')]")).click();
        return this;
    }
    public DialogBox clickDonePackage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(done2));
        done2.click();
        return this;
    }
    public DialogBox clickYesClearAll ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(yesClearAll));
        yesClearAll.click();
        return this;
    }
    public DialogBox clickYes ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(yes));
        yes.click();
        return this;
    }
    public DialogBox enterSubDomain ( String string )
    {
        AbstractPart.waitForAjax2(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(subdomainInput));
        subdomainInput.click();
        subdomainInput.sendKeys(string);
        return this;
    }
    public DialogBox enterReplyToName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(repyToInput));
        repyToInput.click();
        repyToInput.sendKeys(string);
        return this;
    }
    public DialogBox enterBusinessName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(businessNameInput));
        businessNameInput.click();
        businessNameInput.sendKeys(string);
        return this;
    }
    public DialogBox enterBusinessAddress ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(businessAddressInput));
        businessAddressInput.click();
        businessAddressInput.sendKeys(string);
        return this;
    }
    public DialogBox enterBusinessCity ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(businessCityInput));
        businessCityInput.click();
        businessCityInput.sendKeys(string);
        return this;
    }
    public DialogBox enterBusinessZip ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(businessZipInput));
        businessZipInput.click();
        businessZipInput.sendKeys(string);
        return this;
    }
    public Contact_ListAll clickSubmit ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(submitAccount));
        submitAccount.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }
    public DialogBox checkIKnowDeleted ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(confirmationBox1));
        confirmationBox1.click();
        return this;
    }
    public DialogBox checkIKnowNoRecovery ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(confirmationBox2));
        confirmationBox2.click();
        return this;
    }
    public DialogBox checkIKnowStopWorking ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(confirmationBox3));
        confirmationBox3.click();
        return this;
    }
    public Login clickCancelAccount ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(cancelAccount));
        cancelAccount.click();
        return (Login) new Login().init();
    }
    public DialogBox checkTitle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(firstCheckBox));
        firstCheckBox.click();
        return this;
    }
    public DialogBox clickInsertField ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(insertFields));
        insertFields.click();
        return this;
    }
    public DialogBox clickAddRuleFields ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(addFormConditions));
        addFormConditions.click();
        return this;
    }
    public DialogBox clickIfConditionDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(ifFieldDropDown));
        ifFieldDropDown.click();
        return this;
    }
    public DialogBox selectIfOption ( String string )
    {
        //struggling with selecting this drop down so combined click which highlighted option and then used the enter key to select
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(ifEvents));
        ifEvents.findElement(By.xpath(".//option[contains(text(), '" + string + "')]")).click();
        Actions action = new Actions(driver);
        wait(30).until(ExpectedConditions.visibilityOf(ifEvents.findElement(By.xpath(".//option[contains(text(), '" + string + "')]"))));
        ///action.click(ifEvents.findElement(By.xpath(".//option[contains(text(), '" + string + "')]"))).build().perform();
        action.sendKeys(Keys.RETURN).build().perform();
        //action.release().build().perform();
        return this;
    }
    public DialogBox clickIfConditionOperatorDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(ifOperatorDropDown));
        ifOperatorDropDown.click();
        return this;
    }
    public DialogBox enterIfValue ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(ifValueInput));
        ifValueInput.sendKeys(string);
        return this;
    }
    public DialogBox clickOutcomeActionDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(thenOutcomeActionDropDown));
        thenOutcomeActionDropDown.click();
        return this;
    }
    public DialogBox selectThenOption ( String string )
    {
      //struggling with selecting this drop down so combined click which highlighted option and then used the enter key to select
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(thenEvents));
        thenEvents.findElement(By.xpath(".//option[contains(text(), '" + string + "')]")).click();
        Actions action = new Actions(driver);
        wait(30).until(ExpectedConditions.visibilityOf(thenEvents.findElement(By.xpath(".//option[contains(text(), '" + string + "')]"))));
        //action.click(thenEvents.findElement(By.xpath(".//option[contains(text(), '" + string + "')]"))).build().perform();
        action.sendKeys(Keys.RETURN).build().perform();
        //action.release().build().perform();
        return this;
    }
    public DialogBox clickOutcomeFieldDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(thenOutcomeFieldDropDown));
        thenOutcomeFieldDropDown.click();
        return this;
    }
    public DialogBox clickAddRuleRedirect ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(addRedirect));
        addRedirect.click();
        return this;
    }
    public DialogBox enterRedirectSite ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(redirectInput));
        redirectInput.sendKeys(string);
        return this;
    }
    public DialogBox verifyShowOrHideFields ( String thenAction, String thenField, String ifField, String ifOperator, String ifValue )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(conditionActions.getText());
            System.out.println(thenAction + " \"" + thenField + "\"");
            String compare1 = conditionActions.getText();
            if(!compare1.equals(thenAction + " \"" + thenField + "\""))
            {
                return null;
            }
            System.out.println(conditionIf.getText());
            System.out.println("When \"" + ifField + "\" " + ifOperator + " \" " + ifValue + " \"");
            String compare2 = conditionIf.getText();
            if(!compare2.equals("When \"" + ifField + "\" " + ifOperator + " \" " + ifValue + " \""))
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        return this;
    }
    public DialogBox verifyRedirectOnSubmitRule ( String ifField, String ifOperator, String ifValue, String redirect )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(redirectIf.getText());
            System.out.println("When \"" + ifField + "\" " + ifOperator + " \"" + ifValue + "\"");
            String compare1 = redirectIf.getText();
            if(!compare1.equals("When \"" + ifField + "\" " + ifOperator + " \"" + ifValue + "\""))
            {
                return null;
            }
            System.out.println(redirectThen.getText());
            System.out.println("Redirect the user to " + redirect);
            String compare2 = redirectThen.getText();
            if(!compare2.equals("Redirect the user to " + redirect))
            {
                return null;
            }
        }
        catch(NoSuchElementException e)
        {
            return null;
        }
        return this;
    }
    public DialogBox clickSaveCondition ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(saveButton3));
        saveButton3.click();
        return this;
    }
    public DialogBox clickUseThisTemplate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(template));
        template.click();
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(useThisTemplate));
        useThisTemplate.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }


}
