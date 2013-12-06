package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class LeadRouter_TypeSelection extends AbstractPage
{

    @FindBy(
            how = How.XPATH,
            using = "//div[div[a[text()='Round Robin']]]/descendant::a/button")
    private WebElement roundRobinCreate;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/lead_rout/create&type=rr']/following-sibling::div//button")
    private WebElement roundRobinDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[@href='#!/lead_rout/create&type=wr']/following-sibling::div//button")
    private WebElement weightedRandomDropDown;
    
    @FindBy(
            how = How.XPATH,
            using = "//ul[@class='ussr-component-drilldownselect-ul']")
    private WebElement drillDown;

    @FindBy(
            how = How.XPATH,
            using = "//div[div[a[text()='Weighted Random']]]/descendant::a/button")
    private WebElement weightedRandomCreate;
    
    public LeadRouter_CreateRR clickRoundRobinCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(roundRobinCreate));
        roundRobinCreate.click();
        return (LeadRouter_CreateRR) new LeadRouter_CreateRR().init();
    }

    public LeadRouter_CreateWR clickWeightedRandomCreate ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(weightedRandomCreate));
        weightedRandomCreate.click();
        return (LeadRouter_CreateWR) new LeadRouter_CreateWR().init();
    }

    public LeadRouter_TypeSelection clickRoundRobinDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(roundRobinDropDown));
        roundRobinDropDown.click();
        return this;
    }

    public LeadRouter_CreateRR selectDrillDown ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return (LeadRouter_CreateRR) new LeadRouter_CreateRR().init();
    }

    public LeadRouter_TypeSelection clickWeightedRandomDropDown ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(weightedRandomDropDown));
        weightedRandomDropDown.click();
        return this;
    }

    public LeadRouter_CreateWR selectDrillDown2 ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(drillDown));
        drillDown.findElement(By.xpath(".//li[contains(., '" + string + "')]")).click();
        return (LeadRouter_CreateWR) new LeadRouter_CreateWR().init();
    }
    
}
