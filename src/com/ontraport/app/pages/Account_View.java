package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;

public class Account_View extends AbstractPage
{
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/sequence/listAll']")
    private WebElement uiSequenceListAll;

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='SOFTWARE AFFILIATE LINKS']/span")
    private WebElement softwareAffiliateLinks;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='MANAGE TAGS']/span")
    private WebElement manageTags;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='FACEBOOK']/span")
    private WebElement facebook;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='EXPORTED LISTS']/span")
    private WebElement exportedLists;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='FULFILLMENT MANAGER']/span")
    private WebElement fulfillmentManager;

    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='1SHOPPINGCART SYNCING']/span")
    private WebElement oneShoppingCartSyncing;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='Get Affiliate Tracking Pixel']/span")
    private WebElement getAffiliateTrackingPixel;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='ONTRAPORT API INSTRUCTIONS AND KEY MANAGER']/span")
    private WebElement ontraportApiInstructionsAndKeyManager;
    
    public OntraportAdmin_Afflink clickSoftwareAffiliateLinks ()
    {
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        softwareAffiliateLinks.click();
        return PageFactory.initElements(driver, OntraportAdmin_Afflink.class);
    }

    public OneShoppingCart_View click1ShoppingCartSyncing ()
    {
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        oneShoppingCartSyncing.click();
        return PageFactory.initElements(driver, OneShoppingCart_View.class);
    }

    public OntraportAdmin_TrackingPixel clickGetAffiliateTrackingPixel ()
    {
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        getAffiliateTrackingPixel.click();
        return PageFactory.initElements(driver, OntraportAdmin_TrackingPixel.class);
    }

    public ApiSettings_ListAll clickOntraportApiInstructionsAndKeyManager ()
    {
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        ontraportApiInstructionsAndKeyManager.click();
        return PageFactory.initElements(driver, ApiSettings_ListAll.class);
    }

    public Tag_ListAll clickManageTags ()
    {
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        manageTags.click();
        return PageFactory.initElements(driver, Tag_ListAll.class);
    }

    public OntraportAdmin_ListExports clickExportedLists ()
    {
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        exportedLists.click();
        return PageFactory.initElements(driver, OntraportAdmin_ListExports.class);
    }

    public Facebook_ListAll clickFacebook ()
    {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(facebook)));
        facebook.click();
        return PageFactory.initElements(driver, Facebook_ListAll.class);
    }

    public Fulfillment_ListAll clickFulfillmentManager ()
    {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fulfillmentManager)));
        fulfillmentManager.click();
        return PageFactory.initElements(driver, Fulfillment_ListAll.class);
    }
    
}
