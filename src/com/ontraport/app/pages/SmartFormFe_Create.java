package com.ontraport.app.pages;

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

public class SmartFormFe_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//img[@class='fe-poweredby-placeholder']")
    private WebElement getPaidImage;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' fe-design-form-wrapper ')]")
    private WebElement smartForm;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' fe-title ')]")
    private WebElement smartFormName;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button-text-icon-primary ')]//span[text()='Sell Products']")
    private WebElement sellProducts;
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' moonray-form-payments-element ')]//button[contains(concat(' ', normalize-space(@class), ' '),' orderform-action-addproducts ')]")
    private WebElement addProducts;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' orderform-action-paymentmethod ')]")
    private WebElement addPayment;
    @FindBy(how = How.XPATH,
            using = "//div[contains(text(),'Payment Tax and Invoice settings')]/following-sibling::div//button[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-button-menu-toggle ')]")
    private WebElement gatewayDropDown;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' fe-control-save ')]")
    private WebElement save;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button-text-icon-primary ')]//span[text()='Add Field']")
    private WebElement addField;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button-text-icon-primary ')]//span[text()='Add Content']")
    private WebElement addContent;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button-text-icon-primary ')]//span[text()='Get Paid']")
    private WebElement getPaid;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button-text-icon-primary ')]//span[text()='Captcha']")
    private WebElement captcha;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button-text-icon-primary ')]//span[text()='Add Separator']")
    private WebElement addSeparator;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button-text-icon-primary ')]//span[text()='Conditions']")
    private WebElement conditions;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ui-button-text-icon-primary ')]//span[text()='Templates']")
    private WebElement template;
    @FindBy(how = How.XPATH,
            using = "//a[@href='#fe-mode-settings']")
    private WebElement settings;
    @FindBy(how = How.XPATH,
            using = "//input[@value='single']")
    private WebElement singlOptIn;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' orderform-action-addshipping ')]")
    private WebElement addShippingMethod;
    @FindBy(how = How.XPATH,
            using = "//input[@name='submit-button']")
    private WebElement submitButton;
    @FindBy(how = How.XPATH,
            using = "//input[contains(concat(' ', normalize-space(@class), ' '),' orderform-objectselector-search ')]")
    private WebElement shippingInputSearch;
    @FindBy(how = How.XPATH,
            using = "//input[contains(concat(' ', normalize-space(@class), ' '),' orderform-objectselector-search ')]")
    private WebElement taxInputSearch;
    @FindBy(how = How.XPATH,
            using = "//li[contains(concat(' ', normalize-space(@class), ' '),' orderform-objectselector-list-item-add-new ')]")
    private WebElement createNew;
    @FindBy(how = How.XPATH,
            using = "//input[@name='name']")
    private WebElement nameInput;
    @FindBy(how = How.XPATH,
            using = "//input[@name='price']")
    private WebElement namePrice;
    @FindBy(how = How.XPATH,
            using = "//input[@name='rate']")
    private WebElement rateInput;
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' orderform-action-addtax ')]")
    private WebElement addTaxOption;

    public SmartFormFe_Create verifySubmitButton ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(smartForm));
        try
        {
            driver.manage()
            .timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//input[@name='submit-button']"));
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

    public SmartFormFe_Create clickSmartFormName ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(smartFormName));
        smartFormName.click();
        return this;
        
    }

    public SmartFormFe_Create clickSellProducts ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(sellProducts));
        sellProducts.click();
        return this;
    }

    public SmartFormFe_Create clickAddProduct ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", addProducts);
        wait.until(ExpectedConditions.visibilityOf(addProducts));
        addProducts.click();
        return this;
    }

    public SmartFormFe_Create clickAddPaymentMethod ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addPayment));
        addPayment.click();
        return this;
    }

    public SmartFormFe_Create clickGatewayDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gatewayDropDown));
        gatewayDropDown.click();
        return this;
    }

    public SmartFormFe_Create selectDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//li/div[contains(text(), '" + string +"')]"))));
        driver.findElement(By.xpath("//ul[@class='ussr-component-drilldownselect-ul']//li/div[contains(text(), '" + string +"')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(concat(' ', normalize-space(@class), ' '),' paymentgateway ') and contains(text(), '" + string + "')]"))));
        return this;
        
    }

    public SmartFormFe_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", save);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (SmartFormFe_ListAll) new SmartFormFe_ListAll().init();
    }

    public SmartFormFe_Create clickAddField ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addField));
        addField.click();
        return this;
    }

    public SmartFormFe_Create clickAddContent ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addContent));
        addContent.click();
        return this;
    }

    public SmartFormFe_Create clickGetPaid ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getPaid));
        getPaid.click();
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(getPaidImage));
        return this;
    }

    public SmartFormFe_Create clickCaptcha ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(captcha));
        captcha.click();
        return this;
    }

    public SmartFormFe_Create clickAddSeparator ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addSeparator));
        addSeparator.click();
        return this;
    }

    public SmartFormFe_Create clickConditions ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(conditions));
        conditions.click();
        return this;
    }

    public SmartFormFe_Create clickTemplates ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(template));
        template.click();
        return this;
    }

    public SmartFormFe_Create clickSettings ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(settings));
        settings.click();
        return this;
    }

    public SmartFormFe_Create clickSingle ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(singlOptIn));
        singlOptIn.click();
        return this;
    }

    public SmartFormFe_Create dragAndDropSubmit ( int i )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        Actions action = new Actions(driver);
        action.dragAndDropBy(submitButton, 0, i).build().perform();
        return this;
    }

    public SmartFormFe_Create clickAddShippingMethod ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addShippingMethod));
        addShippingMethod.click();
        return this;
    }

    public SmartFormFe_Create clickShippingNameInput ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(shippingInputSearch));
        shippingInputSearch.click();
        return this;
    }

    public SmartFormFe_Create clickCreateNew ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createNew));
        createNew.click();
        return this;
    }

    public SmartFormFe_Create enterShippingPrice ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(namePrice));
        namePrice.sendKeys(string);
        return this;
    }

    public SmartFormFe_Create enterShippingName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(string);
        return this;
    }

    public SmartFormFe_Create clickAddTaxOption ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(addTaxOption));
        addTaxOption.click();
        return this;
    }

    public SmartFormFe_Create clickTaxNameInput ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taxInputSearch));
        taxInputSearch.click();
        return this;
    }

    public SmartFormFe_Create enterTaxName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.click();
        nameInput.sendKeys(string);
        return this;
    }

    public SmartFormFe_Create enterTaxPercent ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(rateInput));
        rateInput.sendKeys(string);
        return this;
    }

    public SmartFormFe_Create verifyGetPaid ()
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
}
