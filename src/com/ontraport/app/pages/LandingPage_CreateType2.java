package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class LandingPage_CreateType2 extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//ul[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-drilldownselect-ul ')]")
    private WebElement drillDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement landingPageName;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-hosted-domain-selector-subdomain ')]//input")
    private WebElement landingPageURLSubDomain;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' component-hosted-domain-selector-target-default-domain-selector ')]//button")
    private WebElement landingPageURLSubDomainDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(normalize-space(.),'Save')]")
    private WebElement save;

    public LandingPage_CreateType2 enterLandingPageName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageName));
        landingPageName.click();
        landingPageName.sendKeys(string + Keys.RETURN);
        return this;
    }

    public LandingPage_CreateType2 enterPageURL ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageURLSubDomain));
        landingPageURLSubDomain.click();
        landingPageURLSubDomain.sendKeys(string + Keys.RETURN);
        return this;
    }

    public LandingPage_CreateType2 clickDomainDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageURLSubDomainDropDown));
        landingPageURLSubDomainDropDown.click();
        return this;
    }

    public LandingPage_CreateType2 selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]"))));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }

    public LandingPage_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }
    
}
