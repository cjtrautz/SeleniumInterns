package com.ontraport.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
    
    @FindBy(
            how = How.XPATH,
            using = "//div[@class='ussr-settings']//div[.='User Field Editor']/span")
    private WebElement userFieldEditor;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/package/listAll ')]")
    private WebElement packageManager;
    
    public OntraportAdmin_Afflink clickSoftwareAffiliateLinks ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        softwareAffiliateLinks.click();
        return (OntraportAdmin_Afflink) new OntraportAdmin_Afflink().init();
    }

    public OneShoppingCart_View click1ShoppingCartSyncing ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        oneShoppingCartSyncing.click();
        return (OneShoppingCart_View) new OneShoppingCart_View().init();
    }

    public OntraportAdmin_TrackingPixel clickGetAffiliateTrackingPixel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        getAffiliateTrackingPixel.click();
        return (OntraportAdmin_TrackingPixel) new OntraportAdmin_TrackingPixel().init();
    }

    public ApiSettings_ListAll clickOntraportApiInstructionsAndKeyManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        ontraportApiInstructionsAndKeyManager.click();
        return (ApiSettings_ListAll) new ApiSettings_ListAll().init();
    }

    public Tag_ListAll clickManageTags ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        manageTags.click();
        return (Tag_ListAll) new Tag_ListAll().init();
    }

    public OntraportAdmin_ListExports clickExportedLists ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        exportedLists.click();
        return (OntraportAdmin_ListExports) new OntraportAdmin_ListExports().init();
    }

    public Facebook_ListAll clickFacebook ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(facebook)));
        facebook.click();
        return (Facebook_ListAll) new Facebook_ListAll().init();
    }

    public Fulfillment_ListAll clickFulfillmentManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(fulfillmentManager)));
        fulfillmentManager.click();
        return (Fulfillment_ListAll) new Fulfillment_ListAll().init();
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
        return (Sender_View) new Sender_View().init();
    }

    public MessageTemplate_ListAll clickDoubleOptInOrInvoiceManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(doubleOptInInvoice)));
        doubleOptInInvoice.click();
        return (MessageTemplate_ListAll) new MessageTemplate_ListAll().init();
    }

    public UltraCart_View clickUCConfig ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ultraCart)));
        ultraCart.click();
        return (UltraCart_View) new UltraCart_View().init();
    }

    public Role_ListAll clickTeamRolesAndPermissionManagement ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(roles)));
        roles.click();
        return (Role_ListAll) new Role_ListAll().init();
    }

    public Field_Editor clickUserFieldEditor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(userFieldEditor)));
        userFieldEditor.click();
        return (Field_Editor) new Field_Editor().init();
    }

    public Package_ListAll clickPackageManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(uiSequenceListAll)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(userFieldEditor)));
        packageManager.click();
        return (Package_ListAll) new Package_ListAll().init();
    }
    
}
