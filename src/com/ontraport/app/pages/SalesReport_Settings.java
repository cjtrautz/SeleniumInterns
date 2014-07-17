package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.Gateway_ListAll;
import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class SalesReport_Settings extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/gateway/listAll']/div[contains(., 'Gateways')]")
    private WebElement gateway;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/sales_report/recharge']")
    private WebElement rechargeSettings;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/message_template/listAll']")
    private WebElement doubleOptInInvoice;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/taxes/listAll']")
    private WebElement taxTypes;
    
    public Gateway_ListAll clickGateways ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gateway));
        gateway.click();
        return (Gateway_ListAll) new Gateway_ListAll().init();
    }

    public SalesReport_Recharge clickRechargeSettings ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(rechargeSettings));
        rechargeSettings.click();
        return (SalesReport_Recharge) new SalesReport_Recharge().init();
    }

    public MessageTemplate_ListAll clickDoubleOptInInvoiceManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(doubleOptInInvoice));
        doubleOptInInvoice.click();
        return (MessageTemplate_ListAll) new MessageTemplate_ListAll().init();
    }
    
    public Taxes_ListAll clickTaxTypes ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(taxTypes));
        taxTypes.click();
        return (Taxes_ListAll) new Taxes_ListAll().init();
    }
}
