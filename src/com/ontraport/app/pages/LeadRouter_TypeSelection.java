package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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
    
}
