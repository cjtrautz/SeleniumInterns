package com.ontraport.app.parts.bb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ontraport.app.pages.AffiliateProgram_ListAll;
import com.ontraport.app.pages.Affiliate_ListAll;
import com.ontraport.app.pages.Affiliate_Settings;
import com.ontraport.app.pages.Affiliate_View;
import com.ontraport.app.pages.Contact_ListAll;
import com.ontraport.app.pages.Contact_Settings;
import com.ontraport.app.pages.LandingPage_ListAll;
import com.ontraport.app.pages.Message_ListAll;
import com.ontraport.app.pages.Product_ListAll;
import com.ontraport.app.pages.Purchase_ListAll;
import com.ontraport.app.pages.Rule_ListAll;
import com.ontraport.app.pages.SalesReport_ListAll;
import com.ontraport.app.pages.SalesReport_Settings;
import com.ontraport.app.pages.Sequence_ListAll;
import com.ontraport.app.pages.SmartFormFe_ListAll;
import com.ontraport.app.pages.Task_ListAll;
import com.ontraport.app.pages.TrackedDomain_ListAll;
import com.ontraport.app.pages.TrackingCampaign_ListAll;
import com.ontraport.app.pages.TrackingContent_ListAll;
import com.ontraport.app.pages.TrackingLeadSource_ListAll;
import com.ontraport.app.pages.TrackingLinks_ListAll;
import com.ontraport.app.pages.TrackingMedium_ListAll;
import com.ontraport.app.pages.TrackingTerm_ListAll;
import com.ontraport.app.pages.TrackingUrlHistory_ListAll;
import com.ontraport.app.pages.WordPress_ListAll;
import com.ontraport.app.tools.AbstractPart;

