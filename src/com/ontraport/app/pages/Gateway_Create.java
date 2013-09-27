package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDownCollection;
    
    @FindBy(how = How.XPATH,
            using = "//div[contains(concat(' ', normalize-space(@class), ' '),' ussr-component-targets ')]//input")
    private WebElement gatewayNickName;
    
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
        wait.until(ExpectedConditions.visibilityOf(gatewayNickName));
        gatewayNickName.sendKeys(string);
        return this;
        
    }

    public Gateway_ListAll clickSave ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        return PageFactory.initElements(driver, Gateway_ListAll.class);
        
    }

}
