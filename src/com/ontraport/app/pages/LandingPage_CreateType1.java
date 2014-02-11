package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class LandingPage_CreateType1 extends AbstractPage
{
    @FindBy(
            how = How.TAG_NAME,
            using = "iframe")
    private WebElement iFrame;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@style), ' '),' font-family: Verdana,Geneva,sans-serif; ')]")
    private WebElement textArea;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-landing-page-form-selector ')]//button")
    private WebElement formDropDown;
    
    @FindBy(how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;
    
    @FindBy(how = How.XPATH,
            using = "//div[@class='inpt_button' and contains(text(), 'Edit HTML')]")
    private WebElement editHTML;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-pane-editor-name ')]//input")
    private WebElement landingPageName;

    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ')]//input[@type='TEXT']")
    private WebElement landingPageNameTitle;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ')]//input[contains(concat(' ', normalize-space(@class), ' '),' inpt_text_focus ')]")
    private WebElement landingPageNameFocus;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' menu_button_class ') and @style='cursor: pointer;']")
    private WebElement pageUrl;
    
    @FindBy(how = How.XPATH,
            using = "//div[@id='layer_box']//div[text()='+ New Item']")
    private WebElement newItem;
    
    @FindBy(how = How.XPATH,
            using = "//button[contains(concat(' ', normalize-space(@class), ' '),' ontraport_components_button ')]//span[text()='Save']")
    private WebElement save;
    
    public LandingPage_CreateType1 enterLandingPageName ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageName));
        landingPageName.click();
        landingPageName.sendKeys(string + Keys.RETURN);
        return this;
        
    }

    public LandingPage_CreateType1 enterLandingPageTitle ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(landingPageNameTitle));
        //landingPageNameTitle.click();
        Actions action = new Actions(driver);
        action.click(landingPageNameTitle).build().perform();
        //wait.until(ExpectedConditions.visibilityOf(landingPageNameFocus));
        landingPageNameTitle.sendKeys(string);
        return this;
        
    }

    public LandingPage_CreateType1 clickPageURL ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(pageUrl));
        pageUrl.click();
        return this;
        
    }

    public LandingPage_CreateType1 clickNewItem ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newItem);
        newItem.click();
        return this;
        
    }

    public LandingPage_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }

    public LandingPage_CreateType1 doubleClickInsertText ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(textArea));
        Actions action = new Actions(driver);
        action.doubleClick(textArea).build().perform();
        return this; 
    }

    public LandingPage_CreateType1 enterText ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.switchTo().frame(iFrame);
        Actions action = new Actions(driver);
        action.sendKeys(string).build().perform();
        driver.switchTo().defaultContent();
        return this;
    }

    public LandingPage_CreateType1 clickEditHTML ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", editHTML);
        wait.until(ExpectedConditions.visibilityOf(editHTML));
        editHTML.click();
        return this;
    }

    public LandingPage_CreateType1 clickFormDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", formDropDown);
        wait.until(ExpectedConditions.visibilityOf(formDropDown));
        formDropDown.click();
        return this;
    }

    public LandingPage_CreateType1 selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]"))));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return this;
    }
    
    
}
