package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Facebook_Create extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-section-components']/div[1]/div/div/input")
    private WebElement appName;

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-section-components']/div[2]/div/div/input")
    private WebElement appID;

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-section-components']/div[3]/div/div/input")
    private WebElement redirect;

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-component-section-components']/div[4]/div/div/input")
    private WebElement visits;

    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ussr-chrome-panel-pane']//button[normalize-space(.)='Save']")
    private WebElement save;

    public Facebook_Create enterAppName ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        appName.sendKeys(name);
        return this;
        
    }

    public Facebook_Create enterAppID ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        appID.sendKeys(name);
        return this;
        
    }

    public Facebook_Create enterRedirect ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        redirect.sendKeys(name);
        return this;
        
    }

    public Facebook_Create enterVisits ( String name )
    {
        AbstractPart.waitForAjax(driver, 20);
        visits.sendKeys(name);
        return this;
        
    }

    public Facebook_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        save.click();
        return PageFactory.initElements(driver, Facebook_ListAll.class);
        
    }
    
}
