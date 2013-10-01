package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

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
            using = "//div[@class='ussr-settings']//div[.='ATTACHMENT MANAGER']/span")
    private WebElement attachmentManager;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='ONTRAPORT API INSTRUCTIONS AND KEY MANAGER']/span")
    private WebElement ontraportApiInstructionsAndKeyManager;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[contains(., 'ADDRESS SET UP')]/span")
    private WebElement sendFromAddress;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='DOUBLE OPT IN / INVOICE MANAGER']/span")
    private WebElement doubleOptInInvoice;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='ULTRACART CONFIGURATION']/span")
    private WebElement ultraCart;
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='Team Roles & Permission Management']/span")
    private WebElement roles;
    
    public OntraportAdmin_Afflink clickSoftwareAffiliateLinks ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        softwareAffiliateLinks.click();
        return PageFactory.initElements(driver, OntraportAdmin_Afflink.class);
    }

    public OneShoppingCart_View click1ShoppingCartSyncing ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        oneShoppingCartSyncing.click();
        return PageFactory.initElements(driver, OneShoppingCart_View.class);
    }

    public OntraportAdmin_TrackingPixel clickGetAffiliateTrackingPixel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        getAffiliateTrackingPixel.click();
        return PageFactory.initElements(driver, OntraportAdmin_TrackingPixel.class);
    }

    public ApiSettings_ListAll clickOntraportApiInstructionsAndKeyManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        ontraportApiInstructionsAndKeyManager.click();
        return PageFactory.initElements(driver, ApiSettings_ListAll.class);
    }

    public Tag_ListAll clickManageTags ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        manageTags.click();
        return PageFactory.initElements(driver, Tag_ListAll.class);
    }

    public OntraportAdmin_ListExports clickExportedLists ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        exportedLists.click();
        return PageFactory.initElements(driver, OntraportAdmin_ListExports.class);
    }

    public Facebook_ListAll clickFacebook ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(facebook)));
        facebook.click();
        return PageFactory.initElements(driver, Facebook_ListAll.class);
    }

    public Fulfillment_ListAll clickFulfillmentManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fulfillmentManager)));
        fulfillmentManager.click();
        return PageFactory.initElements(driver, Fulfillment_ListAll.class);
    }

    public Account_View clickAttachmentManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(attachmentManager)));
        attachmentManager.click();
        return this;
        
    }

    public Sender_View clickSendFrom ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(sendFromAddress)));
        sendFromAddress.click();
        return PageFactory.initElements(driver, Sender_View.class);
    }

    public MessageTemplate_ListAll clickDoubleOptInOrInvoiceManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(doubleOptInInvoice)));
        doubleOptInInvoice.click();
        return PageFactory.initElements(driver, MessageTemplate_ListAll.class);
    }

    public UltraCart_View clickUCConfig ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ultraCart)));
        ultraCart.click();
        return PageFactory.initElements(driver, UltraCart_View.class);
    }

    public Role_ListAll clickTeamRolesAndPermissionManagement ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(roles)));
        roles.click();
        return PageFactory.initElements(driver, Role_ListAll.class);
    }
    
}
