package com.ontraport.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Gateway_Create extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement gatewayName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-type-chooser ')]//button")
    private WebElement gatewayDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-type-chooser ')]//input")
    private WebElement gatewayInput;
    
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownCollection;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-targets ')]//input")
    private List<WebElement> components;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-targets ')]//input")
    private WebElement component;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-controls ')]/button//span[text()='Save']")
    private WebElement save;

    public Gateway_Create enterGatewayName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")));
        wait.until(ExpectedConditions.visibilityOf(gatewayName));
        gatewayName.sendKeys(string);
        return this;
        
    }

    public Gateway_Create clickGatewayTypeDropdown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gatewayDropDown));
        gatewayDropDown.click();
        return this;
        
    }

    public Gateway_Create selectDrilldownOption ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDownCollection));
        drillDownCollection.findElement(By.xpath(".//li/div[text()='" + string + "']")).click();
        return this;
        
    }

    public Gateway_Create enterGatewayNickName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(component));
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
        
    }

    public Gateway_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (Gateway_ListAll) new Gateway_ListAll().init();
        
    }

    public Gateway_Create enterlogin ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
    }

    public Gateway_Create enterKey ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterMerchantId ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
    }

    public Gateway_Create enterPin ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        components.get(2).sendKeys(string);
        return this;
    }

    public Gateway_Create enterUserId ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterCustomerId ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
    }

    public Gateway_Create enterRefundPass ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterPassword ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(3)));
        components.get(3).sendKeys(string);
        return this;
    }

    public Gateway_Create enterUsername ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        components.get(2).sendKeys(string);
        return this;
    }

    public Gateway_Create enterNetworkMerchantUsername ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
    }

    public Gateway_Create enterNetwork ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterUser ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
    }

    public Gateway_Create enterVendor ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterPWD ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(3)));
        components.get(3).sendKeys(string);
        return this;
    }

    public Gateway_Create enterPartner ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        components.get(2).sendKeys(string);
        return this;
    }

    public Gateway_Create enterDc_password ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterGatewayType ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gatewayInput));
        gatewayInput.sendKeys(string);
        return this;
    }

    public Gateway_Create enterConnectionTicket ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
    }

    public Gateway_Create enterAppLogin ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterAppId ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        components.get(2).sendKeys(string);
        return this;
    }

    public Gateway_Create enterUMkey ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
    }

    public Gateway_Create enterUMpin ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterPayPalUser ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(0)));
        components.get(0).sendKeys(string);
        return this;
    }

    public Gateway_Create enterPayPalPWD ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(1)));
        components.get(1).sendKeys(string);
        return this;
    }

    public Gateway_Create enterPayPalSignature ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(components.get(2)));
        components.get(2).sendKeys(string);
        return this;
    }

}
