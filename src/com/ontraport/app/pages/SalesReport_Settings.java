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
    
    public Gateway_ListAll clickGateways ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(gateway));
        gateway.click();
        return (Gateway_ListAll) new Gateway_ListAll().init();
    }
    
}
