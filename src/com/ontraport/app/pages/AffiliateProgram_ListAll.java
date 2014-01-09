package com.ontraport.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;
import com.ontraport.app.tools.AbstractSuite;

public class AffiliateProgram_ListAll extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//td[contains(concat(' ', normalize-space(@class), ' '),' ussr-collection-empty ')]")
    private WebElement emptyCell;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']/tr/td/a")
    private WebElement uiSelectAll;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@id='ontraport_panel_action_new']")
    private WebElement newPartnerProgram;
    
    @FindBy(how = How.XPATH,
            using = "//tbody[@class='ussr-component-collection-body']")
    private WebElement uiCollectionBody;

    public AffiliateProgram_Create clickNewPartnerProgram ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(newPartnerProgram));
        newPartnerProgram.click();
        return (AffiliateProgram_Create) new AffiliateProgram_Create().init();
    }

    public AffiliateProgram_ListAll verifyProgram ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']"));
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public AffiliateProgram_Edit clickProgram ( String string )
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']"))));
        uiCollectionBody.findElement(By.xpath(".//a[normalize-space(text())='" + string + "']")).click();
        return (AffiliateProgram_Edit) new AffiliateProgram_Edit().init();
    }

    public AffiliateProgram_ListAll selectAllOnPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(uiCollectionBody));
        wait.until(ExpectedConditions.visibilityOf(uiSelectAll));
        Actions action = new Actions(driver);
        action.click(uiSelectAll).build().perform();
        return this;
    }

    public AffiliateProgram_ListAll verifyNoProgram ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            emptyCell.isDisplayed();
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

    public AffiliateProgram_ListAll verifyPage ()
    {
        AbstractPart.waitForAjax(driver, 20);
        try
        {
            System.out.println(driver.getCurrentUrl());
            System.out.println(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/affiliate_program/listAll");
            if(!driver.getCurrentUrl().equals(AbstractPage.getUrl() + AbstractPage.getLatch() + "/#!/affiliate_program/listAll"))
            {
                return null; 
            }
            uiCollectionBody.isDisplayed();
        }
        catch(NoSuchElementException e){
            return null;
        }
        
        return this;
    }

}
