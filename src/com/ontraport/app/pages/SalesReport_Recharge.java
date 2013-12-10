package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class SalesReport_Recharge extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//label[contains(text(), 'Retry credit cards every:')]/following-sibling::div/input")
    private WebElement retryInput;
    
    @FindBy(how = How.XPATH,
            using = "//label[contains(text(), 'Retry credit cards every:')]/following-sibling::div/input[contains(concat(' ', normalize-space(@class), ' '),' ussr-state-error ')]")
    private WebElement retryInputError;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-controls ')]/button[span[contains(text(), 'Save')]]")
    private WebElement save;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement collectionBody;

    public SalesReport_Recharge enterRetryCreditCardsEvery ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(collectionBody));
        wait.until(ExpectedConditions.visibilityOf(retryInput));
        retryInput.clear();
        retryInput.sendKeys(string);
        return this;
    }

    public SalesReport_Settings clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(collectionBody));
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (SalesReport_Settings) new SalesReport_Settings().init();
    }

    public SalesReport_Recharge verifyRetryCardEvery ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!retryInput.getAttribute("value").equals(string))
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
        return this;
    }

    public SalesReport_Recharge verifyRetryCardError ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            if(!retryInputError.isDisplayed())
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
        return this;
    }
    
}
