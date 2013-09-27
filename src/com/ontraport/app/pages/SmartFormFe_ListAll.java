package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class SmartFormFe_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newSmartForm;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td")
    private WebElement uiCollectionBodyRow1;

    public SmartFormFe_Create clickNewSmartForm ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBodyRow1));
        wait.until(ExpectedConditions.visibilityOf(newSmartForm));
        newSmartForm.click();
        return PageFactory.initElements(driver, SmartFormFe_Create.class);
    }
    
}
