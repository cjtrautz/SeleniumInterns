package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class MessageTemplate_TypeSelection extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/message_template/create&type=1']/button")
    private WebElement createDoubleOptIn;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/message_template/create&type=2']/button")
    private WebElement createInvoice;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/message_template/create&type=1']/following-sibling::div[contains(concat(' ', @class, ' '),' ussr-type-sel-copy ')]//button")
    private WebElement createDoubleOptInCopyDropDown;

    public MessageTemplate_CreateType1 clickCreateDoubleOptIn ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createDoubleOptIn));
        createDoubleOptIn.click();
        return (MessageTemplate_CreateType1) new MessageTemplate_CreateType1().init();
    }

    public MessageTemplate_CreateType1 selectDropDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return (MessageTemplate_CreateType1) new MessageTemplate_CreateType1().init();
    }

    public MessageTemplate_TypeSelection clickDoubleOptInDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createDoubleOptInCopyDropDown));
        createDoubleOptInCopyDropDown.click();
        return this;
    }

    public MessageTemplate_CreateType2 clickCreateInvoice ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(createInvoice));
        createInvoice.click();
        return (MessageTemplate_CreateType2) new MessageTemplate_CreateType2().init();
    }
    
}
