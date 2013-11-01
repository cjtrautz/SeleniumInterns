package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Package_ListAll extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newPackage;

    public Package_Create clickNewPackage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        newPackage.click();
        return (Package_Create) new Package_Create().init();
    }
    
}
