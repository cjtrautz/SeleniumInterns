package com.ontraport.app.pages;

import org.openqa.selenium.By;
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
            using = "//a[@href='#!/landing_page/create&type=1']/following-sibling::div//button")
    private WebElement easyPagesDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/landing_page/create&type=0']/button[contains(concat(' ', normalize-space(@class), ' '),' type-selection-create-button ')]")
    private WebElement creatCodeMode;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/landing_page/create&type=0']/following-sibling::div//button")
    private WebElement codeModeDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//a[@href='#!/landing_page/create&type=2']/button[contains(concat(' ', normalize-space(@class), ' '),' type-selection-create-button ')]")
    private WebElement creatRedirectMode;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' type-selection-cancel-button ')]")
    private WebElement cancel;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-chrome-panel-pane-header-back ')]")
    private WebElement back;
    
    @FindBy(how = How.XPATH,
            using = "//ul[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-ul ')]")
    private WebElement drilldown;
    
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

    public LandingPage_ListAll clickCancel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(cancel));
        cancel.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }

    public LandingPage_ListAll clickBack ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(back));
        back.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }

    public LandingPage_CreateType2 clickCreateRedirectMode ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(creatRedirectMode));
        creatRedirectMode.click();
        return (LandingPage_CreateType2) new LandingPage_CreateType2().init();
    }

    public LandingPage_TypeSelection clickEasyPageDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(easyPagesDropDown));
        easyPagesDropDown.click();
        return this;
    }

    public LandingPage_Edit selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drilldown));
        drilldown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return (LandingPage_Edit) new LandingPage_Edit().init();
    }

    public LandingPage_TypeSelection clickCodeModePageDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(codeModeDropDown));
        codeModeDropDown.click();
        return this;
    }
    
}
