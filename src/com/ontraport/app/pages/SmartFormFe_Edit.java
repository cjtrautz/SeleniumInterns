package com.ontraport.app.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class SmartFormFe_Edit extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@class), ' '),' fe-state-active ')]//a[@data-action='remove']")
    private WebElement activeDeleteField;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' moonray-form-element-paymentmethod ')]")
    private WebElement paymentMethod;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' orderform-action-addproducts ')]//span")
    private WebElement addOrEditProducts;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' grid-offer-element ')]")
    private WebElement productGrid;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' cart-shipping-style-widget ')]")
    private WebElement shipping;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' cart-taxes-style-widget ')]")
    private WebElement tax;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' orderform-action-addtax ')]")
    private WebElement addTaxButton;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' cart-taxes-style-widget ')]//input[contains(concat(' ', normalize-space(@class), ' '),' search ')]")
    private WebElement taxSearchBox;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' cart-taxes-style-widget ')]//li[contains(concat(' ', normalize-space(@class), ' '),' orderform-objectselector-list-item-add-new ')]")
    private WebElement createNewTax;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' cart-taxes-style-widget ')]//input[contains(concat(' ', normalize-space(@class), ' '),' orderform-objectselector-create-input ')]")
    private WebElement newTaxName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' cart-taxes-style-widget ')]//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_form_control_input_text_percent ')]//input")
    private WebElement newTaxRate;
    
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@class), ' '),' orderform-objectselector-list-item-add-new ')]/span")
    private WebElement fields;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' fe-design-form-wrapper ')]")
    private WebElement smartForm;
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' rules_transaction_success ')]//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-import-wizard-target-rule-add-button ')]")
    private WebElement addRuleOnSuccess;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' rules_transaction_success ')]//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-quick-view-object-rules-target-name ')]//input")
    private WebElement ruleName;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//button")
    private WebElement ifDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-conditions ')]//input")
    private WebElement ifDropDownInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//button")
    private WebElement thenDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' fe-control-save ')]")
    private WebElement save;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' fe-control-publish ')]")
    private WebElement publishForm;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-quick-view-object-rules-target-save ')]//span")
    private WebElement saveRule;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-rule-editor-target-actions ')]//input")
    private List<WebElement> thenInput;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#fe-mode-settings']")
    private WebElement settings;
    
    @FindBy(
            how = How.XPATH,
            using = "//input[@name='title']")
    private WebElement titleField;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='moonray-form-element-html']/p")
    private WebElement doubleClickToEdit;
    
    @FindBy(
            how = How.XPATH,
            using = "//img[@class='fe-poweredby-placeholder']")
    private WebElement getPaidImage;
    
    @FindBy(
            how = How.XPATH,
            using = "//img[@class='fe-captcha-placeholder']")
    private WebElement captcha;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='moonray-form-element-separator']")
    private WebElement separator;
    
    @FindBy(
            how = How.XPATH,
            using = "//li[@class='ui-sortable-item']//div[@class='moonray-form-element-html']")
    private WebElement template;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Tags')]/following-sibling::div//input")
    private WebElement tagDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Tags')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' component-subscription-simple-list-target ')]")
    private WebElement tagList;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Sequences')]/following-sibling::div//input")
    private WebElement sequenceDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//label[contains(text(),'Sequences')]/following-sibling::div//div[contains(concat(' ', normalize-space(@class), ' '),' component-subscription-simple-list-target ')]")
    private WebElement sequenceList;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' rules_transaction_success ')]//div[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_rule_collection ')]")
    private WebElement ruleList;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' moonray-form ')]/ul/li")
    private WebElement form;
    
    @FindBy(
            how = How.XPATH,
            using = "//iframe")
    private WebElement iframe;
    
    @FindBy(
            how = How.XPATH,
            using = "//body[contains(concat(' ', normalize-space(@class), ' '),' cke_editable ')]/p")
    private WebElement editableBody;
    
    public SmartFormFe_Edit clickSettings ()
    {
        AbstractPart.waitForAjax(driver, 30);
        //wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ussr-dialog-title ussr-helper-font-weight-bold h1']"))));
        System.out.println("here3");
        wait.until(ExpectedConditions.visibilityOf(form));
        wait.until(ExpectedConditions.visibilityOf(settings));
        settings.click();
        System.out.println("here4");
        return this;
    }

    public SmartFormFe_Edit clickTagDropDown ()
    {
        AbstractPart.waitForAjax(driver, 30);
        System.out.println("here");
        wait.until(ExpectedConditions.visibilityOf(tagDropDown));
        tagDropDown.click();
        System.out.println("here5");
        return this;
    }

    public SmartFormFe_Edit selectDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        System.out.println("here2");
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")));
        wait.until(ExpectedConditions.visibilityOf(drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]"))));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }

    public SmartFormFe_Edit clickSequenceDropDown ()
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", sequenceDropDown);
        wait.until(ExpectedConditions.visibilityOf(sequenceDropDown));
        sequenceDropDown.click();
        return this;
    }

    public SmartFormFe_Edit clickAddRule ()
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", addRuleOnSuccess);
        wait.until(ExpectedConditions.visibilityOf(addRuleOnSuccess));
        addRuleOnSuccess.click();
        return this;
    }

    public SmartFormFe_Edit enterRuleName ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ruleName);
        wait.until(ExpectedConditions.visibilityOf(ruleName));
        ruleName.sendKeys(string);
        return this;
    }

    public SmartFormFe_Edit clickIfDropDown ()
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ifDropDown);
        wait.until(ExpectedConditions.visibilityOf(ifDropDown));
        ifDropDown.click();
        return this;
    }

    public SmartFormFe_Edit clickThenDropDown ()
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", thenDropDown);
        wait.until(ExpectedConditions.visibilityOf(thenDropDown));
        thenDropDown.click();
        return this;
    }

    public SmartFormFe_Edit enterThenInput ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", thenInput.get(i-1));
        wait.until(ExpectedConditions.visibilityOf(thenInput.get(i-1)));
        thenInput.get(i-1).sendKeys(string);
        return this;
    }
    
    public SmartFormFe_Edit enterThenInputForDropDown ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", thenInput.get(i-1));
        wait.until(ExpectedConditions.visibilityOf(thenInput.get(i-1)));
        thenInput.get(i-1).sendKeys(string);
        wait.until(ExpectedConditions.visibilityOf(drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]"))));
        return this;
    }

    public SmartFormFe_Edit clickRuleSave ()
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", saveRule);
        wait.until(ExpectedConditions.visibilityOf(saveRule));
        saveRule.click();
        return this;
    }

    public SmartFormFe_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", save);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (SmartFormFe_ListAll) new SmartFormFe_ListAll().init();
    }

    public SmartFormFe_Edit verifyTag ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(tagList));
            if(!tagList.findElement(By.xpath(".//li[contains(., '" + string + "')]")).isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifySequence ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(sequenceList));
            if(!sequenceList.findElement(By.xpath(".//li[contains(., '" + string + "')]")).isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifyRule ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ruleList);
            wait.until(ExpectedConditions.visibilityOf(ruleList));
            if(!ruleList.findElement(By.xpath(".//td[contains(., '" + string + "')]")).isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit clickRule ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ruleList);
        wait.until(ExpectedConditions.visibilityOf(ruleList));
        ruleList.findElement(By.xpath(".//td[contains(., '" + string + "')]//a")).click();
        return this;
    }

    public SmartFormFe_Edit verifyIfDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(ifDropDownInput));
            if(!ifDropDownInput.getAttribute("value").equals(string))
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifyThenInput ( String string, int i )
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(thenInput.get(i-1)));
            if(!thenInput.get(i-1).getAttribute("value").equals(string))
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifyTitleField ()
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(titleField));
            if(!titleField.isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifyAddContent ()
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(doubleClickToEdit));
            if(!doubleClickToEdit.isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifyGetPaid ()
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(getPaidImage));
            System.out.println(getPaidImage.isDisplayed());
            if(!getPaidImage.isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifyCaptcha ()
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(captcha));
            if(!captcha.isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifyAddSeparator ()
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(separator));
            if(!separator.isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifyTemplate ()
    {
        AbstractPart.waitForAjax(driver, 30);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(template));
            if(!template.isDisplayed())
            {
                return null;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return this;
    }

    public SmartFormFe_Edit verifySubmitButton ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(smartForm));
        try
        {
            if(!driver.findElement(By.xpath("//input[@name='submit-button']")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public SmartFormFe_Edit clickField ( String fieldName )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(fields));
        fields.findElement(By.xpath(".//input[@name='" + fieldName + "']")).click();
        return this;
    }

    public SmartFormFe_Edit deleteActiveField ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(activeDeleteField));
        activeDeleteField.click();
        return this;
    }

    public SmartFormFe_Edit verifyField ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(fields.findElements(By.xpath(".//li")).size());
            if(fields.findElements(By.xpath(".//li")).size()!=i)
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public SmartFormFe_Edit clickPaymentMethod ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' moonray-form-element-paymentmethod ')]")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", paymentMethod);
        wait.until(ExpectedConditions.visibilityOf(paymentMethod));
        paymentMethod.click();
        return this;
    }

    public SmartFormFe_Edit verifyTaxName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!tax.findElement(By.xpath(".//span[@class='name' and contains(normalize-space(text()), '" + string + "')]")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public SmartFormFe_Edit verifyTaxRate ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!tax.findElement(By.xpath(".//span[contains(@class, 'rate') and normalize-space(text())='" + string + "']")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public SmartFormFe_Edit verifyShippingName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", shipping);
            if(!shipping.findElement(By.xpath(".//span[@class='name' and normalize-space(text())='" + string + "']")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public SmartFormFe_Edit verifyShippingPrice ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!shipping.findElement(By.xpath(".//span[contains(@class, 'rate') and normalize-space(text())='" + string + "']")).isDisplayed())
            {
                return null;
            }
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public SmartFormFe_Edit clickAddOrEditProducts ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(addOrEditProducts));
        addOrEditProducts.click();
        return this;
    }

    public SmartFormFe_Edit clickProductForm ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(productGrid));
        productGrid.click();
        return this;
    }

    public SmartFormFe_Edit clickAddTaxOption ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addTaxButton));
        addTaxButton.click();
        return this;
    }
    
    public SmartFormFe_Edit clickTaxNameInput ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taxSearchBox));
        taxSearchBox.click();
        return this;
    }

    public SmartFormFe_Edit createNewTaxOption ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createNewTax));
        createNewTax.click();
        return this;
    }
    
    public SmartFormFe_Edit enterNewTaxName (String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newTaxName));
        newTaxName.sendKeys(string);
        return this;
    }
    
    public SmartFormFe_Edit enterNewTaxRate (String string)
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newTaxRate));
        newTaxRate.sendKeys(string);
        return this;
    }
    
    public SmartFormFe_Edit clickPublishForm ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(publishForm));
        publishForm.click();
        return this;
    }
}
