package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class LandingPage_TypeSelection extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/landing_page/create&type=1']/button[contains(concat(' ', normalize-space(@class), ' '),' type-selection-create-button ')]")
    private WebElement creatEasyPages;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/landing_page/create&type=0']/button[contains(concat(' ', normalize-space(@class), ' '),' type-selection-create-button ')]")
    private WebElement creatCodeMode;

    public LandingPage_CreateType1 clickCreateEasyPages ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(creatEasyPages));
        creatEasyPages.click();
        return (LandingPage_CreateType1) new LandingPage_CreateType1().init();
    }

    public LandingPage_CreateType0 clickCreateCodeMode ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(creatCodeMode));
        creatCodeMode.click();
        return (LandingPage_CreateType0) new LandingPage_CreateType0().init();
    }
    
}
