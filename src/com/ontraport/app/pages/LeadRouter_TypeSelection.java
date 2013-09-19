package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

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
        wait.until(ExpectedConditions.visibilityOf(roundRobinCreate));
        roundRobinCreate.click();
        return PageFactory.initElements(driver, LeadRouter_CreateRR.class);
    }

    public LeadRouter_CreateWR clickWeightedRandomCreate ()
    {
        wait.until(ExpectedConditions.visibilityOf(weightedRandomCreate));
        weightedRandomCreate.click();
        return PageFactory.initElements(driver, LeadRouter_CreateWR.class);
    }
    
}
