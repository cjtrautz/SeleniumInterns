package com.ontraport.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.tools.AbstractPage;
import com.ontraport.app.tools.AbstractPart;

public class Account_View extends AbstractPage
{
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/ontraport_admin/afflink ')]")
    private WebElement softwareAffiliateLinks;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/tag/listAll ')]")
    private WebElement manageTags;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/facebook/listAll ')]")
    private WebElement facebook;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/ontraport_admin/listExports ')]")
    private WebElement exportedLists;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/fulfillment/listAll ')]")
    private WebElement fulfillmentManager;

    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/one_shopping_cart/view ')]")
    private WebElement oneShoppingCartSyncing;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/ontraport_admin/trackingpixel ')]")
    private WebElement getAffiliateTrackingPixel;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @class, ' '),' account-target-file-manager ')]")
    private WebElement attachmentManager;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/api_settings/listAll ')]")
    private WebElement ontraportApiInstructionsAndKeyManager;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/sender/view ')]")
    private WebElement sendFromAddress;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/message_template/listAll ')]")
    private WebElement doubleOptInInvoice;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/ultracart/view ')]")
    private WebElement ultraCart;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/role/listAll ')]")
    private WebElement roles;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/fieldeditor/manage&obj_id=2 ')]")
    private WebElement userFieldEditor;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/package/listAll ')]")
    private WebElement packageManager;
    
    @FindBy(
            how = How.XPATH,
            using = "//a[contains(concat(' ', @href, ' '),' #!/zencoder_video/listAll ')]")
    private WebElement videoManager;
    
    public OntraportAdmin_Afflink clickSoftwareAffiliateLinks ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", softwareAffiliateLinks);
        wait.until(ExpectedConditions.visibilityOf(softwareAffiliateLinks));
        softwareAffiliateLinks.click();
        return (OntraportAdmin_Afflink) new OntraportAdmin_Afflink().init();
    }

    public OneShoppingCart_View click1ShoppingCartSyncing ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", oneShoppingCartSyncing);
        wait.until(ExpectedConditions.visibilityOf(oneShoppingCartSyncing));
        oneShoppingCartSyncing.click();
        return (OneShoppingCart_View) new OneShoppingCart_View().init();
    }

    public OntraportAdmin_TrackingPixel clickGetAffiliateTrackingPixel ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", getAffiliateTrackingPixel);
        wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        getAffiliateTrackingPixel.click();
        return (OntraportAdmin_TrackingPixel) new OntraportAdmin_TrackingPixel().init();
    }

    public ApiSettings_ListAll clickOntraportApiInstructionsAndKeyManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ontraportApiInstructionsAndKeyManager);
        wait.until(ExpectedConditions.visibilityOf(ontraportApiInstructionsAndKeyManager));
        ontraportApiInstructionsAndKeyManager.click();
        return (ApiSettings_ListAll) new ApiSettings_ListAll().init();
    }

    public Tag_ListAll clickManageTags ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", manageTags);
        wait.until(ExpectedConditions.visibilityOf(manageTags));
        manageTags.click();
        return (Tag_ListAll) new Tag_ListAll().init();
    }

    public OntraportAdmin_ListExports clickExportedLists ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", exportedLists);
        wait.until(ExpectedConditions.visibilityOf(exportedLists));
        exportedLists.click();
        return (OntraportAdmin_ListExports) new OntraportAdmin_ListExports().init();
    }

    public Facebook_ListAll clickFacebook ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", facebook);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        wait.until(ExpectedConditions.visibilityOf(facebook));
        facebook.click();
        return (Facebook_ListAll) new Facebook_ListAll().init();
    }

    public Fulfillment_ListAll clickFulfillmentManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", fulfillmentManager);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        wait.until(ExpectedConditions.visibilityOf(fulfillmentManager));
        fulfillmentManager.click();
        return (Fulfillment_ListAll) new Fulfillment_ListAll().init();
    }

    public Account_View clickAttachmentManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", attachmentManager);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        wait.until(ExpectedConditions.visibilityOf(attachmentManager));
        attachmentManager.click();
        return this;
        
    }

    public Sender_View clickSendFrom ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", sendFromAddress);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        wait.until(ExpectedConditions.visibilityOf(sendFromAddress));
        sendFromAddress.click();
        return (Sender_View) new Sender_View().init();
    }

    public MessageTemplate_ListAll clickDoubleOptInOrInvoiceManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", doubleOptInInvoice);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        wait.until(ExpectedConditions.visibilityOf(doubleOptInInvoice));
        doubleOptInInvoice.click();
        return (MessageTemplate_ListAll) new MessageTemplate_ListAll().init();
    }

    public UltraCart_View clickUCConfig ()
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ultraCart);
        wait.until(ExpectedConditions.visibilityOf(ultraCart));
        ultraCart.click();
        return (UltraCart_View) new UltraCart_View().init();
    }

    public Role_ListAll clickTeamRolesAndPermissionManagement ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", roles);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        wait.until(ExpectedConditions.visibilityOf(roles));
        roles.click();
        return (Role_ListAll) new Role_ListAll().init();
    }

    public Field_Editor clickUserFieldEditor ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", userFieldEditor);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        wait.until(ExpectedConditions.visibilityOf(userFieldEditor));
        userFieldEditor.click();
        return (Field_Editor) new Field_Editor().init();
    }

    public Package_ListAll clickPackageManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", packageManager);
        wait.until(ExpectedConditions.visibilityOf(packageManager));
        packageManager.click();
        return (Package_ListAll) new Package_ListAll().init();
    }

    public ZencoderVideo_ListAll clickVideoManager ()
    {
        AbstractPart.waitForAjax(driver, 20);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", videoManager);
        //wait.until(ExpectedConditions.visibilityOf(getAffiliateTrackingPixel));
        wait.until(ExpectedConditions.visibilityOf(videoManager));
        videoManager.click();
        return (ZencoderVideo_ListAll) new ZencoderVideo_ListAll().init();
    }
    
}
