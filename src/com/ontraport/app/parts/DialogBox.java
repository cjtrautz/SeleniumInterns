package com.ontraport.app.parts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.User_Create;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class DialogBox extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-package-manager-dialog ')]//div[@class='clearfix']")
    private List<WebElement> packageOptions;
    @FindBy(how = How.XPATH,
            using = "//textarea")
    private WebElement textarea;
    @FindBy(how = How.XPATH,
            using = "//input[@value='Start with a blank page']")
    private WebElement startWithBlankPage;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]")
    private WebElement uiDialogBox;
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
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ') and not(contains(concat(' ', normalize-space(@style), ' '), ' display: none; '))]//input[@type='BUTTON' and @value='Accept']")
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
            using = "//div[@class='ussr-dialog-buttons']//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]/span[text()='Add E-Mail']")
    private WebElement addEmail;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]//span[text()='Agree']")
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
        hostedDomainInput.sendKeys(string);
        return this;
        
    }
    public DialogBox clickAccept ()
    {
        waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(buttonAccept));
        buttonAccept.click();
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
        //priceInput.clear();
        priceInput.sendKeys(string);
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
        rInputLP.click();
        rInputLP.sendKeys(i);
        return this;
    }
    public DialogBox enterGValueLP ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(gInputLP));
        gInputLP.click();
        gInputLP.clear();
        gInputLP.click();
        gInputLP.sendKeys(string);
        return this;
    }
    public DialogBox enterBValueLP ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait(30).until(ExpectedConditions.visibilityOf(bInputLP));
        bInputLP.click();
        bInputLP.clear();
        bInputLP.click();
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
        wait(40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ussr-state-loading green']")));
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
        wait(30).until(ExpectedConditions.visibilityOf(done2));
        done2.click();
        return this;
    }

}