public class MenuPrimary extends AbstractPart
{
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiContactListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/sequence/listAll']")
    private WebElement uiSequenceListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/rule/listAll']")
    private WebElement uiRuleListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/smart_form_fe/listAll']")
    private WebElement uiSmartFormFeListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/message/listAll']")
    private WebElement uiMessageListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/settings']")
    private WebElement uiContactSettings;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/task/listAll']")
    private WebElement uiTaskListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/purchase/listAll']")
    private WebElement uiPurchaseListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/product/listAll']")
    private WebElement uiProductListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/sales_report/view']")
    private WebElement uiSalesReportView;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/sales_report/settings']")
    private WebElement uiSalesReportSettings;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/affiliate/listAll']")
    private WebElement uiAffiliateListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/affiliate_program/listAll']")
    private WebElement uiAffiliateProgramListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/affiliate_view/listAll']")
    private WebElement uiAffiliateView;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/affiliate/settings']")
    private WebElement uiAffiliateSettings;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']/section/nav/ul/li/a[@href='#!/landing_page/listAll']")
    private WebElement uiLandingPageListAll1;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']/section/nav/ul/li//li/a[@href='#!/landing_page/listAll']")
    private WebElement uiLandingPageListAll2;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/wordpress/listAll']")
    private WebElement uiWordPressListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackedDomainListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackingCampaignListAll1;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackingCampaignListAll2;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackingLeadSourceListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackingMediumListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackingContentListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackingTermListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackingUrlHistoryListAll;
    @FindBy(how = How.XPATH,
            using = "//aside[@id='ussr-chrome-sidebar']//a[@href='#!/contact/listAll']")
    private WebElement uiTrackingLinksListAll;
    public Contact_ListAll clickContactListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiContactListAll));
        uiContactListAll.click();
        return (Contact_ListAll) new Contact_ListAll().init();
    }
    public Sequence_ListAll clickSequenceListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiContactListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiContactListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiSequenceListAll));
        uiSequenceListAll.click();
        return (Sequence_ListAll) new Sequence_ListAll().init();
    }
    public Rule_ListAll clickRuleListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiContactListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiContactListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiRuleListAll));
        uiRuleListAll.click();
        return (Rule_ListAll) new Rule_ListAll().init();
    }
    public SmartFormFe_ListAll clickSmartFormFeListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiContactListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiContactListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiSmartFormFeListAll));
        uiSmartFormFeListAll.click();
        return (SmartFormFe_ListAll) new SmartFormFe_ListAll().init();
    }
    public Message_ListAll clickMessageListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiContactListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiContactListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiMessageListAll));
        uiMessageListAll.click();
        return (Message_ListAll) new Message_ListAll().init();
    }
    public Contact_Settings clickContactSettings ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiContactListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiContactListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiContactSettings));
        uiContactSettings.click();
        return (Contact_Settings) new Contact_Settings().init();
    }
    public Task_ListAll clickTaskListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiContactListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiContactListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTaskListAll));
        uiTaskListAll.click();
        return (Task_ListAll) new Task_ListAll().init();
    }
    public Purchase_ListAll clickPurchaseListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiPurchaseListAll));
        uiPurchaseListAll.click();
        return (Purchase_ListAll) new Purchase_ListAll().init();
    }
    public Product_ListAll clickProductListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiPurchaseListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiPurchaseListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiProductListAll));
        uiProductListAll.click();
        return (Product_ListAll) new Product_ListAll().init();
    }
    public SalesReport_ListAll clickSalesReportView ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiPurchaseListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiPurchaseListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiProductListAll));
        uiProductListAll.click();
        return (SalesReport_ListAll) new SalesReport_ListAll().init();
    }
    public SalesReport_Settings clickSalesReportSettings ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiPurchaseListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiPurchaseListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiSalesReportSettings));
        uiSalesReportSettings.click();
        return (SalesReport_Settings) new SalesReport_Settings().init();
    }
    public Affiliate_ListAll clickAffiliateListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiAffiliateListAll));
        uiAffiliateListAll.click();
        return (Affiliate_ListAll) new Affiliate_ListAll().init();
    }
    public AffiliateProgram_ListAll clickAffiliateProgramListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiAffiliateListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiAffiliateListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiAffiliateProgramListAll));
        uiAffiliateProgramListAll.click();
        return (AffiliateProgram_ListAll) new AffiliateProgram_ListAll().init();
    }
    public Affiliate_View clickAffiliateView ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiAffiliateListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiAffiliateListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiAffiliateView));
        uiAffiliateView.click();
        return (Affiliate_View) new Affiliate_View().init();
    }
    public Affiliate_Settings clickAffiliateSettings ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiAffiliateListAll));
        Actions action = new Actions(driver);
        action.moveToElement(uiAffiliateListAll)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiAffiliateSettings));
        uiAffiliateSettings.click();
        return (Affiliate_Settings) new Affiliate_Settings().init();
    }
    public LandingPage_ListAll clickLandingPageListAll1 ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiLandingPageListAll1));
        uiLandingPageListAll1.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }
    public LandingPage_ListAll clickLandingPageListAll2 ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiLandingPageListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiLandingPageListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiLandingPageListAll2));
        uiLandingPageListAll2.click();
        return (LandingPage_ListAll) new LandingPage_ListAll().init();
    }
    public WordPress_ListAll clickWordPressListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiLandingPageListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiLandingPageListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiWordPressListAll));
        uiWordPressListAll.click();
        return (WordPress_ListAll) new WordPress_ListAll().init();
    }
    public TrackedDomain_ListAll clickTrackedDomainListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiLandingPageListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiLandingPageListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackedDomainListAll));
        uiTrackedDomainListAll.click();
        return (TrackedDomain_ListAll) new TrackedDomain_ListAll().init();
    }
    public TrackingCampaign_ListAll clickTrackingCampaignListAll1 ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll1));
        uiTrackingCampaignListAll1.click();
        return (TrackingCampaign_ListAll) new TrackingCampaign_ListAll().init();
    }
    public TrackingCampaign_ListAll clickTrackingCampaignListAll2 ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiTrackingCampaignListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll2));
        uiTrackingCampaignListAll2.click();
        return (TrackingCampaign_ListAll) new TrackingCampaign_ListAll().init();
    }
    public TrackingLeadSource_ListAll clickTrackingLeadSourceListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiTrackingCampaignListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingLeadSourceListAll));
        uiTrackingLeadSourceListAll.click();
        return (TrackingLeadSource_ListAll) new TrackingLeadSource_ListAll().init();
    }
    public TrackingMedium_ListAll clickTrackingMediumListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiTrackingCampaignListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingMediumListAll));
        uiTrackingMediumListAll.click();
        return (TrackingMedium_ListAll) new TrackingMedium_ListAll().init();
    }
    public TrackingContent_ListAll clickTrackingContentListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiTrackingCampaignListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingContentListAll));
        uiTrackingContentListAll.click();
        return (TrackingContent_ListAll) new TrackingContent_ListAll().init();
    }
    public TrackingTerm_ListAll clickTrackingTermListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiTrackingCampaignListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingTermListAll));
        uiTrackingTermListAll.click();
        return (TrackingTerm_ListAll) new TrackingTerm_ListAll().init();
    }
    public TrackingUrlHistory_ListAll clickTrackingUrlHistoryListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiTrackingCampaignListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingUrlHistoryListAll));
        uiTrackingUrlHistoryListAll.click();
        return (TrackingUrlHistory_ListAll) new TrackingUrlHistory_ListAll().init();
    }
    public TrackingLinks_ListAll clickTrackingLinksListAll ()
    {
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingCampaignListAll1));
        Actions action = new Actions(driver);
        action.moveToElement(uiTrackingCampaignListAll1)
            .perform();
        wait(1).until(ExpectedConditions.visibilityOf(uiTrackingLinksListAll));
        uiTrackingLinksListAll.click();
        return (TrackingLinks_ListAll) new TrackingLinks_ListAll().init();
    }
}
