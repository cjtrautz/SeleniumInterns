package com.ontraport.app.parts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
            using = "//input[@value='Start with a blank page']")
    private WebElement startWithBlankPage;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '), ' ussr-dialog ')]")
    private WebElement uiDialogBox;
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
            using = "//div[@class='ussr-dialog-buttons']//button[span[contains(text(), 'save')]]")
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
    public DialogBox clickSave ()
    {
        waitForAjax(driver, 20);
        wait(5).until(ExpectedConditions.visibilityOf(saveButton2));
        saveButton2.click();
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
        return (WordPress_ListAll) new WordPress_ListAll().init();
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
        urlInput.sendKeys(string);
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
        newEmailInput.sendKeys(string);
        return this;
        
    }
    public DialogBox addEmail (String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        addEmail.click();
        wait(5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[text()='" + string + "']"))));
        return this;
        
    }
    public User_Create clickAgree ()
    {
        waitForAjax(driver, 20);
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
        enterNameInput.sendKeys(string);
        return this;
        
    }
    public DialogBox clickProductName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        enterProduct.click();
        return this;
    }
    public DialogBox selectCreateNew ()
    {
        AbstractPart.waitForAjax(driver, 20);
        createNew.click();
        return this;
    }
    public DialogBox enterProductName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        createNewInput.sendKeys(string);
        return this;
    }
    public DialogBox clickGrid ()
    {
        AbstractPart.waitForAjax(driver, 20);
        grid.click();
        return this;
    }
    
    public DialogBox enterPrice ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        priceInput.click();
        //priceInput.clear();
        priceInput.sendKeys(string);
        return this;
    }
    public DialogBox clickDone ()
    {
        AbstractPart.waitForAjax(driver, 20);
        done.click();
        return this;
        
    }
    public DialogBox enterEmail ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        uiInput.sendKeys(string);
        return this;
    }
    public DialogBox clickSend ()
    {
        AbstractPart.waitForAjax(driver, 20);
        sendButton.click();
        return this;
    }
    public DialogBox clickTextArea ()
    {
        AbstractPart.waitForAjax(driver, 20);
        textAreaButton.click();
        return this;
        
    }
    public DialogBox enterRValue ( String i )
    {
        AbstractPart.waitForAjax(driver, 20);
        rInput.click();
        rInput.clear();
        rInput.click();
        rInput.sendKeys(i);
        return this;
    }
    public DialogBox enterGValue ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        gInput.click();
        gInput.clear();
        gInput.click();
        gInput.sendKeys(string);
        return this;
    }
    public DialogBox enterBValue ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        bInput.click();
        bInput.clear();
        bInput.click();
        bInput.sendKeys(string);
        return this;
    }
    public DialogBox enterRValueLP ( String i )
    {
        AbstractPart.waitForAjax(driver, 20);
        rInputLP.click();
        rInputLP.clear();
        rInputLP.click();
        rInputLP.sendKeys(i);
        return this;
    }
    public DialogBox enterGValueLP ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        gInputLP.click();
        gInputLP.clear();
        gInputLP.click();
        gInputLP.sendKeys(string);
        return this;
    }
    public DialogBox enterBValueLP ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        bInputLP.click();
        bInputLP.clear();
        bInputLP.click();
        bInputLP.sendKeys(string);
        return this;
    }
    public DialogBox clickAcceptColor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        buttonAcceptColor.get(0).click();
        return this;
    }
    public DialogBox clickAcceptColorLP ()
    {
        AbstractPart.waitForAjax(driver, 20);
        buttonAcceptColorLP.click();
        return this;
    }
    public DialogBox clickAcceptColor (int index)
    {
        AbstractPart.waitForAjax(driver, 20);
        buttonAcceptColor.get(index).click();
        return this;
    }
    public DialogBox clickGradient ()
    {
        AbstractPart.waitForAjax(driver, 20);
        gradientButton.click();
        return this;
    }
    public DialogBox clickPicture ()
    {
        AbstractPart.waitForAjax(driver, 20);
        imageButton.click();
        return this;
    }
    public DialogBox selectPicture ()
    {
        AbstractPart.waitForAjax(driver, 20);
        images.findElement(By.xpath(".//img")).click();
        return this;
    }
    public DialogBox selectPicture (String here)
    {
        AbstractPart.waitForAjax(driver, 20);
        driver.findElement(By.xpath("//ul[contains(concat(' ', normalize-space(@class), ' '), ' ussr-componet-image-selector-target-box-ul ')]/li/img[contains(@src, '" + here + "')]")).click();
        return this;
    }
    public DialogBox insertSelectedImage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        uiInsertImage.click();
        return this;
    }
    public DialogBox clickDelete ()
    {
        AbstractPart.waitForAjax(driver, 20);
        deleteButton.click();
        return this;
    }
    public DialogBox clickCancelPicture ()
    {
        AbstractPart.waitForAjax(driver, 20);
        cancelButton.click();
        return this;
    }
    public DialogBox enterHeight ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        widthAndHeight.get(1).clear();
        widthAndHeight.get(1).sendKeys(string);
        return this;
    }
    public DialogBox enterWidth ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        widthAndHeight.get(0).clear();
        widthAndHeight.get(0).sendKeys(string);
        return this;
    }
    public DialogBox clickStartWithBlankPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        startWithBlankPage.click();
        return this;
    }
}
